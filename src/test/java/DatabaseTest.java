import com.google.common.annotations.VisibleForTesting;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


@Test
public class DatabaseTest {

    @Test
    public static void retrieveStudentsAndFillFormTest() throws SQLException {
        List<Student> students = getStudents();

        String answer = getLastname(students);
        System.out.println(answer);

    }

    private static List<Student> getStudents() throws SQLException {
        List<Student> students = new ArrayList<>();

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:1433/homework", "root", "");
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM students");


        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt(1));
            student.setFirstName(resultSet.getString(2));
            student.setLastName(resultSet.getString(3));
            student.setPhoneNumber(resultSet.getString(4));

            students.add(student);
        }
        con.close();
        return students;
    }

    private static String getLastname(List<Student> students) {
        String answer = "";
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == 1005) {
                answer = students.get(i).getLastName();
            }
        }
        return answer;
    }
}
