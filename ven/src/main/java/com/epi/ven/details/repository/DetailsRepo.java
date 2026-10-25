package com.epi.ven.details.repository;

import com.epi.ven.details.model.DetailsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepo extends JpaRepository<DetailsData, Integer> {
}
