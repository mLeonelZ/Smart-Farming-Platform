package br.com.agricoladigital.smart_farming_api.repository;

import br.com.agricoladigital.smart_farming_api.entity.Talhao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TalhaoRepository extends JpaRepository<Talhao, Long> {
    List<Talhao> findAllByFazenda_Id(Long fazendaId);

    Optional<Talhao> findByIdAndFazenda_Id(Long id, Long fazendaId);
}
