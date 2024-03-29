package com.Tallerdecoches.services.manoDeObra;

import com.Tallerdecoches.DTOs.manoDeObra.ManoDeObraCrearDTO;
import com.Tallerdecoches.DTOs.codigoPostal.CodigoPostalDTO;
import com.Tallerdecoches.DTOs.manoDeObra.ManoDeObraDTO;
import com.Tallerdecoches.DTOs.ordenReparacion.OrdenReparacionBusquedasDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ManoDeObraService {
    ManoDeObraDTO crearManoDeObra(ManoDeObraCrearDTO manoDeObraCrearDTO);
    List<ManoDeObraDTO> findAll();
    ManoDeObraDTO findByPrecioHoraClienteTallerActual(Boolean precioHoraClienteTallerActual);
}
