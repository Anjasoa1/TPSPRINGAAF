package com.example.annoncesapi.controller;

import com.example.annoncesapi.model.Annonce;
import com.example.annoncesapi.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annonces")
public class AnnonceController {

    @Autowired
    private AnnonceService annonceService;

    @GetMapping
    public List<Annonce> getAll() {
        return annonceService.getAll();
    }

    @GetMapping("/all")
    public List<Annonce> getAllAnnonces() {
        return annonceService.getAll();
    }

    @GetMapping("/{id}")
    public Annonce getById(@PathVariable Long id) {
        return annonceService.getById(id);
    }

    @PostMapping
    public Annonce add(@RequestBody Annonce annonce) {
        return annonceService.save(annonce);
    }

    @PutMapping("/{id}")
    public Annonce update(@PathVariable Long id, @RequestBody Annonce annonce) {
        return annonceService.update(id, annonce);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        annonceService.delete(id);
    }
}
