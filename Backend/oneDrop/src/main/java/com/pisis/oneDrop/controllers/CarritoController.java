package com.pisis.oneDrop.controllers;

import com.pisis.oneDrop.model.dtos.RegistrosPaginadosReadDtoArray;
import com.pisis.oneDrop.model.dtos.carrito.CarritoReadDto;
import com.pisis.oneDrop.model.dtos.resumenCompra.ResumenCompraReadDto;
import com.pisis.oneDrop.model.dtos.servicios.ServicioAddDto;
import com.pisis.oneDrop.model.dtos.servicios.ServicioReadDto;
import com.pisis.oneDrop.model.dtos.servicios.ServicioUpdateDto;
import com.pisis.oneDrop.model.entities.ResumenCompra;
import com.pisis.oneDrop.model.entities.enums.MetodoDePago;
import com.pisis.oneDrop.services.CarritoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/carrito/", produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("isAuthenticated()")
public class CarritoController {
    @Autowired
    CarritoService carritoService;

    /*
    @GetMapping()
    public ResponseEntity<RegistrosPaginadosReadDtoArray> findAll (@RequestParam(required = false, defaultValue = "0") Integer page,
                                                                   @RequestParam(required = false, defaultValue = "10") Integer size,
                                                                   @RequestParam(required = false, defaultValue = "paciente") String sortBy){
        return new ResponseEntity<>(carritoService.findAll(page, size, sortBy), HttpStatus.OK);
    }
     */
    // crear un carrito para un usuario, lo crea vacio y por unica vez!
    @PostMapping("{idUser}")
    public ResponseEntity<CarritoReadDto> addCarrito (@PathVariable Integer idUser){
        return new ResponseEntity<>(carritoService.createCarrito(idUser) , HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<CarritoReadDto> findById (@PathVariable Integer id){
        return new ResponseEntity<>(carritoService.findById(id) , HttpStatus.OK);
    }
    @GetMapping("user/{id}")
    public ResponseEntity<CarritoReadDto> findByIdUser (@PathVariable Integer id){
        return new ResponseEntity<>(carritoService.findByIdUser(id) , HttpStatus.OK);
    }
    // agregar servicios
    @PostMapping("{idCarrito}/{idServicio}")
    public ResponseEntity<CarritoReadDto> addServicioACarrito (@PathVariable Integer idCarrito,
                                                               @PathVariable Integer idServicio){
        return new ResponseEntity<>(carritoService.addServicioACarrito(idCarrito,idServicio) , HttpStatus.ACCEPTED);
    }
    // quitar servicios
    @DeleteMapping("{idCarrito}/{idServicio}")
    public ResponseEntity<CarritoReadDto> removeServicioDeCarrito (@PathVariable Integer idCarrito,
                                                               @PathVariable Integer idServicio){
        return new ResponseEntity<>(carritoService.removeServicioDeCarrito(idCarrito,idServicio) , HttpStatus.ACCEPTED);
    }

    // comprar carrito
    @PutMapping("{idCarrito}")
    public ResponseEntity<ResumenCompraReadDto> comprarCarrito (@PathVariable Integer idCarrito,
                                                                @RequestParam (required = false) MetodoDePago metodoDePago){
        return new ResponseEntity<>(carritoService.comprarCarrito(idCarrito, metodoDePago) , HttpStatus.ACCEPTED);
    }


}
