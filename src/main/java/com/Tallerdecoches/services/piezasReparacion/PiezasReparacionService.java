package com.Tallerdecoches.services.piezasReparacion;

import com.Tallerdecoches.DTOs.entradaPieza.EntradaPiezaBusquedasDTO;
import com.Tallerdecoches.DTOs.piezasReparacion.PiezasReparacionBusquedasDTO;
import com.Tallerdecoches.DTOs.piezasReparacion.PiezasReparacionBusquedasParcialDTO;
import com.Tallerdecoches.DTOs.piezasReparacion.PiezasReparacionCrearDTO;
import com.Tallerdecoches.DTOs.piezasReparacion.PiezasReparacionDTO;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface PiezasReparacionService {

    PiezasReparacionDTO crearPiezasReparacion(PiezasReparacionCrearDTO piezasReparacionCrearDTO, Long id_ordenReparacion, Long id_pieza);
    List<PiezasReparacionBusquedasDTO> findAll();
    PiezasReparacionBusquedasDTO findById(Long id);
    List<PiezasReparacionBusquedasParcialDTO> obtenerPiezasReparacionPorOrdenReparacion(Long id);
    List<PiezasReparacionBusquedasDTO> obtenerPiezasReparacionPorPiezaHQL(Long id_pieza);
    List<PiezasReparacionBusquedasDTO> obtenerPiezasReparacionPorOrdenReparacion(LocalDate fecha);
    List<PiezasReparacionBusquedasDTO> obtenerPiezasReparacionPorPiezaYOrdenReparacion(String referencia);
    String deleteById(Long id);
}
