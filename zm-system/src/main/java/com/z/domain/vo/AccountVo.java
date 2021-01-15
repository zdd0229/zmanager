package com.z.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AccountVo {
    private Long accountId;
    private String name;
    private BigDecimal balance;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date openTime;
}
