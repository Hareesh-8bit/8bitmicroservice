package com.bitmicro.bitmicro.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users =new ArrayList<>();
	
	
	private static int userCounts = 3;
	
	static{
		users.add(new User(1, "hari", new Date()));
		users.add(new User(2, "adam", new Date()));
		users.add(new User(3, "smith", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user){
		if(user.getId()==null){
			user.setId(++userCounts);
		}
		users.add(user);
		return user;
			
	}
	
	public User findOne(int id){
		for(User user:users){
			if(user.getId()==id){
				return user;
			}
			
		}
		return null;
	}

}