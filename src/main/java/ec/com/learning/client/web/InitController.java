
package ec.com.learning.client.web;

import ec.com.learning.client.dao.PersonDao;
import ec.com.learning.client.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
