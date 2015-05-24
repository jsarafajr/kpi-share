package ua.kpi.share.service.impl;

import org.springframework.stereotype.Service;
import ua.kpi.share.service.EmailService;

import javax.swing.text.html.HTMLDocument;

/**
 * Created by oleh on 24.05.2015.
 */
@Service
public class EmailServiceImpl implements EmailService {
    @Override
    public void send(String email, HTMLDocument message) {

    }
}
