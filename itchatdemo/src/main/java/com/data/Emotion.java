package com.data;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhiwj
 * @date 2018/9/10
 */
@Data
public class Emotion implements Serializable {
    private static final long serialVersionUID = 1L;
    private RobotEmotion robotEmotion;
    private UserEmotion userEmotion;
}
