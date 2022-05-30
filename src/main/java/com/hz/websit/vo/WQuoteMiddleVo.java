package com.hz.websit.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 项目名称：hz-websit
 * 类 名 称：WQuoteMiddleVo
 * 类 描 述：TODO
 * 创建时间：2021/8/23 1:54 下午
 * 创 建 人：guan
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class WQuoteMiddleVo implements Serializable {

    private static final long serialVersionUID=1L;

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
     * 视频地址
     */
    private String videoUrl;

    /**
     * 删除标识
     */
    private Integer sort;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime updateTime;

}
