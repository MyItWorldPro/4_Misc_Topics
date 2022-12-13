package com.misc1.DroolsSpringBoot.controller;

import com.misc1.DroolsSpringBoot.dto.CarDetailsDto;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drools")
public class DroolsController {

    @Autowired
    private KieSession kieSession;

    @PostMapping(value = "traditionalWay")
    public ResponseEntity<CarDetailsDto> traditionalWay(
            @RequestBody CarDetailsDto carDetailsDto) {

        if (carDetailsDto.getCarModelYear() <= 2010) {
            carDetailsDto.setCarSellingPricePercentage(25);
        } else if (carDetailsDto.getCarModelYear() > 2010 && carDetailsDto.getCarModelYear() <= 2015) {
            carDetailsDto.setCarSellingPricePercentage(35);
        } else if (carDetailsDto.getCarModelYear() > 2015 && carDetailsDto.getCarModelYear() <= 2020) {
            carDetailsDto.setCarSellingPricePercentage(45);
        }

        return new ResponseEntity<>(carDetailsDto, HttpStatus.OK);
    }

    @PostMapping(value = "droolsEngine")
    public ResponseEntity<CarDetailsDto> droolsEngine(
            @RequestBody CarDetailsDto carDetailsDto) {

        kieSession.insert(carDetailsDto);
        kieSession.fireAllRules();

        return new ResponseEntity<>(carDetailsDto, HttpStatus.OK);
    }

}
