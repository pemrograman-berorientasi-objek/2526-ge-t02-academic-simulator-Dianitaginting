package academic.driver;

import academic.model.Enrollment; // Mengimpor kelas Enrollment

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @author 12S24044 Dianita Lorensia Br Ginting
 */


/**
 * Kelas Driver3 adalah kelas utama untuk menjalankan program demonstrasi
 * penambahan dan pengelolaan data pendaftaran mata kuliah (enrollment).
 * Kelas ini akan membaca input enrollment, menyimpan, dan menampilkannya.
 * Input menggunakan '#' sebagai pemisah dan diakhiri dengan baris "---".
 * Output menggunakan '|' sebagai pemisah, dengan nilai default "None" untuk grade.
 */
public class Driver3 {

    public static void main(String[] args) {
        List<Enrollment> enrollments = new ArrayList<>();
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
            if (parts.length == 4) { // Diharapkan 4 bagian: courseCode, studentId, academicYear, semester
                try {
                    String courseCode = parts[0].trim();
                    String studentId = parts[1].trim();
                    String academicYear = parts[2].trim();
                    String semester = parts[3].trim();

                    // Membuat objek Enrollment dan menambahkannya ke daftar
                    Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                    enrollments.add(newEnrollment);
                    // System.out.println("Pendaftaran berhasil ditambahkan: " + newEnrollment); // Opsional: Konfirmasi penambahan
                } catch (Exception e) {
                    System.err.println("Error memproses input '" + line + "': " + e.getMessage());
                }
            } else {
                System.err.println("Error: Format input tidak valid. Harap gunakan: KodeMK#IDMahasiswa#TahunAkademik#Semester. Input '" + line + "' diabaikan.");
            }
        }

       
        if (enrollments.isEmpty()) {
            System.out.println("Belum ada pendaftaran yang ditambahkan.");
        } else {
            for (Enrollment enrollment : enrollments) {
                System.out.println(enrollment); // Menggunakan method toString() dari kelas Enrollment
            }
        }

        scanner.close(); // Menutup scanner
       
    }
}

