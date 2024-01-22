package org.learning.spring.ricette.controller;

import jakarta.validation.Valid;
import org.learning.spring.ricette.model.Ricette;
import org.learning.spring.ricette.repository.RicetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        return "list";
    }

    @GetMapping("/show/{id}")
    private String show(@PathVariable("id") Integer id, Model model) {
        Optional<Ricette> ricetteOptional = ricetteRepository.findById(id);
        if (ricetteOptional.isPresent()) {
            model.addAttribute("recipe", ricetteOptional.get());
            return "show";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/create")
    private String create(Model model) {
        model.addAttribute("ricette", new Ricette());
        return "recipes/form";
    }

    @PostMapping("/create")
    private String doCreate(@ModelAttribute("ricette") Ricette ricette) {
        ricetteRepository.save(ricette);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    private String edit(@PathVariable("id") Integer id, Model model) {
        Optional<Ricette> ricetteOptional = ricetteRepository.findById(id);
        if (ricetteOptional.isPresent()) {
            model.addAttribute("recipe", ricetteOptional.get());
            return "recipes/form";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Integer id, @Valid @ModelAttribute("pizza") Ricette formRicette ,
                         BindingResult bindingResult) {
        Optional<Ricette> result = ricetteRepository.findById(id);
        if (result.isPresent()) {
            Ricette editedRicette = result.get();
            if (bindingResult.hasErrors()) {
                return "/edit";
            }
            Ricette savedRicetta = ricetteRepository.save(formRicette);
            return "redirect:/" + id;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe with" + id + " not found");
        }
    }


    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Optional<Ricette> result = ricetteRepository.findById(id);
        if (result.isPresent()) {
            ricetteRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("redirectMessage", result.get().getTitle() + " è stato cancellato!");
            return "redirect:/list";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La ricetta con ID" + id + "non è stata trovata");
        }
    }
}