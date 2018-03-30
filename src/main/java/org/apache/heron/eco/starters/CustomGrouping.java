package org.apache.heron.eco.starters;

import org.apache.storm.generated.GlobalStreamId;
import org.apache.storm.grouping.CustomStreamGrouping;
import org.apache.storm.task.WorkerTopologyContext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomGrouping implements CustomStreamGrouping {

    private int tasks = 0;

    public CustomGrouping() {
    }

    public void prepare(WorkerTopologyContext context, GlobalStreamId stream, List<Integer> targetTasks) {
        this.tasks = targetTasks.size();
    }

    public List<Integer> chooseTasks(int taskId, List<Object> values) {
        List<Integer> boltIds = new ArrayList<>();
        if (values.size() > 0) {
            String str = values.get(0).toString();
            if (str.isEmpty()) {
                boltIds.add(0);
            } else {
                boltIds.add(str.charAt(0) % tasks);
            }

        }
        return boltIds;
    }
}
