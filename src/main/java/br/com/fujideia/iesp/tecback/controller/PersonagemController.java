package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.dto.PersonagemDTO;
import br.com.fujideia.iesp.tecback.service.PersonagemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personagens")
@RequiredArgsConstructor
public class PersonagemController {

    private final PersonagemService personagemService;

    @GetMapping
    public ResponseEntity<List<PersonagemDTO>> listarTodos() {
        List<PersonagemDTO> personagens = personagemService.listarTodos();
        return new ResponseEntity<>(personagens, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonagemDTO> buscarPorId(@PathVariable Long id) {
        Optional<PersonagemDTO> personagem = personagemService.buscarPorId(id);
        return personagem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PersonagemDTO> criarPersonagem(@RequestBody PersonagemDTO personagemDTO) {
        PersonagemDTO novoPersonagem = personagemService.criarPersonagem(personagemDTO);
        return new ResponseEntity<>(novoPersonagem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonagemDTO> atualizarPersonagem(@PathVariable Long id, @RequestBody PersonagemDTO personagemDTO) {
        Optional<PersonagemDTO> personagemAtualizado = personagemService.atualizarPersonagem(id, personagemDTO);
        return personagemAtualizado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPersonagem(@PathVariable Long id) {
        boolean deletado = personagemService.deletarPersonagem(id);
        return deletado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
