
package ec.com.learning.client.web;

import ec.com.learning.client.dao.PersonDao;
import ec.com.learning.client.domain.Person;
import ec.com.learning.client.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class InitController {
    
    @Autowired
    private PersonService personService;
    
    @GetMapping("/")
    public String init(Model model){
        var people = personService.getAllPeople();
        log.info("Executing Spring MVC controller");
        model.addAttribute("people", people);
        return "index";
    }
    
    @GetMapping("/add")
    public String add(Person person){
        return "edit";
    }
    
    @PostMapping("/save")
    public String save(Person person){
        personService.save(person);
        return "redirect:/";
    }
    
    @GetMapping("/edit/{idPerson}")
    public String edit(Person person, Model model){
        person = personService.findPerson(person);
        model.addAttribute("person", person);
        return "edit";
    }
    
    @GetMapping("/delete")
    public String delete(Person person){
        personService.delete(person);
        return "redirect:/";
    }
}
