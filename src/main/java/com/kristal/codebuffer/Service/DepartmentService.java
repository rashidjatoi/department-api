package com.kristal.codebuffer.Service;

import java.util.List;

import com.kristal.codebuffer.Entity.DepartmentEntity;

// Interface for DepartmentService
public interface DepartmentService {

    // Method to save a department entity
    DepartmentEntity saveDepartment(DepartmentEntity departmentEntity);

    // Method to fetch all departments
    List<DepartmentEntity> fetchDepartment();

    // Method to fetch a department by its ID
    DepartmentEntity fetchDepartmentById(Long departmentId);

    // Method to delete a department by its ID
    String deleteDepartmentById(Long departmentId);

    // Method to update a department entity by its ID
    DepartmentEntity updateDepartmentEntity(Long departmentId, DepartmentEntity departmentEntity);

    DepartmentEntity fetchDepartmentByName(String departmentName);

}
