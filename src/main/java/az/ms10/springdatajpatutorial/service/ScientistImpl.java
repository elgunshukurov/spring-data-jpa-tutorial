package az.ms10.springdatajpatutorial.service;

import az.ms10.springdatajpatutorial.domain.Scientist;
import az.ms10.springdatajpatutorial.dto.ScientistDto;
//import az.ms10.springdatajpatutorial.mapper.ScientistMapper;
import az.ms10.springdatajpatutorial.dto.ScientistDtoMapper;
import az.ms10.springdatajpatutorial.exception.NonexistentIdException;
import az.ms10.springdatajpatutorial.mapper.ScientistMapper;
import az.ms10.springdatajpatutorial.repository.ScientistRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScientistImpl  implements ScientistService{
    private final ScientistRepo scientistRepo;
//    private final ScientistMapper mapper;

    @Override
    public List<ScientistDto> getScientists() {
        return ScientistMapper.INSTANCE.toDto(scientistRepo.findAll());
    }


//    public List<ScientistDto> getScientists() {
//        List<ScientistDto> dtoList = new ArrayList<>();
//        scientistRepo.findAll().forEach(it -> dtoList.add(ScientistDtoMapper.to(it)));
//        return dtoList;
//    }

    @Override
    public List<ScientistDto> getScientistByParams(String name, String surname, int age) {
        return ScientistMapper.INSTANCE.toDto(scientistRepo.findByNameOrSurnameOrAge(name, surname, age));
    }


//    public List<ScientistDto> getScientistByParams(String name, String surname, int age) {
//        List<ScientistDto> dtoList = new ArrayList<>();
//        scientistRepo.findByNameOrSurnameOrAge(name, surname, age).forEach(it -> dtoList.add(ScientistDtoMapper.to(it)));
//
//        return dtoList;
//    }

    @Override
    public ScientistDto saveScientist(ScientistDto dto) {
        return ScientistMapper.INSTANCE.toDto(scientistRepo.save(ScientistMapper.INSTANCE.toEntity(dto)));
    }

//    @Override
//    public ScientistDto saveScientist(ScientistDto dto) {
//        return ScientistDtoMapper.to(scientistRepo.save(ScientistDtoMapper.to(dto)));
//    }

    @Override
    public ScientistDto updateScientist(int id, ScientistDto dto) {
        if(scientistRepo.existsById(id)){
            return ScientistMapper.INSTANCE.toDto(scientistRepo.save(ScientistMapper.INSTANCE.toEntity(dto)));

        } else {
            throw new NonexistentIdException();
        }

    }

    @Override
    public void deleteScientist(int id) {
        if(scientistRepo.existsById(id)){
            scientistRepo.deleteById(id);
        } else {
            throw new NonexistentIdException();
        }
    }
//    @Override
//    public ScientistDto saveScientist(ScientistDto dto) {
//        scientistRepo.save(mapper.toEntity(dto));
//        return dto;
//    }
}
