package com.sofia.springCourse.dao;

import com.sofia.springCourse.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Sofia"));
        people.add(new Person(++PEOPLE_COUNT,"Viktoria"));
        people.add(new Person(++PEOPLE_COUNT,"Vitaliy"));
        people.add(new Person(++PEOPLE_COUNT,"Anna"));
        people.add(new Person(++PEOPLE_COUNT,"Katya"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
