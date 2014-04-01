package com.lubq.test.web.service;

import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lubq.test.web.bo.Customer;

public class DaoTest {

	ICustomerService cs = null;
	ApplicationContext ctx = null;
	
	@Before
	public void before() {
		ctx = new FileSystemXmlApplicationContext("E:/java/eclipse-workspace-20131230/lubqtest/WebContent/WEB-INF/spring-context/applicationContext.xml");
		cs = (ICustomerService)ctx.getBean("customerService");
	}

	@After
	public void after() {
		cs =null;
		ctx = null;
	}

	@Test
	public void testCreate() {
		Customer customer = new Customer();
		customer.setUsername("tomcat6");
		cs.saveCustomer(customer);

	}
	@Test
	public void testFindAll() {
		List<Customer> custs = cs.findAllCustomerUser();
		Assert.assertNotNull(custs);
		Assert.assertEquals(true, custs.size() > 0);
		for (Customer customer : custs) {
			System.out.println(customer);
		}
	}
	
	@Test
	public void testFindCustomerByName() {
		Customer cust = cs.findCustomerByName("tomcat1");
		Assert.assertNotNull(cust);
		Assert.assertEquals(true, cust.getUserId() ==1);

	}

}
