/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.com.learning.client.service;

import ec.com.learning.client.domain.Person;
import java.util.List;

/**
 *
 * @author Steven
 */
public interface PersonService {
    
    public List<Person> getAllPeople();
    
    public void save(Person person);
    
    public void delete(Person person);
    
    public Person findPerson(Person person);
    
}
