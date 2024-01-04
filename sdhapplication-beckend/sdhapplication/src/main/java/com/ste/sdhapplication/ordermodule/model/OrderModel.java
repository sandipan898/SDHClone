package com.ste.sdhapplication.ordermodule.model;

import com.ste.sdhapplication.clientmodule.module.ClientModel;
import com.ste.sdhapplication.offermodule.model.OfferModel;
import com.ste.sdhapplication.usermodule.model.UserModel;
import com.ste.sdhapplication.vehiclemodule.model.VersionModel;
import jakarta.persistence.*;

@Entity
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @ManyToOne
    private UserModel user;
    @ManyToOne
    private VersionModel car;
    @OneToOne
    private OfferModel contract;
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
