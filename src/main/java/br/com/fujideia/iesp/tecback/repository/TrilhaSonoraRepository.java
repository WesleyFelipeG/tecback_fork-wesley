package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.TrilhaSonora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrilhaSonoraRepository extends JpaRepository<TrilhaSonora, Long> {
    List<TrilhaSonora> findByCompositor(String compositor);
}