package com.data;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhiwj
 * @date 2018/9/10
 */
@Data
public class TulingResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private Emotion emotion;
    private Intent intent;
    private List<Results> results;

}
