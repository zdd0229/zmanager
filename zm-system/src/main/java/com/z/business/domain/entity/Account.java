package com.z.business.domain.entity;

import com.z.base.BaseEntity;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Account extends BaseEntity implements Serializable {

    private Integer id;

    @NotEmpty(message = "名称不能为空")
    private String name;

    @NotNull(message = "余额不能为空")
    private BigDecimal balance;

    @NotNull(message = "开户时间不能为空")
    private Date openTime;

}
