package com.jaagro.account.biz.mapper;

import com.jaagro.account.biz.entity.AccountChangeRecord;
import org.springframework.stereotype.Repository;

/**
 * @author yj
 */
@Repository
public interface AccountChangeRecordMapper {
    /**
     *
     * @mbggenerated 2018-10-23
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-10-23
     */
    int insert(AccountChangeRecord record);

    /**
     *
     * @mbggenerated 2018-10-23
     */
    int insertSelective(AccountChangeRecord record);

    /**
     *
     * @mbggenerated 2018-10-23
     */
    AccountChangeRecord selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-10-23
     */
    int updateByPrimaryKeySelective(AccountChangeRecord record);

    /**
     *
     * @mbggenerated 2018-10-23
     */
    int updateByPrimaryKey(AccountChangeRecord record);
}