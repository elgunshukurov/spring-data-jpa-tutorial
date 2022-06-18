package az.ms10.springdatajpatutorial.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
public class ScientistDto {
    private int id;
    private String name;
    private String surname;
    private int age;
}
