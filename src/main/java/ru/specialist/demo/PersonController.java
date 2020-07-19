package ru.specialist.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //Контроллер, который будет использован для REST Full Service	 

public class PersonController {
	
	Repository rep = new Repository();
	
	//@RequestMapping("/person") //Адрес url будет задаваться по этой аннотации,
	@GetMapping("/person") //Показать записи/объект
	//person - адрес по которому должен поступить запрос
	public Person person(@RequestParam(value = "name", required =true) String name) {
		return rep.personByName(name);		
	}
	
	@PostMapping("/person") //Вызов производится аннотацией @PostMapping - добавление
	public Person personUpdate(
			@RequestParam(value="name", required = true) String name, 
			@RequestParam(value="age", required = true) int age) {
			Person p = rep.personByName(name);
			if(p!= null) {
				p.setAge(age);
				return p;
			}else
				return rep.addPesrson(new Person(name,age));
			}	
}


