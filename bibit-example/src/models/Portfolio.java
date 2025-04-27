package models;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private List<Transaction> transaksiList;

    public Portfolio() {
        this.transaksiList = new ArrayList<>();
    }

    public void tambahTransaksi(Transaction t) {
        transaksiList.add(t);
    }

    public void tampilkanPortfolio() {
        double total = 0;
        System.out.println("=== Portfolio Anda ===");
        for (Transaction t : transaksiList) {
            t.tampilkanDetailTransaksi();
            System.out.println();
            total += t.getNominalInvestasi();
        }
        System.out.println("Total Investasi: Rp " + total);
    }
}
