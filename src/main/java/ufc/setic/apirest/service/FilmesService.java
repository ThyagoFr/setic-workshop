package ufc.setic.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ufc.setic.apirest.dto.CriarFilmeRequest;
import ufc.setic.apirest.exceptions.ResourceBadRequestException;
import ufc.setic.apirest.exceptions.ResourceNotFoundException;
import ufc.setic.apirest.model.FilmesModel;
import ufc.setic.apirest.repository.FilmesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FilmesService {

  @Autowired
  private FilmesRepository filmesRepository;

  public Page<FilmesModel> buscarFilmes(PageRequest page) {
    return filmesRepository.findAll(page);
  }

  public FilmesModel buscarFilme(Long id){
    Optional<FilmesModel> filme = filmesRepository.findById(id);
    if(filme.isPresent()) {
      return filme.get();
    }
    throw new ResourceNotFoundException("Filme nao encontrado");
  }

  public void criarFilme(CriarFilmeRequest request) {
    FilmesModel model1 = buscarFilmePorNome(request.getNome());
    if(model1 != null ) {
      throw new ResourceBadRequestException("Filme ja cadastrado");
    }
    FilmesModel model = new FilmesModel();
    model.setNome(request.getNome());
    model.setImdb(request.getImdb());
    model.setGenero(request.getGenero());
    model.setAutor(request.getAutor());
    model.setAnoLancamento(request.getAnoLancamento());
    filmesRepository.save(model);
  }

  public void removerFilme(Long id) {
    FilmesModel filme = buscarFilme(id);
    filmesRepository.delete(filme);
  }

  public void atualizarFilme(Long id, CriarFilmeRequest request) {
    FilmesModel model = buscarFilme(id);
    model.setNome(request.getNome());
    model.setImdb(request.getImdb());
    model.setGenero(request.getGenero());
    model.setAutor(request.getAutor());
    model.setAnoLancamento(request.getAnoLancamento());
    filmesRepository.save(model);
  }

  private FilmesModel buscarFilmePorNome(String nome) {
    return filmesRepository.findByNome(nome);
  }



}
