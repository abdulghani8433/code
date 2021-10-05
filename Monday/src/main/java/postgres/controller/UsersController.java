package postgres.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import postgres.model.Users;
import postgres.service.UsersService;

@RestController
@RequestMapping(path="/Users")
public class UsersController {
	
	
	@Autowired
	private UsersService usersService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	@GetMapping
	public List<Users> getUsers(){
		return usersService.getUsers();
	}
	
	@PostMapping
	public Users addNewUser(@Valid @RequestBody Users users){
	return usersService.addNewUser(users);
}
	@DeleteMapping(path="{username}")
    public void deleteUsers(@PathVariable("username")Long id) {
     usersService.deleteUsers(id);	
	
	}
	@GetMapping(path="{username}")
	public Optional<Users> getById(@PathVariable("username")Long id){
		return usersService.getById(id);
	}
	
	@PutMapping(path= "{/id}")
	public List<Users> updateUser(@RequestBody List<Users> users){
	return usersService.updateUser(users);
}
//	public Login(Users users) get()

}















