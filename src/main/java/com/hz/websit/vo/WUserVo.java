package com.hz.websit.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 项目名称：hz-websit
 * 类 名 称：WUserVo
 * 类 描 述：TODO
 * 创建时间：2021/8/23 4:58 下午
 * 创 建 人：guan
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WUserVo implements Serializable {

    private static final long serialVersionUID=1L;


    /**
     * 用户名称
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
