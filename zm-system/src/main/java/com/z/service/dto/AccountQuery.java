package com.z.service.dto;

import com.z.base.BaseQuery;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountQuery extends BaseQuery {
    private String name;

    private BigDecimal balanceStart;
    private BigDecimal balanceEnd;

    private String openTimeStart;
    private String openTimeEnd;
}
