package ufc.setic.apirest.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "setic_filmes")
@Data
public class FilmesModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String nome;

  @NotBlank
  private String autor;

  @Column(name = "ano_lancamento")
  private Integer anoLancamento;

  @NotBlank
  private String genero;

  @NotNull
  private Float imdb;

}
