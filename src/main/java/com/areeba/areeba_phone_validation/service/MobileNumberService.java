package com.areeba.areeba_phone_validation.service;

import com.areeba.areeba_phone_validation.exception.InvalidMobileNumberException;
import com.areeba.areeba_phone_validation.model.dto.MobileNumberDetailsDTO;
import com.areeba.areeba_phone_validation.model.dto.MobileVerificationResponseDTO;

public interface MobileNumberService {

  MobileVerificationResponseDTO getMobileNumberDetails(String phoneNumber) throws InvalidMobileNumberException;
}
