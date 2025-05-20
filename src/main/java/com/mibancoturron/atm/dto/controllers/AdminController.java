package com.mibancoturron.atm.dto.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mibancoturron.atm.entity.Cliente;
import com.mibancoturron.atm.entity.Cuenta;
import com.mibancoturron.atm.entity.TipoCuenta;
import com.mibancoturron.atm.service.ClienteService;
import com.mibancoturron.atm.service.CuentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final ClienteService clienteService;
    private final CuentaService cuentaService;

    @GetMapping 
    public String admiHome(){
        return "admin/index";
    }
    @GetMapping("/crear-cliente")
    public String mostrarFormularioCliente(Model model ) {
        model.addAttribute("cliente", new Cliente());
        return "admin/cliente";
    }

    @PostMapping("/crear-cliente")
    public String crearCliente(@ModelAttribute Cliente cliente) {
        clienteService.crearCliente(cliente);
        return "redirect:/admin";
    }
    @GetMapping("/crear-cuenta")
    public String mostrarFormularioCuenta(Model model) {
        model.addAttribute("cuenta", new Cuenta());
        return "admin/crear-cuenta";
    }
    @PostMapping("/crear-cuenta")
    public String crearCuenta(@RequestParam String identificacion,@RequestParam String numero,
                              @RequestParam TipoCuenta tipo, @RequestParam double saldo) {
        Cliente cliente = clienteService.buscarPorIdentificacion(identificacion).orElseThrow();
        return "redirect:/admin";
    }
    @GetMapping("/desbloquear")
    public String mostrarDesbloqueo() {
        return "admin/desbloquear";
    }

    @PostMapping("/desbloquear")
    public String desbloquearCuenta(@RequestParam String identificacion, @RequestParam String nuevoPin) {
        clienteService.desbloquearCliente(identificacion, nuevoPin);
        return "redirect:/admin";
    
    }
}