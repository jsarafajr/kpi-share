package ua.kpi.share.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.kpi.share.Application;
import ua.kpi.share.service.EmailService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class EmailServiceImplTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void testSend() throws Exception {
        String[] emails = {"golovan11@gmail.com"};
        emailService.sendText(emails, "Test Email Message Subject", "Hi, i am a test text message from kpi-share!");
    }
}