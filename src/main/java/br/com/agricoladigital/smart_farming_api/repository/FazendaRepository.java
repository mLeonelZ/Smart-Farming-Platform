package br.com.agricoladigital.smart_farming_api.repository;

import br.com.agricoladigital.smart_farming_api.entity.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FazendaRepository extends JpaRepository<Fazenda, Long> {
    List<Fazenda> findAllByUsuario_Id(Long usuarioId);
}
