package com.dcp.ticket.custom.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 顾客表(Customer)实体类
 *
 * @author dcp
 * @since 2020-08-11 19:00:44
 */
@Data
public class Customer implements Serializable {
  private static final long serialVersionUID = 237273602515358046L;
  /**
   * 主键
   */
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;
  /**
   * 登录名
   */
  private String loginName;
  /**
   * 密码
   */
  private String password;
  /**
   * 昵称
   */
  private String nickName;
  /**
   * 邮箱
   */
  private String email;
  /**
   * 手机号
   */
  private String phone;
  /**
   * 地址
   */
  private String address;
  /**
   * 账号创建时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createTime;
  /**
   * 会员等级
   */
  private String memberLevel;
}