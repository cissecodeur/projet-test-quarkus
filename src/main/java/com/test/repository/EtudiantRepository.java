package com.test.repository;

import com.test.entity.Etudiant;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EtudiantRepository implements PanacheRepository<Etudiant> {

    public Etudiant findByNom(String nom) {
        return find("nom", nom).firstResult();
    }
}
