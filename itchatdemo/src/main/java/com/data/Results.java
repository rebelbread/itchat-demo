package com.data;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhiwj
 * @date 2018/9/10
 */
@Data
public class Results implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer groupType;
    private String resultType;
    private Values values;

}
