
package daily.cost;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;

public class Tabungan {
    
    static int saldo;
    static int saldotambah;
    
    public static int get_uang_gopay(int user_id){

        String querry_get_uang_gopay = String.format("SELECT uang_gopay FROM tabungan WHERE user_id = %d", user_id);
        try {
            Connection conn = database.getConnect();
            PreparedStatement get_uang_gopay = conn.prepareStatement(querry_get_uang_gopay);
            ResultSet hasil = get_uang_gopay.executeQuery();

            while(hasil.next()){
                int uang_gopay = hasil.getInt("uang_gopay");
                return uang_gopay;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
        
    }
    
    public static int set_uang_gopay(int saldo, int user_id){

        String querry_set_uang_gopay = String.format("UPDATE tabungan SET uang_gopay = %d WHERE user_id = %d", saldo, user_id);
        try {
            Connection conn = database.getConnect();
            PreparedStatement input = conn.prepareStatement(querry_set_uang_gopay);
            input.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
        
    }
    
    public static int get_uang_cash(int user_id){

        String querry_get_uang_cash = String.format("SELECT uang_cash FROM tabungan WHERE user_id = %d", user_id);
        try {
            Connection conn = database.getConnect();
            PreparedStatement get_uang_cash = conn.prepareStatement(querry_get_uang_cash);
            ResultSet hasil = get_uang_cash.executeQuery();

            while(hasil.next()){
                int uang_cash = hasil.getInt("uang_cash");
                return uang_cash;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
        
    }
    
    public static int set_uang_cash(int saldo, int user_id){

        String querry_set_uang_cash = String.format("UPDATE tabungan SET uang_cash = %d WHERE user_id = %d", saldo, user_id);
        try {
            Connection conn = database.getConnect();
            PreparedStatement input = conn.prepareStatement(querry_set_uang_cash);
            input.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
        
    }
    
    public static int get_uang_rekening(int user_id){

        String querry_get_uang_rekening = String.format("SELECT uang_rekening FROM tabungan WHERE user_id = %d", user_id);
        try {
            Connection conn = database.getConnect();
            PreparedStatement get_uang_rekening = conn.prepareStatement(querry_get_uang_rekening);
            ResultSet hasil = get_uang_rekening.executeQuery();

            while(hasil.next()){
                int uang_rekening = hasil.getInt("uang_rekening");
                return uang_rekening;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
        
    }
    
    public static int set_uang_rekening(int saldo, int user_id){

        String querry_set_uang_rekening = String.format("UPDATE tabungan SET uang_rekening = %d WHERE user_id = %d", saldo, user_id);
        try {
            Connection conn = database.getConnect();
            PreparedStatement input = conn.prepareStatement(querry_set_uang_rekening);
            input.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
        
    }
    
    
    public static void tambah_saldo(int user_id, int pembayaran, int jumlah){
        
        if (pembayaran == 1){
            saldo = Tabungan.get_uang_gopay(user_id);
            saldotambah = saldo + jumlah;
            Tabungan.set_uang_gopay(saldotambah, user_id);
            System.out.println("Saldo gopay anda sebelum : " + saldo);
            System.out.println("Saldo gopay anda sekarang : " + Tabungan.get_uang_gopay(user_id));
        } else if (pembayaran == 2){
            saldo = Tabungan.get_uang_cash(user_id);
            saldotambah = saldo + jumlah;
            Tabungan.set_uang_cash(saldotambah, user_id);
            System.out.println("Saldo cash anda sebelum : " + saldo);
            System.out.println("Saldo cash anda sekarang : " + Tabungan.get_uang_cash(user_id));
        } else if (pembayaran == 3){
            saldo = Tabungan.get_uang_rekening(user_id);
            saldotambah = saldo + jumlah;
            Tabungan.set_uang_rekening(saldotambah, user_id);
            System.out.println("Saldo rekening anda sebelum : " + saldo);
            System.out.println("Saldo rekening anda sekarang : " + Tabungan.get_uang_rekening(user_id));
        }
        
    }
    
}
