package com.example.emailtracing.tracing.service;

import com.example.emailtracing.tracing.model.MailObj;
import com.example.emailtracing.tracing.repository.MailObjRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailObjServiceImpl implements MailObjService{
    @Autowired
    private MailObjRepository mailObjRepository;
    @Override
    public List<MailObj> getAllMailObjs() {
        return mailObjRepository.findAll();
    }

    @Override
    public MailObj createMailObj(MailObj mailObj) {
        return mailObjRepository.save(mailObj);
    }

    @Override
    public MailObj getMailObjById(Long id) {
        return mailObjRepository.findById(id).orElse(null);
    }

    @Override
    public MailObj updateMailObj(MailObj mailObj) {
        return mailObjRepository.save(mailObj);
    }

    @Override
    public void deleteMailObj(Long id) {
        mailObjRepository.deleteById(id);
    }
}
