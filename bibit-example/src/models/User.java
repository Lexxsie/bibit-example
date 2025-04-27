package models;

public class User {
    private String userId;
    private String namaLengkap;
    private String email;
    private String nomorHP;
    private String password;      
    private String profilRisiko;
    private Portfolio portfolio;

    public User(String userId, String namaLengkap, String email, String nomorHP, String password) {
        this.userId = userId;
        this.namaLengkap = namaLengkap;
        this.email = email;
        this.nomorHP = nomorHP;
        this.password = password;    
        this.profilRisiko = "Konservatif";
        this.portfolio = new Portfolio();
    }

    public void lihatProfil() {
        System.out.println("=== Profil User ===");
        System.out.println("Nama: " + namaLengkap);
        System.out.println("Email: " + email);
        System.out.println("Nomor HP: " + nomorHP);
        System.out.println("Profil Risiko: " + profilRisiko);
    }

    // Getter untuk email dan password
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }
}
