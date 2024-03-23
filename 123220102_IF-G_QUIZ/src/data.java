import java.util.Scanner;

class dataMahasiswa {

    private final String nim;
    private final String nama;
    private final double tugas;
    private final double kuis;
    private final String divisi;

    public dataMahasiswa(String nim, String nama, double tugas, double kuis, String divisi) {
        this.nim = nim;
        this.nama = nama;
        this.tugas = tugas;
        this.kuis = kuis;
        this.divisi = divisi;
    }

    public void hitungHasil() {
        double rataRata;
        if (divisi.equalsIgnoreCase("Kelas Praktikum")) {
            rataRata = (this.kuis * 0.7) + (this.tugas * 0.3);
        } else {
            rataRata = (this.kuis * 0.3) + (this.tugas * 0.7);
        }
        String hasil = (rataRata >= 85) ? "Pass" : "Tidak Pass";
        System.out.println("Hasil: " + hasil);
    }

    public void tampilkanInfo() {
        System.out.println("NIM: " + this.nim);
        System.out.println("Nama: " + this.nama);
        System.out.println("Divisi: " + this.divisi);
        System.out.println("Nilai Tugas: " + this.tugas);
        System.out.println("Nilai Kuis: " + this.kuis);
    }
}

public class data {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean lanjut = true;
        while (lanjut) {
            System.out.println("\nPilih Kelas :");
            System.out.println("1. Kelas Praktikum");
            System.out.println("2. Kelas Teori");
            System.out.println("3. Keluar");
            System.out.println("Masukkan pilihan (1/2/3): ");
            int divisi = scanner.nextInt();
            switch (divisi) {
                case 1:
                    System.out.println("Masukkan NIM :");
                    String nim1 = scanner.next();
                    System.out.println("Masukkan Nama :");
                    String nama1 = scanner.next();
                    System.out.println("Masukkan nilai tugas :");
                    double tugas1 = scanner.nextDouble();
                    System.out.println("Masukkan nilai kuis :");
                    double kuis1 = scanner.nextDouble();

                    dataMahasiswa mhs1 = new dataMahasiswa(nim1, nama1, tugas1, kuis1, "Kelas Praktikum");
                    mhs1.tampilkanInfo();
                    mhs1.hitungHasil();

                    break;
                case 2:
                    System.out.println("\nKelas Teori");
                    System.out.println("Masukkan NIM :");
                    String nim2 = scanner.next();
                    System.out.println("Masukkan Nama :");
                    String nama2 = scanner.next();
                    System.out.println("Masukkan nilai tugas :");
                    double tugas2 = scanner.nextDouble();
                    System.out.println("Masukkan nilai kuis :");
                    double kuis2 = scanner.nextDouble();

                    dataMahasiswa mhs2 = new dataMahasiswa(nim2, nama2, tugas2, kuis2, "Kelas Teori");
                    mhs2.tampilkanInfo();
                    mhs2.hitungHasil();

                    break;
                case 3:
                    lanjut = false;
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
            }
        }
    }
}
