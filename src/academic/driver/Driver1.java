package academic.driver;

import academic.model.Course; // Mengimpor kelas Course

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 12S24044 Dianita Lorensia Br Ginting
 */
public class Driver1 {

      public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
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
                    String code = parts[0].trim();
                    String name = parts[1].trim();
                    int credits = Integer.parseInt(parts[2].trim());
                    String grade = parts[3].trim();

                    // Membuat objek Course dan menambahkannya ke daftar
                    Course newCourse = new Course(code, name, credits, grade);
                    courses.add(newCourse);
                    // System.out.println("Mata kuliah berhasil ditambahkan: " + newCourse); // Opsional: Konfirmasi penambahan
                } catch (NumberFormatException e) {
                    System.err.println("Error: SKS harus berupa angka. Input '" + line + "' diabaikan.");
                } catch (Exception e) {
                    System.err.println("Error memproses input '" + line + "': " + e.getMessage());
                }
            } else {
                System.err.println("Error: Format input tidak valid. Harap gunakan: Kode#Nama#SKS#Nilai. Input '" + line + "' diabaikan.");
            }
        }

        if (courses.isEmpty()) {
            System.out.println("Belum ada mata kuliah yang ditambahkan.");
        } else {
            for (Course course : courses) {
                System.out.println(course); // Menggunakan method toString() dari kelas Course
            }
        }

        scanner.close(); // Menutup scanner
    }
}