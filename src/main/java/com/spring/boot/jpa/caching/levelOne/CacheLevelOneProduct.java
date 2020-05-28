package com.spring.boot.jpa.caching.levelOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

//import org.hibernate.annotations.GenericGenerator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table (name = "Product")
@ApiModel ("All Details about Product")
public class CacheLevelOneProduct {
	@Id
	
//	@TableGenerator(name = "product_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 10)
//	@GeneratedValue(strategy = GenerationType.TABLE, generator = "product_gen")

//	@GenericGenerator(name = "prod_id", strategy = "com.spring.boot.jpa.product.data.CustomIdGenerator")
//	@GeneratedValue(generator = "prod_id")
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull(message = "{validation.user.name}")
	@Size(min = 3, message = "{validation.user.name.length}")
	@ApiModelProperty(notes = "Name should not be empty")
	private String name;
	
	@Column(name = "description")
	@NotNull(message = "{validation.user.description}")
	@Size(min = 5, message = "{validation.user.description.length}")
	@ApiModelProperty(notes = "Description should not be empty")
	private String desc;
	
	@Positive (message = "{validation.user.price}")
	@ApiModelProperty(notes = "Price should be positive Value")
	private double price;

	public CacheLevelOneProduct() {
		// do Nothing
	}

	public CacheLevelOneProduct(String name, String desc, double price) {
		this.name = name;
		this.desc = desc;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
