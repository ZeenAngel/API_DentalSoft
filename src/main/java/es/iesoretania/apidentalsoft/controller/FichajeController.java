package es.iesoretania.apidentalsoft.controller;

import es.iesoretania.apidentalsoft.model.Fichaje;
import es.iesoretania.apidentalsoft.service.FichajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RestController
// URL Donde se redirigen las peticiones a la API. Tengo que cambiar la URL api.fichar por la que utilice el servidor
@RequestMapping(value = "api")
public class FichajeController {

    @Autowired
    private FichajeService servicio;

    // Petición GET a la url para ver si ha fichado por la mañana
    @GetMapping(value = "/fichadodia")
    public ResponseEntity<String> getFichadoDia(){
        // Tengo que comprobar si el usuario ha fichado por la mañana y entonces devolver True o False
        return ResponseEntity.status(HttpStatus.OK).body("Petición GET funcionando");
    }

    @PostMapping(value = "/fichadotarde")
    public ResponseEntity<String> postFichadoTarde(){
        // Tengo que comprobar si el usuario ha fichado por la tarde y entonces devolver True o False
        return ResponseEntity.status(HttpStatus.OK).body("Petición POST funcionando");
    }

    @PostMapping(value = "/fichar")
    public ResponseEntity<Fichaje> ficharEmpleado(@RequestParam Map<String, String> empleado){
        Fichaje nuevoFichaje = new Fichaje(empleado.get("empleado"));
        Date fecha = Date.valueOf(LocalDate.now());
        Time hora = Time.valueOf(LocalTime.now());
        nuevoFichaje.setFecha(fecha);
        nuevoFichaje.setHora(hora);
        return ResponseEntity.status(HttpStatus.OK).body(servicio.fichar(nuevoFichaje));
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<Fichaje>> listarFichajes(){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.listadoFichajes());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Fichaje> getFichajeById(@PathVariable Integer id){
        Fichaje fichaje = servicio.getById(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(fichaje);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> borrarFichaje(@PathVariable Integer id){
        if(servicio.borrarFichajeById(id))
            return ResponseEntity.status(HttpStatus.OK).body("Fichaje eliminado correctamente");
        else
            return ResponseEntity.status(HttpStatus.OK).body("No se ha podido eliminar el fichaje");
    }
}
