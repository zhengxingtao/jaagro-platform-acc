package com.jaagro.account.api.service;

import com.jaagro.account.api.dto.request.BatchDeleteAccountDto;
import com.jaagro.account.api.dto.request.CreateAccountDto;
import com.jaagro.account.api.dto.request.QueryAccountDto;
import com.jaagro.account.api.dto.request.UpdateAccountDto;
import com.jaagro.account.api.dto.response.AccountReturnDto;

/**
 * 账户操作
 * @author yj
 * @date 2018/10/23
 */
public interface AccountService {
    /**
     * 创建账户
     * @param createAccountDto
     * @return
     */
    Integer createAccount(CreateAccountDto createAccountDto);

    /**
     * 修改账户
     * @param updateAccountDto
     * @return
     */
    boolean updateAccount(UpdateAccountDto updateAccountDto);

    /**
     * 查询账户
     * @param id
     * @return
     */
    AccountReturnDto getById(Integer id);

    /**
     * 删除账户
     * @param id
     * @return
     */
    boolean disableAccount(Integer id);

    /**
     * 查询账户
     * @param queryAccountDto
     * @return
     */
    AccountReturnDto getByQueryAccountDto(QueryAccountDto queryAccountDto);

    /**
     * 批量删除账户
     * @param batchDeleteAccountDto
     * @return
     */
    boolean batchDisableAccount(BatchDeleteAccountDto batchDeleteAccountDto);
}
