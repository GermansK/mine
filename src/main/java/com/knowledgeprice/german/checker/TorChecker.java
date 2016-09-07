package com.knowledgeprice.german.checker;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class TorChecker {

    @Autowired
    TorRelay torRelay;

    public List<String> checkIncomingIp(List<String> incomingIp) {

        final List<String> relayIp = torRelay.getTorPossibleRelay();
        return incomingIp.stream()
                .filter(relayIp::contains)
                .collect(Collectors.toList());
    }
}
