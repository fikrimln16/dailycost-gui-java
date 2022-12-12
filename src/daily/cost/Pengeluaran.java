
package daily.cost;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Pengeluaran {
    
    private int pengeluaran_id;
    private String nama;
    private String tanggal;
    private int jumlah;
    private String pembayaran;
    private int user_id;
    
    static int gopay;
    static int saldogopay;
    
    static int cash;
    static int saldocash;
    
    static int rekening;
    static int saldorekening;

    public Pengeluaran(int pengeluaran_id, String nama, String tanggal, int jumlah, String pembayaran) {
        this.pengeluaran_id = pengeluaran_id;
        this.nama = nama;
        this.tanggal = tanggal;
        this.jumlah = jumlah;
        this.pembayaran = pembayaran;
    }
    
    
     public static void input_pembayaran(String nama, String tanggal, int jumlah, String pembayaran, int user_id){
    	
        try {
            Connection conn = database.getConnect();
            String querry = String.format("INSERT INTO pengeluaran VALUES(null, '%s', '%s', %d, '%s', %d )", nama, tanggal, jumlah, pembayaran, user_id);
            PreparedStatement input = conn.prepareStatement(querry);
            input.executeUpdate();
            if ("GOPAY".equals(pembayaran)){
                gopay = Tabungan.get_uang_gopay(user_id);
                saldogopay = gopay - jumlah;
                Tabungan.set_uang_gopay(saldogopay, user_id);
            } else if ("CASH".equals(pembayaran)){
                cash = Tabungan.get_uang_cash(user_id);
                saldocash = cash - jumlah;
                Tabungan.set_uang_cash(saldocash, user_id);
            } else if ("REKENING".equals(pembayaran)){
                rekening = Tabungan.get_uang_rekening(user_id);
                saldorekening = rekening - jumlah;
                Tabungan.set_uang_rekening(saldorekening, user_id);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        finally {
            System.out.println("Berhasil Terinput");
        }        
    }
    
     
     public static String get_pembayaran(int pengeluaran_id){

        String querry_getuserID = String.format("SELECT pembayaran FROM pengeluaran WHERE pengeluaran_id = %d", pengeluaran_id);
        try {
            Connection conn = database.getConnect();
            PreparedStatement get_userid = conn.prepareStatement(querry_getuserID);
            ResultSet hasil = get_userid.executeQuery();

            while(hasil.next()){
                String pembayaran = hasil.getString("pembayaran");
                return pembayaran;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return "NULL";
        
    }
     
     public static void display_pengeluaran(int user_id){
        String querry_data = "SELECT user.nama, pengeluaran.nama as 'nama_barang', pengeluaran.tanggal, pengeluaran.jumlah, pengeluaran.pembayaran FROM user INNER JOIN pengeluaran ON user.user_id = pengeluaran.user_id";
        try {
            Connection conn = database.getConnect();
            PreparedStatement get_data = conn.prepareStatement(querry_data);
            ResultSet hasil = get_data.executeQuery();

            while(hasil.next()){
                String nama = hasil.getString("nama");
                String namabarang = hasil.getString("nama_barang");
                String tanggal = hasil.getString("tanggal");
                int jumlah = hasil.getInt("jumlah");
                String pembayaran = hasil.getString("pembayaran");
                
                System.out.println("#-------------------------------#");
                System.out.println("nama : " + nama);
                System.out.println("namabarang : " + namabarang);
                System.out.println("tanggal : " + tanggal);
                System.out.println("jumlah : " + jumlah);
                System.out.println("pembayaran : " + pembayaran);
                System.out.println("#-------------------------------#");

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
     
     public static void display_jumlah_dan_total(int user_id){
        String querry_data = String.format("SELECT SUM(jumlah) as 'jumlah', COUNT(jumlah) as 'total' FROM pengeluaran WHERE user_id = %d", user_id);
        try {
            Connection conn = database.getConnect();
            PreparedStatement get_data = conn.prepareStatement(querry_data);
            ResultSet hasil = get_data.executeQuery();

            while(hasil.next()){
                int jumlah = hasil.getInt("jumlah");
                int total = hasil.getInt("total");

                System.out.println("#-------------------------------#");
                System.out.println("Total anda membeli barang sebanyak: " + total);
                System.out.println("Total pengeluaran anda sejumlah : " + jumlah); 
                System.out.println("#-------------------------------#");

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
