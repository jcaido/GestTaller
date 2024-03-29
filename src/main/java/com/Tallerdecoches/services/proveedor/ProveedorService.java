package com.Tallerdecoches.services.proveedor;

import com.Tallerdecoches.DTOs.entradaPieza.EntradaPiezaBusquedasDTO;
import com.Tallerdecoches.DTOs.propietario.PropietarioBusquedasDTO;
import com.Tallerdecoches.DTOs.proveedor.ProveedorBusquedasDTO;
import com.Tallerdecoches.DTOs.proveedor.ProveedorBusquedasParcialDTO;
import com.Tallerdecoches.DTOs.proveedor.ProveedorCrearDTO;
import com.Tallerdecoches.DTOs.proveedor.ProveedorDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProveedorService {

    ProveedorDTO crearProveedor(ProveedorCrearDTO proveedorCrearDTO, Long idCodigoPostal);
    List<ProveedorBusquedasDTO> findAll();
    List<ProveedorBusquedasParcialDTO> findAllParcial();
    ProveedorBusquedasDTO findById(Long id);
    ProveedorBusquedasDTO findByDniCif(String dniCif);
    List<ProveedorBusquedasDTO> findByNombre(String nombre);
    List<ProveedorBusquedasParcialDTO> findByNombreParcial(String nombre);
    ProveedorDTO modificarProveedor(ProveedorDTO proveedorDTO, Long idCodigoPostal);
    String deleteById(Long  id);
}
