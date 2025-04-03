package com.ecicredit.payments.repository;

import com.ecicredit.payments.model.Pago;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PagoRepository extends MongoRepository<Pago, String> {
    List<Pago> findByUsuarioId(String usuarioId);
}