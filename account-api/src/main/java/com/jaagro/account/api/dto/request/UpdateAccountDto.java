package com.jaagro.account.api.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 更新账户参数
 * @author yj
 * @date 2018/10/24
 */
@Data
@Accessors(chain = true)
public class UpdateAccountDto implements Serializable{

    private static final long serialVersionUID = -3667373826701820944L;
    /**
     * 账户id
     */
    @NotNull(message = "{accountId.NotNull}")
    @Min(value = 1,message = "{accountId.Min}")
    private Integer id;

    /**
     * 乐观锁版本号
     */
    @NotNull(message = "{version.NotNull}")
    private Integer version;

    /**
     * 账户类型1-现金账户 2-保证金账户
     */
    @Min(value = 1,message = "{accountType.Min}")
    private Integer accountType;

    /**
     * 用户id
     */
    @Min(value = 1,message = "{userId.Min}")
    private Integer userId;

    /**
     * 用户类型1-客户 2-司机
     */
    @Min(value = 1,message = "{userType.Min}")
    private Integer userType;

    /**
     * 支出总额
     */
    private BigDecimal credit;

    /**
     * 收入总额
     */
    private BigDecimal debit;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 账户状态1-正常 2-止收 3-止支 4-冻结
     */
    @Min(value = 1,message = "{accountStatus.Min}")
    private Integer accountStatus;

    /**
     * 创建人
     */
    @Min(value =1,message = "{createUserId.Min}")
    private Integer createUserId;

    /**
     * 修改人
     */
    @NotNull(message = "{modifyUserId.NotNull}")
    @Min(value =1,message = "{modifyUserId.Min}")
    private Integer modifyUserId;
}
