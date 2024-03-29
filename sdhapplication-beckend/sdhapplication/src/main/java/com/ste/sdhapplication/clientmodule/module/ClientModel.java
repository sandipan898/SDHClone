package com.ste.sdhapplication.clientmodule.module;

import com.ste.sdhapplication.cremodule.model.CreModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@Setter
@Entity
@Table(name = "client")
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long clientId;
    private String type;
    private LocalDate creationDate;
    private String initial;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private String address1;
    private String address2;
    @ManyToOne
    private CreModel cre;
}
