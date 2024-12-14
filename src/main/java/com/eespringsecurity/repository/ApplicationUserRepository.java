package com.eespringsecurity.repository;


import com.eespringsecurity.entity.ApplicationUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUserEntity, Long> {
}
