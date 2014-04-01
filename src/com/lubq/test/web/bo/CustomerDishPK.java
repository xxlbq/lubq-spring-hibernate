package com.lubq.test.web.bo;

import java.io.Serializable;

public class CustomerDishPK implements Serializable {

	private static final long serialVersionUID = -7442820542437923149L;
	private Integer userId;
	private Integer dishId;

	public CustomerDishPK() {
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dishId == null) ? 0 : dishId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDishPK other = (CustomerDishPK) obj;
		if (dishId == null) {
			if (other.dishId != null)
				return false;
		} else if (!dishId.equals(other.dishId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}


}
