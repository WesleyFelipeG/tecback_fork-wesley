package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.dto.PersonagemDTO;
import br.com.fujideia.iesp.tecback.service.PersonagemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PersonagemController.class)
public class PersonagemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonagemService personagemService;

    @InjectMocks
    private PersonagemController personagemController;

    @Autowired
    private ObjectMapper objectMapper;

    private PersonagemDTO personagemDTO;

    @BeforeEach
    void setUp() {
        personagemDTO = new PersonagemDTO(1L, "Batman", "Um herói que se veste de morcego");
    }

    @Test
    void testListarTodos() throws Exception {
        when(personagemService.listarTodos()).thenReturn(List.of(personagemDTO));

        mockMvc.perform(get("/api/personagens"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nome").value("Batman"))
                .andExpect(jsonPath("$[0].descricao").value("Um herói que se veste de morcego"));
    }

    @Test
    void testBuscarPorId() throws Exception {
        when(personagemService.buscarPorId(1L)).thenReturn(Optional.of(personagemDTO));

        mockMvc.perform(get("/api/personagens/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("Batman"))
                .andExpect(jsonPath("$.descricao").value("Um herói que se veste de morcego"));
    }

    @Test
    void testCriarPersonagem() throws Exception {
        when(personagemService.criarPersonagem(any(PersonagemDTO.class))).thenReturn(personagemDTO);

        mockMvc.perform(post("/api/personagens")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personagemDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("Batman"))
                .andExpect(jsonPath("$.descricao").value("Um herói que se veste de morcego"));
    }

    @Test
    void testAtualizarPersonagem() throws Exception {
        when(personagemService.atualizarPersonagem(1L, personagemDTO)).thenReturn(Optional.of(personagemDTO));

        mockMvc.perform(put("/api/personagens/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personagemDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("Batman"))
                .andExpect(jsonPath("$.descricao").value("Um herói que se veste de morcego"));
    }

    @Test
    void testDeletarPersonagem() throws Exception {
        when(personagemService.deletarPersonagem(1L)).thenReturn(true);

        mockMvc.perform(delete("/api/personagens/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testDeletarPersonagemNotFound() throws Exception {
        when(personagemService.deletarPersonagem(1L)).thenReturn(false);

        mockMvc.perform(delete("/api/personagens/1"))
                .andExpect(status().isNotFound());
    }
}
