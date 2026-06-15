package sn.dcssi.courrier.gestcourrier.entity;

import java.util.Date;

class Historique {

    Long id;

    Date date;

    User utilisateur;

    Action action;

    String commentaire;

    Courrier courrier;
}