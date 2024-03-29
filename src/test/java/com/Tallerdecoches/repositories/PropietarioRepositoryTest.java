package com.Tallerdecoches.repositories;

import com.Tallerdecoches.entities.CodigoPostal;
import com.Tallerdecoches.entities.Propietario;
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
public class PropietarioRepositoryTest {

    @Autowired
    private PropietarioRepository propietarioRepository;

    @Autowired
    private CodigoPostalRepository codigoPostalRepository;

    private CodigoPostal codigoPostal;
    private Propietario propietario;

    @BeforeEach
    void setUp() {
        codigoPostal = CodigoPostal.builder()
                .codigo("14920")
                .localidad("Aguilar de la Frontera")
                .provincia("Cordoba")
                .build();
        codigoPostalRepository.save(codigoPostal);
        propietario = Propietario.builder()
                .nombre("Antonio")
                .primerApellido("Perez")
                .segundoApellido("Segundo")
                .dni("44555666G")
                .domicilio("Calle Larga, 56")
                .build();
        propietarioRepository.save(propietario);
    }

    @DisplayName("Test para guardar un propietario")
    @Test
    void guardarPropietarioTest() {
        CodigoPostal codigoPostal1 = CodigoPostal.builder()
                .codigo("28700")
                .localidad("Lucena")
                .provincia("Cordoba")
                .build();
        codigoPostalRepository.save(codigoPostal1);
        Propietario propietario1 = Propietario.builder()
                .nombre("Jaime")
                .primerApellido("Rodriguez")
                .segundoApellido("Jimenez")
                .dni("55888999A")
                .domicilio("Calle Fuentecita, 98")
                .codigoPostal(codigoPostal1)
                .build();
        Propietario propietarioGuardado = propietarioRepository.save(propietario1);
        assertThat(propietarioGuardado.getId()).isGreaterThan(0);
        assertThat(propietarioGuardado.getNombre()).isEqualTo("Jaime");
        assertThat(propietarioGuardado.getCodigoPostal().getLocalidad()).isEqualTo("Lucena");
    }

    @DisplayName("Test para listar todos los propietarios")
    @Test
    void listarTodosLosPropietariosTest() {
        Propietario propietario1 = Propietario.builder()
                .nombre("Jaime")
                .primerApellido("Rodriguez")
                .segundoApellido("Jimenez")
                .dni("55888999A")
                .domicilio("Calle Fuentecita, 98")
                .codigoPostal(codigoPostal)
                .build();
        propietarioRepository.save(propietario1);
        List<Propietario> propietarios = propietarioRepository.findAll();
        assertThat(propietarios.size()).isEqualTo(2);
    }

    @DisplayName("Test para obtener un propietario por su id")
    @Test
    void obtenerPropietarioPorIdTest() {
        Propietario propietarioEncontrado = propietarioRepository.findById(propietario.getId()).get();
        assertThat(propietarioEncontrado.getNombre()).isEqualTo("Antonio");
    }

    @DisplayName("Test para obtener un propietario por su dni")
    @Test
    void obtenerPropietarioPorDniTest() {
        Propietario propietarioEncontrado = propietarioRepository.findByDni(propietario.getDni()).get();
        assertThat(propietario.getDni()).isEqualTo("44555666G");
    }

    @DisplayName("Test para obtener una lista de propietarios filtrada por nombre")
    @Test
    void obtenerPropietariosPorNombre() {
        Propietario propietarioNuevo = Propietario.builder()
                .nombre("Antonio")
                .primerApellido("jimenez")
                .segundoApellido("Gomez")
                .dni("99888777D")
                .domicilio("Calle Empedrada, 5")
                .codigoPostal(codigoPostal)
                .build();
        propietarioRepository.save(propietarioNuevo);
        List<Propietario> propietarios = propietarioRepository.findByNombre("Antonio");
        assertThat(propietarios.size()).isEqualTo(2);
    }

    @DisplayName("Test para obtener una lista de propietarios filtrada por primer apellido")
    @Test
    void obtenerPropietariosPorPrimerApellido() {
        Propietario propietarioNuevo = Propietario.builder()
                .nombre("Braulio")
                .primerApellido("Perez")
                .segundoApellido("Gomez")
                .dni("99888777D")
                .domicilio("Calle Empedrada, 5")
                .codigoPostal(codigoPostal)
                .build();
        propietarioRepository.save(propietarioNuevo);
        List<Propietario> propietarios = propietarioRepository.findByPrimerApellido("Perez");
        assertThat(propietarios.size()).isEqualTo(2);
    }

    @DisplayName("Test para obtener una lista de propietarios filtrada por nombre completo")
    @Test
    void obtenerPropietariosPorNombreCompleto() {
        Propietario propietario1 = Propietario.builder()
                .nombre("Antonio")
                .primerApellido("Perez")
                .segundoApellido("Segundo")
                .dni("115556456H")
                .domicilio("Calle Tercia, 6")
                .codigoPostal(codigoPostal)
                .build();
        propietarioRepository.save(propietario1);
        List<Propietario> propietarios = propietarioRepository.findByNombreAndPrimerApellidoAndSegundoApellido("Antonio", "Perez", "Segundo");
        assertThat(propietarios.size()).isEqualTo(2);
    }

    @DisplayName("Test para actualizar un propietario")
    @Test
    void actualizarPropietarioTest() {
        CodigoPostal codigoPostal1 = CodigoPostal.builder()
                .codigo("23499")
                .localidad("Zafra")
                .provincia("Badajoz")
                .build();
        Propietario propietarioAActualizar = propietarioRepository.findById(propietario.getId()).get();
        propietarioAActualizar.setNombre("Jorge");
        propietarioAActualizar.setPrimerApellido("Ramirez");
        propietarioAActualizar.setSegundoApellido("Raya");
        propietarioAActualizar.setDni("55665778E");
        propietarioAActualizar.setDomicilio("Calle Moreno, 3");
        propietarioAActualizar.setCodigoPostal(codigoPostal1);
        Propietario propietarioActualizado = propietarioRepository.save(propietarioAActualizar);
        assertThat(propietarioActualizado.getNombre()).isEqualTo("Jorge");
    }

    @DisplayName("Test para eliminar un propietario")
    @Test
    void eliminarPropietarioTest() {
        propietarioRepository.deleteById(propietario.getId());
        Optional<Propietario> propietarioBorrado = propietarioRepository.findById(propietario.getId());
        assertThat(propietarioBorrado).isEmpty();
    }

    @DisplayName("Test para comprobar si existe un propietario por su id")
    @Test
    void existsPropietarioPorIdTest() {
        boolean isExists = propietarioRepository.existsById(propietario.getId());
        assertThat(isExists).isTrue();
    }

    @DisplayName("Test para comprobar si existe un propietario por su dni")
    @Test
    void existsPropietarioPorDniTest() {
        boolean isExists = propietarioRepository.existsByDni(propietario.getDni());
        assertThat(isExists).isTrue();
    }
}
