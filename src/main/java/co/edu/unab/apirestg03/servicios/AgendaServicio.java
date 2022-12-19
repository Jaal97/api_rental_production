package co.edu.unab.apirestg03.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;

import co.edu.unab.apirestg03.modelos.AgendaModelo;
import co.edu.unab.apirestg03.modelos.AutoModelo;
import co.edu.unab.apirestg03.repositorios.AgendaRepositorio;
import co.edu.unab.apirestg03.repositorios.AutoRepositorio;

@Service
public class AgendaServicio {
    @Autowired
    AgendaRepositorio agendaRepositorio;
    @Autowired
    AutoRepositorio autoRepositorio;

    public List<AgendaModelo>getAllAgendas(){
        return agendaRepositorio.findAll();
    }

    // public Optional <AgendaModelo> getAgendaById(String id){
    //     Optional <AgendaModelo> agenda = agendaRepositorio.findById(id);
    //     Optional <AutoModelo> auto = autoRepositorio.findById(agenda.get().getId_auto());
    //     agenda.get().setMarcaauto(id);(auto.get().getMarca());
    //     agenda.get().setModelo(auto.get().getModelo());
    //     return agenda;
    // }

    public Optional<AgendaModelo> getAgendaById(String id) {
        return agendaRepositorio.findById(id);
    }
    
    public AgendaModelo saveAgenda(AgendaModelo agenda){
        return agendaRepositorio.save(agenda);
    }

    public AgendaModelo update(AgendaModelo agenda) {
        AgendaModelo agendaToUpdate=new AgendaModelo();
        if(agendaRepositorio.existsById(agenda.getId())){
            agendaToUpdate = agenda;
            agendaRepositorio.save(agendaToUpdate);
        }        
        return agendaToUpdate;
    }

    public String eliminarAgendaPorId(String id) {
        if (agendaRepositorio.existsById(id)) {
            agendaRepositorio.deleteById(id);
            return "Agenda Eliminada";
        } else {
            return "Documento No Eliminado";
        }
    }
    
}
