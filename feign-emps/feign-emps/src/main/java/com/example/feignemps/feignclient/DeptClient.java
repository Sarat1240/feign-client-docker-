package com.example.feignemps.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.feignemps.dto.Department;

//@FeignClient(value = "dept-service", url="http://localhost:8080/depts")
@FeignClient(name="http://dept-service/depts")
public interface DeptClient {
	
	@GetMapping
	public List<Department> getAll();
	
	@GetMapping("/{deptId}")
	public List<Department> getAllById(@PathVariable String deptId);
	
	@GetMapping("/byparam")
	public List<Department> getAllByReqParam(@RequestParam String empId);
	
	@PostMapping("/byparam")
	public List<Department> getAllByPostReqParam();
	
	@PostMapping("/bybody")
	public Department getAllByPostReqBody(@RequestBody Department department);
}
