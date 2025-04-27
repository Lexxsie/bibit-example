package models;

public class Transaction {
    private String transactionId;
    private User user;
    private Product product;
    private double nominalInvestasi;
    private String tanggalTransaksi;

    public Transaction(String transactionId, User user, Product product, double nominalInvestasi) {
        this.transactionId = transactionId;
        this.user = user;
        this.product = product;
        this.nominalInvestasi = nominalInvestasi;
        this.tanggalTransaksi = java.time.LocalDate.now().toString(); // Simpan tanggal sebagai String

    }

    public void tampilkanDetailTransaksi() {
        System.out.println("=== Detail Transaksi ===");
        product.tampilkanDetailProduk();
        System.out.println("Nominal Investasi: Rp " + nominalInvestasi);
        System.out.println("Tanggal Transaksi: " + tanggalTransaksi);
    }

    public double getNominalInvestasi() {
        return nominalInvestasi;
    }
}
