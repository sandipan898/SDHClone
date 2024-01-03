package com.ste.sdhapplication.offermodule.model;

import com.ste.sdhapplication.clientmodule.module.ClientModel;
import com.ste.sdhapplication.vehiclemodule.model.VersionModel;
import com.ste.sdhapplication.usermodule.model.UserModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "offer")
public class OfferModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long offerID;
    @ManyToOne
    private UserModel user;
    @ManyToOne
    private VersionModel car;
    @ManyToOne
    private ClientModel client;
    private String color;
    private String trim;
    private String option;
    private String colorPrice;
    private String trimPrice;
    private String totalOptionPrice;
    private double totalPrice;
}
