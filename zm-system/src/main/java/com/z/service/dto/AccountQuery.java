package com.z.service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountQuery {
    private String name;

    private BigDecimal balanceStart;
    private BigDecimal balanceEnd;

    private String openTimeStart;
    private String openTimeEnd;
}
