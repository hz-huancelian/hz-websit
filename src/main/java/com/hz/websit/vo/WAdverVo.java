package com.hz.websit.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.sql.Blob;

/**
 * 项目名称：hz-websit
 * 类 名 称：WAdverVo
 * 类 描 述：TODO
 * 创建时间：2021/8/22 8:16 下午
 * 创 建 人：guan
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class WAdverVo {

    private Long id;

    /**
     * swiper图片
     */
    private String imgUrl;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容体
     */
    private String content;

    /**
     * 外链地址
     */
    private String routerUrl;

    /**
     * 排序标记
     */
    private Integer sort;

    private Integer showPage;
}
