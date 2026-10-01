public class Trajneri extends Personi {
    private String licenca;     // p.sh. "UEFA A", "UEFA B", "UEFA C"
    private int vitetPervoje;

    public Trajneri(String emri, String mbiemri, int mosha, String telefoni,
                    String licenca, int vitetPervoje) {
        super(emri, mbiemri, mosha, telefoni);
        this.licenca = licenca;
        setVitetPervoje(vitetPervoje);
    }

    public String getLicenca() { return licenca; }
    public int getVitetPervoje() { return vitetPervoje; }

    public void setVitetPervoje(int vitetPervoje) {
        if (vitetPervoje < 0) {
            this.vitetPervoje = 0;
        } else {
            this.vitetPervoje = vitetPervoje;
        }
    }

    // Paga varet nga licenca + 20 EUR për çdo vit përvoje
    public double getPaga() {
        double baza;
        if (licenca.equalsIgnoreCase("UEFA A")) {
            baza = 1000;
        } else if (licenca.equalsIgnoreCase("UEFA B")) {
            baza = 700;
        } else {
            baza = 500;
        }
        return baza + vitetPervoje * 20;
    }

    @Override
    public String getRoli() {
        return "Trajner";
    }

    @Override
    public void shfaqInfo() {
        super.shfaqInfo();
        System.out.println("Licenca: " + licenca);
        System.out.println("Vite përvoje: " + vitetPervoje);
        System.out.println("Paga mujore: " + getPaga() + " EUR");
    }
}
