package com.goodfancier.cyanexam.data.map;

import java.util.Collection;
import java.util.List;

public interface AbstractDtoMapper<M, D> {

		/**
		 * Map Domain model -> DTO.
		 *
		 * @param domainModel Domain model
		 * @return DTO
		 */
		D toDto(M domainModel);

		/**
		 * Map list of Domain models -> list of DTOs.
		 *
		 * @param domainModelList List of Domain model
		 * @return List of DTOs
		 */
		List<D> toDtos(Collection<M> domainModelList);
}
