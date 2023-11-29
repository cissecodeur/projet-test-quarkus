package com.test.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Etudiant extends PanacheEntity {

    //PanacheEntity inclus un champ id par defaut donc pas besoin de l'ajouter
    public String nom;
    public String prenom;
    // autres attributs
}
