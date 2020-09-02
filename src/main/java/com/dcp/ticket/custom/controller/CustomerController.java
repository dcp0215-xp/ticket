package com.dcp.ticket.custom.controller;

import com.dcp.ticket.custom.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 顾客表(Customer)表控制层
 *
 * @author dcp
 * @since 2020-08-11 19:00:49
 */
@RestController
@RequestMapping("custom")
public class CustomerController {
  /**
   * 服务对象
   */
  @Resource
  private CustomerService customerService;

}