package com.dcp.ticket.base.config;

import com.dcp.ticket.custom.model.Customer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求拦截器
 *
 * @author dcp
 * @since 2020-08-12 20:17:00
 */
public class ReqInterceptor extends HandlerInterceptorAdapter {

  private static String LOGIN_PATH = "/login";

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    // 查看session是否存在customer，如果存在则用户登录过，反之需要跳转到登录页面进行重新登录
    Customer customer = (Customer) request.getSession().getAttribute("customer");
    if (customer == null) {
      // 重定向到登录页面进行登录
      response.sendRedirect(request.getContextPath() + LOGIN_PATH);
    }
    return customer != null;
  }
}
