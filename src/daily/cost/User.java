
package daily.cost;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class User {

    private int user_id;
    private String nama;
    private String rekening;
    
    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRekening() {
        return rekening;
    }

    public void setRekening(String rekening) {
        this.rekening = rekening;
    }
    
    public User(String nama, String rekening) {
        this.user_id = user_id;
        this.nama = nama;
        this.rekening = rekening;
    }
    
    public void register(){
        String querry = String.format("INSERT INTO user VALUES(null, '%s', '%s')", this.nama, this.rekening );
        try {
            Connection conn = database.getConnect();
            PreparedStatement input = conn.prepareStatement(querry);
            input.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally {
            System.out.println("Berhasil Terinput");
        }        
    }
    
    public static int get_userid(String nama){

        String querry_getuserID = String.format("SELECT user_id FROM user WHERE nama = '%s'", nama);
        try {
            Connection conn = database.getConnect();
            PreparedStatement get_userid = conn.prepareStatement(querry_getuserID);
            ResultSet hasil = get_userid.executeQuery();

            while(hasil.next()){
                int userid = hasil.getInt("user_id");
                return userid;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
        
    }
    
    
    
}
