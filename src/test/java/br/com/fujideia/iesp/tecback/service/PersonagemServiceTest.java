package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Personagem;
import br.com.fujideia.iesp.tecback.model.dto.PersonagemDTO;
import br.com.fujideia.iesp.tecback.repository.PersonagemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonagemServiceTest {

    @InjectMocks
    private PersonagemService personagemService;

    @Mock
    private PersonagemRepository personagemRepository;

    private Personagem personagem;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        personagem = new Personagem(1L, "Batman", "Um herói que se veste de morcego");
    }

    @Test
    void testBuscarPorId_Encontrado() {
        when(personagemRepository.findById(1L)).thenReturn(Optional.of(personagem));

        Optional<PersonagemDTO> resultado = personagemService.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Batman", resultado.get().getNome());
        assertEquals("Um herói que se veste de morcego", resultado.get().getDescricao());

        verify(personagemRepository, times(1)).findById(1L);
    }

    @Test
    void testBuscarPorId_NaoEncontrado() {
        when(personagemRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<PersonagemDTO> resultado = personagemService.buscarPorId(1L);

        assertFalse(resultado.isPresent());

        verify(personagemRepository, times(1)).findById(1L);
    }
}
