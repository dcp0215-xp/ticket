package com.dcp.ticket.login.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 登录传值表
 *
 * @author dcp
 * @since 2020-08-11 19:00:44
 */
@Data
public class LoginVO implements Serializable {
  private static final long serialVersionUID = 237273602515358046L;
  /** 登录名 */
  private String loginName;
  /** 密码 */
  private String password;
  /** 邮箱 */
  private String email;
  /** 手机号 */
  private String phone;
}
