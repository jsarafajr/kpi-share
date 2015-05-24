package ua.kpi.share.utils.impl;

import org.springframework.stereotype.Component;
import ua.kpi.share.domain.Task;
import ua.kpi.share.domain.User;
import ua.kpi.share.dto.TaskApply;
import ua.kpi.share.utils.HTMLMessageBuilder;

import javax.swing.text.html.HTMLDocument;

/**
 * Created by oleh on 24.05.2015.
 */
@Component
public class HTMLMailBuilderImpl implements HTMLMessageBuilder {

    @Override
    public HTMLDocument applyMessage(User user, TaskApply taskApply, Task task) {
        return null;
    }
}
