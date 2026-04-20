import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Perpustakaan perpus = new Perpustakaan();

        // Data buku
        Buku b1 = new Buku("1. Belajar Koding untuk Pemula");
        Buku b2 = new Buku("2. Dasar dasar bahasa C++");
        Buku b3 = new Buku("3. Koding tingkat lanjut");
        Buku b4 = new Buku("4. Kalkulus 1");
        Buku b5 = new Buku("5. Kalkulus 2");

        Buku[] daftarBukuBaru = {b1, b2, b3, b4, b5};
        perpus.tambahBuku(daftarBukuBaru);

        ArrayList<User> daftarUser = new ArrayList<>(); 
        daftarUser.add(new Mahasiswa("Shenry"));
        daftarUser.add(new Mahasiswa("Charissa"));
        daftarUser.add(new Dosen("Bu Lia"));

        int pilihan;

        do {
            System.out.println("\n=== MENU PERPUSTAKAAN ===");
            System.out.println("1. Tampilkan Buku");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Kembalikan Buku");
            System.out.println("4. Aktifkan Status User");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    perpus.tampilkanBuku();
                    break;

                case 2:                    
                    System.out.println("User:");
                    for (int i = 0; i < daftarUser.size(); i++) {
                        User u = daftarUser.get(i);
                        System.out.println((i+1) + ". " + u.getNama() + " [" + u.getTipeUser() + "]");
                    }
                    System.out.print("Pilih User: ");

                    int pilihUser = input.nextInt();
                    User userAktif = daftarUser.get(pilihUser - 1);
                                
                    perpus.tampilkanBuku();
                    System.out.print("Pilih nomor buku : ");
                    int pilihPinjam = input.nextInt();

                    if (pilihPinjam == 1) perpus.pinjamBuku(userAktif, b1);
                    else if (pilihPinjam == 2) perpus.pinjamBuku(userAktif, b2);
                    else if (pilihPinjam == 3) perpus.pinjamBuku(userAktif, b3);
                    else if (pilihPinjam == 4) perpus.pinjamBuku(userAktif, b4);
                    else if (pilihPinjam == 5) perpus.pinjamBuku(userAktif, b5);
                    else System.out.println("Pilihan tidak valid");
                    break;

                case 3:
                    System.out.println("User:");
                    for (int i = 0; i < daftarUser.size(); i++) {
                        User u = daftarUser.get(i);
                        System.out.println((i+1) + ". " + u.getNama() + " [" + u.getTipeUser() + "]");
                    }
                    System.out.print("Pilih User: ");

                    int pilihUser2 = input.nextInt();
                    User userAktif2 = daftarUser.get(pilihUser2 - 1);
            
                    perpus.tampilkanBuku();
                    System.out.print("Pilih nomor buku : ");
                    int pilihKembali = input.nextInt();

                    System.out.print("Apakah telat? (ya/tidak): ");
                    String inputTelat = input.next();
                    boolean telat = inputTelat.equalsIgnoreCase("ya");

                    if (pilihKembali == 1) perpus.kembaliBuku(userAktif2, b1, telat);
                    else if (pilihKembali == 2) perpus.kembaliBuku(userAktif2, b2, telat);
                    else if (pilihKembali == 3) perpus.kembaliBuku(userAktif2, b3, telat);
                    else if (pilihKembali == 4) perpus.kembaliBuku(userAktif2, b4, telat);
                    else if (pilihKembali == 5) perpus.kembaliBuku(userAktif2, b5, telat);
                    else System.out.println("Pilihan tidak valid");
                    break;

                case 4:
                    System.out.println("Status User:");
                    for (int i = 0; i < daftarUser.size(); i++) {
                        String status = daftarUser.get(i).isDiblokir() ? "[DIBLOKIR]" : "[AKTIF]";
                        System.out.println((i+1) + ". " + daftarUser.get(i).getNama() + " " + status);
                    }
                    System.out.print("Pilih User: ");
                    int pilihUnblokir = input.nextInt();
                    User userUnblokir = daftarUser.get(pilihUnblokir - 1);
                    

                    if (userUnblokir.isDiblokir()) {
                        userUnblokir.setDiblokir(false);
                        System.out.println(userUnblokir.getNama() + " berhasil diaktifkan.");
                    } else {
                        System.out.println(userUnblokir.getNama() + " tidak sedang diblokir.");
                    }
                    break;
                
                case 5:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }

        } while (pilihan != 5);

        input.close();
    }
}