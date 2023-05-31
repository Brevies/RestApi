package com.nt.controller;

import java.util.List;

import org.hibernate.annotations.NotFound;
import org.hibernate.engine.spi.EntityEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.beans.UserDetails;
import com.nt.dto.UserDTO;
import com.nt.entity.UserEntity;
import com.nt.service.IUserService;

@RequestMapping("/controller")
@RestController
public class UserController {

	@Autowired
	private IUserService service;

	@GetMapping("/user")
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<UserDTO> dto = service.getAllUsers();
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping("/user1")
	public ResponseEntity<UserDTO> getUserbyId(@RequestParam Integer id) {
		UserDTO dto = service.getUserById(id);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@PostMapping("/user")
	public ResponseEntity<String> saveUser(@RequestBody UserDetails details) {
		UserEntity entity = service.saveUser(details);
		if (entity != null) {
			return new ResponseEntity<>("Inserted successfully", HttpStatus.OK);
		} else
			return new ResponseEntity<>("Error in insert Record", HttpStatus.OK);
	}

	@PutMapping("/user")
	public ResponseEntity<String> UpdateUser(@RequestBody UserDetails details) {
		UserEntity entity = service.updateUser(details);
		if (entity != null) {
			return new ResponseEntity<>("Record inserted successfully !!!", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Error in inserted Record !!! ", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/user")
	public ResponseEntity<String> deleteUserById(@RequestParam Integer id) {
		if (id != null) {
			service.deleteUserById(id);
			return new ResponseEntity<>("Record deleted successfully !!! ", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Record Not Found !!! ", HttpStatus.BAD_REQUEST);
		}
	}
}
