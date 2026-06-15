package sn.dcssi.courrier.gestcourrier.entity;

import java.util.List;

import jakarta.persistence.OneToMany;

public class Service {
    Long id;
    String code;
    String nom;

    Service parent;

    @OneToMany(mappedBy = "service")
    List<User> users;
}
