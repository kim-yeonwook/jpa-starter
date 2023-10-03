package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.repository.RoleRepository;
import com.example.demo.entity.Role;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleService {

	private final RoleRepository roleRepository;
	
	public Role getRole(Long id) {
		return roleRepository.findById(id).get();
	}
	
	public List<Role> getRoles() {
		return roleRepository.findAll();
	}
}
