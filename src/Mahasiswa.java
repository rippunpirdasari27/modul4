public class Mahasiswa {

    String nama;
    String nim;
    String jurusan;
    boolean islulus = false;
    static int angkatan = 2019;

    //Atribut
    Mahasiswa(String nama, String nim, String jurusan){
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }
    //method/function
    void belajar(){
        System.out.println(nama + " sedang belajar");
    }
    String getnama(){
        return nama;
    }
//classdalam
    class dalam{
        void test(){
            System.out.println("iniadalahinnerclass");
        }
    }

    static void kuliah(){
        System.out.println(" Mahasiswa sedang kuliah");
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
