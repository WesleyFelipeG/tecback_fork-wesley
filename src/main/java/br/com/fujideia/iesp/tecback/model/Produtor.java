package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Produtor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;
    private String nacionalidade;

    @ManyToMany
    @JoinTable(
            name = "produtor_filme",
            joinColumns = @JoinColumn(name = "produtor_id"),
            inverseJoinColumns = @JoinColumn(name = "filme_id")
    )
    private List<Filme> filmesProduzidos = new ArrayList<>();

    public void adicionarFilme(Filme filme) {
        this.filmesProduzidos.add(filme);
    }

    public List<String> listarFilmes() {
        List<String> titulos = new ArrayList<>();
        for (Filme filme : filmesProduzidos) {
            titulos.add(filme.getTitulo());
        }
        return titulos;
    }
}

