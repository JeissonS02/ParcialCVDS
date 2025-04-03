package com.ecicredit.payments.model;

import lombok.Data;

@Data
public class Articulo {
    private String id;
    private String nombre;
    private double precio;
    private int cantidad;
}