package ru.specialist.demo;

import java.util.Hashtable;
import java.util.Map;

public class Repository {
	static Map<String, Person> persons = new Hashtable<>();
	
	static {
		persons.put("Сергей", new Person("Сергей", 35));
		persons.put("Костя", new Person("Костя", 13));
		persons.put("Саша", new Person("Саша", 9));
	}
	
	public Person personByName(String name) {
		return persons.get(name);
	}
	
	public Person addPesrson(Person p) {
		persons.put(p.getName(),p);
		return p;
	}
}
