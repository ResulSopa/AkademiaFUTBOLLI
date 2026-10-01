public class Personi {
    private static int numeruesi = 1; // Për me i dhënë secilit ID unike

    private int id;
    private String emri;
    private String mbiemri;
    private int mosha;
    private String telefoni;

    // Konstruktori
    public Personi(String emri, String mbiemri, int mosha, String telefoni) {
        this.id = numeruesi++;
        this.emri = emri;
        this.mbiemri = mbiemri;
        setMosha(mosha);         // Përdorim setter për kontroll
        setTelefoni(telefoni);   // Përdorim setter për kontroll
    }

    // Getterat
    public int getId() { return id; }
    public String getEmri() { return emri; }
    public String getMbiemri() { return mbiemri; }
    public String getEmriPlote() { return emri + " " + mbiemri; }
    public int getMosha() { return mosha; }
    public String getTelefoni() { return telefoni; }

    // Enkapsulim: mosha s'mund të jetë negative
    public void setMosha(int mosha) {
        if (mosha < 0) {
            this.mosha = 0;
        } else {
            this.mosha = mosha;
        }
    }

    // Enkapsulim: telefoni duhet të ketë së paku 9 shifra
    public void setTelefoni(String telefoni) {
        if (telefoni == null || telefoni.length() < 9) {
            this.telefoni = "I panjohur";
        } else {
            this.telefoni = telefoni;
        }
    }

    // Do të mbishkruhet te klasat fëmijë
    public String getRoli() {
        return "Person";
    }

    public void shfaqInfo() {
        System.out.println("[" + getRoli() + "] ID: " + id);
        System.out.println("Emri: " + getEmriPlote());
        System.out.println("Mosha: " + mosha);
        System.out.println("Telefoni: " + telefoni);
    }
}
