/* Collections #2024 */
package com.favourite.collections.portfolio.product.api;

import java.time.LocalDateTime;

import com.favourite.collections.commons.core.data.CommandResult;
import com.favourite.collections.commons.core.data.SearchParameters;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.favourite.collections.commons.portfolio.product.data.ProductFetchData;
import com.favourite.collections.commons.portfolio.product.data.ProductRequestData;
import com.favourite.collections.portfolio.product.service.ProductReadService;
import com.favourite.collections.portfolio.product.service.ProductWriteService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Products")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
	private final ProductWriteService productWriteService;
	private final ProductReadService productReadService;

	@GetMapping
	public ResponseEntity<Page<ProductFetchData>> retrieveAllProducts(@RequestParam(required = false) Long id,
			@RequestParam(required = false) String name, @RequestParam(defaultValue = "1") Integer offset,
			@RequestParam(defaultValue = "10") Integer limit, @RequestParam(defaultValue = "DESC") String sortOrder,
			@RequestParam(defaultValue = "id") String orderBy, @RequestParam(defaultValue = "all") String category,
			@RequestParam(defaultValue = "all") String subcategory,
			@RequestParam(name = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
			@RequestParam(name = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {

		SearchParameters searchParameters = SearchParameters.builder().id(id).offset(offset).limit(limit).name(name)
				.category(category).subcategory(subcategory).sortOrder(sortOrder).orderBy(orderBy).startDate(startDate)
				.endDate(endDate).build();

		return productReadService.retrieveAllProducts(searchParameters);
	}

	@PostMapping
	public ResponseEntity<CommandResult> addNewProduct(@RequestBody ProductRequestData productRequestData) {
		return productWriteService.addNewProduct(productRequestData);
	}

	@GetMapping("/{productId}")
	public ResponseEntity<CommandResult> retrieveProduct(@PathVariable Long productId) {
		return productReadService.retrieveProduct(productId);
	}

	@PutMapping("/productId")
	public ResponseEntity<CommandResult> updateProduct(@PathVariable Long productId,
			@RequestBody ProductRequestData productRequestData) {
		return this.productWriteService.updateProduct(productId, productRequestData);
	}
}
