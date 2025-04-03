package com.ecicredit.payments.service;

import com.ecicredit.payments.model.Pago;
import com.ecicredit.payments.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public Pago guardarPago(Pago pago) {
        // Validar y calcular el total
        double totalCalculado = pago.getArticulos().stream()
                .mapToDouble(articulo -> articulo.getPrecio() * articulo.getCantidad())
                .sum();
        if (totalCalculado != pago.getTotal()) {
            throw new IllegalArgumentException("El valor total de la transacción no coincide.");
        }
        pago.setTotal(totalCalculado);
        return pagoRepository.save(pago);
    }

    public List<Pago> consultarPagosPorUsuario(String usuarioId) {
        return pagoRepository.findByUsuarioId(usuarioId);
    }
}