package com.misc.twilio.service;

import com.misc.twilio.dto.SendWAMsgDto;
import com.misc.twilio.dto.WhatsAppWebhookDto;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

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

    @Override
    public WhatsAppWebhookDto processWhatsAppWebhook(Map<String, String[]> webhookResponse) {
        WhatsAppWebhookDto whatsAppWebhookDto = mapResponseToDto(webhookResponse);
        logger.info("processed webhook response={}", whatsAppWebhookDto.toString());
        logger.info("\n\nReceived Message:\n{} \n\n", whatsAppWebhookDto.getBody());
        return whatsAppWebhookDto;
    }

    public WhatsAppWebhookDto mapResponseToDto(Map<String, String[]> webhookResponse) {
        WhatsAppWebhookDto whatsAppMsgDto = new WhatsAppWebhookDto();
        whatsAppMsgDto.setApiVersion(webhookResponse.get("ApiVersion")[0]);
        whatsAppMsgDto.setSmsSid(webhookResponse.get("SmsSid")[0]);
        whatsAppMsgDto.setSmsStatus(webhookResponse.get("SmsStatus")[0]);
        whatsAppMsgDto.setSmsMessageSid(webhookResponse.get("SmsMessageSid")[0]);
        whatsAppMsgDto.setProfileName(webhookResponse.get("ProfileName")[0]);
        whatsAppMsgDto.setNumSegments(webhookResponse.get("NumSegments")[0]);
        whatsAppMsgDto.setFrom(webhookResponse.get("From")[0]);
        whatsAppMsgDto.setWaId(webhookResponse.get("WaId")[0]);
        whatsAppMsgDto.setMessageSid(webhookResponse.get("MessageSid")[0]);
        whatsAppMsgDto.setReferralNumMedia(webhookResponse.get("ReferralNumMedia")[0]);
        whatsAppMsgDto.setTo(webhookResponse.get("To")[0]);
        whatsAppMsgDto.setBody(webhookResponse.get("Body")[0]);
        whatsAppMsgDto.setNumMedia(webhookResponse.get("NumMedia")[0]);
        return whatsAppMsgDto;
    }

}
