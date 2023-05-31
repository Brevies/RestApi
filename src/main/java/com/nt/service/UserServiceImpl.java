package com.nt.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.beans.UserDetails;
import com.nt.dao.IUserDAO;
import com.nt.dto.UserDTO;
import com.nt.entity.UserEntity;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private IUserDAO dao;

	@Override
	public List<UserDTO> getAllUsers() {
		TypeToken<List<UserDTO>> typetoken = new TypeToken<List<UserDTO>>() {
		};
		List<UserEntity> entity = dao.findAll();
		List<UserDTO> dto = this.mapper.map(entity, typetoken.getType());
		return dto;
	}

	@Override
	public UserDTO getUserById(Integer id) {
		UserDTO dto = new UserDTO();
		Optional<UserEntity> entity = dao.findById(id);
		if (entity.isPresent()) {
			dto = this.mapper.map(entity, UserDTO.class);
			return dto;
		}
		return null;
	}

	@Override
	public UserEntity saveUser(UserDetails details) {
		UserEntity status = null;
		UserEntity entity = this.mapper.map(details, UserEntity.class);
		if (entity != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String formatDate = dateFormat.format(date);
			entity.setCreatedDate(formatDate);
			status = dao.save(entity);
		}
		return status;
	}

	@Override
	public UserEntity updateUser(UserDetails details) {
		UserEntity status = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String FormateDate = dateFormat.format(date);
		if (details != null) {
			Optional<UserEntity> entity = dao.findById(details.getId());
			if (entity.isPresent()) {
				entity.get().setCity(details.getCity());
				entity.get().setFirstName(details.getFirstName());
				entity.get().setLastName(details.getLastName());
				entity.get().setAddLine1(details.getAddLine1());
				entity.get().setLastUpdatedDate(FormateDate);
				status = dao.save(entity.get());
			}
		}
		return status;
	}

	@Override
	public String deleteUserById(Integer id) {
		String response = null;
		if (id != null) {
			dao.deleteById(id);
			response = "Record id # " + id + " Deleted Successfully ";
		}
		return response;
	}

}
