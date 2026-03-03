package academic.model;

/**
 * @author 12S24044 Dianita Lorensia Br Ginting


/**
 * Kelas Student merepresentasikan seorang mahasiswa dalam sistem akademik.
 * Menyimpan informasi ID, nama, tahun masuk, dan program studi.
 */
public class Student { // <<< Pastikan baris ini ada dan benar
    private String id;
    private String name;
    private String year; // Tahun masuk
    private String studyProgram; // Program Studi

    /**
     * Konstruktor untuk membuat objek Student baru.
     *
     * @param id ID unik mahasiswa.
     * @param name Nama lengkap mahasiswa.
     * @param year Tahun masuk mahasiswa.
     * @param studyProgram Program studi yang diambil mahasiswa.
     */
    public Student(String id, String name, String year, String studyProgram) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.studyProgram = studyProgram;
    }

    // --- Getters ---

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    // --- Setters (Jika diperlukan, bisa ditambahkan) ---
    // public void setId(String id) { this.id = id; }
    // public void setName(String name) { this.name = name; }
    // public void setYear(String year) { this.year = year; }
    // public void setStudyProgram(String studyProgram) { this.studyProgram = studyProgram; }

    /**
     * Mengembalikan representasi String dari objek Student.
     * Format: [ID Mahasiswa]|[Nama Mahasiswa]|[Tahun Masuk]|[Program Studi]
     *
     * @return String representasi Student.
     */
    @Override
    public String toString() {
        return String.format("%s|%s|%s|%s", id, name, year, studyProgram);
    }
}