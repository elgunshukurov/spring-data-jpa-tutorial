package az.ms10.springdatajpatutorial.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@ToString
public class Scientist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String name;
    private String surname;
    private int age;

}
