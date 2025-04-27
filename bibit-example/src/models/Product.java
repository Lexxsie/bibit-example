package models;

public class Product {
    protected String productId;
    protected String namaProduk;
    protected double returnTahunan;

    public Product(String productId, String namaProduk, double returnTahunan) {
        this.productId = productId;
        this.namaProduk = namaProduk;
        this.returnTahunan = returnTahunan;
    }

    public void tampilkanDetailProduk() {
        System.out.println("Produk: " + namaProduk);
        System.out.println("Return Tahunan: " + returnTahunan + "%");
    }

    public String getProductId() {
        return productId;
    }

    public String getNamaProduk() {
        return namaProduk;     // ✅ getter namaProduk
    }

    public double getReturnTahunan() {
        return returnTahunan;  // ✅ getter returnTahunan
    }
}
