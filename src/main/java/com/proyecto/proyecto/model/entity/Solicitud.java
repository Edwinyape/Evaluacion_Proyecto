package com.proyecto.proyecto.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Solicitud")
@Data
@NoArgsConstructor
public class Solicitud {
    @Id
    private String idSolicitud;
    private String dniCliente;
    private String afpCliente;
    private Double montRetiroSolicitud;
    private String fechaSolicitud;
    private String numCuentaCliente;
}
