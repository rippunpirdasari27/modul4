class Mobil {
    String nomorPlat, merek;
     double hargaSewa;
    boolean tersedia;

    public Mobil(String nomorPlat, String merek, double hargaSewa) {
        this.nomorPlat = nomorPlat;
        this.merek = merek;
        this.hargaSewa = hargaSewa;
        this.tersedia = true;
    }

    public void tampilkanInfo() {
        System.out.println(nomorPlat + " - " + merek + " - Rp " + (int)hargaSewa + " - " + (tersedia ? "Tersedia" : "Tidak"));
    }

    public boolean isTersedia() { return tersedia; }
    public void setTersedia(boolean tersedia) { this.tersedia = tersedia; }
    public double getHargaSewa() { return hargaSewa; }
    public String getNomorPlat() { return nomorPlat; }
}

class Pelanggan {
    private String nama, ktp, hp;
    public Pelanggan(String nama, String ktp, String hp) {
        this.nama = nama; this.ktp = ktp; this.hp = hp;
    }
    public void tampilkanInfo() {
        System.out.println("Nama: " + nama + ", KTP: " + ktp + ", HP: " + hp);
    }
}

class Sewamobil {
    public Sewamobil(Pelanggan pelanggan, Mobil mobil, int hari) {
        System.out.println(" STRUK PENYEWAAN ");
        pelanggan.tampilkanInfo();
        if (mobil.isTersedia()) {
            mobil.setTersedia(false);
            double total = (hari > 5) ? mobil.getHargaSewa() * hari * 0.9 : mobil.getHargaSewa() * hari;
            System.out.println("Mobil: " + mobil.getNomorPlat());
            System.out.println("Lama Sewa: " + hari + " hari");
            System.out.println("Total: Rp " + (int)total);
        } else {
            System.out.println("Penyewaan gagal: Mobil tidak tersedia");
        }

    }
}

public class Main {
    public static void main(String[] args) {
        Mobil m1 = new Mobil("B 1234 XY", "bmw", 300000);
        Mobil m2 = new Mobil("D 5678 ZZ", "portuner", 350000);
        Pelanggan p1 = new Pelanggan("Andi", "1234567890", "081234567890");
        
        m1.tampilkanInfo();
        m2.tampilkanInfo();
        
        new Sewamobil(p1, m1, 6);
        m1.tampilkanInfo();
    }
}
