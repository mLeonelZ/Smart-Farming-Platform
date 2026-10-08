package br.com.agricoladigital.smart_farming_api.repository;

import br.com.agricoladigital.smart_farming_api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
}
