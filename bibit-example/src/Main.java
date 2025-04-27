import database.DataStore;
import database.UserDataStore;
import java.util.List;
import java.util.Scanner;
import models.Product;
import models.ReksaDanaProduct;
import models.Transaction;
import models.User;        // <-- Tambahkan ini
import services.AuthenticationService;     // <-- Tambahkan ini


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DataStore.users = UserDataStore.loadUsers();

        DataStore.products.add(new ReksaDanaProduct("P001", "Reksa Dana Pasar Uang", 5.5, "Manajer Sentosa"));
        DataStore.products.add(new ReksaDanaProduct("P002", "Reksa Dana Saham", 12.0, "Manajer CuanMax"));

        printHeader("Bibit Investment App");

        User user = null;

        while (user == null) {
            printHeader("Login / Register");
            System.out.println("1. Sign In (Login)");
            System.out.println("2. Sign Up (Register)");
            System.out.print("Pilihan: ");
            int pilihanAwal = sc.nextInt();
            sc.nextLine(); // Clear buffer

            if (pilihanAwal == 1) {
                System.out.print("Masukkan Email: ");
                String email = sc.nextLine();
                System.out.print("Masukkan Password: ");
                String password = sc.nextLine();

                user = AuthenticationService.login(email, password);

                if (user != null) {
                    System.out.println("\nLogin sukses, selamat datang " + user.getNamaLengkap() + "!");
                } else {
                    System.out.println("\n❌ Email atau Password salah.\n");
                }
            } else if (pilihanAwal == 2) {
                System.out.print("Nama Lengkap: ");
                String nama = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Nomor HP: ");
                String hp = sc.nextLine();
                System.out.print("Password: ");
                String password = sc.nextLine();

                user = AuthenticationService.register(nama, email, hp, password);
                System.out.println("\n✅ Pendaftaran berhasil, selamat datang " + user.getNamaLengkap() + "!");
            } else {
                System.out.println("\n❌ Pilihan tidak valid. Silakan pilih 1 atau 2.\n");
            }
        }

        // Menu Utama setelah login berhasil
        while (true) {
            printHeader("Menu Utama");
            System.out.println("1. Lihat Produk");
            System.out.println("2. Beli Produk");
            System.out.println("3. Lihat Portfolio");
            System.out.println("4. Logout");
            System.out.print("Pilihan: ");
            int pilihan = sc.nextInt();
            sc.nextLine(); // Clear buffer

            if (pilihan == 1) {
                showProdukList();
            } else if (pilihan == 2) {
                beliProduk(user, sc);
            } else if (pilihan == 3) {
                user.getPortfolio().tampilkanPortfolio();
            } else if (pilihan == 4) {
                System.out.println("\nTerima kasih telah menggunakan Bibit Prototype. 👋");
                break;
            } else {
                System.out.println("\n❌ Pilihan tidak valid. Silakan pilih 1-4.\n");
            }
        }

        sc.close();
    }

    private static void printHeader(String title) {
        System.out.println("\n===============================");
        System.out.println("       " + title);
        System.out.println("===============================\n");
    }

    private static void showProdukList() {
        System.out.println("\n=== Daftar Produk ===");
        List<Product> produkList = DataStore.products;
        for (int i = 0; i < produkList.size(); i++) {
            Product p = produkList.get(i);
           System.out.println((i + 1) + ". " + p.getProductId() + " - " + p.getNamaProduk() + " (" + p.getReturnTahunan() + "%)");

        }
        System.out.println();
    }

    private static void beliProduk(User user, Scanner sc) {
        List<Product> produkList = DataStore.products;

        showProdukList();
        System.out.print("Pilih produk [angka]: ");
        int pilihanProduk = sc.nextInt();
        sc.nextLine(); // Clear buffer

        if (pilihanProduk < 1 || pilihanProduk > produkList.size()) {
            System.out.println("\n❌ Produk tidak valid.\n");
            return;
        }

        Product produkDipilih = produkList.get(pilihanProduk - 1);

        System.out.print("Masukkan nominal investasi (Rp): ");
        double nominal = sc.nextDouble();
        sc.nextLine(); // Clear buffer

        Transaction trx = new Transaction("T" + (DataStore.transactions.size() + 1), user, produkDipilih, nominal);
        DataStore.transactions.add(trx);
        user.getPortfolio().tambahTransaksi(trx);

        System.out.println("\n✅ Investasi ke " + produkDipilih.getNamaProduk() + " sebesar Rp" + nominal + " berhasil!\n");

    }
}
