package com.vishwajeet.job_tracker.repository;

import com.vishwajeet.job_tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
