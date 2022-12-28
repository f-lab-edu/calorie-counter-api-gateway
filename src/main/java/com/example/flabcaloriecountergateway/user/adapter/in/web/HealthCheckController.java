package com.example.flabcaloriecountergateway.user.adapter.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

import static com.example.flabcaloriecountergateway.user.adapter.in.web.Constants.LATEST_API_VERSION;

@RestController
public class HealthCheckController {

	private static final Logger logger = Logger.getLogger(HealthCheckController.class.getName());

	@GetMapping(LATEST_API_VERSION + "/health")
	public ResponseEntity<String> healthCheck(@RequestHeader("x-session-id") final String sessionId) {
		logger.info("Health check request received. Session ID: " + sessionId);
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
}
