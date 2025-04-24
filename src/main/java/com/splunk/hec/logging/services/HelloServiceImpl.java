package com.splunk.hec.logging.services;

import com.splunk.hec.logging.services.contracts.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String callService() {
        log.info("passing by service");
        return "service called";
    }
}