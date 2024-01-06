package com.ste.sdhapplication.cremodule.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Entity
@Table(name = "cre")
public class CreModel {
    @Id
    private String dealerId;
    private String vp_mode;
    private String vu_mode;
    private Boolean is_active;
}
