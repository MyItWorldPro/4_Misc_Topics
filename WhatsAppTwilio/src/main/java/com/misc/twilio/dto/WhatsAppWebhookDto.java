package com.misc.twilio.dto;

public class WhatsAppWebhookDto {

    private String Body;// message Text
    private String From;// Customer Phone number

    private String ApiVersion;
    private String SmsSid;
    private String SmsStatus;
    private String SmsMessageSid;
    private String ProfileName;
    private String NumSegments;
    private String WaId;
    private String MessageSid;
    private String AccountSid;
    private String ReferralNumMedia;
    private String To;
    private String NumMedia;

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getApiVersion() {
        return ApiVersion;
    }

    public void setApiVersion(String apiVersion) {
        ApiVersion = apiVersion;
    }

    public String getSmsSid() {
        return SmsSid;
    }

    public void setSmsSid(String smsSid) {
        SmsSid = smsSid;
    }

    public String getSmsStatus() {
        return SmsStatus;
    }

    public void setSmsStatus(String smsStatus) {
        SmsStatus = smsStatus;
    }

    public String getSmsMessageSid() {
        return SmsMessageSid;
    }

    public void setSmsMessageSid(String smsMessageSid) {
        SmsMessageSid = smsMessageSid;
    }

    public String getProfileName() {
        return ProfileName;
    }

    public void setProfileName(String profileName) {
        ProfileName = profileName;
    }

    public String getNumSegments() {
        return NumSegments;
    }

    public void setNumSegments(String numSegments) {
        NumSegments = numSegments;
    }

    public String getWaId() {
        return WaId;
    }

    public void setWaId(String waId) {
        WaId = waId;
    }

    public String getMessageSid() {
        return MessageSid;
    }

    public void setMessageSid(String messageSid) {
        MessageSid = messageSid;
    }

    public String getAccountSid() {
        return AccountSid;
    }

    public void setAccountSid(String accountSid) {
        AccountSid = accountSid;
    }

    public String getReferralNumMedia() {
        return ReferralNumMedia;
    }

    public void setReferralNumMedia(String referralNumMedia) {
        ReferralNumMedia = referralNumMedia;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public String getNumMedia() {
        return NumMedia;
    }

    public void setNumMedia(String numMedia) {
        NumMedia = numMedia;
    }

    @Override
    public String toString() {
        return "WhatsAppWebhookDto{" +
                "Body='" + Body + '\'' +
                ", From='" + From + '\'' +
                ", ApiVersion='" + ApiVersion + '\'' +
                ", SmsSid='" + SmsSid + '\'' +
                ", SmsStatus='" + SmsStatus + '\'' +
                ", SmsMessageSid='" + SmsMessageSid + '\'' +
                ", ProfileName='" + ProfileName + '\'' +
                ", NumSegments='" + NumSegments + '\'' +
                ", WaId='" + WaId + '\'' +
                ", MessageSid='" + MessageSid + '\'' +
                ", AccountSid='" + AccountSid + '\'' +
                ", ReferralNumMedia='" + ReferralNumMedia + '\'' +
                ", To='" + To + '\'' +
                ", NumMedia='" + NumMedia + '\'' +
                '}';
    }
}
