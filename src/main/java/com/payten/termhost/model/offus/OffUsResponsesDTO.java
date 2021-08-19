package com.payten.termhost.model.offus;

public class OffUsResponsesDTO {
	private Integer responseId;
	private String responseName;
	public OffUsResponsesDTO() {
		super();
	}
	public OffUsResponsesDTO(Integer responseId, String responseName) {
		super();
		this.responseId = responseId;
		this.responseName = responseName;
	}
	public Integer getResponseId() {
		return responseId;
	}
	public void setResponseId(Integer responseId) {
		this.responseId = responseId;
	}
	public String getResponseName() {
		return responseName;
	}
	public void setResponseName(String responseName) {
		this.responseName = responseName;
	}
	
	
}
