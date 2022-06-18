package az.ms10.springdatajpatutorial.controller;

import az.ms10.springdatajpatutorial.dto.ScientistDto;
import az.ms10.springdatajpatutorial.service.ScientistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/index")
public class ScientistController {
    private final ScientistService service;

    @GetMapping("/all")
    public List<ScientistDto> getInfo() {
        return service.getScientists();
    }

    @GetMapping
    public List<ScientistDto> getInfoByParams(
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String surname,
            @RequestParam(defaultValue = "0") int age) {

        return service.getScientistByParams(name, surname, age);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ScientistDto saveInfo(@RequestBody ScientistDto scientistDto) {
        log.info(scientistDto.toString());
        return service.saveScientist(scientistDto);
    }

    @PutMapping("/{id}")
    public ScientistDto updateInfo(@PathVariable int id,
                                   @RequestParam ScientistDto dto){
        return service.updateScientist(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInfo(@PathVariable int id){
        service.deleteScientist(id);
    }

}
