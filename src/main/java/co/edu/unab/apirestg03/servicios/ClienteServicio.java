package co.edu.unab.apirestg03.servicios;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.apirestg03.modelos.ClienteModelo;
import co.edu.unab.apirestg03.repositorios.ClienteRepositorio;

@Service
public class ClienteServicio {
    @Autowired
    ClienteRepositorio clienteRepositorio;

    public String guardarcliente(ClienteModelo cliente) {
        cliente.setNombre(cliente.getNombre().toLowerCase());
        cliente.setApellido(cliente.getApellido().toLowerCase());
        boolean estado = cliente.getId() == null || !clienteRepositorio.existsById(cliente.getId());
        clienteRepositorio.save(cliente);
        if (estado) {
            return "Se Guardo El cliente";
        } else {
            return "Se Actualizo el cliente";
        }
    }

    public ClienteModelo saveCliente(ClienteModelo cliente) {
        return clienteRepositorio.save(cliente);
    }

    public List<ClienteModelo> getListclientesOrden() {
        List<ClienteModelo> listaclientes = clienteRepositorio.findAll();
        listaclientes.sort(Comparator.comparing(ClienteModelo::getNombre));
        return listaclientes;
    }

    public Optional<ClienteModelo> getClienteById(String id) {
        return clienteRepositorio.findById(id);
    }

    // public List<ClienteModelo> getClientesByApellido(String apellido){
    // return clienteRepositorio.findByApellido(apellido);
    // }

    // public List<ClienteModelo> clientesByCiudad(String ciudad){
    // return clienteRepositorio.buscarPorCiudad(ciudad);
    // }

    // public List<ClienteModelo>clientePorFechaMenor(LocalDate fecha){
    // return clienteRepositorio.buscarClientesMenoresDeFecha(fecha);
    // }

    public ClienteModelo update(ClienteModelo cliente) {
        ClienteModelo clienteToUpdate = new ClienteModelo();
        if (clienteRepositorio.existsById(cliente.getId())) {
            clienteToUpdate = cliente;
            clienteRepositorio.save(clienteToUpdate);
        }
        return clienteToUpdate;
    }

    public String clienteDeleteById(String id) {
        if (clienteRepositorio.existsById(id)) {
            clienteRepositorio.deleteById(id);
            return "Cliente Eliminado";
        } else {
            return "Cliente No Eliminado";
        }
    }

}
