package com.details.NACE.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.details.NACE.model.NaceDetailsDTO;

@Repository
public interface NaceRepository extends MongoRepository<NaceDetailsDTO, Integer> {

	Optional<NaceDetailsDTO> findByOrder(int order);
}
