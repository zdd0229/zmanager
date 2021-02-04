package com.z.business.rest;

import com.github.pagehelper.PageInfo;
import com.z.business.domain.entity.Account;
import com.z.business.domain.vo.AccountVo;
import com.z.business.service.AccountService;
import com.z.business.domain.query.AccountQuery;
import com.z.utils.BeanCopierUtils;
import com.z.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("accounts")
@Api(tags = "账户管理")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping
    @ApiOperation("新增账户")
    public ResponseEntity addOne(@RequestBody @Validated Account account){
        return R.create(accountService.addAccount(account)) ;
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除账户")
    public ResponseEntity delOne(@PathVariable("id") Integer id){
        return R.create(accountService.delAccount(id)) ;
    }

    @PatchMapping("/{id}/balance")
    @ApiOperation("修改余额")
    public ResponseEntity changeBalance(@PathVariable("id") Integer id, BigDecimal balance){
        return R.create(accountService.changeBalance(id,balance)) ;
    }

    @GetMapping
    @ApiOperation("条件查询")
    public ResponseEntity getSome(HttpServletRequest request , AccountQuery query){

        List<Account> some = accountService.getSome(query);
        PageInfo pageInfo = new PageInfo(some);
        pageInfo.setList(BeanCopierUtils.copyList(Account.class, AccountVo.class, some));
        return R.create(pageInfo);
    }

}
