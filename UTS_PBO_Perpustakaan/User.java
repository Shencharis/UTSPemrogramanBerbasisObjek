public class User {
    private String nama;
    private int jumlahPinjam;
    private boolean diblokir;

    // Constructor
    public User(String nama) {
        this.nama = nama;
        this.jumlahPinjam = 0;
        this.diblokir = false;
    }

    public String getNama() {
        return nama;
    }

    public int getJumlahPinjam() {
        return jumlahPinjam;
    }

    public boolean isDiblokir() {
        return diblokir;
    }

    public void tambahPinjam() {
        jumlahPinjam++;
    }

    public void kurangiPinjam() {
        if (jumlahPinjam > 0) {
            jumlahPinjam--;
        }
    }

    public void setDiblokir(boolean status) {
        this.diblokir = status;
    }
}