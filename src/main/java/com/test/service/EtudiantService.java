package com.test.service;

import com.test.entity.Etudiant;
import com.test.repository.EtudiantRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped // similaire a @service pour indiquer un bean contenant la logique metier
public class EtudiantService {

    @Inject //pour faire l'injection de depedance comme @autowire
    EtudiantRepository etudiantRepository;

    public List<Etudiant> listAll() {
        return etudiantRepository.listAll();
    }

    @Transactional
    public void addEtudiant(Etudiant etudiant) {
        etudiantRepository.persist(etudiant);
    }


    @Transactional
    public Etudiant findByNom(String nom) {
      return etudiantRepository.findByNom(nom);
    }


    @Transactional
    public Etudiant updateEtudiant(Long id, Etudiant etudiant) {
        Etudiant existingEtudiant = etudiantRepository.findById(id);
        if (existingEtudiant != null) {
            existingEtudiant.nom = etudiant.nom;
            existingEtudiant.prenom = etudiant.prenom;
            // Autres attributs à mettre à jour
        }
        return existingEtudiant;
    }

    @Transactional
    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }
}
