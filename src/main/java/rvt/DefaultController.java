package rvt; // ASK TEACHER

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DefaultController {
    
   @GetMapping(value = "/")
    ModelAndView index(@RequestParam HashMap<String, String> allParam) {
        ModelAndView modelAndView = new ModelAndView("index");
        CsvManager csvManager = new CsvManager(CsvManager.file);

        if(allParam.size() != 0)
            if(allParam.get("name") != "")
                csvManager.saveNewStudent(new Student(allParam.get("name"), allParam.get("surname"), allParam.get("email"), allParam.get("group")));

        ArrayList<Student> students = csvManager.getListFromFile();

        modelAndView.addObject("students", students);
        modelAndView.addObject("date", "19.12.23");
        return modelAndView;
    }
    
    @GetMapping(value = "/about")
    ModelAndView aboutUs(@RequestParam HashMap<String, String> allParam) {
        // String myName = "Nikitka";
        // int age = 12;

        // HashMap<String, String> cart = new HashMap<>();
        // cart.put("name", "Jhon");

        ModelAndView modelAndView = new ModelAndView("about");
        // modelAndView.addObject("name", myName);
        // modelAndView.addObject("age", age);
        // modelAndView.addObject("id", allParam.get("id"));

        return modelAndView;
    }
}
