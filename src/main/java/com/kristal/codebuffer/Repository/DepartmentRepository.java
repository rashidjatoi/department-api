package com.kristal.codebuffer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kristal.codebuffer.Entity.DepartmentEntity;

// Annotation to indicate that this interface is a Spring repository
@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    // Spring Data JPA provides CRUD operations out-of-the-box
    // No need to implement these methods manually

    public DepartmentEntity findByDepartmentName(String departmentName);

    public DepartmentEntity findByDepartmentNameIgnoreCase(String departmentName);
}
