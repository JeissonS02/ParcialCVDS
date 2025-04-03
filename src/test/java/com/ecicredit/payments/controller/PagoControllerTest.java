package com.ecicredit.payments.controller;

import com.ecicredit.payments.model.Pago;
import com.ecicredit.payments.service.PagoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

@WebMvcTest(PagoController.class)
public class PagoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PagoService pagoService;

    @Test
    public void testRegistrarPago() throws Exception {
        Pago pago = new Pago();
        pago.setId("123");
        pago.setUsuarioId("12345");
        pago.setTotal(100.0);

        Mockito.when(pagoService.guardarPago(Mockito.any(Pago.class))).thenReturn(pago);

        String requestJson = "{\"usuarioId\":\"12345\",\"fecha\":\"2025-04-03\",\"estado\":\"aprobado\",\"total\":100.0,\"articulos\":[{\"id\":\"1\",\"nombre\":\"Producto A\",\"precio\":50.0,\"cantidad\":1},{\"id\":\"2\",\"nombre\":\"Producto B\",\"precio\":25.0,\"cantidad\":2}]}";

        mockMvc.perform(post("/pagos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.total").value(100.0));
    }

    @Test
    public void testRegistrarPagoConError() throws Exception {
        String requestJson = "{\"usuarioId\":\"12345\",\"fecha\":\"2025-04-03\",\"estado\":\"aprobado\",\"total\":90.0,\"articulos\":[{\"id\":\"1\",\"nombre\":\"Producto A\",\"precio\":50.0,\"cantidad\":1},{\"id\":\"2\",\"nombre\":\"Producto B\",\"precio\":25.0,\"cantidad\":2}]}";

        Mockito.doThrow(new IllegalArgumentException("El valor total de la transacción no coincide."))
                .when(pagoService).guardarPago(Mockito.any(Pago.class));

        mockMvc.perform(post("/pagos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("El valor total de la transacción no coincide."));
    }

    @Test
    public void testConsultarPagos() throws Exception {
        Pago pago1 = new Pago();
        pago1.setId("123");
        pago1.setUsuarioId("12345");

        Pago pago2 = new Pago();
        pago2.setId("124");
        pago2.setUsuarioId("12345");

        Mockito.when(pagoService.consultarPagosPorUsuario("12345")).thenReturn(Arrays.asList(pago1, pago2));

        mockMvc.perform(get("/pagos/usuario/12345"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("123"))
                .andExpect(jsonPath("$[1].id").value("124"));
    }

    @Test
    public void testConsultarPagosSinResultados() throws Exception {
        Mockito.when(pagoService.consultarPagosPorUsuario("12345")).thenReturn(Arrays.asList());

        mockMvc.perform(get("/pagos/usuario/12345"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}