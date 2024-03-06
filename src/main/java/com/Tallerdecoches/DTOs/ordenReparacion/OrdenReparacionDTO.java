package com.Tallerdecoches.DTOs.ordenReparacion;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrdenReparacionDTO {
    private Long id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "la fecha de apertura no puede ser nula")
    private LocalDate fechaApertura;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaCierre;
    @NotBlank(message = "debe introducir la descripcion")
    private String descripcion;
    private Long kilometros;
    private Double horas;
    private Boolean cerrada;
    private Boolean facturada;
}
