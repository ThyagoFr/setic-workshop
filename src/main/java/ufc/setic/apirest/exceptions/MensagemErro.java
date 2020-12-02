package ufc.setic.apirest.exceptions;

import lombok.Data;

@Data
public class MensagemErro {

  private String data;

  private String mensagem;

  private Integer status;
}
