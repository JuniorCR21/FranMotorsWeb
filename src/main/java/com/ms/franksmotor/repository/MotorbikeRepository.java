package com.ms.franksmotor.repository;

import com.ms.franksmotor.model.db.Motorbike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorbikeRepository extends JpaRepository<Motorbike, Integer>{

}
