package com.ecicredit.payments.repository;

import com.ecicredit.payments.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}