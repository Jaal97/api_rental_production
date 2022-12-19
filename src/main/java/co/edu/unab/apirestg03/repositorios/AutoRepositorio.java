package co.edu.unab.apirestg03.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.edu.unab.apirestg03.modelos.AutoModelo;

@Repository
public interface AutoRepositorio extends MongoRepository <AutoModelo, String>{
    

}
