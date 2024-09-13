package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.TrilhaSonora;
import br.com.fujideia.iesp.tecback.model.dto.TrilhaSonoraDTO;
import br.com.fujideia.iesp.tecback.service.TrilhaSonoraService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trilhas")
@RequiredArgsConstructor
@Slf4j
public class TrilhaSonoraController {

    private final TrilhaSonoraService trilhaSonoraService;

    @GetMapping
    public ResponseEntity<List<TrilhaSonora>> listarTodos() {
        log.info("Chamando listarTodos no TrilhaSonoraController");
        List<TrilhaSonora> trilhas = trilhaSonoraService.listarTodos();
        return ResponseEntity.ok(trilhas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrilhaSonora> buscarPorId(@PathVariable Long id) {
        log.info("Chamando buscarPorId no TrilhaSonoraController com id: {}", id);
        Optional<TrilhaSonora> trilhaSonora = trilhaSonoraService.buscarPorId(id);
        return trilhaSonora.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/compositor/{compositor}")
    public ResponseEntity<List<TrilhaSonora>> buscarPorCompositor(@PathVariable String compositor) {
        log.info("Chamando buscarPorCompositor no TrilhaSonoraController com compositor: {}", compositor);
        List<TrilhaSonora> trilhas = trilhaSonoraService.buscarPorCompositor(compositor);
        return ResponseEntity.ok(trilhas);
    }

    @PostMapping
    public ResponseEntity<TrilhaSonora> criarTrilhaSonora(@RequestBody TrilhaSonora trilhaSonora) {
        TrilhaSonora trilhaSonoraCriada = trilhaSonoraService.criarTrilhaSonora(trilhaSonora);
        return ResponseEntity.ok(trilhaSonoraCriada);
    }
}