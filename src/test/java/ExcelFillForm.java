import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Test
public class ExcelFillForm {

    @Test
    public static void retrieveStudentsAndFillFormTest() throws IOException {
        List<Student> students = getExcelValues();

        for (Student student: students) {
            fillForm(student);
        }
    }


    private static List<Student> getExcelValues() throws IOException {

        List<Student> students = new ArrayList<Student>();

        File src = new File("C:\\EXCELINFO\\Information.xlsx");
        FileInputStream fls = new FileInputStream(src);
        XSSFWorkbook workbook = new XSSFWorkbook(fls);

        XSSFSheet firstSheet = workbook.getSheetAt(0);

        Student student = new Student();

        String firstRowfirstName = firstSheet.getRow(0).getCell(0).getStringCellValue();
        String firstRowlastName = firstSheet.getRow(0).getCell(1).getStringCellValue();
        int number = (int) firstSheet.getRow(0).getCell(2).getNumericCellValue();
        String firstRowtoStringNumber = Integer.toString(number);

        String secondRowFirstName = firstSheet.getRow(1).getCell(0).getStringCellValue();
        String secondRowlastName = firstSheet.getRow(1).getCell(1).getStringCellValue();
        int secondNumber = (int) firstSheet.getRow(1).getCell(2).getNumericCellValue();
        String secondRowToStringNumber = Integer.toString(number);

        student.setFirstName(firstRowfirstName);
        student.setLastName(firstRowlastName);
        student.setPhoneNumber(firstRowtoStringNumber);

        student.setFirstName(secondRowFirstName);
        student.setLastName(secondRowlastName);
        student.setPhoneNumber(secondRowToStringNumber);

        students.add(student);
        for (Student student1: students) {
            fillForm(student1);
        }
        return students;
    }
    

    private static void fillForm(Student student) {
        open("https://demoqa.com/automation-practice-form");

        $(By.id("firstName")).sendKeys(student.getFirstName());
        $(By.id("lastName")).sendKeys(student.getLastName());
        $(By.id("userNumber")).sendKeys(student.getPhoneNumber());
        $(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")).click();
    }

}
