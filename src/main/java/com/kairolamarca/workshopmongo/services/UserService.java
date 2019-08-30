package com.kairolamarca.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kairolamarca.workshopmongo.domain.User;
import com.kairolamarca.workshopmongo.repository.UserRepository;
import com.kairolamarca.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		/*User user = repo.findOne(id);
		if(user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}*/
		
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
	}
	
}
