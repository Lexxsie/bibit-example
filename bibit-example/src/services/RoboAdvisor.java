package services;

import models.Product;
import models.ReksaDanaProduct;

public class RoboAdvisor {

    public Product rekomendasikanProduk(String profilRisiko) {
        if (profilRisiko.equalsIgnoreCase("Konservatif")) {
            return new ReksaDanaProduct("P001", "Reksa Dana Pasar Uang", 5.5, "MI Aman Sentosa");
        } else if (profilRisiko.equalsIgnoreCase("Agresif")) {
            return new ReksaDanaProduct("P002", "Reksa Dana Saham", 12.0, "MI Cuan Maximal");
        } else {
            return new ReksaDanaProduct("P003", "Reksa Dana Campuran", 8.0, "MI Seimbang Abadi");
        }
    }
}
