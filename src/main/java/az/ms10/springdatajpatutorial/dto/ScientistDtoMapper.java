package az.ms10.springdatajpatutorial.dto;

import az.ms10.springdatajpatutorial.domain.Scientist;

public class ScientistDtoMapper {

    public static ScientistDto to(Scientist ent){

        ScientistDto dto = new ScientistDto();
        dto.setId(ent.getId());
        dto.setName(ent.getName());
        dto.setSurname(ent.getSurname());
        dto.setAge(ent.getAge());

        return dto;
    }

    public static Scientist to(ScientistDto dto){

        Scientist ent = new Scientist();
        ent.setId(dto.getId());
        ent.setName(dto.getName());
        ent.setSurname(dto.getSurname());
        ent.setAge(dto.getAge());

        return ent;
    }

}
