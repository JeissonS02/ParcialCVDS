package com.ecicredit.payments.controller;

import com.ecicredit.payments.model.Pago;
import com.ecicredit.payments.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    //Metodo para registrar un pago cualquiera

    @PostMapping
    public ResponseEntity<?> registrarPago(@RequestBody Pago pago) {
        try {
            Pago result = pagoService.guardarPago(pago);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    //Metodo para buscar los pagos de un usuario por su ID

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Pago>> consultarPagos(@PathVariable String usuarioId) {
        List<Pago> pagos = pagoService.consultarPagosPorUsuario(usuarioId);
        return new ResponseEntity<>(pagos, HttpStatus.OK);
    }
}