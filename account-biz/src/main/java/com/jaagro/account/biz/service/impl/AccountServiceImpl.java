package com.jaagro.account.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.jaagro.account.api.constant.AccountStatus;
import com.jaagro.account.api.constant.AccountType;
import com.jaagro.account.api.dto.request.BatchDeleteAccountDto;
import com.jaagro.account.api.dto.request.CreateAccountDto;
import com.jaagro.account.api.dto.request.QueryAccountDto;
import com.jaagro.account.api.dto.request.UpdateAccountDto;
import com.jaagro.account.api.dto.response.AccountReturnDto;
import com.jaagro.account.api.service.AccountService;
import com.jaagro.account.biz.entity.Account;
import com.jaagro.account.biz.mapper.AccountMapperExt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;

/**
 * @author yj
 * @date 2018/10/23
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapperExt accountMapperExt;
    @Autowired
    private CurrentUserService currentUserService;
    /**
     * 创建账户
     *
     * @param createAccountDto
     * @return
     */
    @Override
    public Integer createAccount(CreateAccountDto createAccountDto) {
        Account account = accountMapperExt.selectActiveAccount(AccountType.CASH,createAccountDto.getUserId(),createAccountDto.getUserType());
        if (account != null){
            log.info("account already created,{}", JSON.toJSONString(createAccountDto));
            return account.getId();
        }
        account = new Account();
        BeanUtils.copyProperties(createAccountDto,account);
        generateAccount(account);
        accountMapperExt.insertSelective(account);
        return account.getId();
    }

    /**
     * 修改账户
     *
     * @param updateAccountDto
     * @return
     */
    @Override
    public boolean updateAccount(UpdateAccountDto updateAccountDto) {
        Account account = new Account();
        BeanUtils.copyProperties(updateAccountDto,account);
        account.setModifyTime(new Date());
        account.setModifyUserId(currentUserService.getCurrentUser() == null ? null : currentUserService.getCurrentUser().getId());
        int i = accountMapperExt.updateByPrimaryKeySelective(account);
        if (i < 1){
            return false;
        }
        return true;
    }

    /**
     * 查询账户
     *
     * @param id
     * @return
     */
    @Override
    public AccountReturnDto getById(Integer id) {
        Account account = accountMapperExt.selectByPrimaryKey(id);
        if (account == null){
            return null;
        }
        AccountReturnDto accountDto = new AccountReturnDto();
        BeanUtils.copyProperties(account,accountDto);
        return accountDto;
    }

    /**
     * 删除账户(逻辑删除)
     *
     * @param id
     * @return
     */
    @CacheEvict(cacheNames = "account",allEntries = true)
    @Override
    public boolean disableAccount(Integer id) {
        Account account = accountMapperExt.selectByPrimaryKey(id);
        if (account == null){
            log.warn("id not exist id={}",id);
            return false;
        }
        account.setAccountStatus(AccountStatus.FREEZE);
        account.setModifyTime(new Date());
        account.setModifyUserId(currentUserService.getCurrentUser() == null ? null : currentUserService.getCurrentUser().getId());
        int result = accountMapperExt.updateByPrimaryKeySelective(account);
        if (result == 1){
            return true;
        }
        return false;
    }

    /**
     * 查询账户
     *
     * @param queryAccountDto
     * @return
     */
    @Cacheable
    @Override
    public AccountReturnDto getByQueryAccountDto(QueryAccountDto queryAccountDto) {
        Account account = accountMapperExt.selectActiveAccount(queryAccountDto.getAccountType(),queryAccountDto.getUserId(),queryAccountDto.getUserType());
        if (account == null){
            return null;
        }
        AccountReturnDto accountDto = new AccountReturnDto();
        BeanUtils.copyProperties(account,accountDto);
        return accountDto;
    }

    /**
     * 批量删除账户
     *
     * @param batchDeleteAccountDto
     * @return
     */
    @CacheEvict(cacheNames = "account",allEntries = true)
    @Override
    public boolean batchDisableAccount(BatchDeleteAccountDto batchDeleteAccountDto) {
        Integer currentUserId = currentUserService.getCurrentUser() == null ? null : currentUserService.getCurrentUser().getId();
        batchDeleteAccountDto.setModifyUserId(currentUserId);
        Integer effective = accountMapperExt.batchDisableAccount(batchDeleteAccountDto);
        // 防止userId重复
        if(effective == new HashSet<>(batchDeleteAccountDto.getUserIdList()).size()){
            return true;
        }
        log.warn("batchDisableAccount fail,batchDeleteAccountDto={},effective={}",batchDeleteAccountDto,effective);
        return false;
    }

    private void generateAccount(Account account) {
        account.setVersion(0);
        account.setAccountStatus(AccountStatus.NORMAL);
        account.setBalance(new BigDecimal("0"));
        account.setCreateTime(new Date());
        account.setCredit(new BigDecimal("0"));
        account.setDebit(new BigDecimal("0"));
    }
}
