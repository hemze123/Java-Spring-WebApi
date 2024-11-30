package com.Aspgam.JavaTestProject1.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Aspgam.JavaTestProject1.business.abstracts.BrandService;
import com.Aspgam.JavaTestProject1.business.requests.CreateBrandsRequest;
import com.Aspgam.JavaTestProject1.business.requests.UpdateBrandRequest;
import com.Aspgam.JavaTestProject1.business.responses.GetAllBrandsResponse;
import com.Aspgam.JavaTestProject1.business.responses.GetByIdBrandResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
   private BrandService brandService;


@GetMapping()
public List<GetAllBrandsResponse>getAll(){
	
	return brandService.getAll();
}

@GetMapping("/{id}")
public GetByIdBrandResponse getById(@PathVariable int id) {
	return brandService.getById(id);
	}

   
   @PostMapping()
   @ResponseStatus(code = HttpStatus.CREATED)
   public void add(@RequestBody()CreateBrandsRequest createBrandRequest) {
	   this.brandService.add(createBrandRequest);
   }
   
   @PutMapping
   public void update(@RequestBody() UpdateBrandRequest updateBrandRequest) {
	   this.brandService.update(updateBrandRequest);
	   
   }
   
   @DeleteMapping("/{id}")
   public void delete(@PathVariable int id) {
	   this.brandService.delete(id);
   }
}
