package com.hiteshjha.controller;



import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.hiteshjha.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class EmployeeController {

    private final List<Employee> employeeList = new ArrayList<>();
    private int employeeCounter = 1;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("employees", employeeList);
        return "home";
    }

    @GetMapping("/addEmployee")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }
    
    @GetMapping("/searchEmployee")
    public String searchEmployee(@RequestParam(value = "search", required = false) String search, Model model) {
        // Sample employee list for demonstration
        List<Employee> employeeList = this.employeeList;

        if (search != null && !search.isEmpty()) {
          
            employeeList = employeeList.stream()
                    .filter(emp -> emp.getName().toLowerCase().contains(search.toLowerCase()) ||
                                  emp.getDepartment().toLowerCase().contains(search.toLowerCase()))
                    .collect(Collectors.toList());
        }

       
        model.addAttribute("employees", employeeList);
        model.addAttribute("search", search); 

        return "search-employee"; // Return the view name
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@Valid @ModelAttribute Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	model.addAttribute("errorMessage", "There are errors in the form. Please correct them.");
            return "add-employee"; 
        }
        employee.setId(employeeCounter++);
        employeeList.add(employee);
        return "redirect:/";
    }

    @GetMapping("/updateEmployee/{id}")
    public String showUpdateEmployeeForm(@PathVariable int id, Model model) {
        Employee employee = employeeList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
        if (employee == null) {
            return "redirect:/";
        }
        model.addAttribute("employee", employee);
        return "update-employee";
    }

    @PostMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable int id, @Valid @ModelAttribute Employee updatedEmployee, BindingResult result) {
        if (result.hasErrors()) {
            return "update-employee";
        }
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                employeeList.set(i, updatedEmployee);
                updatedEmployee.setId(id);
                break;
            }
        }
        return "redirect:/";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeList.removeIf(employee -> employee.getId() == id);
        return "redirect:/";
    }
}
