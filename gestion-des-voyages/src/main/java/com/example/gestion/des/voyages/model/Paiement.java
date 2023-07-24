package com.example.gestion.des.voyages.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="paiement")
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private Integer montant; // 3oud e5dem b bigDecimal
    private String methodeDeMontant; // attribut mouch kaka yetktab blech '_'
    private Date datePaiement;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation_id;
    private StatutPaiement statut; //ay class yabda b majuscule w blech tiret bas


}
