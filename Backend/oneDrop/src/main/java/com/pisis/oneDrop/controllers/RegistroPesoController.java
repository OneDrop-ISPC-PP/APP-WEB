package com.pisis.oneDrop.controllers;

import com.pisis.oneDrop.model.dtos.RegistrosPaginadosReadDtoArray;
import com.pisis.oneDrop.model.dtos.registros.RegistroAddDto;
import com.pisis.oneDrop.model.dtos.registros.RegistroReadDto;
import com.pisis.oneDrop.model.dtos.registros.RegistroUpdateDto;
import com.pisis.oneDrop.services.RegistroPesoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/registros/peso/", produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("isAuthenticated()") // TODO  AND (hasRole('ADMIN') OR esDueñoDelRecurso() )
public class RegistroPesoController {
    @Autowired
    RegistroPesoService registroPesoService;

    // todo DOCUMENTACION CON SWAGGER?
    @GetMapping("usuario/{id}")
    public ResponseEntity<RegistrosPaginadosReadDtoArray> findAllRegistrosByIdUser (@PathVariable Integer id,
                                                                                    @RequestParam(required = false, defaultValue = "0") Integer page,
                                                                                    @RequestParam(required = false, defaultValue = "100") Integer size){
        return new ResponseEntity<>(registroPesoService.findAllRegistrosByIdUser(id, page, size), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<RegistroReadDto> findRegistrobyId (@PathVariable Integer id){
        return new ResponseEntity<>(registroPesoService.findById(id) , HttpStatus.OK);
    }
    @PostMapping("usuario/{id}")
    public ResponseEntity<RegistroReadDto> addRegistro (@PathVariable Integer id, @Valid @RequestBody RegistroAddDto registroAddDto){
        return new ResponseEntity<>(registroPesoService.addRegistro(id, registroAddDto) , HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<RegistroReadDto> editRegistro (@PathVariable Integer id, @RequestBody RegistroUpdateDto registroUpdateDto){
        return new ResponseEntity<>(registroPesoService.editRegistro(id, registroUpdateDto) , HttpStatus.ACCEPTED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<RegistroReadDto> deleteRegistro (@PathVariable Integer id){
        return new ResponseEntity<>(registroPesoService.deleteRegistroById(id) , HttpStatus.ACCEPTED);
    }
}
