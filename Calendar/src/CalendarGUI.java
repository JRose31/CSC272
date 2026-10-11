
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class CalendarGUI extends JFrame {

    private AppointmentCalendar calendar;

    private JTextField descriptionField;
    private JTextField dateField;
    private JTextField startField;
    private JTextField endField;
    private JTextField searchDateField;

    private DefaultListModel<Appointment> listModel;
    private JList<Appointment> appointmentList;

    public CalendarGUI() {

        calendar = new AppointmentCalendar();

        // Build the application window
        setTitle("Appointment Calendar");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        // Appointment input fields
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));

        descriptionField = new JTextField();
        dateField = new JTextField("2026-11-02");
        startField = new JTextField("10:30");
        endField = new JTextField("11:30");

        JButton addButton = new JButton("Add Appointment");

        inputPanel.add(new JLabel("Description:"));
        inputPanel.add(descriptionField);

        inputPanel.add(new JLabel("Date (YYYY-MM-DD):"));
        inputPanel.add(dateField);

        inputPanel.add(new JLabel("Start Time (HH:MM):"));
        inputPanel.add(startField);

        inputPanel.add(new JLabel("End Time (HH:MM):"));
        inputPanel.add(endField);

        inputPanel.add(new JLabel(""));
        inputPanel.add(addButton);

        // Date search section
        JPanel searchPanel = new JPanel(new BorderLayout(5, 5));

        searchDateField = new JTextField("2026-11-02");
        JButton viewButton = new JButton("View Appointments");

        searchPanel.add(
                new JLabel("View Date (YYYY-MM-DD):"),
                BorderLayout.WEST
        );
        searchPanel.add(searchDateField, BorderLayout.CENTER);
        searchPanel.add(viewButton, BorderLayout.EAST);

        // Appointment list
        listModel = new DefaultListModel<>();
        appointmentList = new JList<>(listModel);
        appointmentList.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        JScrollPane scrollPane = new JScrollPane(appointmentList);

        JButton removeButton = new JButton("Remove Selected");

        // Combine search, list, and remove button
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));

        centerPanel.add(searchPanel, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.add(removeButton, BorderLayout.SOUTH);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        add(mainPanel);

        // Button actions
        addButton.addActionListener(e -> addAppointment());
        viewButton.addActionListener(e -> viewAppointments());
        removeButton.addActionListener(e -> removeAppointment());

        setVisible(true);
    }

    // Add an appointment using the input fields
    private void addAppointment() {

        try {
            String description = descriptionField.getText().trim();

            if (description.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this, "Please enter a description."
                );
                return;
            }

            LocalDate date = LocalDate.parse(
                    dateField.getText().trim()
            );

            LocalTime startTime = LocalTime.parse(
                    startField.getText().trim()
            );

            LocalTime endTime = LocalTime.parse(
                    endField.getText().trim()
            );

            if (!endTime.isAfter(startTime)) {
                JOptionPane.showMessageDialog(
                        this, "End time must be after start time."
                );
                return;
            }

            Appointment appointment = new Appointment(
                    description, date, startTime, endTime
            );

            calendar.addAppointment(appointment);

            JOptionPane.showMessageDialog(
                    this, "Appointment added successfully."
            );

            descriptionField.setText("");
            searchDateField.setText(date.toString());

            viewAppointments();

        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Invalid date or time format.\n" +
                            "Date: YYYY-MM-DD\nTime: HH:MM"
            );
        }
    }

    // Show appointments for the selected date
    private void viewAppointments() {

        try {
            LocalDate date = LocalDate.parse(
                    searchDateField.getText().trim()
            );

            ArrayList<Appointment> appointments =
                    calendar.getAppointmentsByDate(date);

            listModel.clear();

            for (Appointment appointment : appointments) {
                listModel.addElement(appointment);
            }

        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(
                    this, "Please enter a valid search date."
            );
        }
    }

    // Remove the selected appointment
    private void removeAppointment() {

        Appointment selected = appointmentList.getSelectedValue();

        if (selected == null) {
            JOptionPane.showMessageDialog(
                    this, "Please select an appointment to remove."
            );
            return;
        }

        int confirmation = JOptionPane.showConfirmDialog(
                this,
                "Remove this appointment?",
                "Confirm Removal",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmation == JOptionPane.YES_OPTION) {
            calendar.removeAppointment(selected);
            viewAppointments();
        }
    }
}
