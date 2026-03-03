package academic.driver;
import academic.model.Student; // Mengimpor kelas Student

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @author 12S24044 Dianita Lorensia Br Ginting
 */

public class Driver2 {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

       

        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            
            // Menghentikan input jika baris adalah "---"
            if (line.trim().equals("---")) { 
                break; 
            }

            // Memproses input dengan pemisah '#'
            String[] parts = line.split("#");
            if (parts.length == 4) {
                try {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String year = parts[2].trim();
                    String studyProgram = parts[3].trim();

                    // Membuat objek Student dan menambahkannya ke daftar
                    Student newStudent = new Student(id, name, year, studyProgram);
                    students.add(newStudent);
                    // System.out.println("Mahasiswa berhasil ditambahkan: " + newStudent); // Opsional: Konfirmasi penambahan
                } catch (Exception e) {
                    System.err.println("Error memproses input '" + line + "': " + e.getMessage());
                }
            } else {
                System.err.println("Error: Format input tidak valid. Harap gunakan: ID#Nama#TahunMasuk#ProgramStudi. Input '" + line + "' diabaikan.");
            }
        }

  
        if (students.isEmpty()) {
            System.out.println("Belum ada mahasiswa yang ditambahkan.");
        } else {
            for (Student student : students) {
                System.out.println(student); // Menggunakan method toString() dari kelas Student
            }
        }

        scanner.close(); // Menutup scanner

    }
}