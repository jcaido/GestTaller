package com.Tallerdecoches.services.facturaCliente;

import com.Tallerdecoches.DTOs.facturaCliente.FacturaClienteCrearDTO;
import com.Tallerdecoches.DTOs.facturaCliente.FacturaClienteDTO;
import com.Tallerdecoches.DTOs.facturaCliente.FacturaClientesBusquedasDTO;
import com.Tallerdecoches.DTOs.facturaProveedor.FacturaProveedorBusquedasDTO;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface FacturaClienteService {

    FacturaClienteDTO crearFacturaCliente(FacturaClienteCrearDTO facturaClienteCrearDTO, Long idPropietario, Long idOrdenReparacion);
    List<FacturaClientesBusquedasDTO> findAll();
    List<FacturaClientesBusquedasDTO> obtenerFacturasClientesEntreFechas(LocalDate fechaFacturaInicial, LocalDate fechaFacturaFinal);
    List<FacturaClientesBusquedasDTO> obtenerFacturasPorClienteEntreFechas(Long idCliente, LocalDate fechaFacturaInicial, LocalDate fechaFacturaFinal);
    FacturaClientesBusquedasDTO findById(Long id);
    FacturaClientesBusquedasDTO obtenerUltimaFacturaCliente();
    FacturaClienteDTO modificarFacturaCliente(FacturaClienteDTO facturaClienteDTO, Long idOrdenReparacion);
    FacturaClienteDTO modificarFacturaClienteNoOR(FacturaClienteDTO facturaClienteDTO);
    String eliminarFacturaCliente(Long id);

}
