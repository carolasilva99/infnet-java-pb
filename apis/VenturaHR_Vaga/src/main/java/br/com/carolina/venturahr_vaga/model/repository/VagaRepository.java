package br.com.carolina.venturahr_vaga.model.repository;

import br.com.carolina.venturahr_vaga.model.domain.Vaga;
import br.com.carolina.venturahr_vaga.model.domain.enums.StatusVaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Integer> {
    List<Vaga> findAllByDataInicioBefore(LocalDateTime tempoLimiteParaExpiracao);
}
