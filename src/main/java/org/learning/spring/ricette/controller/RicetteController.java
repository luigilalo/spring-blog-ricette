package org.learning.spring.ricette.controller;

import org.learning.spring.ricette.model.Ricette;
import org.learning.spring.ricette.repository.RicetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping ("/list")
public class RicetteController {
    @Autowired
    RicetteRepository ricetteRepository;

    @GetMapping()
    private String index(Model model) {
        List<Ricette> ricetteList = ricetteRepository.findAll();
        model.addAttribute("ricette", ricetteList);
        return "recipes/list";
    }
    @GetMapping("/show/{id}")
    private String show(@PathVariable("id") Integer id, Model model) {
        Optional<Ricette> ricetteOptional = ricetteRepository.findById(id);
        if (ricetteOptional.isPresent()) {
            model.addAttribute("recipe", ricetteOptional.get());
            return "recipes/details";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


}
