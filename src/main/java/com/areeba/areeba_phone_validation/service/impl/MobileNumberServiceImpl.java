package com.areeba.areeba_phone_validation.service.impl;

import com.areeba.areeba_phone_validation.exception.InvalidMobileNumberException;
import com.areeba.areeba_phone_validation.exception.MobileNumberHandlerException;
import com.areeba.areeba_phone_validation.model.dto.MobileNumberDetailsDTO;
import com.areeba.areeba_phone_validation.model.dto.MobileVerificationResponseDTO;
import com.areeba.areeba_phone_validation.service.MobileNumberService;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberToCarrierMapper;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@Slf4j
public class MobileNumberServiceImpl implements MobileNumberService {

    /**
     * Validate mobile number and return details if valid
     *
     * @Author Johnny
     * @param mobileNumber
     * @return
     * @throws InvalidMobileNumberException
     */
    @Override
    public MobileVerificationResponseDTO getMobileNumberDetails(String mobileNumber) throws InvalidMobileNumberException {
       PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        MobileVerificationResponseDTO mobileVerificationResponseDTO = new MobileVerificationResponseDTO();
        try {
            Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(mobileNumber.trim(),"");
            //check if the number is valid
            if (phoneNumberUtil.isValidNumber(phoneNumber)) {
                // if valid get the details
                mobileVerificationResponseDTO.setIsValid(true);
                MobileNumberDetailsDTO mobileNumberDetailsDTO = new MobileNumberDetailsDTO();
                mobileNumberDetailsDTO.setCountryCode(String.valueOf(phoneNumber.getCountryCode()));
                // Using Locale to get the full country name
                Locale locale = new Locale("", phoneNumberUtil.getRegionCodeForNumber(phoneNumber));
                mobileNumberDetailsDTO.setCountryName(locale.getDisplayName());
                //get the operator Name
                PhoneNumberToCarrierMapper carrierMapper = PhoneNumberToCarrierMapper.getInstance();
                mobileNumberDetailsDTO.setOperatorName(carrierMapper.getNameForValidNumber(phoneNumber, Locale.ENGLISH));
                mobileVerificationResponseDTO.setMobileNumberDetailsDTO(mobileNumberDetailsDTO);
            }
        } catch (NumberParseException e) {
            // Parsing failed
            log.error("Invalid mobile number");
       }
        return  mobileVerificationResponseDTO;
   }
}
