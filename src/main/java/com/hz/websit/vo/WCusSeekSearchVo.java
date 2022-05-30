package com.hz.websit.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 项目名称：hz-websit
 * 类 名 称：WCusSeekSearchVo
 * 类 描 述：TODO
 * 创建时间：2021/8/23 10:52 上午
 * 创 建 人：guan
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class WCusSeekSearchVo implements Serializable {


    private static final long serialVersionUID = 11L;

    // 内容标题
    private String organName;

    // 内容标题
    private String organNo;

}
