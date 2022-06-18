package az.ms10.springdatajpatutorial.repository;

import az.ms10.springdatajpatutorial.domain.Scientist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScientistRepo extends JpaRepository<Scientist, Integer> {

    public List<Scientist> findByNameOrSurnameOrAge(String name, String surname, int age);

}
