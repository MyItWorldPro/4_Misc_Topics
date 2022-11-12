package com.misc4.sha256.service;

import com.misc4.sha256.dto.PassAuthReqRespDto;

public interface ShaService {

    PassAuthReqRespDto authenticateUser(PassAuthReqRespDto passAuthRequest);

}
