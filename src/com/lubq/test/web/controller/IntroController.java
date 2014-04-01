package com.lubq.test.web.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lubq.test.web.bo.Customer;
import com.lubq.test.web.bo.Dish;
import com.lubq.test.web.service.ICustomerService;
import com.lubq.test.web.service.IDishService;

@Controller
public class IntroController {

	private final Logger LOGGER = LoggerFactory.getLogger(IntroController.class);

	@Autowired
	private IDishService dishService;
	@Autowired
	private ICustomerService customerService;
	
	
    @RequestMapping("/intro")
    public String introList(ModelMap model) {
    	
    	List<Dish> dishList = dishService.findAllDish();
    	model.put("dishList", dishList);
    	LOGGER.info("dish list size :{}",dishList.size());
        return "intro";
    }
	
    @RequestMapping(value = "/dishCheck")
    public String doDishCheck(Dish dish,ModelMap model) throws java.lang.IllegalStateException {
    	//
    	LOGGER.info("dis selected :{}",dish.getDishId());
    	Customer  customer = customerService.find(1);
    	Set<Dish> dishes = customer.getDishes() == null ?  new HashSet<Dish>(): customer.getDishes() ;

    	dishes.add(dishService.find(dish.getDishId()));
        customer.setDishes(dishes);
        customerService.update(customer);
        
        
        return introList(model);
    }
    
    @RequestMapping(value = "/dishUnCheck")
    public String doDishUnCheck(Dish dish,ModelMap model) throws java.lang.IllegalStateException {
    	//
    	LOGGER.info("dis unCheck :{}",dish.getDishId());
    	Customer  customer = customerService.find(1);
    	Set<Dish> dishes = customer.getDishes() == null ?  new HashSet<Dish>(): customer.getDishes() ;

    	dishes.remove(dishService.find(dish.getDishId()));
        customer.setDishes(dishes);
        customerService.update(customer);
        
        
        return introList(model);
    }

}
