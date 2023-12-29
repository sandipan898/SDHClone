package com.ste.sdhapplication.offermodule.model;

import com.ste.sdhapplication.usermodule.model.UserModel;
import com.ste.sdhapplication.vehiclemodule.model.VersionModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "OOS")
public class OOSModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OosID;
    @ManyToOne
    private OfferModel offer;
    @NonNull
    private String type;
    private String category;
    private String attribute;
    private Double priceWT;
    private Double priceWOT;
}
