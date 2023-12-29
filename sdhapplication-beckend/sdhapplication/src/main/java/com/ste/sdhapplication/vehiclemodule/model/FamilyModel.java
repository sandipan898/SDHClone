package com.ste.sdhapplication.vehiclemodule.model;

import com.ste.sdhapplication.usermodule.model.UserModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
    @NonNull
    private String code;
    @ManyToOne
    private UserModel userCre;
}
