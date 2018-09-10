package com.data;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhiwj
 * @date 2018/9/10
 */
@Data
public class RobotEmotion implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer a;
    private Integer d;
    private Integer emotionId;
    private Integer p;

}
