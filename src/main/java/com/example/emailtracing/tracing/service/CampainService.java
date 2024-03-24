package com.example.emailtracing.tracing.service;

import com.example.emailtracing.tracing.model.Campain;

import java.util.List;

public interface CampainService {
    List<Campain> getAllCampains();
    Campain createCampain(Campain campain);
    Campain getCampainById(Long id);
    Campain updateCampain(Campain campain);
    void deleteCampain(Long id);
}
