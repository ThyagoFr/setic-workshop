package ufc.setic.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufc.setic.apirest.dto.CriarFilmeRequest;
import ufc.setic.apirest.model.FilmesModel;
import ufc.setic.apirest.service.FilmesService;

@RestController
@RequestMapping("/api/v1/filmes")
public class FilmesController {

  @Autowired
  private FilmesService filmesService;

  @GetMapping
  public ResponseEntity<Page<FilmesModel>> buscarFilmes(
      @RequestParam(value = "tamanho", defaultValue = "10", required = false) int tamanho,
      @RequestParam(value = "pagina", defaultValue = "0", required = false) int pagina
  ) {
    PageRequest page = PageRequest.of(pagina, tamanho);
    Page<FilmesModel> filmes = filmesService.buscarFilmes(page);
    return ResponseEntity.ok(filmes);
  }

  @GetMapping(
      value = "/{id}"
  )
  public ResponseEntity<FilmesModel> buscarFilme(@PathVariable("id") Long id) {
    FilmesModel filme = filmesService.buscarFilme(id);
    return ResponseEntity.ok(filme);
  }

  @PostMapping
  public ResponseEntity<?> criarFilme(@RequestBody CriarFilmeRequest request) {
    filmesService.criarFilme(request);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(
      value = "/{id}"
  )
  public ResponseEntity<?> removerFilme(@PathVariable("id") Long id) {
    filmesService.removerFilme(id);
    return ResponseEntity.accepted().build();
  }

  @PutMapping(
      value = "/{id}"
  )
  public ResponseEntity<?> atualizarFilme(
      @PathVariable("id") Long id,
      @RequestBody CriarFilmeRequest request
  ) {
    filmesService.atualizarFilme(id, request);
    return ResponseEntity.accepted().build();
  }

}
