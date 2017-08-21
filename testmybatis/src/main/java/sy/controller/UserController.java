package sy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sy.model.User;
import sy.service.UserServiceI;

@Controller
@RequestMapping("/userController")
public class UserController {

    private UserServiceI userService;

    public UserServiceI getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserServiceI userService) {
        this.userService = userService;
    }

    @RequestMapping("/test")
    public String test(HttpServletRequest request) {
        System.out.println(111);
        return "showUser";
    }

    @RequestMapping("/{id}/showUser")
    public String showUser(@PathVariable String id, HttpServletRequest request) {
        User u = userService.getUserById(id);
        request.setAttribute("user", u);
        List<User> list = userService.getAll();
        System.out.println(list.size());
        return "showUser";
    }

}
