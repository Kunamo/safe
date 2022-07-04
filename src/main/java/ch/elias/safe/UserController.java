package ch.elias.safe;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Read Operation
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getUsers(Model model) {
        List<UserInfo> users=userService.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("userInfo", new UserInfo());
        return "users";
    }

    //Create Operation
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public String createUser(@ModelAttribute UserInfo userInfo) {
        userService.createUser(userInfo);
        return "redirect:/";
    }
}
