package com.ecicredit.payments.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "pagos")
public class Pago {
    @Id
    private String id;
    private String usuarioId;
    private Date fecha;
    private String estado;
    private double total;
    private List<Articulo> articulos;
}