package com.jaxb.repository;

import com.jaxb.model.booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarshallRepository extends JpaRepository<booking, Integer> {
}
