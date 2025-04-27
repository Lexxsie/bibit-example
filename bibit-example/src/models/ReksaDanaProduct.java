package models;

public class ReksaDanaProduct extends Product {
    private String jenisManajerInvestasi;

    public ReksaDanaProduct(String productId, String namaProduk, double returnTahunan, String jenisManajerInvestasi) {
        super(productId, namaProduk, returnTahunan);
        this.jenisManajerInvestasi = jenisManajerInvestasi;
    }

    @Override
    public void tampilkanDetailProduk() {
        super.tampilkanDetailProduk();
        System.out.println("Manajer Investasi: " + jenisManajerInvestasi);
    }
}
