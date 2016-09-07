package com.knowledgeprice.german.checker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;


import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TorCheckerTest {

    @Mock
    private TorRelay torRelay;

    @InjectMocks
    private TorChecker torChecker;

    @Test
    public void shouldReturnIpWhichWasInParameterAndInTorList() throws Exception {
        when(torRelay.getTorPossibleRelay()).thenReturn(Arrays.asList("1","2"));

        List<String> torIp = torChecker.checkIncomingIp(Arrays.asList("1","2"));

        assertThat(torIp, hasItems("1","2"));

    }
}