package az.ms10.springdatajpatutorial.service;

import az.ms10.springdatajpatutorial.dto.ScientistDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ScientistService {
    public List<ScientistDto> getScientists();

    public List<ScientistDto> getScientistByParams(String name, String surname, int age);

    ScientistDto saveScientist(ScientistDto dto);

    ScientistDto updateScientist(int id, ScientistDto dto);

    public void deleteScientist(int id);
}
