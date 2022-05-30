package com.hz.websit.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDateTime;

/**
 * 项目名称：hz-websit
 * 类 名 称：WServerCustomerVo
 * 类 描 述：TODO
 * 创建时间：2021/8/23 1:54 下午
 * 创 建 人：guan
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class WServerCustomerVo implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;

    /**
     * swiper图片
     */
    private String imgUrl;

    /**
     * 企业logo
     */
    private String logo;

    /**
     * 外链地址
     */
    private String routerUrl;

    /**
     * 企业名称
     */
    private String enterName;

    /**
     * 企业分类
     */
    private String serverType;

    /**
     * 企业分类-对应value
     */
    private String serverTypeVal;

    /**
     * 标题
     */
    private String title;

    /**
     * 评论信息
     */
    private String comment;

    /**
     * 公司描述
     */
    private String serverDesc;

    /**
     * 描述信息落款
     */
    private String descSign;


    /**
     * 内容体
     */
    private String content;

    /**
     * 排序
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
