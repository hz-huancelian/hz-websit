package com.hz.websit.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 项目名称：hz-websit
 * 类 名 称：WCusSearchVo
 * 类 描 述：TODO
 * 创建时间：2021/8/22 5:17 下午
 * 创 建 人：guan
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class WCusSearchVo implements Serializable {

    private static final long serialVersionUID = 11L;

    // 内容标题
    private String title;
    
}
