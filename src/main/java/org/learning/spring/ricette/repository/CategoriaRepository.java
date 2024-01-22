package org.learning.spring.ricette.repository;

import org.learning.spring.ricette.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
