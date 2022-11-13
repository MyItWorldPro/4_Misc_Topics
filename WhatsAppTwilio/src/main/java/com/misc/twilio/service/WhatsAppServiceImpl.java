package com.misc.twilio.service;

import com.misc.twilio.dto.SendWAMsgDto;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WhatsAppServiceImpl implements WhatsAppService {

    private static final Logger logger = LoggerFactory.getLogger(WhatsAppServiceImpl.class);

    @Value("${twilio.account.sid}")
    private String twilioAccountSid;

    @Value("${twilio.auth.token}")
    private String twilioAccountAuthToken;

    @Value("${twilio.account.whatsapp.number}")
    private String twilioAccountWhatsAppNumber;

    @Override
    public void sendWhatsAppMessage(SendWAMsgDto sendWAMsgDto) {
        String messageText = sendWAMsgDto.getMessage();
        String cusWhatsAppNumber = "whatsapp:" + sendWAMsgDto.getCustomerWhatsAppNumber();
        Twilio.init(twilioAccountSid, twilioAccountAuthToken);
        Message twilioMessage = Message.creator(
                        new com.twilio.type.PhoneNumber(cusWhatsAppNumber),
                        new com.twilio.type.PhoneNumber(twilioAccountWhatsAppNumber),
                        messageText)
                .create();
        logger.info("Twilio SID={}", twilioMessage.getSid());
    }

}
