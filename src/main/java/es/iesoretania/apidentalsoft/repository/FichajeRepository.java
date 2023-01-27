package es.iesoretania.apidentalsoft.repository;

import es.iesoretania.apidentalsoft.model.Fichaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichajeRepository extends CrudRepository<Fichaje, Integer> {

}
