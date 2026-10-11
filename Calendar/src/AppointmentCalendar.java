
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class AppointmentCalendar {

    private ArrayList<Appointment> appointments;

    // Constructor
    public AppointmentCalendar() {
        appointments = new ArrayList<>();
    }

    // Add an appointment
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    // Remove an appointment
    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    // Retrieve appointments for a specific date
    public ArrayList<Appointment> getAppointmentsByDate(LocalDate date) {

        ArrayList<Appointment> results = new ArrayList<>();

        for (Appointment appointment : appointments) {
            if (appointment.getDate().equals(date)) {
                results.add(appointment);
            }
        }

        // Sort appointments by starting time
        results.sort(
                Comparator.comparing(Appointment::getStartTime)
        );

        return results;
    }
}
