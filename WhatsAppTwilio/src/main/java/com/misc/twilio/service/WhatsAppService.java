package com.misc.twilio.service;

import com.misc.twilio.dto.SendWAMsgDto;

public interface WhatsAppService {

    void sendWhatsAppMessage(SendWAMsgDto sendWAMsgDto);

}
