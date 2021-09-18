public class Student {

    private int id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static String URL = "https://demoqa.com/automation-practice-form";

    public static int EXPECTED_ID = 1005;

    public static String EXPECTED_FIRSTNAME = "Jack";

    public static String EXPECTED_UPDATEDFIRSTNAME = "Daniel";

    public static String EXPECTED_LASTNAME = "Connor";

    public static String EXPECTED_PHONE = "5568578967";
}
