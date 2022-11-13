package com.misc.twilio.controller;

import com.misc.twilio.dto.SendWAMsgDto;
import com.misc.twilio.service.WhatsAppServiceImpl;
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
@RequestMapping("/whatsapp")
public class WhatsAppController {

    private static final Logger logger = LoggerFactory.getLogger(WhatsAppController.class);

    @Autowired
    WhatsAppServiceImpl whatsAppServiceImpl;

    @PostMapping("/sendWhatsAppMsg")
    public ResponseEntity<String> sendWhatsAppMsg(@Valid @RequestBody(required = true) SendWAMsgDto sendWAMsgDto) {
        logger.info("sendWhatsAppMsg request={}", sendWAMsgDto.toString());
        whatsAppServiceImpl.sendWhatsAppMessage(sendWAMsgDto);
        return new ResponseEntity<>("Successfully sent WhatsApp message!", HttpStatus.OK);
    }

}
