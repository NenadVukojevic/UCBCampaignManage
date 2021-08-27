package com.payten.termhost.model.offus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="CITY")
public class City {
	@Id
	@Column(name="CITY_ID")
	private Integer cityId;

	@Column(name="CITY_NAME")
	private String cityName;

	@Column(name="CITY_CODE")
	private String cityCode;

	public City() {
		super();
	}

	public City(Integer cityId, String cityName, String cityCode) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.cityCode = cityCode;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
	
}
