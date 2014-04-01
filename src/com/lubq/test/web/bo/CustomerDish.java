package com.lubq.test.web.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@IdClass(CustomerDishPK.class)
@Entity
@Table(name = "CUSTOMER_DISH")
public class CustomerDish implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5942316854433088094L;

	@Id
	@Column(name = "uid")

	private Integer userId;

	@Id
	@Column(name = "did")

	private Integer dishId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDishId() {
		return dishId;
	}

	public void setDishId(Integer dishId) {
		this.dishId = dishId;
	}
	
}
