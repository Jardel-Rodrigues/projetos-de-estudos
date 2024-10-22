package com.softstrem.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softstrem.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	boolean existsByCpf(String value);

}
