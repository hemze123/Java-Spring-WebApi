package com.Aspgam.JavaTestProject1.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Aspgam.JavaTestProject1.business.abstracts.BrandService;
import com.Aspgam.JavaTestProject1.business.requests.CreateBrandsRequest;
import com.Aspgam.JavaTestProject1.business.requests.UpdateBrandRequest;
import com.Aspgam.JavaTestProject1.business.responses.GetAllBrandsResponse;
import com.Aspgam.JavaTestProject1.business.responses.GetByIdBrandResponse;
import com.Aspgam.JavaTestProject1.core.utilities.mappers.ModelMapperService;
import com.Aspgam.JavaTestProject1.dataAccess.abstracts.BrandRepository;
import com.Aspgam.JavaTestProject1.entities.concretes.Brand;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	
	

	@Override
	public List<GetAllBrandsResponse> getAll() {
		List<Brand> brands = brandRepository.findAll();
		
		List<GetAllBrandsResponse> brandsResponse = brands.stream()
			.map(brand -> this.modelMapperService.forResponse()
			.map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());		
		return brandsResponse;
	}

	@Override
	public void add(CreateBrandsRequest createBrandsRequest) {
		
		Brand brand = this.modelMapperService.forRequest().map(createBrandsRequest, Brand.class);
		this.brandRepository.save(brand);
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		GetByIdBrandResponse response = this.modelMapperService.forResponse()
				.map(brand, GetByIdBrandResponse.class);
				return response;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
	   Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
	   this.brandRepository.save(brand);
		
	}

	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);
		
	}

}
