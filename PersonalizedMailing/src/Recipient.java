// Define recipient class with known attributes to be derived from text file
public class Recipient {

    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String method;

    public Recipient(
            String title,
            String firstName,
            String lastName,
            String email,
            String address,
            String method) {

        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.method = method;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getMethod() {
        return method;
    }
}