package com.example.emailtracing.tracing.service;

import com.example.emailtracing.tracing.model.Campain;
import com.example.emailtracing.tracing.repository.CampainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampainServiceImpl implements CampainService{
    @Autowired
    private CampainRepository campainRepository;
    @Override
    public List<Campain> getAllCampains() {
        return campainRepository.findAll();
    }

    @Override
    public Campain createCampain(Campain campain) {
        return campainRepository.save(campain);
    }

    @Override
    public Campain getCampainById(Long id) {
        return campainRepository.findById(id).orElse(null);
    }

    @Override
    public Campain updateCampain(Campain campain) {
        return campainRepository.save(campain);
    }

    @Override
    public void deleteCampain(Long id) {
        campainRepository.deleteById(id);
    }
}
