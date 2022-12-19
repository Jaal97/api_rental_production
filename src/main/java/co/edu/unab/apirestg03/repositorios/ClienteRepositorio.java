package co.edu.unab.apirestg03.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.unab.apirestg03.modelos.ClienteModelo;

@Repository
public interface ClienteRepositorio extends MongoRepository<ClienteModelo, String> {

    // List<ClienteModelo> findByApellido(String apellido); //keywords for query
    // methods

    // @Query("{'direccion.ciudad':?0}")
    // List<ClienteModelo> buscarPorCiudad(String ciudad);

    // @Query("{fnacimiento:{$lt:?0}}")
    // List<ClienteModelo>buscarClientesMenoresDeFecha(LocalDate fecha);

    // List<PacienteModelo>findByFnacimientoBefore(LocalDate date);//keywords for
    // query methods

}
