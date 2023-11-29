/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.tahap.pkg2;

/**
 *
 * @author ACER
 */
import java.util.Scanner;
public class PBOTahap2 {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input untuk Admin
        System.out.print("Masukkan ID Admin: ");
        int idAdmin = scanner.nextInt();
        System.out.print("Masukkan Nama Admin: ");
        String namaAdmin = scanner.next();
        System.out.print("Masukkan Alamat Admin: ");
        String alamatAdmin = scanner.next();
        Admin admin = new Admin(idAdmin, namaAdmin, alamatAdmin);

        // Input untuk AnggotaPerpustakaan
        System.out.print("Masukkan ID Anggota: ");
        int idAnggota = scanner.nextInt();
        System.out.print("Masukkan Nama Anggota: ");
        String namaAnggota = scanner.next();
        System.out.print("Masukkan Alamat Anggota: ");
        String alamatAnggota = scanner.next();
        AnggotaPerpustakaan anggota = new AnggotaPerpustakaan(idAnggota, namaAnggota, alamatAnggota);

        // Input untuk Buku
        System.out.print("Masukkan ID Buku: ");
        int idBuku = scanner.nextInt();
        System.out.print("Masukkan Judul Buku: ");
        String judulBuku = scanner.next();
        System.out.print("Masukkan Pengarang Buku: ");
        String pengarangBuku = scanner.next();
        System.out.print("Masukkan ISBN Buku: ");
        String isbnBuku = scanner.next();
        System.out.print("Apakah Buku Tersedia? (true/false): ");
        boolean ketersediaanBuku = scanner.nextBoolean();
        Buku buku = new Buku(idBuku, judulBuku, pengarangBuku, isbnBuku, ketersediaanBuku);

        // Input untuk TransaksiPeminjaman
        System.out.print("Masukkan Tanggal Peminjaman (YYYY-MM-DD): ");
        String tanggalPinjam = scanner.next();
        TransaksiPeminjaman transaksiPinjam = new TransaksiPeminjaman(anggota, buku, tanggalPinjam);

        // Input untuk TransaksiPengembalian
        System.out.print("Masukkan Tanggal Pengembalian (YYYY-MM-DD): ");
        String tanggalKembali = scanner.next();
        System.out.print("Masukkan Jumlah Denda: ");
        System.out.println("");
        double denda = scanner.nextDouble();
        TransaksiPengembalian transaksiKembali = new TransaksiPengembalian(anggota, buku, tanggalKembali, denda);

        // Menampilkan representasi string dari setiap objek
        System.out.println("\nAdmin: " + admin);
        System.out.println("\nAnggota Perpustakaan: " + anggota);
        System.out.println("\nBuku: " + buku);
        System.out.println("\nTransaksi Peminjaman: " + transaksiPinjam);
        System.out.println("\nTransaksi Pengembalian: " + transaksiKembali);

        // Menutup scanner
        scanner.close();
    }    
}
