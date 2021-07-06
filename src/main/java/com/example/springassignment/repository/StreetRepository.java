package com.example.springassignment.repository;

import com.example.springassignment.entity.Street;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepository extends JpaRepository<Street, Integer> {

    public Page<Street> findStreetByNameContainsAndDistrictName(String streetName, String districtId, Pageable pageable);

    public Page<Street> findStreetsByNameContains(String streetName, Pageable pageable);

    public Page<Street> findStreetByDistrictName(String districtName, Pageable pageable);
}
