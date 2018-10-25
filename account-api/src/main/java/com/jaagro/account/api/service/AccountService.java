package com.jaagro.account.api.service;

import com.jaagro.account.api.dto.request.UpdateAccountDto;
import com.jaagro.account.api.dto.request.CreateAccountDto;
import com.jaagro.account.api.dto.response.AccountDto;

import java.util.Map;

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
    AccountDto getById(Integer id);

    /**
     * 删除账户
     * @param id
     * @return
     */
    boolean disableAccount(Integer id);
}
