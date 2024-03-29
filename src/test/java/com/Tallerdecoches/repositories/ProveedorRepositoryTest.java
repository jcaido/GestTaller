package com.Tallerdecoches.repositories;

import com.Tallerdecoches.entities.CodigoPostal;
import com.Tallerdecoches.entities.Proveedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ProveedorRepositoryTest {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private CodigoPostalRepository codigoPostalRepository;

    private CodigoPostal codigoPostal;
    private Proveedor proveedor;


    @BeforeEach
    void setUp() {

        codigoPostal = CodigoPostal.builder()
                .codigo("14920")
                .localidad("Aguilar de la Frontera")
                .provincia("Cordoba")
                .build();
        codigoPostalRepository.save(codigoPostal);

        proveedor = Proveedor.builder()
                .nombre("GRUPO PEÑA SA")
                .dniCif("B14567876")
                .domicilio("Calle Grande, 6")
                .codigoPostal(codigoPostal)
                .build();
        proveedorRepository.save(proveedor);
    }

    @DisplayName("Test para guardar un proveedor")
    @Test
    void guardarProveedorTest() {
        CodigoPostal codigoPostal1 = CodigoPostal.builder()
                .codigo("28700")
                .localidad("Lucena")
                .provincia("Cordoba")
                .build();
        codigoPostalRepository.save(codigoPostal1);

        Proveedor proveedor1 = Proveedor.builder()
                .nombre("RECACOR SL")
                .dniCif("B22333444")
                .domicilio("Calle Alta, 6")
                .codigoPostal(codigoPostal1)
                .build();
        proveedorRepository.save(proveedor1);
        assertThat(proveedor1.getNombre()).isEqualTo("RECACOR SL");
        assertThat(proveedor1.getCodigoPostal().getLocalidad()).isEqualTo("Lucena");
    }

    @DisplayName("Test para listar todos los proveedores")
    @Test
    void listarTodosLosProveedoresTest() {
        codigoPostal = CodigoPostal.builder()
                .codigo("28700")
                .localidad("Lucena")
                .provincia("Cordoba")
                .build();
        codigoPostalRepository.save(codigoPostal);

        proveedor = Proveedor.builder()
                .nombre("RECACOR SL")
                .dniCif("B22333444")
                .domicilio("Calle Alta, 6")
                .codigoPostal(codigoPostal)
                .build();
        proveedorRepository.save(proveedor);
        List<Proveedor> proveedores = proveedorRepository.findAll();
        assertThat(proveedores.size()).isEqualTo(2);
    }

    @DisplayName("Test para obtener un proveedor por su id")
    @Test
    void obtenerProveedorPorIdTest() {
        Proveedor proveedorEncontrado = proveedorRepository.findById(proveedor.getId()).get();
        assertThat(proveedorEncontrado.getNombre()).isEqualTo("GRUPO PEÑA SA");
    }

    @DisplayName("Test para obtener un proveedor por su dni/cif")
    @Test
    void obtenerProveedorPorDniCifTest() {
        Proveedor proveedorEncontrado = proveedorRepository.findByDniCif(proveedor.getDniCif()).get();
        assertThat(proveedorEncontrado.getNombre()).isEqualTo("GRUPO PEÑA SA");
    }

    @DisplayName("Test para obtener un proveedor por su nombre")
    @Test
    void obtenerProveedorPorNombreTest() {
        CodigoPostal codigoPostal1 = CodigoPostal.builder()
                .codigo("28700")
                .localidad("Lucena")
                .provincia("Cordoba")
                .build();
        codigoPostalRepository.save(codigoPostal1);

        Proveedor proveedor1 = Proveedor.builder()
                .nombre("GRUPO PEÑA SA")
                .dniCif("B22333444")
                .domicilio("Calle Alta, 6")
                .codigoPostal(codigoPostal1)
                .build();
        proveedorRepository.save(proveedor1);
        List<Proveedor> proveedoresEncontrados = proveedorRepository.findByNombre(proveedor.getNombre());
        assertThat(proveedoresEncontrados.size()).isEqualTo(2);
    }

    @DisplayName("Test para actualizar un proveedor")
    @Test
    void actualizarProveedorTest() {
        CodigoPostal codigoPostal1 = CodigoPostal.builder()
                .codigo("23499")
                .localidad("Zafra")
                .provincia("Badajoz")
                .build();

        Proveedor proveedorAActualizar = proveedorRepository.findById(proveedor.getId()).get();
        proveedorAActualizar.setNombre("RECAMBIOS ELIAS");
        proveedorAActualizar.setDniCif("W33222167");
        proveedorAActualizar.setDomicilio("Calle Ancha, 34");
        proveedorAActualizar.setCodigoPostal(codigoPostal1);
        proveedorRepository.save(proveedorAActualizar);
        assertThat(proveedorAActualizar.getNombre()).isEqualTo("RECAMBIOS ELIAS");
        assertThat(proveedorAActualizar.getDniCif()).isEqualTo("W33222167");
        assertThat(proveedorAActualizar.getDomicilio()).isEqualTo("Calle Ancha, 34");
        assertThat(proveedorAActualizar.getCodigoPostal()).isEqualTo(codigoPostal1);
    }

    @DisplayName("Test para eliminar un proveedor")
    @Test
    void eliminarProveedorTest() {
        proveedorRepository.deleteById(proveedor.getId());
        Optional<Proveedor> proveedorBuscado = proveedorRepository.findById(proveedor.getId());
        assertThat(proveedorBuscado).isEmpty();
    }

    @DisplayName("Test para comprobar si existe un proveedor por su id")
    @Test
    void existeProveedorPorIdTest() {
        boolean isExists = proveedorRepository.existsById(proveedor.getId());
        assertThat(isExists).isTrue();
    }

    @DisplayName("Test para comprobar si existe un proveedor por su dni/cif")
    @Test
    void existeProveedorPorDniCifTest() {
        boolean isExists = proveedorRepository.existsByDniCif(proveedor.getDniCif());
        assertThat(isExists).isTrue();
    }
}
