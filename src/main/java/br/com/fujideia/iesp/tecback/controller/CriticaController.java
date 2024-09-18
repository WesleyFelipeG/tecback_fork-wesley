package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Critica;
import br.com.fujideia.iesp.tecback.model.dto.CriticaDTO;
import br.com.fujideia.iesp.tecback.service.CriticaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/criticas")
@RequiredArgsConstructor
@Slf4j
public class CriticaController {

    private final CriticaService criticaService;

    @GetMapping
    public ResponseEntity<List<Critica>> listarTodos() {
        log.info("Chamando listarTodos no CriticaController");
        List<Critica> criticas = criticaService.listarTodos();
        return ResponseEntity.ok(criticas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Critica> buscarPorId(@PathVariable Long id) {
        log.info("Chamando buscarPorId no CriticaController com id: {}", id);
        Optional<Critica> critica = criticaService.buscarPorId(id);
        return critica.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/filme/{filmeId}")
    public ResponseEntity<List<Critica>> buscarPorFilmeId(@PathVariable Long filmeId) {
        log.info("Chamando buscarPorFilmeId no CriticaController com filmeId: {}", filmeId);
        List<Critica> criticas = criticaService.buscarPorFilmeId(filmeId);
        return ResponseEntity.ok(criticas);
    }

    @PostMapping
    public ResponseEntity<Critica> criarCritica(@RequestBody Critica critica) {
        Critica criticaCriada = criticaService.criarCritica(critica);
        return ResponseEntity.ok(criticaCriada);
    }
}