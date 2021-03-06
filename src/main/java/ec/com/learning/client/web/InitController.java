
package ec.com.learning.client.web;

import ec.com.learning.client.domain.Person;
import ec.com.learning.client.service.PersonService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class InitController {
    
    @Autowired
    private PersonService personService;
    
    @GetMapping("/")
    public String init(Model model, @AuthenticationPrincipal User user){
        var people = personService.getAllPeople();
        log.info("Executing Spring MVC controller");
        log.info("Logged user: " + user);
        model.addAttribute("people", people);
        var totalBalance = 0D;
        for(var p: people){
            totalBalance += p.getBalance();
        }
        model.addAttribute("totalBalance", totalBalance);
        model.addAttribute("totalClients", people.size());
        return "index";
    }
    
    @GetMapping("/add")
    public String add(Person person){
        return "edit";
    }
    
    @PostMapping("/save")
    public String save(@Valid Person person, Errors errors){ //@Valid Person person and Errors errors allways have to be together
        if(errors.hasErrors()){
            return "edit";
        }
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
