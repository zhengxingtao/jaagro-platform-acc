package com.jaagro.account.api.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *创建账户参数
 * @author yj
 * @date 2018/10/23
 */
@Data
@Accessors(chain = true)
public class CreateAccountDto implements Serializable{

    private static final long serialVersionUID = -2794054642508531240L;
    /**
     * 用户id
     */
    @NotNull(message = "{userId.NotNull}")
    @Min(value = 1,message = "{userId.Min}")
    private Integer userId;
    /**
     * 用户类型1-客户 2-司机
     */
    @NotNull(message = "{userType.NotNull}")
    @Min(value = 1,message = "{userType.Min}")
    private Integer userType;
    /**
     * 账户类型1-现金账户 2-保证金账户
     */
    @NotNull(message = "{accountType.NotNull}")
    @Min(value = 1,message = "{accountType.Min}")
    private Integer accountType;
    /**
     * 创建人用户id
     */
    @NotNull(message = "{createUserId.NotNull}")
    @Min(value = 1,message = "{createUserId.Min}")
    private Integer createUserId;
}
