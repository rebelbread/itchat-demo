package com.data;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhiwj
 * @date 2018/9/10
 */
@Data
public class Intent implements Serializable {
    private static final long serialVersionUID = 1L;
    private String actionName;
    private Integer code;
    private String intentName;
}
