package com.knowledgeprice.german.checker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class IpExtractor {

    @Value("${ip.list.file.name}")
    private String fileName;

    public List<String> getIpListFromFile() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            return stream.collect(Collectors.toList());
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}
