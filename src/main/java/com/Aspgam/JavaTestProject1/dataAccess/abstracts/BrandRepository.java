package com.Aspgam.JavaTestProject1.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Aspgam.JavaTestProject1.entities.concretes.Brand;


public interface BrandRepository extends JpaRepository<Brand, Integer> {
     
}
