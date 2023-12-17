package com.ste.sdhapplication.offermodule.model;

import com.ste.sdhapplication.usermodule.model.UserModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;

@Getter
@Setter
@ToString
@Entity
@Table(name = "offer")
public class OfferModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private long offerID;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;
    private String color;
    private String trim;
    private String option;
    private String colorPrice;
    private String trimPrice;
    private String totalOptionPrice;
    private double totalPrice;
}
