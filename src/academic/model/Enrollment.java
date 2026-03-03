package academic.model;

/**
 * @author 12S24044 Dianita Lorensia Br Ginting
 */

 

/**
 * Kelas Enrollment merepresentasikan pendaftaran mahasiswa pada suatu mata kuliah
 * dalam sistem akademik.
 * Menyimpan informasi kode mata kuliah, ID mahasiswa, tahun akademik, semester,
 * dan nilai (secara default "None" jika belum ada).
 */
public class Enrollment {
    private String courseCode;
    private String studentId;
    private String academicYear;
    private String semester;
    private String grade; // Default "None"

    /**
     * Konstruktor untuk membuat objek Enrollment baru.
     *
     * @param courseCode Kode unik mata kuliah yang didaftarkan.
     * @param studentId ID unik mahasiswa yang mendaftar.
     * @param academicYear Tahun akademik pendaftaran (contoh: 2021/2022).
     * @param semester Semester pendaftaran (contoh: "even" atau "odd").
     */
    public Enrollment(String courseCode, String studentId, String academicYear, String semester) {
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None"; // Nilai default saat pendaftaran
    }

    // --- Getters ---

    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public String getGrade() {
        return grade;
    }

    // --- Setters (Jika diperlukan, bisa ditambahkan, contoh untuk set grade) ---
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * Mengembalikan representasi String dari objek Enrollment.
     * Format: [Kode MK]|[ID Mhs]|[Tahun Akademik]|[Semester]|[Nilai]
     *
     * @return String representasi Enrollment.
     */
    @Override
    public String toString() {
        return String.format("%s|%s|%s|%s|%s", courseCode, studentId, academicYear, semester, grade);
    }
}