package com.Tallerdecoches.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "entrada_pieza")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class EntradaPieza implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne()
    private Pieza pieza;
    private Integer cantidad;
    @Column(name = "precio_entrada")
    private Double precioEntrada;
    @OneToOne()
    private AlbaranProveedor albaranProveedor;
}
