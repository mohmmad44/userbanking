package com.banking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banking.dto.UserDto;
import com.banking.model.User;
import com.banking.model.UserAddress;
import com.banking.repository.UserRepository;
import com.banking.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDto saveUser(UserDto userDto) {
		User user = new User();
		user.setFirstName(userDto.getFirstName());
		
		List<UserAddress> userAddressList = new ArrayList<>();
		UserAddress ua1 = new UserAddress();
		ua1.setCity(userDto.getCity());
		ua1.setHouseNumber(Integer.valueOf(userDto.getHouseNumber()));
		ua1.setUser(user);
		userAddressList.add(ua1);
		
	
		
			
		
		
		user = userRepository.save(user);
		userDto.setFirstName(user.getFirstName());
		userDto.setUserId(user.getId());
		
		return userDto;
	}

}
