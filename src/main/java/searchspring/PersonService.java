package searchspring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
	
	
	private List<Person> allPersons = new ArrayList<>(Arrays.asList(new Person("test"),new Person("test2")));
	
	public List<Person> getAllPersons(){
		return allPersons;
	}
	
	public Person findPerson(String name) {
		System.out.println("Name received::"+name);
		Person person = allPersons.stream().filter(t->t.getName().equals(name)).findFirst().get();
		System.out.println("Person :::"+person);
		return person;
	}

	public void addPerson(Person person) {
		allPersons.add(person);
	}

	public void deletePerson(String name) {
		allPersons.remove(allPersons.stream().filter(t -> t.getName().equals(name)).findAny().get());
		/*for(Person p : allPersons) {
			if(p.getName().equals(name)) {
				allPersons.remove(p);
				return;
			}
		}*/
	}
}
