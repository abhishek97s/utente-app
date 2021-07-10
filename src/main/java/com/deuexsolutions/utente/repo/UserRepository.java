package com.deuexsolutions.utente.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deuexsolutions.utente.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
