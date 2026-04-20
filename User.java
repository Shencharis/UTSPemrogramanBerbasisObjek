public abstract class User { // Abstract agar tidak bisa di-instantiate langsung
    protected String nama;
    protected int jumlahPinjam;
    protected boolean diblokir;

    public User(String nama) {
        this.nama = nama;
        this.jumlahPinjam = 0;
        this.diblokir = false;
    }

    public String getNama() { return nama; }
    public int getJumlahPinjam() { return jumlahPinjam; }
    public boolean isDiblokir() { return diblokir; }
    
    public void tambahPinjam() { jumlahPinjam++; }
    public void kurangiPinjam() { if (jumlahPinjam > 0) jumlahPinjam--; }
    public void setDiblokir(boolean status) { this.diblokir = status; }

    public abstract String getTipeUser();
}

class Mahasiswa extends User {
    public Mahasiswa(String nama) {
        super(nama);
    }
    @Override
    public String getTipeUser() { return "Mahasiswa"; }
}

class Dosen extends User {
    public Dosen(String nama) {
        super(nama);
    }
    @Override
    public String getTipeUser() { return "Dosen"; }
}