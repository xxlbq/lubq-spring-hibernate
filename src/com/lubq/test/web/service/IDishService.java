package com.lubq.test.web.service;

import java.util.List;

import com.lubq.test.web.bo.Dish;

public interface IDishService {

	public Dish find(Integer id);

	public Dish findReference(Integer id);

	public Dish findDishByName(String name);

	public List<Dish> findAllDish();

	public boolean saveDish(Dish Dish);

}