package com.example.sidcloud.Repository;

import com.example.sidcloud.model.entity.Apple;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppleRepository extends JpaRepository<Apple, Long> {
}
