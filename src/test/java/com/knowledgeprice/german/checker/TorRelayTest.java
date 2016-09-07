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
public class TorRelayTest {
    @Autowired
    private TorRelay torRelay;

    @Test
    public void shouldReturnTorIpList() throws Exception {
        List<String> relayList =  torRelay.getTorPossibleRelay();
        assertFalse(relayList.isEmpty());
    }
}