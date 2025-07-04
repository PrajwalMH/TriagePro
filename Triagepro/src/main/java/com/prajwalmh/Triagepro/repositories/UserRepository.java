package com.prajwalmh.Triagepro.repositories;



import com.prajwalmh.Triagepro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
