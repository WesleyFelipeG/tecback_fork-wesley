package br.com.fujideia.iesp.tecback.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutorDTO {
    private Long id;
    private String nome;
    private int idade;
    private String nacionalidade;
    private List<FilmeDTO> filmesProduzidos;
}