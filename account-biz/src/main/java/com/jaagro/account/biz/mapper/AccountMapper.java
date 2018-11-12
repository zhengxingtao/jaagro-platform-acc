package com.jaagro.account.biz.mapper;

import com.jaagro.account.biz.entity.Account;
import org.springframework.stereotype.Repository;

/**
 * @author yj
 */
public interface AccountMapper {
    /**
     *
     * @mbggenerated 2018-10-23
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-10-23
     */
    int insert(Account record);

    /**
     *
     * @mbggenerated 2018-10-23
     */
    int insertSelective(Account record);

    /**
     *
     * @mbggenerated 2018-10-23
     */
    Account selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-10-23
     */
    int updateByPrimaryKeySelective(Account record);

    /**
     *
     * @mbggenerated 2018-10-23
     */
    int updateByPrimaryKey(Account record);
}