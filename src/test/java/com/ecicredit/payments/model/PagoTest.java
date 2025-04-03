package com.ecicredit.payments.model;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PagoTest {

    @Test
    void testPago() {
        Pago pago = new Pago();
        pago.setId("123");
        pago.setUsuarioId("12345");
        pago.setFecha(new Date());
        pago.setEstado("aprobado");
        pago.setTotal(100.0);
        pago.setArticulos(Arrays.asList(new Articulo()));

        assertEquals("123", pago.getId());
        assertEquals("12345", pago.getUsuarioId());
        assertNotNull(pago.getFecha());
        assertEquals("aprobado", pago.getEstado());
        assertEquals(100.0, pago.getTotal());
        assertNotNull(pago.getArticulos());
    }
}