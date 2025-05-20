package com.mibancoturron.atm.service;

import org.springframework.stereotype.Service;
import com.mibancoturron.atm.entity.Cliente;
import com.mibancoturron.atm.entity.Cuenta;
import com.mibancoturron.atm.repository.ClienteRepository;
import com.mibancoturron.atm.repository.CuentaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RetiroService {
    private final CuentaRepository cuentaRepository;
    private final ClienteRepository clienteRepository;
    private final MovimientoService moviminetoService;

    public String realizarRetiro(String identificacion, String numeroCuenta, double monto){
        Cliente cliente = clienteRepository.finByIndetification(identificacion)
        .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        
        
        Cuenta cuenta = cuentaRepository.findByNumero(numeroCuenta)
        .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        
        if (!cuenta.getCliente().equals(cliente)){
            throw new RuntimeException("La cuenta no pertenece al cliente");
        }

        if (cliente.isBloqueado()){
            throw new RuntimeException("El cliente está bloqueado o su cuenta está bloqueada");
        }

        boolean exito = moviminetoService.realizarRetiro(cuenta, monto);
        if (!exito){
            throw new RuntimeException("No se pudo realizar el retiro, saldo insuficiente o error en la cuenta");
        }

        return "redirect:cajero/menu?mensaje=Retiro realizado con éxito";
    }
}