package com.jaagro.account.web.controller;

import com.alibaba.fastjson.JSON;
import com.jaagro.account.api.dto.request.BatchDeleteAccountDto;
import com.jaagro.account.api.dto.request.CreateAccountDto;
import com.jaagro.account.api.dto.request.QueryAccountDto;
import com.jaagro.account.api.dto.request.UpdateAccountDto;
import com.jaagro.account.api.dto.response.AccountReturnDto;
import com.jaagro.account.api.service.AccountService;
import com.jaagro.account.web.vo.AccountVo;
import com.jaagro.utils.BaseResponse;
import com.jaagro.utils.ResponseStatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author yj
 * @date 2018/10/23
 * 账户操作
 */
@RestController
@Slf4j
@Api(value = "account", description = "账户管理", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

    @Autowired
    private AccountService accountService;
    /**
     * 新增账户
     * @param createAccountDto
     * @return
     */
    @PostMapping("/account")
    @ApiOperation("新增账户")
    public BaseResponse insertAccount(@RequestBody @Validated CreateAccountDto createAccountDto){
        log.debug("insertAccount begin,{}", JSON.toJSONString(createAccountDto));
        Integer id = accountService.createAccount(createAccountDto);
        if (id != null && id > 0){
            return BaseResponse.successInstance("创建账户成功");
        }
        return BaseResponse.errorInstance("创建账户失败");
    }

    /**
     * 修改账户
     * @param updateAccountDto
     * @return
     */
    @PutMapping("/account")
    @ApiOperation("修改账户")
    public BaseResponse updateAccount(@RequestBody @Validated UpdateAccountDto updateAccountDto){
        log.debug("updateAccount begin,{}",JSON.toJSONString(updateAccountDto));
        boolean result = accountService.updateAccount(updateAccountDto);
        if (result){
            return BaseResponse.successInstance("修改账户成功");
        }
        return BaseResponse.errorInstance("修改账户失败");
    }

    /**
     * 删除账户
     * @param id
     * @return
     */
    @DeleteMapping("/account/{id}")
    @ApiOperation("删除账户")
    public BaseResponse deleteAccount(@PathVariable Integer id){
        log.debug("deleteAccount begin,id={}",id);
        boolean result = accountService.disableAccount(id);
        if (result){
            return BaseResponse.successInstance("删除账户成功");
        }
        return BaseResponse.errorInstance("删除账户失败");
    }

    /**
     * 查询账户
     * @param id
     * @return
     */
    @GetMapping("/account/{id}")
    @ApiOperation("查询账户")
    public BaseResponse getAccount(@PathVariable Integer id){
        log.debug("get Account begin id={}",id);
        AccountReturnDto accountDto = accountService.getById(id);
        if (accountDto == null){
            return BaseResponse.errorInstance(ResponseStatusCode.ID_VALUE_ERROR.getCode(),"账户不存在");
        }
        AccountVo accountVo = new AccountVo();
        BeanUtils.copyProperties(accountDto,accountVo);
        return BaseResponse.successInstance(accountVo);
    }

    /**
     * 查询账户信息
     * @param queryAccountDto
     * @return
     */
    @PostMapping("/getByQueryAccountDto")
    @ApiOperation("查询账户信息")
    public AccountReturnDto getByQueryAccountDto(@RequestBody @Validated QueryAccountDto queryAccountDto){
        log.debug("getAccountDto begin,{}",JSON.toJSONString(queryAccountDto));
        AccountReturnDto accountDto = accountService.getByQueryAccountDto(queryAccountDto);
        if (accountDto == null){
            return null;
        }
        return accountDto;
    }

    /**
     * 批量删除账户
     * @param batchDeleteAccountDto
     * @return
     */
    @DeleteMapping("/batchDelete")
    @ApiOperation("批量删除账户")
    public BaseResponse batchDelete(@RequestBody @Validated BatchDeleteAccountDto batchDeleteAccountDto){
        log.debug("batchDelete begin,batchDeleteAccountDto={}",batchDeleteAccountDto);
        boolean result = accountService.batchDisableAccount(batchDeleteAccountDto);
        if (result){
            return BaseResponse.successInstance("批量删除账户成功");
        }
        return BaseResponse.errorInstance("批量删除账户失败");
    }
}
