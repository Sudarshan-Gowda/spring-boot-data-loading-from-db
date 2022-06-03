package com.star.sud;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.star.sud.employee.dao.EmployeeRepository;
import com.star.sud.employee.model.TEmployee;

@Component
public class AppLoadData {

	public static Map<Integer, String> mapData = new HashMap<>();

	@Autowired
	private EmployeeRepository repository;

	@PostConstruct
	public void loadEmpData() {

		List<TEmployee> findAll = repository.findAll();

		mapData = findAll.stream().collect(Collectors.toMap(TEmployee::getEmpId, TEmployee::getEmpName));
		System.out.println(mapData);

	}

}
