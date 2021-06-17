package com.payten.termhost.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ATM_BACKGROUNDS")
public class AtmBackground {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IMAGE_ID_GEN")
	@SequenceGenerator(name="IMAGE_ID_GEN", sequenceName = "IMAGE_ID_SEQ", allocationSize = 1)
	@Column(name="IMAGE_ID")
	private int imageId;
	
	@Lob
	@Column(name="IMAGE")
	private byte[] image;
	
	@Column(name="MIME_TYPE")
	private String mimeType;

	public AtmBackground() {
		super();
	}

	public AtmBackground(int imageId, byte[] image, String mimeType) {
		super();
		this.imageId = imageId;
		this.image = image;
		this.mimeType = mimeType;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	
	
}
