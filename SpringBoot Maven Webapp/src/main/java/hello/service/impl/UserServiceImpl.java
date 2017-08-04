package hello.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.dao.UserRepository;
import hello.model.User;
import hello.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public User getUserByName(String username) throws Exception {
		return repository.findUserByUsername(username);
	}

}
