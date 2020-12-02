package ufc.setic.apirest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ufc.setic.apirest.model.FilmesModel;


@Repository
public interface FilmesRepository extends PagingAndSortingRepository<FilmesModel, Long> {

  FilmesModel findByNome(String nome);

  Page<FilmesModel> findAll(Pageable page);
}
