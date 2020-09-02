package com.dcp.ticket.login.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dcp.ticket.base.vo.ResultVO;
import com.dcp.ticket.custom.model.Customer;
import com.dcp.ticket.custom.service.CustomerService;
import com.dcp.ticket.login.model.LoginVO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 登录控制层
 *
 * @author dcp
 * @since 2020-08-11 19:00:49
 */
@RestController
@RequestMapping("")
public class LoginController {
  /** 服务对象 */
  @Resource private CustomerService customerService;
  @Resource private RedisTemplate redisTemplate;

  @GetMapping(value = {"index", "/"})
  public ResultVO index() {
    return ResultVO.success("欢迎来到首页页面");
  }

  @GetMapping(value = "login")
  public ResultVO login() {
    return ResultVO.success("欢迎来到登录页面");
  }

  @PostMapping(value = "loginChecked")
  public ResultVO loginChecked(LoginVO loginVO, HttpServletRequest request) {
    // 判断当前用户是否为系统用户
    Customer customer =
        this.customerService.getOne(
            new LambdaQueryWrapper<Customer>()
                .eq(Customer::getLoginName, loginVO.getLoginName())
                .eq(Customer::getPassword, loginVO.getPassword()));
    // 如果custom不为空，登录成功，写入session中，反之返回用户名密码不匹配
    request.getSession().setAttribute("customer", customer);
    return customer == null ? ResultVO.success("用户名密码不匹配") : ResultVO.success("success");
  }

  @GetMapping(value = "register")
  public ModelAndView register(Customer customer, HttpServletRequest request) {
    // 注册成功后，将注册用户放入session中
    request.getSession().setAttribute("customer", customer);
    return new ModelAndView("redirect:/");
  }

  @GetMapping(value = "logout")
  public ModelAndView logout(HttpServletRequest request) {
    // 将customer对象从session中移除
    request.getSession().removeAttribute("customer");
    return new ModelAndView("redirect:/");
  }
}
