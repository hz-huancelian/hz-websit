package com.hz.websit.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 项目名称：hz-websit
 * 类 名 称：WCusSeekVo
 * 类 描 述：TODO
 * 创建时间：2021/8/23 10:54 上午
 * 创 建 人：guan
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class WCusSeekVo implements Serializable {

    private static final long serialVersionUID = 11L;

    private Long id;

    /**
     * 机构名称
     */
    private String organName;

    /**
     * 机构代码
     */
    private String organNo;

    /**
     * 机构法人
     */
    private String organLegal;

    /**
     * 联系人
     */
    private String link;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

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
