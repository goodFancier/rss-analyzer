package com.goodfancier.cyanexam.data.map;

import java.util.Collection;
import java.util.List;

public interface AbstractDomainMapper<M, D> {

		/**
		 * Map DTO -> Domain model
		 *
		 * @param dto DTO
		 * @return Domain model
		 */
		M toDomainModel(D dto);

		/**
		 * Map list of DTOs -> list of Domain models.
		 *
		 * @param dtoList List of DTO
		 * @return List of domain models
		 */
		List<M> toDomainModels(Collection<D> dtoList);
}
