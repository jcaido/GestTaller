package com.Tallerdecoches.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "albaran_proveedor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AlbaranProveedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne()
    private Proveedor proveedor;
    @Column(name = "fecha_albaran")
    private LocalDate fechaAlbaran;
    @Column(name = "numero_albaran")
    private String numeroAlbaran;
    private Boolean facturado = false;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "albaranProveedor")
    private List<EntradaPieza> entradasPiezas = new ArrayList<>();
    @OneToOne()
    private FacturaProveedor facturaProveedor;
}
