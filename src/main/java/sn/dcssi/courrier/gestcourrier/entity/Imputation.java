package sn.dcssi.courrier.gestcourrier.entity;

import java.util.Date;
import java.util.List;

public class Imputation {
Long id;

    Courrier courrier;

    User emetteur;

    User destinataire;

    TypeImputation type;

    String instruction;

    Date dateImputation;

    Date dateLimite;

    Priorite priorite;

    StatutImputation statut;

    Imputation parent;

    List<Imputation> enfants;
}
