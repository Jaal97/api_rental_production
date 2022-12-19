package co.edu.unab.apirestg03.servicios;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.apirestg03.modelos.AutoModelo;
import co.edu.unab.apirestg03.repositorios.AutoRepositorio;

@Service
public class AutoServicio {
    @Autowired
    AutoRepositorio autoRepositorio;

    public List<AutoModelo> getAllautos(){
        List<AutoModelo> autos= autoRepositorio.findAll();
        autos.sort((Comparator.comparing(AutoModelo::getModelo)));
        return autos;
    }

    public Optional<AutoModelo> getId(String id) {
        Optional<AutoModelo> response = autoRepositorio.findById(id);
        return response;
    }

    public AutoModelo saveauto(AutoModelo auto){
        return autoRepositorio.save(auto);
    }

    public AutoModelo update(AutoModelo auto) {
        AutoModelo autoToUpdate= new AutoModelo();
        if(autoRepositorio.existsById(auto.getId())){
            autoToUpdate = auto;
            autoRepositorio.save(autoToUpdate);
        }        
        return autoToUpdate;
    }

    public String autoDeleteById(String id) {
        if (autoRepositorio.existsById(id)) {
            autoRepositorio.deleteById(id);
            return "Auto Eliminado";
        } else {
            return "Auto No Eliminado";
        }
    }

}
