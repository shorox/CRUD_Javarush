package crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import crud.entity.User;
import crud.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    // Inject user service
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String listUsers(Model model, @RequestParam(value = "str", required = false, defaultValue = "") String str) {

        // Get users from the dao
        List<User> usersList;
        if (str.equals("") || (str == null)) {
            usersList = userService.getUsers();
        } else {
            usersList = userService.getUsers(str);
        }

        // Add users to the model
        model.addAttribute("users", usersList);

        return "list-users";
    }

    @GetMapping("showFormAdd")
    public String showFormAdd(Model model) {

        // Create model attribute to bind form data
        User user = new User();

        model.addAttribute("user", user);

        return "user-form";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {

        // Save the user
        userService.saveUser(user);

        return "redirect:/user/list";
    }

    @GetMapping("/showFormUpdate")
    public String showFormUpdate(@RequestParam("userId") int id, Model model) {

        // Get user from service
        User user = userService.getUser(id);

        // Set User as a model attribute to pre-populate the form update
        model.addAttribute("user", user);

        return "user-form";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") int id) {

        // Delete the user by id
        userService.deleteUser(id);

        return "redirect:/user/list";
    }
}
