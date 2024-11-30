package controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import model.User;


@RestController
@CrossOrigin
public class UserController {
	@GetMapping("/")
	public List<User> getData(){
		return(1,"name", "jgdhh","jjgj");
	}
}
