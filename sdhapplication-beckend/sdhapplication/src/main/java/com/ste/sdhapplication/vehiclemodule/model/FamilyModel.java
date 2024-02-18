package com.ste.sdhapplication.vehiclemodule.model;

import com.ste.sdhapplication.cremodule.model.CreModel;
import com.ste.sdhapplication.usermodule.model.UserModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Family")
public class FamilyModel {
    @Id
    @Column(unique = true, nullable = false)
    private String code;

    private String familyName;

    private String familyType;

    @ManyToOne
    private UserModel user;
    @ManyToOne
    private CreModel cre;
}
