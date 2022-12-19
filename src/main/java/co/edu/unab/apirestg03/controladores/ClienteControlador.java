package co.edu.unab.apirestg03.controladores;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unab.apirestg03.modelos.ClienteModelo;
import co.edu.unab.apirestg03.servicios.ClienteServicio;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteControlador {
    @Autowired
    ClienteServicio clienteServicio;

    @GetMapping("/all")
    public List<ClienteModelo> getAllClientesOrden() {
        return clienteServicio.getListclientesOrden();
    }

    @GetMapping("/{id}")
    public Optional<ClienteModelo> findClienteByID(@PathVariable("id") String id) {
        return clienteServicio.getClienteById(id);
    }

    // @GetMapping("/query") // ejemplo:
    // http://localhost:8080/pacientes/query?apellido=mejia
    // public List<ClienteModelo> getClientesByApellido(@RequestParam("apellido")
    // String apellido){
    // return clienteServicio.getClientesByApellido(apellido);
    // }

    // @GetMapping("/fecha/query")
    // public List<ClienteModelo> getClienteByFechaMenor(@RequestParam("fecha")
    // String fecha){
    // LocalDate localDate = LocalDate.parse(fecha);
    // return clienteServicio.clientePorFechaMenor(localDate);
    // }
    // @GetMapping("/ciudad/{ciudad}")
    // public List<ClienteModelo> listClientesCiudad(@PathVariable("ciudad") String
    // ciudad){
    // return clienteServicio.clientesByCiudad(ciudad);
    // }

    // @PostMapping("/save")
    // public String saveCliente(@RequestBody ClienteModelo cliente){
    // return clienteServicio.guardarcliente(cliente);
    // }

    @PostMapping("/save")
    public ClienteModelo saveCliente(@RequestBody ClienteModelo cliente) {
        return clienteServicio.saveCliente(cliente);
    }

    @PutMapping("/update")
    public ClienteModelo update(@RequestBody ClienteModelo cliente) {
        return clienteServicio.update(cliente);
    }

    @DeleteMapping("/{id}")
    public String deleteAgendaById(@PathVariable("id") String id) {
        return clienteServicio.clienteDeleteById(id);
    }

}
