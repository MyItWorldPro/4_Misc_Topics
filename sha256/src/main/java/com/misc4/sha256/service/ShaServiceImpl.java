package com.misc4.sha256.service;

import com.misc4.sha256.dto.PassAuthReqRespDto;
import com.misc4.sha256.util.ShaAuthUtil;
import org.springframework.stereotype.Service;

@Service
public class ShaServiceImpl implements ShaService {

    @Override
    public PassAuthReqRespDto authenticateUser(PassAuthReqRespDto passAuthRequest) {
        PassAuthReqRespDto resp = null;
        String sha256Signature = ShaAuthUtil.getSha256Signature("dummyKey1", passAuthRequest.getPassword());
        boolean isAuthorised = checkAuth(sha256Signature);
        if (isAuthorised) {
            resp = new PassAuthReqRespDto();
            resp.setUserName(passAuthRequest.getUserName());
            resp.setSha256Signature(sha256Signature);
        }
        return resp;
    }

    private boolean checkAuth(String sha256Signature) {
        boolean isAuthorised = Boolean.FALSE;
        String hashFromDb = "c6e019494f461114fae57a0d2db65d60c31d7191ba82e83a37c85a1c4f178d9d";//In real app, get this hash value from database
        if (sha256Signature.equals(hashFromDb)) {
            isAuthorised = Boolean.TRUE;
        }
        return isAuthorised;
    }
}
