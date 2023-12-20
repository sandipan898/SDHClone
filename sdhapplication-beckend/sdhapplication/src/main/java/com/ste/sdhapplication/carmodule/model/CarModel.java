package com.ste.sdhapplication.carmodule.model;

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
@Table(name = "car")
public class CarModel {
    @Id
    @NonNull
    private String versionCode;
    private String family;
    private List<String> optionList;
    private List<String> colorList;
    private List<String> trimList;
}
