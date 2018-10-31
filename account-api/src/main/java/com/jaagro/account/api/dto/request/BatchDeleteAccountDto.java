package com.jaagro.account.api.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 批量删除账户参数 - 逻辑删除
 * @author yj
 * @date 2018/10/26
 */
@Data
@Accessors(chain = true)
public class BatchDeleteAccountDto implements Serializable {
    /**
     * 用户id列表
     */
    @NotEmpty(message = "{userIdList.NotEmpty}")
    private List<Integer> userIdList;
    /**
     * 用户类型 1-客户,2-司机
     */
    @NotNull(message = "{userType.NotNull}")
    @Min(value = 1,message = "{userType.Min}")
    private Integer userType;
    /**
     * 账户类型 1-现金,2-保证金
     */
    @NotNull(message = "{accountType.NotNull}")
    @Min(value = 1,message = "{accountType.Min}")
    private Integer accountType;
    /**
     * 修改人
     */
    @NotBlank
    private Integer modifyUserId;
}
