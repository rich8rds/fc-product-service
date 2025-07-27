/* Collections #2024 */
package com.favourite.collections.portfolio.product.service.impl;

import com.favourite.collections.commons.core.data.CommandResult;
import com.favourite.collections.commons.core.data.SearchParameters;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.favourite.collections.commons.portfolio.product.data.ProductFetchData;
import com.favourite.collections.portfolio.product.repository.ProductRepository;
import com.favourite.collections.portfolio.product.service.ProductReadService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductReadServiceImpl implements ProductReadService {
	private final ProductRepository productRepository;

	@Override
	public ResponseEntity<Page<ProductFetchData>> retrieveAllProducts(SearchParameters searchParameters) {
		return ResponseEntity.ok().body(productRepository.findBy(searchParameters));
	}

	@Override
	public ResponseEntity<CommandResult> retrieveProduct(Long productId) {
		return null;
	}
}
