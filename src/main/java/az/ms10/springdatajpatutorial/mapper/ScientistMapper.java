package az.ms10.springdatajpatutorial.mapper;

import az.ms10.springdatajpatutorial.dto.ScientistDto;
import az.ms10.springdatajpatutorial.domain.Scientist;
import java.time.LocalDate;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScientistMapper {

    ScientistMapper INSTANCE = Mappers.getMapper(ScientistMapper.class);;

//    @Mappings(
//            value = {
//                    @Mapping(source = "name", target = "name"),
//                    @Mapping(source = "surname", target = "surname"),
//                    @Mapping(source = "age", target = "age")
//            }
//    )
    Scientist toEntity(ScientistDto source);

    ScientistDto toDto(Scientist source);

    List<ScientistDto> toDto(List<Scientist> employees);

}