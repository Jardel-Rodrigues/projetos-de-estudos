package com.softstream.despesa.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softstream.despesa.entities.Mes;

@Repository
public interface MesRepository extends JpaRepository<Mes, Long>{

}
