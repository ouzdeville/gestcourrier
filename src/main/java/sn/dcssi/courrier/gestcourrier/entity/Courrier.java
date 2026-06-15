package sn.dcssi.courrier.gestcourrier.entity;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Courrier {

    private UUID id;
    private String reference;
    private String objet;
    private String contenu;
    private Date dateCreation;
    private Date dateReception;
    private Date dateEmission;
    private Priorite priorite;
    private String confidentialite;
    private StatutCourrier statut;
    private TypeCourrier type;
    private String nombrePages;
    private String observation;
    
    @ManyToOne
    Expediteur expediteur;

    List<Destinataire> destinataires;
    List<PieceJointe> piecesJointes;
    List<Imputation> imputations;

    Courrier parent;

}
