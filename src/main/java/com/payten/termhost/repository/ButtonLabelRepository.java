package com.payten.termhost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payten.termhost.model.ButtonLabel;

public interface ButtonLabelRepository extends JpaRepository<ButtonLabel, Integer> {
	ButtonLabel getButtonLabelByButtonLabelCode(String buttonLabelCode);
}
