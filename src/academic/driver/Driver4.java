package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 12S24044 Dianita lorensia Br Ginting
 
 */


/**
 * Kelas Driver4 adalah kelas utama untuk menjalankan program demonstrasi
 * penambahan dan pengelolaan data terintegrasi untuk mata kuliah, mahasiswa,
 * dan pendaftaran (enrollment).
 * Kelas ini akan membaca input dengan prefiks ('course-add', 'student-add', 'enrollment-add'),
 * menyimpan data di list yang sesuai, dan menampilkannya dengan urutan Course, Student, Enrollment.
 * Input menggunakan '#' sebagai pemisah dan diakhiri dengan baris "---".
 * Output menggunakan '|' sebagai pemisah, dengan nilai default "None" untuk grade enrollment.
 */
public class Driver4 {

    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>();
        
        Scanner scanner = new Scanner(System.in);



        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            
            // Menghentikan input jika baris adalah "---"
            if (line.trim().equals("---")) { 
                break; 
            }

            // Memproses input
            String[] parts = line.split("#");
            if (parts.length > 0) {
                String command = parts[0].trim();
                String[] dataParts = new String[parts.length - 1];
                System.arraycopy(parts, 1, dataParts, 0, parts.length - 1);

                try {
                    switch (command) {
                        case "course-add":
                            if (dataParts.length == 4) {
                                String code = dataParts[0].trim();
                                String name = dataParts[1].trim();
                                int credits = Integer.parseInt(dataParts[2].trim());
                                String grade = dataParts[3].trim();
                                courses.add(new Course(code, name, credits, grade));
                            } else {
                                System.err.println("Error: Format 'course-add' tidak valid. Input '" + line + "' diabaikan.");
                            }
                            break;
                        case "student-add":
                            if (dataParts.length == 4) {
                                String id = dataParts[0].trim();
                                String name = dataParts[1].trim();
                                String year = dataParts[2].trim();
                                String studyProgram = dataParts[3].trim();
                                students.add(new Student(id, name, year, studyProgram));
                            } else {
                                System.err.println("Error: Format 'student-add' tidak valid. Input '" + line + "' diabaikan.");
                            }
                            break;
                        case "enrollment-add":
                            if (dataParts.length == 4) {
                                String courseCode = dataParts[0].trim();
                                String studentId = dataParts[1].trim();
                                String academicYear = dataParts[2].trim();
                                String semester = dataParts[3].trim();
                                enrollments.add(new Enrollment(courseCode, studentId, academicYear, semester));
                            } else {
                                System.err.println("Error: Format 'enrollment-add' tidak valid. Input '" + line + "' diabaikan.");
                            }
                            break;
                        default:
                            System.err.println("Error: Perintah tidak dikenal '" + command + "'. Input '" + line + "' diabaikan.");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error: Nilai numerik tidak valid. Input '" + line + "' diabaikan. Detail: " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("Error memproses input '" + line + "': " + e.getMessage());
                }
            } else {
                System.err.println("Error: Format input kosong atau tidak valid. Input '" + line + "' diabaikan.");
            }
        }

        
        // Output Courses
        if (!courses.isEmpty()) {
            for (Course course : courses) {
                System.out.println(course);
            }
        }

        // Output Students
        if (!students.isEmpty()) {
            for (Student student : students) {
                System.out.println(student);
            }
        }
        
        // Output Enrollments
        if (!enrollments.isEmpty()) {
            for (Enrollment enrollment : enrollments) {
                System.out.println(enrollment);
            }
        }
        
        if (courses.isEmpty() && students.isEmpty() && enrollments.isEmpty()) {
            System.out.println("Belum ada data yang ditambahkan.");
        }

        scanner.close(); // Menutup scanner
    }
}