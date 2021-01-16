package com.z.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseDTO implements Serializable {

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

}
