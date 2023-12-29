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
    @NonNull
    private String code;
    @ManyToOne
    private FamilyModel family;
    @ManyToOne
    private UserModel userCre;
    private List<String> optionList;
    private List<String> colorList;
    private List<String> trimList;
}
