package com.product.manage.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.product.manage.entity.CategoryEntity;
import com.product.manage.entity.ProductEntity;
import com.product.manage.entity.ProductTypeEntity;
import com.product.manage.model.CategoryModel;
import com.product.manage.model.ProductModel;
import com.product.manage.model.ProductTypeModel;

@Component
public class ProductEntityMapper {

	public ProductEntity modelToProductEntity(ProductModel productModel) {

		ProductEntity productEntity = new ProductEntity();
		BeanUtils.copyProperties(productModel, productEntity);
		productEntity.setCategoryEntity(modeltoCategoryEntity(productModel.getCategoryModel()));
		productEntity.setProductTypeEntity(modelToProductTypeEntity(productModel.getProductTypeModel()));
		return productEntity;
	}

	public CategoryEntity modeltoCategoryEntity(CategoryModel categoryModel) {
		CategoryEntity categoryEntity = new CategoryEntity();
		BeanUtils.copyProperties(categoryModel, categoryEntity);
		return categoryEntity;
	}

	public ProductTypeEntity modelToProductTypeEntity(ProductTypeModel ProductTypeModel) {
		ProductTypeEntity productTypeEntity = new ProductTypeEntity();
		BeanUtils.copyProperties(ProductTypeModel, productTypeEntity);
		return productTypeEntity;
	}
}
