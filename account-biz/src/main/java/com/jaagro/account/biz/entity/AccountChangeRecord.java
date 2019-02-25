package com.jaagro.account.biz.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yj
 * 账户变更记录
 */
@Data
@Accessors(chain = true)
public class AccountChangeRecord implements Serializable{
    private static final long serialVersionUID = 6310380686264089718L;
    /**
     * 账户变更记录表id
     */
    private Integer id;

    /**
     * 账户id
     */
    private Integer accountId;

    /**
     * 变更类型 1-收入  2-支出
     */
    private Integer changeType;

    /**
     * 业务类型11-账户充值  12-账户取现 21-运费收入 22-运费支出 
     */
    private Integer bizType;

    /**
     * 关联到业务的ID
     */
    private Integer bizReferId;

    /**
     * 备注
     */
    private String notes;

    /**
     * 发生余额
     */
    private BigDecimal balance;

    /**
     * 发生金额
     */
    private BigDecimal amount;

    /**
     * 变更状态1-成功 2-进行中 3-失败
     */
    private Integer changeStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 创建人
     */
    private Integer createUserId;

    /**
     * 修改人
     */
    private Integer modifyUserId;

}