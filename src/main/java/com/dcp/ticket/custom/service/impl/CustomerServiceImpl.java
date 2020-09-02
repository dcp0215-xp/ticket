package com.dcp.ticket.custom.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dcp.ticket.custom.mapper.CustomerMapper;
import com.dcp.ticket.custom.model.Customer;
import com.dcp.ticket.custom.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 顾客表(Customer)表服务实现类
 *
 * @author dcp
 * @since 2020-08-11 19:00:48
 */
@Service("customerService")
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
  @Resource
  private CustomerMapper customerMapper;
}