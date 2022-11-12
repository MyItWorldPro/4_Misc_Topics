package com.misc4.sha256.controller;

import com.misc4.sha256.dto.PassAuthReqRespDto;
import com.misc4.sha256.service.ShaServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth/")
public class ShaController {

    private static final Logger logger = LoggerFactory.getLogger(ShaController.class);

    @Autowired
    ShaServiceImpl shaServiceImpl;

    @PostMapping(value = "passwordHashAuth")
    public ResponseEntity<PassAuthReqRespDto> passwordHashAuth(
            @Valid @RequestBody(required = true) PassAuthReqRespDto passAuthRequest) {
        PassAuthReqRespDto passAuthReqRespDto = shaServiceImpl.authenticateUser(passAuthRequest);
        if (null != passAuthReqRespDto) {
            return new ResponseEntity<>(passAuthReqRespDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping(value = "httpRequestAuth")
    public ResponseEntity<PassAuthReqRespDto> httpRequestAuth(
            @Valid @RequestBody(required = true) PassAuthReqRespDto passAuthRequest) {
        logger.info("Request Body: {}", passAuthRequest.toString());
        return new ResponseEntity<>(passAuthRequest, HttpStatus.OK);
    }

}
