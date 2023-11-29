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
import java.util.ArrayList;
import java.util.List;

class Admin {
    private int idAdmin;
    private String nama;
    private String alamat;
    private List<Notifikasi> daftarNotifikasi = new ArrayList<>();
    private List<AnggotaPerpustakaan> daftarAnggota = new ArrayList<>();

    public Admin(int idAdmin, String nama, String alamat) {
        this.idAdmin = idAdmin;
        this.nama = nama;
        this.alamat = alamat;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public List<Notifikasi> getDaftarNotifikasi() {
        return daftarNotifikasi;
    }

    public List<AnggotaPerpustakaan> getDaftarAnggota() {
        return daftarAnggota;
    }

    public void aksesNotifikasi() {
        // Implementasi logika untuk mengakses notifikasi
    }

    public void kirimNotifikasi(AnggotaPerpustakaan penerima, String isiPesan) {
        Notifikasi notifikasi = new Notifikasi(909, penerima, isiPesan, true);
        daftarNotifikasi.add(notifikasi);
    }

    public void kelolaAnggota(AnggotaPerpustakaan anggota) {
        daftarAnggota.add(anggota);
    }

    public void mengirimBuku(AnggotaPerpustakaan anggota, Buku buku) {
        // Implementasi logika untuk mengirim buku kepada anggota
    }

    @Override
    public String toString() {
        return "\n Admin{idAdmin=" + idAdmin + ",\n nama='" + nama + "',\n alamat='" + alamat + "'}";
    }
}

class Notifikasi {
    private int idNotifikasi;
    private AnggotaPerpustakaan penerima;
    private String isiPesan;
    private boolean terkirim;

    public Notifikasi(int idNotifikasi, AnggotaPerpustakaan penerima, String isiPesan, boolean terkirim) {
        this.idNotifikasi = idNotifikasi;
        this.penerima = penerima;
        this.isiPesan = isiPesan;
        this.terkirim = terkirim;
    }

    public int getIdNotifikasi() {
        return idNotifikasi;
    }

    public AnggotaPerpustakaan getPenerima() {
        return penerima;
    }

    public String getIsiPesan() {
        return isiPesan;
    }

    public boolean isTerkirim() {
        return terkirim;
    }

    @Override
    public String toString() {
        return "\n Notifikasi{idNotifikasi=" + idNotifikasi + ",\n penerima=" + penerima + ",\n isiPesan='" + isiPesan +
                "',\n terkirim=" + terkirim + "}";
    }
}

class AnggotaPerpustakaan {
    private int idAnggota;
    private String nama;
    private String alamat;
    private List<TransaksiPeminjaman> riwayatPinjam = new ArrayList<>();

    public AnggotaPerpustakaan(int idAnggota, String nama, String alamat) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.alamat = alamat;
    }

    public int getIdAnggota() {
        return idAnggota;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public List<TransaksiPeminjaman> getRiwayatPinjam() {
        return riwayatPinjam;
    }

    public void meminjamBuku(Buku buku, String tanggalPinjam) {
        TransaksiPeminjaman transaksi = new TransaksiPeminjaman(this, buku, tanggalPinjam);
        riwayatPinjam.add(transaksi);
    }

    public void melakukanPengembalian(Buku buku, String tanggalKembali, double denda) {
        TransaksiPengembalian transaksi = new TransaksiPengembalian(this, buku, tanggalKembali, denda);
        // Implementasi logika untuk menghitung denda jika diperlukan
    }

    @Override
    public String toString() {
        return "\n AnggotaPerpustakaan{idAnggota=" + idAnggota + ",\n nama='" + nama + "',\n alamat='" + alamat +
                "',\n riwayatPinjam=" + riwayatPinjam + "}";
    }
}

class Buku {
    private int idBuku;
    private String judul;
    private String pengarang;
    private String ISBN;
    private boolean statusKetersediaan;

    public Buku(int idBuku, String judul, String pengarang, String ISBN, boolean statusKetersediaan) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.pengarang = pengarang;
        this.ISBN = ISBN;
        this.statusKetersediaan = statusKetersediaan;
    }

    public int getIdBuku() {
        return idBuku;
    }

    public String getJudul() {
        return judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isStatusKetersediaan() {
        return statusKetersediaan;
    }

    @Override
    public String toString() {
        return "\n Buku{idBuku=" + idBuku + ",\n judul='" + judul + "',\n pengarang='" + pengarang + "',\n ISBN='" + ISBN +
                "',\n statusKetersediaan=" + statusKetersediaan + "}";
    }
}

class TransaksiPeminjaman {
    private AnggotaPerpustakaan anggota;
    private Buku buku;
    private String tanggalPinjam;

    public TransaksiPeminjaman(AnggotaPerpustakaan anggota, Buku buku, String tanggalPinjam) {
        this.anggota = anggota;
        this.buku = buku;
        this.tanggalPinjam = tanggalPinjam;
    }

    public AnggotaPerpustakaan getAnggota() {
        return anggota;
    }

    public Buku getBuku() {
        return buku;
    }

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }

    @Override
    public String toString() {
        return "\n TransaksiPeminjaman{anggota=" + anggota + ",\n buku=" + buku + ",\n tanggalPinjam='" + tanggalPinjam + "'}";
    }
}

class TransaksiPengembalian {
    private AnggotaPerpustakaan anggota;
    private Buku buku;
    private String tanggalKembali;
    private double denda;

    public TransaksiPengembalian(AnggotaPerpustakaan anggota, Buku buku, String tanggalKembali, double denda) {
        this.anggota = anggota;
        this.buku = buku;
        this.tanggalKembali = tanggalKembali;
        this.denda = denda;
    }

    public AnggotaPerpustakaan getAnggota() {
        return anggota;
    }

    public Buku getBuku() {
        return buku;
    }

    public String getTanggalKembali() {
        return tanggalKembali;
    }

    public double getDenda() {
        return denda;
    }

    @Override
    public String toString() {
        return "\n TransaksiPengembalian{anggota=" + anggota + ",\n buku=" + buku + ",\n tanggalKembali='" + tanggalKembali +
                "',\n denda=" + denda + "}";
    }
}