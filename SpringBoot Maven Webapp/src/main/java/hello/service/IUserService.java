package hello.service;

import hello.model.User;

public interface IUserService {

	public User getUserByName(String username) throws Exception;
}
