package com.misc.twilio.service;

import com.misc.twilio.dto.SendWAMsgDto;
import com.misc.twilio.dto.WhatsAppWebhookDto;

import java.util.Map;

public interface WhatsAppService {

    void sendWhatsAppMessage(SendWAMsgDto sendWAMsgDto);

    WhatsAppWebhookDto processWhatsAppWebhook(Map<String, String[]> webhookResponse);

}
