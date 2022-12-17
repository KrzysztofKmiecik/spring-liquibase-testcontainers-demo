package pl.kmiecik.springliquibasetestcontainersdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.kmiecik.springliquibasetestcontainersdemo.model.PersonDTO;
import pl.kmiecik.springliquibasetestcontainersdemo.model.PersonService;
import pl.kmiecik.springliquibasetestcontainersdemo.model.Person;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")

    public ResponseEntity<List<PersonDTO>> getAll(){
        List<Person> personList = personService.getAll();
        List<PersonDTO> personDTOS = mapToDTO(personList);
        return ResponseEntity.ok(personDTOS);
    }

    private static List<PersonDTO> mapToDTO(List<Person> personList) {
        List<PersonDTO> personDTOS=new ArrayList<>();
        personList.forEach(p->{
            PersonDTO personDTO=new PersonDTO();
            personDTO.setId(p.getId());
            personDTO.setFirstName(p.getFirstName());
            personDTOS.add(personDTO);
        });
        return personDTOS;
    }
}

