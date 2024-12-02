package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Personagem;
import br.com.fujideia.iesp.tecback.model.dto.PersonagemDTO;
import br.com.fujideia.iesp.tecback.repository.PersonagemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonagemService {

    private final PersonagemRepository personagemRepository;

    public List<PersonagemDTO> listarTodos() {
        return personagemRepository.findAll()
                .stream()
                .map(personagem -> new PersonagemDTO(personagem.getId(), personagem.getNome(), personagem.getDescricao()))
                .collect(Collectors.toList());
    }

    public Optional<PersonagemDTO> buscarPorId(Long id) {
        return personagemRepository.findById(id)
                .map(personagem -> new PersonagemDTO(personagem.getId(), personagem.getNome(), personagem.getDescricao()));
    }

    public PersonagemDTO criarPersonagem(PersonagemDTO personagemDTO) {
        Personagem personagem = new Personagem();
        personagem.setNome(personagemDTO.getNome());
        personagem.setDescricao(personagemDTO.getDescricao());
        personagem = personagemRepository.save(personagem);
        return new PersonagemDTO(personagem.getId(), personagem.getNome(), personagem.getDescricao());
    }

    public Optional<PersonagemDTO> atualizarPersonagem(Long id, PersonagemDTO personagemDTO) {
        return personagemRepository.findById(id).map(personagem -> {
            personagem.setNome(personagemDTO.getNome());
            personagem.setDescricao(personagemDTO.getDescricao());
            personagem = personagemRepository.save(personagem);
            return new PersonagemDTO(personagem.getId(), personagem.getNome(), personagem.getDescricao());
        });
    }

    public boolean deletarPersonagem(Long id) {
        if (personagemRepository.existsById(id)) {
            personagemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
