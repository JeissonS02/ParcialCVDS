package com.ecicredit.payments.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticuloTest {

    @Test
    void testArticulo() {
        Articulo articulo = new Articulo();
        articulo.setId("1");
        articulo.setNombre("Producto A");
        articulo.setPrecio(50.0);
        articulo.setCantidad(2);

        assertEquals("1", articulo.getId());
        assertEquals("Producto A", articulo.getNombre());
        assertEquals(50.0, articulo.getPrecio());
        assertEquals(2, articulo.getCantidad());
    }
}