package com.example.annoncesapi.service;

import com.example.annoncesapi.dao.AnnonceRepository;
import com.example.annoncesapi.model.Annonce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnonceService {

    @Autowired
    private AnnonceRepository annonceRepository;

    public List<Annonce> getAll() {
        return annonceRepository.findAll();
    }

    public Annonce getById(Long id) {
        return annonceRepository.findById(id).orElse(null);
    }

    public Annonce save(Annonce annonce) {
        return annonceRepository.save(annonce);
    }

    public Annonce update(Long id, Annonce newAnnonce) {
        Annonce existing = getById(id);
        if (existing != null) {
            existing.setTitre(newAnnonce.getTitre());
            existing.setDescription(newAnnonce.getDescription());
            existing.setAdresse(newAnnonce.getAdresse());
            existing.setEmail(newAnnonce.getEmail());
            return annonceRepository.save(existing);
        }
        return null;
    }

    public void delete(Long id) {
        annonceRepository.deleteById(id);
    }
}
