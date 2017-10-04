package searchspring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	
	
	
	@Autowired
	PersonRepository personRepository;
	
	public List<Person> getAllPersons(){
		ArrayList<Person> persons = new ArrayList<Person>();
		personRepository.findAll().forEach(persons::add);
		return persons;
	}
	
	public Person findPerson(String name) {
		return personRepository.findOne(name);
	}

	public void addPerson(Person person) {
		personRepository.save(person);
	}

	public void deletePerson(String name) {
		personRepository.delete(name);
	}
}
