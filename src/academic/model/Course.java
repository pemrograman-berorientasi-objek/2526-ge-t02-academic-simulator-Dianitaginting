package academic.model;

/**
 * @author 12S24044 Dianita Lorensia Br Ginting
 */

public class Course {
    private String code;
    private String name;
    private int credits;
    private String grade; // Tipe data String untuk nilai huruf

    /**
     * Konstruktor untuk membuat objek Course baru.
     *
     * @param code Kode unik mata kuliah.
     * @param name Nama lengkap mata kuliah.
     * @param credits Jumlah Satuan Kredit Semester (SKS) mata kuliah.
     * @param grade Nilai huruf yang diperoleh dalam mata kuliah.
     */
    public Course(String code, String name, int credits, String grade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    // --- Getters ---

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getGrade() {
        return grade;
    }

    /**
     * Mengembalikan representasi String dari objek Course.
     * Format: [Kode Mata Kuliah]|[Nama Mata Kuliah]|[SKS]|[Nilai]
     *
     * @return String representasi Course.
     */
    @Override
    public String toString() {
        return String.format("%s|%s|%d|%s", code, name, credits, grade);
    }
}