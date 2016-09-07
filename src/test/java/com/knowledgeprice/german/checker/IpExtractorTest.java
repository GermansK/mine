package com.knowledgeprice.german.checker;

import com.knowledgeprice.german.checker.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class IpExtractorTest {

    @Autowired
    private IpExtractor ipExtractor;

    @Test
    public void shouldGetIpFromFile() throws Exception {
        List<String> ipListFromFile =  ipExtractor.getIpListFromFile();
        assertFalse(ipListFromFile.isEmpty());
    }
}