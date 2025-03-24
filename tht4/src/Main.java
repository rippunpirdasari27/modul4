public class Produk {
    String kodeProduk, namaProduk;
    double harga;
    int stok;

    public Produk(String kodeProduk, String namaProduk, double harga, int stok) {
        this.kodeProduk = kodeProduk;
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.stok = stok;
    }

    public void tampilkanInfoProduk() {
        System.out.println("kodeProduk: " +kodeProduk);
        System.out.println("namaProduk: " +namaProduk);
        System.out.println("harga: " +harga);
        System.out.println("stok: " +stok);
    }

    public boolean kurangiStok(int jumlah) {
        if (stok >= jumlah) {
            stok -= jumlah;
            return true;
        }
        return false;
    }

    public double getHarga() { return harga; }
    public String getNamaProduk() { return namaProduk; }
}

class Pelanggan {
    private String idPelanggan, nama, email;
    private double saldo;

    public Pelanggan(String idPelanggan, String nama, String email, double saldo) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.email = email;
        this.saldo = saldo;
    }

    public void tampilkanInfoPelanggan() {
        System.out.println("idPelanggan: " +idPelanggan);
        System.out.println("nama: " +nama);
        System.out.println("email: " +email);
        System.out.println("saldo " +saldo);
    }

    public void topUpSaldo(double jumlah) { saldo += jumlah; }

    public boolean kurangiSaldo(double jumlah) {
        if (saldo >= jumlah) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }

    public String getNama() { return nama; } 
}

class Transaksi {
    String idTransaksi;
    Pelanggan pelanggan;
    Produk produk;
    int jumlahBeli;
    double totalHarga;

    public Transaksi(String idTransaksi, Pelanggan pelanggan, Produk produk, int jumlahBeli) {
        this.idTransaksi = idTransaksi;
        this.pelanggan = pelanggan;
        this.produk = produk;
        this.jumlahBeli = jumlahBeli;
        this.totalHarga = produk.getHarga() * jumlahBeli;
        
        if (produk.kurangiStok(jumlahBeli) && pelanggan.kurangiSaldo(totalHarga)) {
            System.out.println("Transaksi Berhasil: " + pelanggan.getNama() + " membeli " + jumlahBeli + " " + produk.getNamaProduk());
        } else {
            System.out.println("Transaksi Gagal: Saldo tidak cukup atau stok habis.");
        }
    }
}

public class Main {
    
    public static void main(String[] args) {
        Produk p1 = new Produk("P001", "printer", 7500000, 5);
        Produk p2 = new Produk("P002", "Mouse", 150000, 10);
        Pelanggan c1 = new Pelanggan("C001", "rippun", "rpn@email.com", 8000000);

        p1.tampilkanInfoProduk();
        p2.tampilkanInfoProduk();
        c1.tampilkanInfoPelanggan();
        
        new Transaksi("T001", c1, p1, 1);
        
        c1.tampilkanInfoPelanggan();
        p1.tampilkanInfoProduk();
    }
}
