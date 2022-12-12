//package daily.cost;
//
//import java.util.Scanner;
//import java.time.LocalDateTime; 
//import java.time.format.DateTimeFormatter; 
//
//public class DailyCost {
//
//    
//    
//    public static void main(String[] args) {
//        
//        Scanner scan = new Scanner(System.in);
//        Scanner input = new Scanner(System.in);
//        String nama_barang;
//        String user;
//        int jumlah;
//        String pembayaran;
//        int user_id;
//        
//        int tabungan;
//        
//        String back;
//       
//        LocalDateTime waktu = LocalDateTime.now();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String formatteddate = waktu.format(format);
//        
//        
//        
//        
////        User newUser = new User("Fikri", "BCA");
////        newUser.register();
//
//        System.out.print("Masukkan nama user : ");
//        user = scan.nextLine();
//        user_id = User.get_userid(user);
//        if (user_id == 0){
//            System.out.println("Nama Tidak Tersedia!");
//        } else {
//            boolean kondisi = true;
//            while(kondisi == true){
//                System.out.println("#============================#");
//                System.out.println("1. Input barang");
//                System.out.println("2. Chek Gopay");
//                System.out.println("3. Chek Cash");
//                System.out.println("4. Chek Rekening");
//                System.out.println("5. Display Pengeluaran");
//                System.out.println("6. Display Total dan Pengeluaran Bulanan");
//                System.out.println("7. Tambah Saldo GOPAY/CASH/REKENING");
//                System.out.println("8. Exit");
//                System.out.println("#============================#");
//                System.out.print("Pilihan anda : ");
//                int pilihan = scan.nextInt();
//                switch (pilihan) {
//                    case 1:
//                        System.out.print("Masukkan nama barang : ");
//                        nama_barang = scan.next();
//                        System.out.print("Masukkan harga barang : ");
//                        jumlah = scan.nextInt();
//                        System.out.print("Masukkan pembayaran : ");
//                        pembayaran = scan.next();
//                        Pengeluaran.input_pembayaran(nama_barang, formatteddate, jumlah, pembayaran, user_id);
//                        if ("GOPAY".equals(pembayaran)){
//                            System.out.println("Uang Gopay anda tersisa : " + Tabungan.get_uang_gopay(user_id));
//                        } else if ("CASH".equals(pembayaran)){
//                            System.out.println("Uang Cash anda tersisa : " + Tabungan.get_uang_cash(user_id));
//                        } else if ("REKENING".equals(pembayaran)){
//                            System.out.println("Uang Rekening anda tersisa : " + Tabungan.get_uang_rekening(user_id));
//                        }   break;
//                    case 2:
//                        System.out.println("Uang Gopay anda tersisa : " + Tabungan.get_uang_gopay(user_id));
//                        System.out.print("Kembali ke menu (y/n) : ");
//                        back = input.next();
//                        if ("y".equals(back)){
//                            kondisi = true;
//                        } else {
//                            kondisi = false;
//                        }
//                        break;
//                    case 3:
//                        System.out.println("Uang Cash anda tersisa : " + Tabungan.get_uang_cash(user_id));
//                        System.out.print("Kembali ke menu (y/n) : ");
//                        back = input.next();
//                        if ("y".equals(back)){
//                            kondisi = true;
//                        } else {
//                            kondisi = false;
//                        }
//                        break;
//                    case 4:
//                        System.out.println("Uang Rekening anda tersisa : " + Tabungan.get_uang_rekening(user_id));
//                        System.out.print("Kembali ke menu (y/n) : ");
//                        back = input.next();
//                        if ("y".equals(back)){
//                            kondisi = true;
//                        } else {
//                            kondisi = false;
//                        }
//                        break;
//                    case 5:
//                        Pengeluaran.display_pengeluaran(user_id);
//                        System.out.print("Kembali ke menu (y/n) : ");
//                        back = input.next();
//                        if ("y".equals(back)){
//                            kondisi = true;
//                        } else {
//                            kondisi = false;
//                        }
//                        break;
//                    case 6:
//                        Pengeluaran.display_jumlah_dan_total(user_id);
//                        System.out.print("Kembali ke menu (y/n) : ");
//                        back = input.next();
//                        if ("y".equals(back)){
//                            kondisi = true;
//                        } else {
//                            kondisi = false;
//                        }
//                        break;
//                    case 7:
//                        System.out.println("1. GOPAY");
//                        System.out.println("2. CASH");
//                        System.out.println("3. REKENING");
//                        System.out.print("Pilih tabungan : ");
//                        tabungan = input.nextInt();
//                        System.out.print("Masukkan Jumlah : ");
//                        jumlah = scan.nextInt();
//                        Tabungan.tambah_saldo(user_id, tabungan, jumlah);
//                        System.out.print("Kembali ke menu (y/n) : ");
//                        back = input.next();
//                        if ("y".equals(back)){
//                            kondisi = true;
//                        } else {
//                            kondisi = false;
//                        }
//                        break;      
//                    case 8:
//                        kondisi = false;
//                        break;
//                    default:
//                        break;
//                }
//            }
//            
//        }
//   
//    }
//    
//}
