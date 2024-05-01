package com.uis.MediConnect.Controller;

import com.uis.MediConnect.Model.Cita;
import com.uis.MediConnect.Service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cita")
public class CitaController {

    private final CitaService citaService;

    @Autowired
    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }


    @PostMapping("/ingresar")
    ResponseEntity<Cita> guardarCita(@RequestBody Cita cita){
        if(cita != null){
            citaService.guardarCita(cita);
            return new ResponseEntity<>(cita, HttpStatus.OK);
        }
        return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/buscar/{idCita}")
    ResponseEntity<Cita> buscarCita(@PathVariable String idCita){
        Cita cita = citaService.buscarCita(idCita);
        if(cita != null){
            return new ResponseEntity<>(cita, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/buscar")
    ResponseEntity<List<Cita>> buscarTodasCitas(){
        return new ResponseEntity<>(citaService.buscarTodasCitas(), HttpStatus.OK);
    }

    @PutMapping("/editar")
    ResponseEntity<Cita> editarCita(@RequestBody Cita cita){
        Cita citaEditada = citaService.editarCita(cita);
        if(citaEditada != null ){
            return new ResponseEntity<>(citaEditada, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/eliminar/{idCita}")
    ResponseEntity<Cita> eliminarCita(@PathVariable String idCita){
        Cita cita = citaService.eliminarCita(idCita);
        if(cita != null){
            return new ResponseEntity<>(cita, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
