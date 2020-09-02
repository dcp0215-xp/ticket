package com.dcp.ticket.base.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * Http 常用状态码
 *
 * @author dcp
 * @since 2020-08-12 07:40:00
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum HttpCode {
  SUCCESS(200, "成功");

  @Getter private int code;
  @Getter private String explain;
}
