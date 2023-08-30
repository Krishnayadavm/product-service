package com.product.manage.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.manage.entity.ProductEntity;
import com.product.manage.exception.ProductNotFound;
import com.product.manage.mapper.ProductEntityMapper;
import com.product.manage.mapper.ProductModelMapper;
import com.product.manage.model.ProductModel;
import com.product.manage.repository.ProductDao;
import com.product.manage.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ProductEntityMapper productEntityMapper;

	@Autowired
	private ProductModelMapper productModelMapper;

	@Override
	public void createProduct(ProductModel productModel) {
		productDao.save(productEntityMapper.modelToProductEntity(productModel));

	}

	@Override
	public void updateProduct(ProductModel productModel) {
		productDao.save(productEntityMapper.modelToProductEntity(productModel));
	}

	@Override
	public void deleteByProductId(int productId) {
		productDao.deleteById(productId);
	}

	@Override
	public ProductModel findByProductId(int productId) {
		ProductModel productModel;

		Optional<ProductEntity> ProductModelOptional = productDao.findById(productId);

		if (ProductModelOptional.isPresent()) {
			productModel = productModelMapper.entityToProductModel(ProductModelOptional.get());
		} else {
			throw new ProductNotFound("product id is not found" + productId);
		}
		return productModel;
	}
}
