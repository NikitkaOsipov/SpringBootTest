package rvt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class CsvManager {
    public static final String file = "/workspaces/SpringBootTest/src/main/resources/data/students.csv";
    private InputStream is;

    public CsvManager(String file) {
        this.is = CsvManager.class.getClassLoader().getResourceAsStream(file);
    }

    public ArrayList<Student> getListFromFile() {
        ArrayList<Student> students = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(CsvManager.file))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parametrs = line.split(", ");
                students.add(new Student(parametrs[0], parametrs[1], parametrs[2], parametrs[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }

    public void saveNewStudent(Student student) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CsvManager.file, true))){
            bw.write("\n" +student.getName() + ", " + student.getSurname() + ", " + student.getEmail() + ", " + student.getGroup());
        } catch (IOException e){
            System.out.println("ERROR");
        }
    }
}