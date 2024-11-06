package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.CartaoCredito;

import br.com.fujideia.iesp.tecback.service.CartaoCreditoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartoes")
@RequiredArgsConstructor
public class CartaoCreditoController {

    private final CartaoCreditoService cartaoCreditoService;

    @PostMapping
    public ResponseEntity<CartaoCredito> salvar(@RequestBody CartaoCredito cartaoCredito) {
        CartaoCredito cartaoCreditoSalvo = cartaoCreditoService.salvar(cartaoCredito);
        return ResponseEntity.ok(cartaoCreditoSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartaoCredito> buscarPorId(@PathVariable Long id) {
        Optional<CartaoCredito> cartaoCredito = cartaoCreditoService.buscarPorId(id);
        if (cartaoCredito.isPresent()) {
            return ResponseEntity.ok(cartaoCredito.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CartaoCredito>> listarTodos() {
         List<CartaoCredito> cartaoCredito = cartaoCreditoService.listarTodos();
         return ResponseEntity.ok(cartaoCredito);
    }

    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean deletado = cartaoCreditoService.deletar(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}