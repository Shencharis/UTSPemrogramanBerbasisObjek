import java.util.ArrayList;

public class Perpustakaan {
    private ArrayList<Buku> daftarBuku;

    // Constructor
    public Perpustakaan() {
        daftarBuku = new ArrayList<>();
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public void tampilkanBuku() {
        System.out.println("Daftar Buku:");
        for (Buku buku : daftarBuku) {
            System.out.println("- " + buku.getJudul() +
                    (buku.isTersedia() ? " (Tersedia)" : " (Dipinjam)"));
        }
    }

    public void tambahBuku(Buku[] listBuku) {
        for (Buku b : listBuku) {
            daftarBuku.add(b);
        }
    }

    public void pinjamBuku(User user, Buku buku) {
        if (user.isDiblokir()) {
            System.out.println("User sedang diblokir, tidak bisa meminjam.");
            return;
        }

        if (user.getJumlahPinjam() >= 2) {
            System.out.println("Limit peminjaman tercapai (maks 2 buku).");
            return;
        }

        if (!buku.isTersedia()) {
            System.out.println("Buku sedang tidak tersedia.");
            return;
        }

        buku.setTersedia(false);
        user.tambahPinjam();

        System.out.println(user.getNama() + " berhasil meminjam buku: " + buku.getJudul());
    }

    public void kembaliBuku(User user, Buku buku, boolean telat) {
        buku.setTersedia(true);
        user.kurangiPinjam();

        System.out.println(user.getNama() + " mengembalikan buku: " + buku.getJudul());

        if (telat) {
            user.setDiblokir(true);
            System.out.println("User terlambat! Status diblokir.");
        }
    }
}