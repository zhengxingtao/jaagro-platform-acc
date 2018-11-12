package com.jaagro.account.biz.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yj
 * 账户变更记录
 */
public class AccountChangeRecord implements Serializable{
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

    /**
     * 账户变更记录表id
     * @return id 账户变更记录表id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 账户变更记录表id
     * @param id 账户变更记录表id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 账户id
     * @return account_id 账户id
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * 账户id
     * @param accountId 账户id
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * 变更类型 1-收入  2-支出
     * @return change_type 变更类型 1-收入  2-支出
     */
    public Integer getChangeType() {
        return changeType;
    }

    /**
     * 变更类型 1-收入  2-支出
     * @param changeType 变更类型 1-收入  2-支出
     */
    public void setChangeType(Integer changeType) {
        this.changeType = changeType;
    }

    /**
     * 业务类型11-账户充值  12-账户取现 21-运费收入 22-运费支出 
     * @return biz_type 业务类型11-账户充值  12-账户取现 21-运费收入 22-运费支出 
     */
    public Integer getBizType() {
        return bizType;
    }

    /**
     * 业务类型11-账户充值  12-账户取现 21-运费收入 22-运费支出 
     * @param bizType 业务类型11-账户充值  12-账户取现 21-运费收入 22-运费支出 
     */
    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    /**
     * 关联到业务的ID
     * @return biz_refer_id 关联到业务的ID
     */
    public Integer getBizReferId() {
        return bizReferId;
    }

    /**
     * 关联到业务的ID
     * @param bizReferId 关联到业务的ID
     */
    public void setBizReferId(Integer bizReferId) {
        this.bizReferId = bizReferId;
    }

    /**
     * 备注
     * @return notes 备注
     */
    public String getNotes() {
        return notes;
    }

    /**
     * 备注
     * @param notes 备注
     */
    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    /**
     * 发生余额
     * @return balance 发生余额
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 发生余额
     * @param balance 发生余额
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 发生金额
     * @return amount 发生金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 发生金额
     * @param amount 发生金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 变更状态1-成功 2-进行中 3-失败
     * @return change_status 变更状态1-成功 2-进行中 3-失败
     */
    public Integer getChangeStatus() {
        return changeStatus;
    }

    /**
     * 变更状态1-成功 2-进行中 3-失败
     * @param changeStatus 变更状态1-成功 2-进行中 3-失败
     */
    public void setChangeStatus(Integer changeStatus) {
        this.changeStatus = changeStatus;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     * @return modify_time 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 修改时间
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 创建人
     * @return create_user_id 创建人
     */
    public Integer getcreateUserId() {
        return createUserId;
    }

    /**
     * 创建人
     * @param createUserId 创建人
     */
    public void setcreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 修改人
     * @return modify_user_id 修改人
     */
    public Integer getModifyUserId() {
        return modifyUserId;
    }

    /**
     * 修改人
     * @param modifyUserId 修改人
     */
    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }
}