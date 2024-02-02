import java.util.Map;

public class Assignment {
    private int weekNumber;
    private Map<Roommate, Task> assignments;

    public Assignment(int weekNumber, Map<Roommate, Task> assignments) {
        this.weekNumber = weekNumber;
        this.assignments = assignments;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public Map<Roommate, Task> getAssignments() {
        return assignments;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Week ").append(weekNumber).append(" Assignments:\n");
        for (Map.Entry<Roommate, Task> entry : assignments.entrySet()) {
            sb.append(entry.getKey().getName())
                    .append(" -> ")
                    .append(entry.getValue())
                    .append("\n");
        }
        return sb.toString();
    }
}
