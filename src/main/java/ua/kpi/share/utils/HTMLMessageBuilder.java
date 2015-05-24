package ua.kpi.share.utils;

import ua.kpi.share.domain.Task;
import ua.kpi.share.domain.User;
import ua.kpi.share.dto.TaskApply;

import javax.swing.text.html.HTMLDocument;

/**
 * Created by Evgeniy Baranuk on 24.05.15.
 */
public interface HTMLMessageBuilder {
    public HTMLDocument applyMessage(User user, TaskApply taskApply, Task task);
}
