package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.TrilhaSonora;
import br.com.fujideia.iesp.tecback.repository.TrilhaSonoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrilhaSonoraService {

    private final TrilhaSonoraRepository trilhaSonoraRepository;

    public List<TrilhaSonora> listarTodos() {
        return trilhaSonoraRepository.findAll();
    }

    public Optional<TrilhaSonora> buscarPorId(Long id) {
        return trilhaSonoraRepository.findById(id);
    }

    public List<TrilhaSonora> buscarPorCompositor(String compositor) {
        return trilhaSonoraRepository.findByCompositor(compositor);
    }

    public TrilhaSonora criarTrilhaSonora(TrilhaSonora trilhaSonora) {
        return trilhaSonoraRepository.save(trilhaSonora);
    }
}
