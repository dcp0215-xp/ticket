package com.dcp.ticket.base.vo;

import com.dcp.ticket.base.constant.HttpCode;
import lombok.*;

/**
 * 返回结果对象
 *
 * @author dcp
 * @since 2020-08-12 07:26:00
 */
@Data
@ToString(exclude = "data")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResultVO {
  /** HTTP 状态码 */
  private Integer code;
  /** 结果信息 */
  private String message;
  /** 结果数据 */
  private Object data;

  public static ResultVO success(String message, Object data) {
    return new ResultVO(HttpCode.SUCCESS.getCode(), message, data);
  }

  public static ResultVO success(String message) {
    return success(message, null);
  }

  public static ResultVO success(Object data) {
    return success("", data);
  }

  public static ResultVO error(HttpCode code, String message, Object data) {
    return new ResultVO(code.getCode(), message, data);
  }

  public static ResultVO error(HttpCode code, String message) {
    return error(code, message, null);
  }

  public static ResultVO error(HttpCode code, Object data) {
    return error(code, "", data);
  }

  public static ResultVO error(HttpCode code) {
    return error(code, code.getExplain(), null);
  }
}
