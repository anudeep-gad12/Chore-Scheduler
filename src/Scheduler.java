import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scheduler {
    private List<Roommate> roommates;
    private List<Assignment> monthlySchedule;

    public Scheduler(List<Roommate> roommates) {
        this.roommates = roommates;
        this.monthlySchedule = new ArrayList<>();
        generateMonthlySchedule();
    }

    void generateMonthlySchedule() {
        List<Task> tasks = new ArrayList<>(List.of(Task.values()));
        Collections.shuffle(tasks); // Randomize tasks
        // 4 weeks in a month
        for (int week = 1; week <= 4; week++) {
            Map<Roommate, Task> weeklyAssignments = new HashMap<>();
            for (int i = 0; i < roommates.size(); i++) {
                // Rotate tasks
                Task task = tasks.get(i % tasks.size());
                weeklyAssignments.put(roommates.get(i), task);
            }
            monthlySchedule.add(new Assignment(week, weeklyAssignments));

            // Rotate the list for next week's assignment
            Collections.rotate(tasks, 1);
        }
    }

    public void displaySchedule() {
        for (Assignment assignment : monthlySchedule) {
            System.out.println(assignment);
        }
    }
}
