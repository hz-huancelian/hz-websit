package com.hz.websit.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDateTime;

/**
 * 项目名称：hz-websit
 * 类 名 称：WCustomerVo
 * 类 描 述：TODO
 * 创建时间：2021/8/22 4:40 下午
 * 创 建 人：guan
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class WCustomerVo implements Serializable {

    private static final long serialVersionUID = 11L;

    private Long id;
    /**
     * 首页用小图片
     */
    private String imgUrl;

    /**
     * 客户服务用大图片
     */
    private String bigImgUrl;

    /**
     * 客户logo
     */
    private String logo;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容体
     */
    private String content;


    /**
     * 排序标记
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
