package com.kairolamarca.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kairolamarca.workshopmongo.domain.User;
import com.kairolamarca.workshopmongo.dto.UserDTO;
import com.kairolamarca.workshopmongo.repository.UserRepository;
import com.kairolamarca.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		/*
		 * User user = repo.findOne(id); if(user == null) { throw new
		 * ObjectNotFoundException("Objeto não encontrado"); }
		 */

		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	public int soma(int n1, int n2) {
		return n1+n2;
	}

}
