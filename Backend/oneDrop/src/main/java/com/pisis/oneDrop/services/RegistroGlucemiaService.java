package com.pisis.oneDrop.services;

import com.pisis.oneDrop.exceptions.customsExceptions.NotFoundException;
import com.pisis.oneDrop.model.dtos.RegistrosPaginadosReadDtoArray;
import com.pisis.oneDrop.model.dtos.fichaMedica.FichaMedicaReadDto;
import com.pisis.oneDrop.model.dtos.registros.RegistroAddDto;
import com.pisis.oneDrop.model.dtos.registros.RegistroReadDto;
import com.pisis.oneDrop.model.dtos.registros.RegistroUpdateDto;
import com.pisis.oneDrop.model.entities.FichaMedica;
import com.pisis.oneDrop.model.entities.RegistroGlucemia;
import com.pisis.oneDrop.model.mappers.RegistroGlucemiaMapper;
import com.pisis.oneDrop.model.repositories.RegistroGlucemiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistroGlucemiaService {
    @Autowired
    RegistroGlucemiaRepository registroGlucemiaRepository;

    @Autowired
    RegistroGlucemiaMapper registroGlucemiaMapper;

    @Autowired
    FichaMedicaService fichaMedicaService;

    // TODO validar datos de ficha medica
    public RegistroReadDto addRegistro (Integer id, RegistroAddDto registroGlucemiaAddDto){
        FichaMedica fichaMedicaDeUsuario = fichaMedicaService.getFichaMedicaById(id);
        // TODO validar datos de ficha medica
        // TODO validar datos de ficha medica
        RegistroGlucemia nuevoReg = registroGlucemiaMapper.toEntity(registroGlucemiaAddDto);
        RegistroGlucemia regGuardado = registroGlucemiaRepository.save(nuevoReg);
        fichaMedicaDeUsuario.getRegistros_glucemia().add(regGuardado);
        fichaMedicaService.fichaMedicaRepository.save(fichaMedicaDeUsuario);
        return registroGlucemiaMapper.toReadDto(regGuardado);
    }


    public RegistrosPaginadosReadDtoArray findAllRegistrosByIdUser(Integer id, Integer page, Integer size ){
        Page<RegistroGlucemia> results;
        Pageable pageable = PageRequest.of(page, size);
        results = registroGlucemiaRepository.findAllRegistrosByIdUser(id, pageable);
        Page pagedResults = results.map(entity -> registroGlucemiaMapper.toReadDto(entity));
        return RegistrosPaginadosReadDtoArray.builder()
                .registros(pagedResults.getContent())
                .total_results(pagedResults.getTotalElements())
                .results_per_page(size)
                .current_page(page)
                .pages(pagedResults.getTotalPages())
                .sort_by("sortBy")
                .build();
    }

    public RegistroReadDto findById (Integer id){
        return registroGlucemiaMapper.toReadDto(getRegistroById(id));
    }
    public RegistroGlucemia getRegistroById (Integer id){
        Optional<RegistroGlucemia> reg = registroGlucemiaRepository.findById(id);
        if(reg.isEmpty()) throw new NotFoundException("Registro no encontrado por id: "+id);
        return reg.get();
    }

    public RegistroReadDto deleteRegistroById (Integer id){
        RegistroGlucemia regABorrar = getRegistroById(id);
        fichaMedicaService.deleteRegistroById(regABorrar);
        registroGlucemiaRepository.deleteById(id);
        return registroGlucemiaMapper.toReadDto(regABorrar);
    }

    // todo VALIDAR DATO DE ACTUALIZACION
    public RegistroReadDto editRegistroGlucemia(Integer id, RegistroUpdateDto registroGlucemiaUpdateDto){
        Optional<RegistroGlucemia> registro = registroGlucemiaRepository.findById(id);
        if (registro.isEmpty()){
            throw new NotFoundException("NO SE ENCONTRO REGISTRO CON EL ID "+id);
        }
        RegistroGlucemia regAEditar = registro.get();
        if(registroGlucemiaUpdateDto.getFecha() != null){
            regAEditar.setFecha(registroGlucemiaUpdateDto.getFecha());
        }
        if(registroGlucemiaUpdateDto.getValor() != null){
            regAEditar.setValor(registroGlucemiaUpdateDto.getValor());
        }
        if(registroGlucemiaUpdateDto.getComentario() != null){
            regAEditar.setComentario(registroGlucemiaUpdateDto.getComentario());
        }
        return registroGlucemiaMapper.toReadDto(registroGlucemiaRepository.save(regAEditar));
    }

}
