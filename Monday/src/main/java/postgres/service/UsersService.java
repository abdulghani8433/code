package postgres.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import postgres.model.Users;
import postgres.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public List<Users> getUsers() {
		 return usersRepository.findAll();
		
		
	}


	public Users addNewUser(Users users) {
		String encodedPassword = bCryptPasswordEncoder.encode(users.getPassword());
		users.setPassword(encodedPassword);

		return usersRepository.save(users);
	}



	public void deleteUsers(Long id) {
	 Boolean exists=usersRepository.existsById(id);
	 if(!exists) {
		 System.out.println("employee doesnot exist"+id); 
	 }
	usersRepository.deleteById(id);
		 
	}


	public Optional<Users> getById(Long id) {
		return usersRepository.findById(id);
	}


	public List<Users> updateUser(List<Users> users) {
		return usersRepository.saveAll(users);
	}

//
//	public Optional<Users> login(String username, String password) {
//		return usersRepository.findById(username,password);
//	}


	}


