package com.jaagro.account.biz.mapper;

import com.jaagro.account.api.dto.request.BatchDeleteAccountDto;
import com.jaagro.account.biz.entity.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户CRUD扩展
 * @author yj
 * @date 2018/10/24
 */

public interface AccountMapperExt extends AccountMapper {
    /**
     * 查询有效账户
     * @param accountType 账户类型
     * @param userId 用户id
     * @param userType 用户类型
     * @return
     */
    Account selectActiveAccount(@Param("accountType") Integer accountType, @Param("userId") Integer userId, @Param("userType") Integer userType);

    /**
     * 批量删除账户
     * @param batchDeleteAccountDto
     * @return
     */
    Integer batchDisableAccount(BatchDeleteAccountDto batchDeleteAccountDto);
}
