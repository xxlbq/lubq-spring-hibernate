package com.lubq.test.web.service;

import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lubq.test.web.bo.Customer;
import com.lubq.test.web.bo.Dish;

public class BindTest {

	ICustomerService cs = null;
	IDishService ds = null;
	ApplicationContext ctx = null;
	
	@Before
	public void before() {
		ctx = new FileSystemXmlApplicationContext("E:/java/eclipse-workspace-20131230/lubqtest/WebContent/WEB-INF/spring-context/applicationContext.xml");
		cs = (ICustomerService)ctx.getBean("customerService");
		ds = (IDishService)ctx.getBean("dishService");
	}

	@After
	public void after() {
		ds = null;
		cs = null;
		ctx = null;
	}

	@Test
	public void testCreate() {
		Customer customer = new Customer();
		customer.setUsername("tomcat699955");
		cs.saveCustomer(customer);

		Dish dish = new Dish();
		dish.setDishname("noodl55e");
		ds.saveDish(dish);
		
	}
	
	@Test
    public void bind() {  

    	Customer customer = cs.find(1);  
    	
    	Assert.assertNotNull(customer);

    	
    	Set<Dish> dishes = new HashSet<Dish>();
    	dishes.add(ds.find(1));
        customer.setDishes(dishes);

    	cs.update(customer);
    }
}
