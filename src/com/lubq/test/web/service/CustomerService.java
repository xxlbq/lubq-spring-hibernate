package com.lubq.test.web.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lubq.test.web.bo.Customer;
import com.lubq.test.web.dao.IGeneralDao;

@Transactional
public class CustomerService implements ICustomerService {
	private final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
	@Autowired
	private IGeneralDao<Customer, Integer> generalDao;
	
	/* (non-Javadoc)
	 * @see com.lubq.test.web.service.ICustomerService#update(com.lubq.test.web.bo.Customer)
	 */
	@Transactional ( readOnly=false, propagation = Propagation.REQUIRES_NEW )
	public Customer update(Customer customer){
		Customer user = generalDao.update(customer);
		return user;
	}
	
	/* (non-Javadoc)
	 * @see com.lubq.test.web.service.ICustomerService#find(java.lang.Integer)
	 */
	public Customer find(Integer id){
		Customer user = generalDao.find(Customer.class, id);
		return user;
	}
	/* (non-Javadoc)
	 * @see com.lubq.test.web.service.ICustomerService#findReference(java.lang.Integer)
	 */
	public Customer findReference(Integer id){
		Customer user = generalDao.findReference(Customer.class, id);
		return user;
	}
	
	/* (non-Javadoc)
	 * @see com.lubq.test.web.service.ICustomerService#findCustomerByName(java.lang.String)
	 */
	public Customer findCustomerByName(String name){
		Map<Integer,Object> map = new HashMap<Integer,Object>();
		map.put(1, name);
		List<Customer> users = generalDao.findList("select c from Customer c where c.username=?1 ", Customer.class,map);
		return users.size()>0?users.get(0):null;
	}
	
	/* (non-Javadoc)
	 * @see com.lubq.test.web.service.ICustomerService#findAllCustomerUser()
	 */
	public List<Customer> findAllCustomerUser(){
		return  generalDao.findList("select c from Customer c ",Customer.class,null);
	}
	
	/* (non-Javadoc)
	 * @see com.lubq.test.web.service.ICustomerService#saveCustomer(com.lubq.test.web.bo.Customer)
	 */
	@Transactional ( readOnly=false, propagation = Propagation.REQUIRES_NEW )
	public boolean saveCustomer(Customer customer){
		LOGGER.info("saveCustomer INFO:{}",customer);
		return generalDao.save(customer);
	}
	
	@Transactional ( readOnly=false, propagation = Propagation.REQUIRES_NEW )
	public void delCustomer(Customer customer){
		LOGGER.info("delCustomer INFO:{}",customer);
		generalDao.delete(customer);
	}
}
