public class Lojtari extends Personi {
    private String pozicioni;
    private int numriFanelles;
    private int golat;

    public Lojtari(String emri, String mbiemri, int mosha, String telefoni,
                   String pozicioni, int numriFanelles) {
        super(emri, mbiemri, mosha, telefoni); // Thërret konstruktorin e Personi
        this.pozicioni = pozicioni;
        setNumriFanelles(numriFanelles);
        this.golat = 0;
    }

    public String getPozicioni() { return pozicioni; }
    public int getNumriFanelles() { return numriFanelles; }
    public int getGolat() { return golat; }

    // Enkapsulim: fanella duhet të jetë 1 deri 99
    public void setNumriFanelles(int numriFanelles) {
        if (numriFanelles < 1 || numriFanelles > 99) {
            this.numriFanelles = 0;
        } else {
            this.numriFanelles = numriFanelles;
        }
    }

    // Kategoria caktohet automatikisht sipas moshës
    public String getKategoria() {
        int mosha = getMosha();
        if (mosha <= 8) {
            return "U8";
        } else if (mosha <= 10) {
            return "U10";
        } else if (mosha <= 12) {
            return "U12";
        } else if (mosha <= 15) {
            return "U15";
        } else {
            return "U18";
        }
    }

    public void shenoGol() {
        golat++;
        System.out.println(getEmriPlote() + " shënoi gol! Golat gjithsej: " + golat);
    }

    // Pagesa mujore për lojtar të thjeshtë
    public double getPagesaMujore() {
        return 30;
    }

    @Override
    public String getRoli() {
        return "Lojtar";
    }

    @Override
    public void shfaqInfo() {
        super.shfaqInfo();
        System.out.println("Pozicioni: " + pozicioni);
        System.out.println("Fanella nr: " + numriFanelles);
        System.out.println("Kategoria: " + getKategoria());
        System.out.println("Golat: " + golat);
        System.out.println("Pagesa mujore: " + getPagesaMujore() + " EUR");
    }
}
