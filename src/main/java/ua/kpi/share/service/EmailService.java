package ua.kpi.share.service;

import javax.swing.text.html.HTMLDocument;

/**
 * Created by oleh on 24.05.2015.
 */
public interface EmailService {
    void sendHTML (String[] emails, String subject, HTMLDocument htmlMessage);
    void sendText (String[] emails, String subject, String textMessage);
}
