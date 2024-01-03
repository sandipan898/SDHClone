package com.ste.sdhapplication.parmodule.model;

import com.ste.sdhapplication.usermodule.model.UserModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@Setter
@Entity
@Table(name="par")
public class ParModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long parId;
    @Column(nullable = false, unique = true)
    private String key;
    private Double vNum;
    private String value;
    private String description;
    @ManyToOne
    private UserModel userCre;
    private LocalDate creationDate;
}
