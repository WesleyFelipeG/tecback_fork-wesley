package br.com.fujideia.iesp.tecback.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinematografiaDTO {
    private Long id;
    private String diretorDeFotografia;
    private String estilo;
    private Long filmeId;
    private List<String> premios;
}