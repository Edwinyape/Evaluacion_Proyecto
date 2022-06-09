package com.proyecto.proyecto.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("cliente")
@Data
@NoArgsConstructor
public class Cliente {
    @Id
    private String numCuentaCliente;
    private String numCliente;
    private String dniCliente;
    private String nomCliente;
    private String apellCliente;
    private String emailCliente;
    private String afpCliente;
    private Double montoCliente;
}
