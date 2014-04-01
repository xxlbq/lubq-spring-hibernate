package com.lubq.test.web.controller;

import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lubq.test.web.bo.Customer;
import com.lubq.test.web.service.ICustomerService;


@Controller
public class RegController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(RegController.class);
	@Autowired
	private ICustomerService customerService;
    @RequestMapping("/reg")
    public String reg(ModelMap model) {
    	Customer customer = new Customer();
    	model.addAttribute("customer", customer);
        return "reg";
    }
    @RequestMapping(value = "doReg", method = RequestMethod.POST)
    public String doReg(@ModelAttribute("customer")@Valid Customer cust, BindingResult bindingResult,ModelMap model) {
    	//
    	if (bindingResult.hasErrors()){
    		return "reg";
    	}
    	LOGGER.info("CUSTOMER INFO:{}",cust);
    	cust.setRegisterDate(new Date());
    	boolean done = customerService.saveCustomer(cust);
    	LOGGER.info("CUSTOMER INFO SAVE:{}",done);

    	//
        return "success";
    }

    
}