package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Personagem;
import br.com.fujideia.iesp.tecback.model.dto.PersonagemDTO;
import br.com.fujideia.iesp.tecback.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    public Optional<PersonagemDTO> buscarPorId(Long id) {
        Optional<Personagem> personagem = personagemRepository.findById(id);
        if (personagem.isPresent()) {
            PersonagemDTO personagemDTO = new PersonagemDTO(
                    personagem.get().getId(),
                    personagem.get().getNome(),
                    personagem.get().getDescricao()
            );
            return Optional.of(personagemDTO);
        }
        return Optional.empty();
    }
}
