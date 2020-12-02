package ufc.setic.apirest.dto;

import lombok.Data;

@Data
public class CriarFilmeRequest {

  private String nome;

  private Integer anoLancamento;

  private String autor;

  private Float imdb;

  private String genero;
}
