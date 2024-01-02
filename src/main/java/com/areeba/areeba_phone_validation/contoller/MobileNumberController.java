package com.areeba.areeba_phone_validation.contoller;

import com.areeba.areeba_phone_validation.exception.InvalidMobileNumberException;
import com.areeba.areeba_phone_validation.model.dto.MobileVerificationResponseDTO;
import com.areeba.areeba_phone_validation.service.MobileNumberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name= "MobileNumberController", description = "Operations to handle verification for the phones number")
@RestController
@RequestMapping("/mobile/verification/v1")
@Slf4j
@Validated
public class MobileNumberController {

    @Autowired
    private MobileNumberService mobileNumberService;

    @Operation(summary= "Validate mobile number and return details")
    @GetMapping ("/info/{mobileNumber}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MobileVerificationResponseDTO> getMobileNumberDetails(@PathVariable String mobileNumber) throws InvalidMobileNumberException {
        log.info("Process Start - validate and Return mobile number details ");
        MobileVerificationResponseDTO mobileVerificationResponseDTO =  mobileNumberService.getMobileNumberDetails(mobileNumber);
        log.info("Process End - validate and Return mobile number details ");
            return new ResponseEntity<>(mobileVerificationResponseDTO, HttpStatus.OK);
    }
}
