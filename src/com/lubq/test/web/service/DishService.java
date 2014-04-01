package com.lubq.test.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lubq.test.web.bo.Dish;
import com.lubq.test.web.dao.IGeneralDao;

@Transactional
public class DishService implements IDishService {
	private final Logger LOGGER = LoggerFactory.getLogger(DishService.class);
	@Autowired
	private IGeneralDao<Dish, Integer> generalDao;
	
	
	/* (non-Javadoc)
	 * @see com.lubq.test.web.service.IDishService#find(java.lang.Integer)
	 */
	@Override
	public Dish find(Integer id){
		Dish dish = generalDao.find(Dish.class, id);
		return dish;
	}
	/* (non-Javadoc)
	 * @see com.lubq.test.web.service.IDishService#findReference(java.lang.Integer)
	 */
	@Override
	public Dish findReference(Integer id){
		Dish dish = generalDao.findReference(Dish.class, id);
		return dish;
	}
	/* (non-Javadoc)
	 * @see com.lubq.test.web.service.IDishService#findDishByName(java.lang.String)
	 */
	@Override
	public Dish findDishByName(String name){
		Map<Integer,Object> map = new HashMap<Integer,Object>();
		map.put(1, name);
		List<Dish> users = generalDao.findList("select c from Dish c where c.dishname=?1 ", Dish.class,map);
		return users.size()>0?users.get(0):null;
	}
	
	/* (non-Javadoc)
	 * @see com.lubq.test.web.service.IDishService#findAllDish()
	 */
	@Override
	public List<Dish> findAllDish(){
		return  generalDao.findList("select c from Dish c ",Dish.class,null);
	}
	
	/* (non-Javadoc)
	 * @see com.lubq.test.web.service.IDishService#saveDish(com.lubq.test.web.bo.Dish)
	 */
	@Override
	@Transactional ( readOnly=false, propagation = Propagation.REQUIRES_NEW )
	public boolean saveDish(Dish Dish){
		LOGGER.info("saveDish INFO:{}",Dish);
		return generalDao.save(Dish);
	}
}
