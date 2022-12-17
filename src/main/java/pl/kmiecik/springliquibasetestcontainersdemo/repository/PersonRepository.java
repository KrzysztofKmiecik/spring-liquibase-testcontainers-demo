package pl.kmiecik.springliquibasetestcontainersdemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.kmiecik.springliquibasetestcontainersdemo.repository.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity,Long> {

}

