package com.details.NACE.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.details.NACE.model.NaceDetailsDTO;
import com.details.NACE.service.NaceService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/nacedetails")
@Slf4j
public class NaceController {

	private final NaceService naceService;

	public NaceController(NaceService naceService) {
		this.naceService = naceService;
	}

	@PostMapping
	public ResponseEntity<NaceDetailsDTO> putNaceDetails(@RequestBody NaceDetailsDTO naceDetails) {
		// log.info("creating NaceDetails = {}", naceDetails);
		return ResponseEntity.ok(naceService.create(naceDetails));
	}

	@GetMapping(path = "{orderNo}")
	public ResponseEntity<NaceDetailsDTO> getNaceDetails(@PathVariable int orderNo) {
		log.info("get NaceDetails by Order No= {}", orderNo);
		return ResponseEntity.ok(naceService.getDetails(orderNo));
	}
}
