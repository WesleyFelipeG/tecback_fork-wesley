package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Cinematografia;
import br.com.fujideia.iesp.tecback.model.dto.CinematografiaDTO;
import br.com.fujideia.iesp.tecback.service.CinematografiaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cinematografias")
@RequiredArgsConstructor
@Slf4j
public class CinematografiaController {

    private final CinematografiaService cinematografiaService;

    @GetMapping
    public ResponseEntity<List<Cinematografia>> listarTodos() {
        log.info("Chamando listarTodos no CinematografiaController");
        List<Cinematografia> cinematografias = cinematografiaService.listarTodos();
        return ResponseEntity.ok(cinematografias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cinematografia> buscarPorId(@PathVariable Long id) {
        log.info("Chamando buscarPorId no CinematografiaController com id: {}", id);
        Optional<Cinematografia> cinematografia = cinematografiaService.buscarPorId(id);
        return cinematografia.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/filme/{filmeId}")
    public ResponseEntity<List<Cinematografia>> buscarPorFilmeId(@PathVariable Long filmeId) {
        log.info("Chamando buscarPorFilmeId no CinematografiaController com filmeId: {}", filmeId);
        List<Cinematografia> cinematografias = cinematografiaService.buscarPorFilmeId(filmeId);
        return ResponseEntity.ok(cinematografias);
    }

    @PostMapping
    public ResponseEntity<Cinematografia> criarCinematografia(@RequestBody Cinematografia cinematografia) {
        Cinematografia cinematografiaCriada = cinematografiaService.criarCinematografia(cinematografia);
        return ResponseEntity.ok(cinematografiaCriada);
    }
}