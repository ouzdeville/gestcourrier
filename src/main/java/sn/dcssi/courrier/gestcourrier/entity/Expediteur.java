package sn.dcssi.courrier.gestcourrier.entity;

import java.util.List;

import jakarta.persistence.OneToMany;

public class Expediteur {
Long id;
    String nom;
    String adresse;
    String telephone;
    String email;

    @OneToMany(mappedBy = "expediteur")
    List<Courrier> courriers;
}
