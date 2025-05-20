package com.mibancoturron.atm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mibancoturron.atm.entity.Cuenta;
import com.mibancoturron.atm.entity.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long>{
    List <Movimiento> finByCuenta(Cuenta cuenta);
    List <Movimiento> finbyCuenta_NumeroOrderByFechaDesc(String numeroCuenta);
    List<Movimiento> findByCuentaOrderByFechaDesc(Cuenta cuenta);

}
