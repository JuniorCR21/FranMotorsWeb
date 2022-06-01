package com.ms.franksmotor.repository;

import com.ms.franksmotor.model.db.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Integer>{

}
