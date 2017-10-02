package searchspring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping("/persons")
	public List<Person> search() {
		return personService.getAllPersons();
	}
	
	@RequestMapping("/persons/{name}")
	public Person findPerson(@PathVariable String name){
		return personService.findPerson(name);
	}
	@RequestMapping(method=RequestMethod.POST,value="/persons")
	public void addPerson(@RequestBody Person person) {
		personService.addPerson(person);
	}
	
}
