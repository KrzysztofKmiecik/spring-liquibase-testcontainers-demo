package pl.kmiecik.springliquibasetestcontainersdemo.model;

import org.springframework.stereotype.Service;
import pl.kmiecik.springliquibasetestcontainersdemo.model.Person;
import pl.kmiecik.springliquibasetestcontainersdemo.model.PersonService;

import pl.kmiecik.springliquibasetestcontainersdemo.repository.PersonEntity;
import pl.kmiecik.springliquibasetestcontainersdemo.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
@Service
class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAll() {
        List<Person> personList=new ArrayList<>();
        List<PersonEntity> entities = personRepository.findAll();
        entities.forEach(e->{
            Person person=new Person();
            person.setId(e.getId());
            person.setFirstName(e.getFirstName());
            personList.add(person);
        });
        return personList;
    }
}
