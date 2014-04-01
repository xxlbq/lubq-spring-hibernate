package com.lubq.test.web.bo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.bval.constraints.NotEmpty;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3990799936886269793L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uid")
	private Integer userId;
	
	
	//
	@NotEmpty(message ="{username.notEmpty}")
	@Length( min=6,max =16, message = "{username.length.illegal}")
	
	@Column(name = "username", length = 50)
	 private String username;
	
	@Column(name = "address", length = 500)
	 private String address;
	
	@Column(name = "tel", length = 100)
	 private String tel;
	
	//
	@NotEmpty(message ="{email.notEmpty}")
	@Email(message="{email.Illegal}")
	
	
	@Column(name = "email", length = 200)
	 private String email;
	
	@Column(name = "memo", length = 200)
	 private String memo ;

	@Column(name = "registerDate")
	 private java.util.Date  registerDate;
	 
	@ManyToMany(cascade={CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER )
	@JoinTable(name = "CUSTOMER_DISH", 
	            joinColumns = { @JoinColumn(name = "userId",referencedColumnName = "uid") }, 
	            inverseJoinColumns = { @JoinColumn(name = "dishId",referencedColumnName = "did") })
	
	 private Set<Dish> dishes=new HashSet<Dish>();
	 
	 
	 public Customer() {
	}

	public Set<Dish> getDishes() {
		return dishes;
	}
	public void setDishes(Set<Dish> dishes) {
		this.dishes = dishes;
	}
	
    public void addDish(Dish dish) {
        if (!this.dishes.contains(dish)) {
            this.dishes.add(dish);
        }
    }

    public void removeDish(Dish dish) {
        if(this.dishes.contains(dish)){
            this.dishes.remove(dish);
        }
    }
	
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}


	public java.util.Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(java.util.Date registerDate) {
		this.registerDate = registerDate;
	}
	@Override
	public String toString() {
		return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}
 
}
