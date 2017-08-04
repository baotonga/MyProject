package hello.web;


import javax.servlet.http.HttpServletRequest;

import hello.dao.UserRepository;
import hello.model.User;
import hello.service.IUserService;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.classic.Logger;

@RestController
public class HelloController {
	
	private static Logger logger = (Logger) LoggerFactory.getLogger(HelloController.class); 
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private UserRepository repository;
	
	 @RequestMapping("/findbyname")
	 public String findbyname(@RequestParam(value = "username")String username) { 
		 try {
		        User user = userService.getUserByName(username);
		        //{}占位符对应后面的值 
		        logger.info("password:{},username:{}" , user.getPassword(),user.getUsername()); 
		        return user.getPassword();  
		} catch (Exception e) {
			logger.error("查询失败，原因：",e);
		}
		return "error";	
	} 
	 
	 
	 @RequestMapping("/userlogin")
	 public ModelAndView userlogin(HttpServletRequest request,@RequestParam(value = "username")String username,@RequestParam(value = "password")String password) { 
		 try {
		        User user = repository.findUserByUsername(username);
		        //{}占位符对应后面的值 
		        logger.info("username:{}" , user.getUsername());
		        if(user.getPassword().equals(password)){
		        	 request.getSession().setAttribute("user", user);
		        	 return new ModelAndView("login");  
		        }
		       
		} catch (Exception e) {
			logger.error("登录失败，原因：{}",e);
		}
		 return new ModelAndView("login");  
	}  
	 
	 
	 
	 @RequestMapping("/getPasswordByName")
	 public String getPasswordByName(@RequestParam(value = "username")String username) { 
		 try {
		        User user = repository.getPasswordByName(username); 
		        return "password:----"+user.getPassword();  
		} catch (Exception e) {
			logger.error("查询失败，原因：",e);
		}
		return "getPasswordByName";
	} 
	 
	 @RequestMapping("/findUserByAgeAndSex")
	 public String findUserByAgeAndSex(@RequestParam(value = "age")int age,@RequestParam(value = "sex")String sex) { 
		 try {
		        User user = repository.findUserByAgeAndSex(age,sex); 
		        return "password:----"+user.getUsername();  
		} catch (Exception e) {
			logger.error("查询失败，原因：",e);
		}
		return "findUserByAgeAndSex";
	}
	 
	 
	 @RequestMapping("/updateUserName")
	 public String updateUserName(@RequestParam(value = "username")String username,@RequestParam(value = "age")int age) { 
		 try {
		        repository.updateUserName(username,age); 
		} catch (Exception e) {
			logger.error("查询失败，原因：",e);
		}
		return "success";
	}
}
