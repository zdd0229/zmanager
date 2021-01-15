package com.z.domain;

import com.z.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Account extends BaseEntity implements Serializable {

    private Integer id;

    private String name;

    private BigDecimal balance;

    private Date openTime;

}
