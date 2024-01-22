package org.learning.spring.ricette.repository;

import org.learning.spring.ricette.model.Ricette;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RicetteRepository extends JpaRepository<Ricette, Integer> {

    List<Ricette> findByTitleContaining(String search);
}
