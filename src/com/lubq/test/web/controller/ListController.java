package com.lubq.test.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lubq.test.web.bo.Customer;
import com.lubq.test.web.service.ICustomerService;
import com.lubq.test.web.service.IDishService;

@Controller
public class ListController {
	private final Logger LOGGER = LoggerFactory.getLogger(ListController.class);
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private IDishService dishService;
	
    @RequestMapping(value = "/list")
    public String doList(ModelMap model) throws Exception {
    	//
    	List<Customer> customerList = customerService.findAllCustomerUser();
    	LOGGER.info("customer list size:{}",new Object[]{customerList.size()});
    	model.put("customerList", customerList);
    	//
//    	makeSQLException();
//    	makeException();
        return "list";
    }
    
//	private void makeSQLException() throws SQLException {
//		throw new SQLException();
//		
//	}
//	private void makeException() throws java.lang.Exception {
//		throw new java.lang.Exception();
//		
//	}
    @RequestMapping(value = "/customerDel")
    public String doCustomerDel(Customer formCustomer,ModelMap model) throws Exception {
    	//
    	LOGGER.info("customer del :{}",formCustomer.getUserId());
    	Customer  dbcustomer = customerService.find(formCustomer.getUserId());
        customerService.delCustomer(dbcustomer);
        return doList(model);
    }
    
    
}
