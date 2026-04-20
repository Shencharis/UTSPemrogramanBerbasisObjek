public class Buku {
    private String judul;
    private boolean tersedia;

    // Constructor
    public Buku(String judul) {
        this.judul = judul;
        this.tersedia = true;
    }

    public String getJudul() {
        return judul;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }
}