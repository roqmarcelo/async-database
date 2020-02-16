package io.github.roquesantosdev.asyncdatabase.service;

import io.github.roquesantosdev.asyncdatabase.entities.ApplicationLog;
import io.github.roquesantosdev.asyncdatabase.repository.LogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class LogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogService.class);

    private final LogRepository repository;

    public LogService(LogRepository repository) {
        this.repository = repository;
    }

    @Async("AsyncDatabaseApplicationExecutor")
    public void asyncLog() {
        LOGGER.info("Executing method LogService::asyncLog");
        doLog();
        LOGGER.info("Ended executing method LogService::asyncLog");
    }

    @Transactional
    private void doLog() {
        LOGGER.info("Executing method LogService::doLog");
        ApplicationLog applicationLog = repository.save(new ApplicationLog(LocalDateTime.now(), String.format("Message %d", new Random().nextInt())));
        LOGGER.info("Saved Application Log : {}", applicationLog);
        LOGGER.info("Application Log Count : {}", repository.count());
        LOGGER.info("Application Log Newest ID : {}", repository.newestId());
        LOGGER.info("Ended executing method LogService::doLog");
    }
}