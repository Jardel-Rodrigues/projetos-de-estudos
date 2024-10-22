package com.softstream.web.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softstream.web.services.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
