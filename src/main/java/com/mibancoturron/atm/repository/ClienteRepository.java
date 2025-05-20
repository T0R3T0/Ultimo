package com.mibancoturron.atm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mibancoturron.atm.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    Optional<Cliente> finByIndetification(String identificacion); 

}
