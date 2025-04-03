package com.ecicredit.payments.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void testUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId("1");
        usuario.setNombre("John Doe");
        usuario.setEmail("john.doe@example.com");

        assertEquals("1", usuario.getId());
        assertEquals("John Doe", usuario.getNombre());
        assertEquals("john.doe@example.com", usuario.getEmail());
    }
}