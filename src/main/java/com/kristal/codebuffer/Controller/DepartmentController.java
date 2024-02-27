package com.kristal.codebuffer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kristal.codebuffer.Entity.DepartmentEntity;
import com.kristal.codebuffer.Service.DepartmentService;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // Constructor injection can be used instead of @Autowired
    // public DepartmentController(DepartmentService departmentService) {
    // this.departmentService = departmentService;
    // }

    // Endpoint to save a department
    @PostMapping("/department")
    public DepartmentEntity saveDepartment(@RequestBody DepartmentEntity departmentEntity) {
        return departmentService.saveDepartment(departmentEntity);
    }

    // Endpoint to fetch all departments
    @GetMapping(path = "/department")
    public List<DepartmentEntity> fetchDepartments() {
        return departmentService.fetchDepartment();
    }

    // Endpoint to fetch a department by its ID
    @GetMapping(path = "/department/{id}")
    public DepartmentEntity fetchDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentService.fetchDepartmentById(departmentId);
    }

    // Endpoint to delete a department by its ID
    @DeleteMapping(path = "/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentService.deleteDepartmentById(departmentId);
    }

    // Endpoint to update a department entity by its ID
    @PutMapping(path = "/department/{id}")
    public DepartmentEntity updateDepartmentEntity(@PathVariable("id") Long departmentId,
            @RequestBody DepartmentEntity departmentEntity) {
        return departmentService.updateDepartmentEntity(departmentId, departmentEntity);
    }

    @GetMapping(path = "/department/name/{name}")
    public DepartmentEntity fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);

    }

}
