package com.spring.boot.jpa.miniProj.data;

import javax.persistence.Embeddable;

@Embeddable
public class Insurance {
	
	private String providerName;
	
	private String copay;

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getCopay() {
		return copay;
	}

	public void setCopay(String copay) {
		this.copay = copay;
	}
}
