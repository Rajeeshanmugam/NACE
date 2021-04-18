package com.details.NACE.service;

import org.springframework.stereotype.Service;
import com.details.NACE.exception.NotFoundException;
import com.details.NACE.model.NaceDetailsDTO;
import com.details.NACE.repository.NaceRepository;

@Service
public class NaceServiceImpl implements NaceService {

	private final NaceRepository naceRepository;

	public NaceServiceImpl(NaceRepository naceRepository) {
		this.naceRepository = naceRepository;
	}

	public NaceDetailsDTO create(NaceDetailsDTO naceDetails) {
		return naceRepository.save(naceDetails);
	}

	@Override
	public NaceDetailsDTO getDetails(int order) {
		return naceRepository.findByOrder(order)
				.orElseThrow(() -> new NotFoundException("Nace details not found. order = " + order));
	}

}
