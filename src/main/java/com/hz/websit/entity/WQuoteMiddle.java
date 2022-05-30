package com.hz.websit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.sql.Blob;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author gzh
 * @since 2021-08-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("w_quote_middle")
public class WQuoteMiddle extends Model<WQuoteMiddle> {

    private static final long serialVersionUID=1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * swiper图片
     */
    @TableField("imgUrl")
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
    @TableField("videoUrl")
    private String videoUrl;

    /**
     * 删除标识
     */
    private Integer delFlag;

    /**
     * 删除标识
     */
    private Integer sort;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField("updateTime")
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
