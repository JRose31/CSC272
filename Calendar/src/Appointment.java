
import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    private String description;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    // Constructor
    public Appointment(String description, LocalDate date,
                       LocalTime startTime, LocalTime endTime) {
        this.description = description;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Methods
    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    // Compile appointment description
    @Override
    public String toString() {
        return startTime + " - " + endTime + " | " + description;
    }
}
