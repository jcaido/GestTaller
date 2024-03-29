package com.Tallerdecoches.services.facturaProveedor;

import com.Tallerdecoches.DTOs.facturaProveedor.FacturaProveedorBusquedasDTO;
import com.Tallerdecoches.DTOs.facturaProveedor.FacturaProveedorCrearDTO;
import com.Tallerdecoches.DTOs.facturaProveedor.FacturaProveedorDTO;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface FacturaProveedorService {

    FacturaProveedorDTO crearFacturaProveedor(FacturaProveedorCrearDTO facturaProveedorCrearDTO, Long idProveedor);
    List<FacturaProveedorBusquedasDTO> findAll();
    FacturaProveedorBusquedasDTO findById(Long id);
    List<FacturaProveedorBusquedasDTO> obtenerFacturasProveedoresEntreFechas(LocalDate fechaFacturaInicial, LocalDate fechaFacturaFinal);
    List<FacturaProveedorBusquedasDTO> obtenerFacturasPorProveedorEntreFechas(Long idProveedor, LocalDate fechaFacturaInicial, LocalDate fechaFacturaFinal);
    FacturaProveedorDTO modificarFacturaProveedor(FacturaProveedorDTO facturaProveedorDTO, Long idProveedor);
    String deleteById(Long id);
}
