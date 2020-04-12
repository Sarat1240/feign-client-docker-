package com.example.feignemps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.feignemps.dto.Department;
import com.example.feignemps.feignclient.DeptClient;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
	
	@Autowired
	DeptClient deptClient;
	
	
	@GetMapping("")
	public List<Department> getEmpForDepts()
	{
		return deptClient.getAll();
	}
	
	@GetMapping("/{deptId}")
	public List<Department> getEmpForDepts(@PathVariable String deptId)
	{
		return deptClient.getAllById(deptId);
	}
	
	@GetMapping("/byparam")
	public List<Department> getEmpDeptsByReqParam(@RequestParam String empId)
	{
		return deptClient.getAllByReqParam(empId);
	}
	
	@GetMapping("/postparam")
	public List<Department> testPostWithParam(@RequestParam String userId) 
	{
		return deptClient.getAllByPostReqParam();
	}
	
	@GetMapping("/bybody")
	public Department testReqBody() {
		Department d = new Department();
		d.setId(1);
		d.setdepName("IT");
		return deptClient.getAllByPostReqBody(d);
		
	}
	

}
