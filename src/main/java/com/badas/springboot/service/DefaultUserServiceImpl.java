package com.badas.springboot.service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.badas.springboot.DTO.UserRegisteredDTO;
import com.badas.springboot.model.Role;
import com.badas.springboot.model.UserModel;
import com.badas.springboot.repository.RoleRepository;
import com.badas.springboot.repository.UserModelRepository;

@Component
public class DefaultUserServiceImpl implements DefaultUserService {
	
	@Autowired
	private UserModelRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		UserModel user = userRepo.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}

	@Override
	public UserModel save(UserRegisteredDTO userRegisteredDTO) {
		Role role = roleRepo.findByRole("USER");
		
		UserModel user = new UserModel();
		user.setEmail(userRegisteredDTO.getEmail_id());
		user.setName(userRegisteredDTO.getName());
		user.setPassword(passwordEncoder.encode(userRegisteredDTO.getPassword()));
		user.setRole(role);
		
		return userRepo.save(user);
	}

}
