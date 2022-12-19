package co.edu.unab.apirestg03.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unab.apirestg03.modelos.AutoModelo;
import co.edu.unab.apirestg03.servicios.AutoServicio;

@RestController
@RequestMapping("/autos")
@CrossOrigin(origins = "*")
public class AutoControlador {
    @Autowired
    AutoServicio autoServicio;

    @GetMapping("/all")
    public List<AutoModelo> getAllAutos(){
       return autoServicio.getAllautos();
    }
    
    @GetMapping("/{id}")
    public Optional<AutoModelo> getAutoById(@PathVariable("id") String id){
        return autoServicio.getId(id);
    }

    @PostMapping("/save")
    public AutoModelo saveAuto(@RequestBody AutoModelo auto){
        return autoServicio.saveauto(auto);
    }

    @PutMapping("/update")
    public AutoModelo update(@RequestBody AutoModelo auto) {
        return autoServicio.update(auto);
    }

    @DeleteMapping("/{id}")
    public String deleteAgendaById(@PathVariable("id") String id){
        return autoServicio.autoDeleteById(id);
    }

}
