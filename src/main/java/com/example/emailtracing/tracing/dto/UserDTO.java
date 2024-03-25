package com.example.emailtracing.tracing.dto;

import com.example.emailtracing.tracing.model.InfoMedia;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long userId;
    private String email;
    private HashMap<String, InfoMedia> infoMedia;
    private String fullName;
    private Date updatedAt;
    private Date createdAt;
}
