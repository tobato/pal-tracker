package io.pivotal.pal.tracker;

import java.util.List;

/**
 * @author wuyf
 * @create 2017-09-06 下午12:31
 */
public interface TimeEntryRepository {
    TimeEntry create(TimeEntry timeEntry);
    TimeEntry find(Long id);
    List<TimeEntry> list();
    TimeEntry update(Long id, TimeEntry timeEntry);
    void delete(Long id);
}
