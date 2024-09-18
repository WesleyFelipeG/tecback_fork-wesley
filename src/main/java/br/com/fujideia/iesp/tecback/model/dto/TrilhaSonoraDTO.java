package br.com.fujideia.iesp.tecback.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrilhaSonoraDTO {
    private Long id;
    private String compositor;
    private Long filmeId;
    private List<String> faixas;
    private List<Integer> duracoes;
}