/* Collections #2024 */
package com.favourite.collections.portfolio.product.util;

import com.favourite.collections.commons.useradmin.domain.Product;
import com.favourite.collections.commons.portfolio.product.data.ProductFetchData;
import com.favourite.collections.commons.portfolio.product.data.ProductRequestData;

public class ModelMapper {
	public ProductFetchData fromProductToData(Product product) {
		return ProductFetchData.builder().name(product.getName()).description(product.getDescription())
				.color(product.getColor()).imageUrl(product.getImageUrl())
				.availableQuantity(product.getAvailableQuantity()).unitPrice(product.getUnitPrice())
				.subcategoryId(product.getSubcategory()).build();
	}

	public Product fromDataToProduct(ProductRequestData product) {
		return Product.builder().name(product.getName()).description(product.getDescription())
				.imageUrl(product.getImageUrl()).availableQuantity(product.getAvailableQuantity())
				.unitPrice(product.getUnitPrice()).build();
	}
}
