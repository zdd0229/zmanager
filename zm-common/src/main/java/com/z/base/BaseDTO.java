package com.z.base;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class BaseDTO implements Serializable {

    private String createBy;

    private String updatedBy;

    private Timestamp createTime;

    private Timestamp updateTime;

}
