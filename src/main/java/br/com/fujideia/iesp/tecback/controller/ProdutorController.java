package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Produtor;
import br.com.fujideia.iesp.tecback.service.ProdutorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtores")
@RequiredArgsConstructor
@Slf4j
public class ProdutorController {

    private final ProdutorService produtorService;

    @GetMapping
    public ResponseEntity<List<Produtor>> listarTodos() {
        log.info("Chamando listarTodos no ProdutorController");
        List<Produtor> produtores = produtorService.listarTodos();
        return ResponseEntity.ok(produtores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produtor> buscarPorId(@PathVariable Long id) {
        log.info("Chamando buscarPorId no ProdutorController com id: {}", id);
        Optional<Produtor> produtor = produtorService.buscarPorId(id);
        return produtor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar/{nome}")
    public ResponseEntity<Produtor> buscarPorNome(@PathVariable String nome) {
        log.info("Chamando buscarPorNome no ProdutorController com nome: {}", nome);
        Optional<Produtor> produtor = produtorService.buscarPorNome(nome);
        return produtor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Produtor> criarProdutor(@RequestBody Produtor produtor) {
        Produtor produtorCriado = produtorService.criarProdutor(produtor);
        return ResponseEntity.ok(produtorCriado);
    }
}