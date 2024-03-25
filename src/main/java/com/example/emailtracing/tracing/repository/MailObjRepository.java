package com.example.emailtracing.tracing.repository;

import com.example.emailtracing.tracing.model.MailObj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailObjRepository extends JpaRepository<MailObj, Long> {
}
