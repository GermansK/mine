package com.knowledgeprice.german.checker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TorRelay {


    @Value("${server.ip}")
    private String serverIp;

    @Value("${server.port}")
    private Integer serverPort;

    private static final String BASE_URL = "https://check.torproject.org";

    public List<String> getTorPossibleRelay() {
        RestTemplate restTemplate = new RestTemplate();


        URI targetUrl = createTargetURI(serverIp, serverPort);

        String response = restTemplate.getForObject(targetUrl, String.class);

        return Arrays.asList(response.split("\n"));
    }

    private URI createTargetURI(String ip, Integer port) {
        return UriComponentsBuilder.fromUriString(BASE_URL)
                .path("/cgi-bin/TorBulkExitList.py")
                .queryParam("ip", ip)
                .queryParam("port", port)
                .build()
                .toUri();
    }
}
