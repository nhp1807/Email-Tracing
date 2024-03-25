package com.example.emailtracing.tracing.service;

import com.example.emailtracing.tracing.model.Campain;
import com.example.emailtracing.tracing.model.MailObj;

import java.util.List;

public interface MailObjService {
    List<MailObj> getAllMailObjs();
    MailObj createMailObj(MailObj mailObj);
    MailObj getMailObjById(Long id);
    MailObj updateMailObj(MailObj mailObj);
    void deleteMailObj(Long id);
}
