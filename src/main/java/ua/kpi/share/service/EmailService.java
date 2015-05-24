package ua.kpi.share.service;

import javax.swing.text.html.HTMLDocument;

/**
 * Created by oleh on 24.05.2015.
 */
public interface EmailService {
    void send (String email, HTMLDocument message);
}
