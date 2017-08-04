package hello.dao;

import javax.transaction.Transactional;

import hello.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Transactional
public interface UserRepository extends JpaRepository<User, Long>{

	User findUserByUsername(String username);
	
	@Query("select u from User u where u.username = ?")
	User getPasswordByName(String name);
	
	User findUserByAgeAndSex(int age,String sex);
	
	@Query("update User u set u.username = ? where u.age = ?")
	@Modifying
	void updateUserName(String username,int age);

}
