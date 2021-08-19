package com.payten.termhost.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BTN_LABEL")
public class ButtonLabel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUTTON_LABEL_ID_GEN")
	@SequenceGenerator(name="BUTTON_LABEL_ID_GEN", sequenceName = "BTN_LBL_ID_SEQ", allocationSize = 1)
	@Column(name="BTN_LBL_ID")
	private Integer buttonLabelId;
	
	@Column(name="BTN_LBL_CODE")
	private String buttonLabelCode;
	
	@Column(name="BTN_LBL_TEXT")
	private String buttonLabelText;

	public ButtonLabel() {
		super();
	}

	public ButtonLabel(Integer buttonLabelId, String buttonLabelCode, String buttonLabelText) {
		super();
		this.buttonLabelId = buttonLabelId;
		this.buttonLabelCode = buttonLabelCode;
		this.buttonLabelText = buttonLabelText;
	}

	public Integer getButtonLabelId() {
		return buttonLabelId;
	}

	public void setButtonLabelId(Integer buttonLabelId) {
		this.buttonLabelId = buttonLabelId;
	}

	public String getButtonLabelCode() {
		return buttonLabelCode;
	}

	public void setButtonLabelCode(String buttonLabelCode) {
		this.buttonLabelCode = buttonLabelCode;
	}

	public String getButtonLabelText() {
		return buttonLabelText;
	}

	public void setButtonLabelText(String buttonLabelText) {
		this.buttonLabelText = buttonLabelText;
	}

	@Override
	public String toString() {
		return "ButtonLabel [buttonLabelId=" + buttonLabelId + ", buttonLabelCode=" + buttonLabelCode
				+ ", buttonLabelText=" + buttonLabelText + "]";
	}
	
	
}
