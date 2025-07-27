/* Collections #2024 */
package com.favourite.collections.portfolio.product.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.favourite.collections.commons.core.data.SearchParameters;
import com.favourite.collections.commons.core.exceptions.AbstractPlatformException;
import com.favourite.collections.commons.useradmin.domain.CodeValue;
import com.favourite.collections.commons.useradmin.domain.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.favourite.collections.commons.portfolio.product.data.ProductFetchData;
import com.favourite.collections.portfolio.product.util.ModelMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
	@PersistenceContext
	private final EntityManager em;

//	private final CodeValueRepository codeValueRepository;
	private final ModelMapper modelMapper = new ModelMapper();

	@Override
	public Page<ProductFetchData> findBy(SearchParameters searchParameters) {
		// log.info("SEARCH_PARAMETERS: {}", searchParameters);
		Long id = searchParameters.getId();
		Integer limit = searchParameters.getLimit();

		String name = searchParameters.getName();
		// String category = searchParameters.getCategory();
		String subcategory = searchParameters.getSubcategory();
		Integer offset = searchParameters.getOffset();
		String sortOrder = searchParameters.getSortOrder();
		String orderBy = searchParameters.getOrderBy();

		LocalDateTime requestStartDate = searchParameters.getStartDate();
		LocalDateTime requestEndDate = searchParameters.getEndDate();

		offset = offset <= 0 ? 1 : offset;
		Sort.Direction direction = sortOrder.equals("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC;
		PageRequest pageRequest = PageRequest.of((offset - 1), limit, Sort.by(direction, orderBy));

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);

		Root<Product> nxConnectDBroot = cq.from(Product.class);
		List<Predicate> predicates = new ArrayList<>();
		if (id != null) {
			predicates.add(cb.equal(nxConnectDBroot.get("id"), id));
		}

		if (name != null) {
			predicates.add(cb.like(nxConnectDBroot.get("name"), name));
		}

//		if (subcategory != null) {
//			CodeValue codeValue = this.codeValueRepository.findCodeValueByLabel(name)
//					.orElseThrow(() -> new AbstractPlatformException("error.code.value.id.not.found",
//							"Code value with identifier " + name + "does not exist", 404));
//			predicates.add(cb.equal(nxConnectDBroot.get("subcategory"), codeValue));
//		}

		if (requestEndDate != null && requestStartDate != null) {
			predicates.add(cb.between(nxConnectDBroot.get("created_date"), requestStartDate, requestEndDate));
		}

		cq.where(cb.and(predicates.toArray(new Predicate[0])));
		TypedQuery<Product> typedQuery = em.createQuery(cq).setFirstResult(limit).setMaxResults(offset );

		List<Product> result = typedQuery.getResultList();
		List<ProductFetchData> dataResults = result.stream().map(modelMapper::fromProductToData)
				.collect(Collectors.toList());

		log.info("RESULT: {}", dataResults);
		final int start = (int) pageRequest.getOffset();
		final int end = Math.min((start + pageRequest.getPageSize()), result.size());
		final Page<ProductFetchData> page = new PageImpl<>(dataResults.subList(start, end), pageRequest, result.size());
		return page;
	}
}
