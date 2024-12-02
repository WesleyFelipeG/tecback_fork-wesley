package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
}