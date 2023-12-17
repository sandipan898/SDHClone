package com.ste.sdhapplication.usermodule.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;

@Getter
@Setter
@ToString
@Entity
@Table(name = "User")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NonNull
    private String userId;
    @NonNull
    private String username;
    @NonNull
    private String password;
    private String dealerId;
    private String loginTime;
    private String role;
}
