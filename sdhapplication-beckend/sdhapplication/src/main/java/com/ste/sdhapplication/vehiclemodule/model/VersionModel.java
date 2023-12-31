package com.ste.sdhapplication.vehiclemodule.model;

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
@Table(name = "version")
public class VersionModel {
    @Id
    @Column(unique = true, nullable = false)
    private String code;
    @ManyToOne
    private FamilyModel family;
    @ManyToOne
    private UserModel userCre;
    private String carType;
    private List<String> optionList;
    private List<String> colorList;
    private List<String> trimList;
}
