package com.home.Recruitment_Project.repository;

import com.home.Recruitment_Project.data.EnumRole;
import com.home.Recruitment_Project.data.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByName(EnumRole name);
}
