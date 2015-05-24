package ua.kpi.share.service;

import ua.kpi.share.domain.Attachment;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by vitaliy on 25.05.15.
 */
public interface AttachmentService {

    void upload(Attachment attachment, InputStream inputStream);

    OutputStream load(Attachment attachment);

}
