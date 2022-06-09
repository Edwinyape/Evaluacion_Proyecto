package com.proyecto.proyecto.controller;

import com.proyecto.proyecto.model.entity.Cliente;
import com.proyecto.proyecto.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/ListarCliente")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listarCliente()
    {
        LOGGER.info("Ingresa a la consulta de todos los clientes registrados");
        return clienteRepository.findAll();
    }

    @PostMapping("/GuardarCliente")
    @ResponseStatus(HttpStatus.OK)
    public void guardarCliente(@RequestBody Cliente client)
    {
        LOGGER.info("Inicia la creacion de un cliente");
        clienteRepository.save(client);
    }

    @PutMapping("/ActualizarCliente/{numCuentaCliente}")
    public Cliente actualizarCliente(@RequestBody Cliente cliente, @PathVariable(value="numCuentaCliente") String numerocuenta)
    {
        cliente.setNumCuentaCliente(numerocuenta);
        clienteRepository.save(cliente);
        LOGGER.info("Actualiza el numero de cuenta de los cliente");
        return cliente;
    }

    @DeleteMapping("/EliminarCliente/{numCuentaCliente}")
    public String eliminarCliente(@PathVariable(value = "numCuentaCliente") String numerocuenta)
    {
        clienteRepository.deleteById(numerocuenta);
        LOGGER.info("Cliente eliminado por numero de cuenta");
        return "Cliente eliminado satisfactoriamente";
    }
}
