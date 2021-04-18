package com.details.NACE.service;

import com.details.NACE.model.NaceDetailsDTO;

public interface NaceService {

	NaceDetailsDTO create(NaceDetailsDTO naceDetailsDTO);

	NaceDetailsDTO getDetails(int orderNo);
}
