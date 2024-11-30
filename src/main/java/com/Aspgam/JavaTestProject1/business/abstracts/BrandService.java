package com.Aspgam.JavaTestProject1.business.abstracts;

import java.util.List;

import com.Aspgam.JavaTestProject1.business.requests.CreateBrandsRequest;
import com.Aspgam.JavaTestProject1.business.requests.UpdateBrandRequest;
import com.Aspgam.JavaTestProject1.business.responses.GetAllBrandsResponse;
import com.Aspgam.JavaTestProject1.business.responses.GetByIdBrandResponse;

public interface BrandService {
   List<GetAllBrandsResponse> getAll();
   GetByIdBrandResponse getById(int id);
   void add(CreateBrandsRequest createBrandsRequest);
   void update(UpdateBrandRequest updateBrandRequest);
   void delete(int id);
   
}
