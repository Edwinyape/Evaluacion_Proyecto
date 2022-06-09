package com.proyecto.proyecto.controller;

import com.proyecto.proyecto.model.entity.Cliente;
import com.proyecto.proyecto.model.entity.Solicitud;
import com.proyecto.proyecto.repository.ClienteRepository;
import com.proyecto.proyecto.repository.SolicitudRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/solicitud")
public class SolicitudController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private SolicitudRepository solicitudRepository;

    @PostMapping("/GuardarSolicitud")
    @ResponseStatus(HttpStatus.OK)
    public String guardarSolicitud(@RequestBody Solicitud solicitud)
    {
        LOGGER.info("Validacion de creacion de solicitud");
        String numerocuenta = solicitud.getNumCuentaCliente();
        Double montoretiro = solicitud.getMontRetiroSolicitud();
        String mensaje = null;

        Optional<Cliente> cliente = clienteRepository.findById(numerocuenta);

        Double monto = cliente.get().getMontoCliente();
        String dniCliente = cliente.get().getDniCliente();
        String afpCliente = cliente.get().getAfpCliente();

        Double montoactual = monto*0.50;

        if(montoretiro > monto )
        {
            LOGGER.info("Validacion de monto no permitido");
            mensaje = "No se puede registrar la solicitud. Monto mayor que el permitido";
        }
        else
        {
            if(montoretiro < monto && montoretiro > montoactual)
            {
                LOGGER.info("Validacion de monto menor al actual pero mayor al permitido");
                mensaje = "Registro de solicitud exitoso";
            }
            if(montoretiro < monto && montoretiro<=montoactual)
            {
                LOGGER.info("Validacion de monto permitido a desembolsar");
                mensaje = "Monto mínimo no cubierto por favor revise el monto mínimo a retirar";
            }
        }


        solicitud.setAfpCliente(afpCliente);
        solicitud.setDniCliente(dniCliente);
        solicitudRepository.save(solicitud);

        return mensaje;
    }
}
