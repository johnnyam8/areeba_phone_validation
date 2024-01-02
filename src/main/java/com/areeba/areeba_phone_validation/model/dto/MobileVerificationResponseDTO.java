package com.areeba.areeba_phone_validation.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MobileVerificationResponseDTO {
    // indicate if the mobile number is valid,
    private Boolean isValid = Boolean.FALSE;
    private MobileNumberDetailsDTO mobileNumberDetailsDTO;
}
