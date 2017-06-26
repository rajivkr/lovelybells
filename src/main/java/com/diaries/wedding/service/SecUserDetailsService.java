package com.diaries.wedding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.diaries.wedding.model.SecUsers;
import com.diaries.wedding.repository.UserRepository;

@Component
public class SecUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;


	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		SecUsers user = userRepository.findByUsername(userName);
		System.out.println("username is" + userName);
		if (user == null) {
			throw new UsernameNotFoundException(userName);
		} else {
			// UserDetails details = new SecUsers(user);
			return user;
		}
	}
}
