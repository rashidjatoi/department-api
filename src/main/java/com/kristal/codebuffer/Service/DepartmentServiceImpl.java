package com.kristal.codebuffer.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kristal.codebuffer.Entity.DepartmentEntity;
import com.kristal.codebuffer.Repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Method to save a department entity
    @Override
    public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    // Method to fetch all departments
    @Override
    public List<DepartmentEntity> fetchDepartment() {
        return departmentRepository.findAll();
    }

    // Method to fetch a department by its ID
    @Override
    public DepartmentEntity fetchDepartmentById(Long departmentId) {
        // Using Optional to handle cases where the department may not exist
        Optional<DepartmentEntity> departmentOptional = departmentRepository.findById(departmentId);
        if (departmentOptional.isPresent()) {
            return departmentOptional.get();
        } else {
            // Return null if department is not found (you may want to handle this
            // differently based on your application logic)
            return null;
        }
    }

    // Method to delete a department by its ID
    @Override
    public String deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
        return "Department Deleted";
    }

    // Method to update a department entity by its ID
    @Override
    public DepartmentEntity updateDepartmentEntity(Long departmentId, DepartmentEntity departmentEntity) {
        // Check if the department with given ID exists in the repository
        Optional<DepartmentEntity> optionalDepB = departmentRepository.findById(departmentId);
        if (optionalDepB.isPresent()) {
            DepartmentEntity depB = optionalDepB.get();
            // Update the department entity fields if provided
            if (departmentEntity.getDepartmentName() != null) {
                depB.setDepartmentName(departmentEntity.getDepartmentName());
            }
            if (departmentEntity.getDepartmentAddress() != null) {
                depB.setDepartmentAddress(departmentEntity.getDepartmentAddress());
            }
            // Save and return the updated department entity
            return departmentRepository.save(depB);
        } else {
            // If the department with given ID doesn't exist, save the provided entity as a
            // new one
            return departmentRepository.save(departmentEntity);
        }
    }

    @Override
    public DepartmentEntity fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
