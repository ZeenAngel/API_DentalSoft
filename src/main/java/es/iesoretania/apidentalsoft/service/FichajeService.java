package es.iesoretania.apidentalsoft.service;

import es.iesoretania.apidentalsoft.model.Fichaje;
import es.iesoretania.apidentalsoft.repository.FichajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FichajeService {

    @Autowired
    private FichajeRepository repositorio;

    public Fichaje fichar(Fichaje fichaje){
        return repositorio.save(fichaje);
    }

    public List<Fichaje> listadoFichajes(){
        return (List<Fichaje>) repositorio.findAll();
    }

    public Optional<Fichaje> getById(Integer id){
        return repositorio.findById(id);
    }

    public boolean borrarFichajeById(Integer id){
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
