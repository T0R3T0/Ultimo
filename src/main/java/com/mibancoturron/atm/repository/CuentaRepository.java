package com.mibancoturron.atm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mibancoturron.atm.entity.Cliente;
import com.mibancoturron.atm.entity.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    Optional<Cuenta> findByNumero(String numero);
    List<Cuenta> finByCliente(Cliente cliente);
    List<Cuenta> findByCliente(Cliente cliente);
}
