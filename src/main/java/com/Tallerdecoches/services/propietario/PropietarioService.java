package com.Tallerdecoches.services.propietario;

import com.Tallerdecoches.DTOs.propietario.PropietarioBusquedasDTO;
import com.Tallerdecoches.DTOs.propietario.PropietarioBusquedasParcialDTO;
import com.Tallerdecoches.DTOs.propietario.PropietarioCrearDTO;
import com.Tallerdecoches.DTOs.propietario.PropietarioDTO;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface PropietarioService {
    PropietarioDTO crearPropietario(PropietarioCrearDTO propietarioCrearDTO, Long id_codigoPostal);
    List<PropietarioBusquedasDTO> findAll();
    List<PropietarioBusquedasParcialDTO> findAllPartial();
    PropietarioBusquedasDTO findById(Long id);
    PropietarioBusquedasDTO findByDni(String dni);
    List<PropietarioBusquedasDTO> findByNombre(String nombre);
    List<PropietarioBusquedasDTO> findByPrimerApellido(String primerApellido);
    List<PropietarioBusquedasParcialDTO> findByPrimerApellidoPartial(String primerApellido);
    List<PropietarioBusquedasDTO> findByNombreAndPrimerApellidoAndSegundoApellido(String nombre, String primerApellido, String segundoApellido);
    List<PropietarioBusquedasDTO> ObtenerPropietariosPorCodigoPostal(Long id);
    List<PropietarioBusquedasParcialDTO> obtenerPropietariosPorCodigoPostalParcial(Long id);
    String deleteById(Long  id);
    List<PropietarioBusquedasDTO> obtenerPropietariosPorCodigoPostalSQL(Long id_codigo_postal);
    List<PropietarioBusquedasDTO> obtenerPropietariosPorCodigoPostalHQL(Long id_codigo_postal);
    PropietarioDTO modificarPropietario(PropietarioDTO propietarioDTO, Long id_codigoPostal);

}
