package com.mibancoturron.atm.entity;

import java.time.LocalDateTime;
import lombok.*;
import jakarta.persistence.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Movimiento {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private LocalDateTime fecha;
    @Enumerated(EnumType.STRING)
    private double monto;
    private TipoMovimiento tipo;
    @ManyToOne
    @JoinColumn( name = "cuenta_id")
    private Cuenta cuenta;


}
