package com.ecicredit.payments.service;

import com.ecicredit.payments.model.Articulo;
import com.ecicredit.payments.model.Pago;
import com.ecicredit.payments.repository.PagoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PagoServiceTest {

    @Mock
    private PagoRepository pagoRepository;

    @InjectMocks
    private PagoService pagoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGuardarPago() {
        Articulo articulo1 = new Articulo();
        articulo1.setId("1");
        articulo1.setNombre("Producto A");
        articulo1.setPrecio(50.0);
        articulo1.setCantidad(1);

        Articulo articulo2 = new Articulo();
        articulo2.setId("2");
        articulo2.setNombre("Producto B");
        articulo2.setPrecio(25.0);
        articulo2.setCantidad(2);

        Pago pago = new Pago();
        pago.setId("123");
        pago.setUsuarioId("12345");
        pago.setArticulos(Arrays.asList(articulo1, articulo2));
        pago.setTotal(100.0);

        when(pagoRepository.save(any(Pago.class))).thenReturn(pago);

        Pago result = pagoService.guardarPago(pago);

        assertNotNull(result);
        assertEquals(100.0, result.getTotal());
        verify(pagoRepository, times(1)).save(pago);
    }

    @Test
    void testGuardarPagoConTotalIncorrecto() {
        Articulo articulo1 = new Articulo();
        articulo1.setId("1");
        articulo1.setNombre("Producto A");
        articulo1.setPrecio(50.0);
        articulo1.setCantidad(1);

        Articulo articulo2 = new Articulo();
        articulo2.setId("2");
        articulo2.setNombre("Producto B");
        articulo2.setPrecio(25.0);
        articulo2.setCantidad(2);

        Pago pago = new Pago();
        pago.setId("123");
        pago.setUsuarioId("12345");
        pago.setArticulos(Arrays.asList(articulo1, articulo2));
        pago.setTotal(90.0); // Total incorrecto

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            pagoService.guardarPago(pago);
        });

        String expectedMessage = "El valor total de la transacción no coincide.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testConsultarPagosPorUsuario() {
        Pago pago1 = new Pago();
        pago1.setId("123");
        pago1.setUsuarioId("12345");

        Pago pago2 = new Pago();
        pago2.setId("124");
        pago2.setUsuarioId("12345");

        when(pagoRepository.findByUsuarioId("12345")).thenReturn(Arrays.asList(pago1, pago2));

        List<Pago> pagos = pagoService.consultarPagosPorUsuario("12345");

        assertNotNull(pagos);
        assertEquals(2, pagos.size());
        verify(pagoRepository, times(1)).findByUsuarioId("12345");
    }

    @Test
    void testGuardarPagoSinArticulos() {
        Pago pago = new Pago();
        pago.setId("123");
        pago.setUsuarioId("12345");
        pago.setArticulos(Arrays.asList());
        pago.setTotal(0.0);

        when(pagoRepository.save(any(Pago.class))).thenReturn(pago);

        Pago result = pagoService.guardarPago(pago);

        assertNotNull(result);
        assertEquals(0.0, result.getTotal());
        verify(pagoRepository, times(1)).save(pago);
    }
}