package crm.payten.model;

import java.util.List;

import com.payten.crm.model.CRMCampaign;
import com.payten.crm.model.CRMResponse;
import com.payten.termhost.model.OnUSCampaignDTO;

public class CampaignDetailsDto {

	List<CRMResponse> responses;
	CRMCampaign crmCampaign;
	OnUSCampaignDTO thCampaign;
	
	public CampaignDetailsDto() {
		super();
	}

	public CampaignDetailsDto(List<CRMResponse> responses, CRMCampaign crmCampaign, OnUSCampaignDTO thCampaign) {
		super();
		this.responses = responses;
		this.crmCampaign = crmCampaign;
		this.thCampaign = thCampaign;
	}

	public List<CRMResponse> getResponses() {
		return responses;
	}

	public void setResponses(List<CRMResponse> responses) {
		this.responses = responses;
	}

	public CRMCampaign getCrmCampaign() {
		return crmCampaign;
	}

	public void setCrmCampaign(CRMCampaign crmCampaign) {
		this.crmCampaign = crmCampaign;
	}

	public OnUSCampaignDTO getThCampaign() {
		return thCampaign;
	}

	public void setThCampaign(OnUSCampaignDTO thCampaign) {
		this.thCampaign = thCampaign;
	}
	
	
}
