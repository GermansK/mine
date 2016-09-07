package com.knowledgeprice.german.checker;

import com.knowledgeprice.german.checker.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IpExtractor ipExtractor = (IpExtractor) context.getBean("ipExtractor");
        TorChecker torChecker = (TorChecker) context.getBean("torChecker");
        List<String> torIpList = torChecker.checkIncomingIp(ipExtractor.getIpListFromFile());

        System.out.println("Tor IP list count: " + torIpList.size());
        System.out.println();
        torIpList.forEach(System.out::println);

    }
}
