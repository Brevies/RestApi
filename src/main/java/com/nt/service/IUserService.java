package com.nt.service;

import java.util.List;

import com.nt.beans.UserDetails;
import com.nt.dto.UserDTO;
import com.nt.entity.UserEntity;

public interface IUserService {

	public List<UserDTO> getAllUsers();
	public UserDTO getUserById(Integer id);
	
	public UserEntity saveUser(UserDetails deatails);
	public UserEntity updateUser(UserDetails deatails);
    public String deleteUserById(Integer id);

}
