package io.github.roquesantosdev.asyncdatabase.controller;

import io.github.roquesantosdev.asyncdatabase.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationLogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationLogController.class);

    private final LogService service;

    public ApplicationLogController(LogService service) {
        this.service = service;
    }

    @GetMapping("/log")
    public ResponseEntity<String> log() {
        LOGGER.info("Calling method LogService::asyncLog");
        service.asyncLog();
        LOGGER.info("Ended calling method LogService::asyncLog");
        return ResponseEntity.ok("Method called successfully.");
    }
}