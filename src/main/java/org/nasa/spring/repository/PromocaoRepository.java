package org.nasa.spring.repository;

import org.nasa.spring.entities.Promocoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocaoRepository extends JpaRepository<Promocoes, Long>{

}
