public class Portieri extends Lojtari {
    private int pritjet; // Sa topa ka pritur

    public Portieri(String emri, String mbiemri, int mosha, String telefoni, int numriFanelles) {
        super(emri, mbiemri, mosha, telefoni, "Portier", numriFanelles);
        this.pritjet = 0;
    }

    public int getPritjet() { return pritjet; }

    // Metodë specifike vetëm për portierin
    public void shenoPritje() {
        pritjet++;
        System.out.println(getEmriPlote() + " priti topin! Pritjet gjithsej: " + pritjet);
    }

    // Polimorfizëm: portieri paguan +10 EUR për stërvitje speciale
    @Override
    public double getPagesaMujore() {
        return super.getPagesaMujore() + 10;
    }

    @Override
    public String getRoli() {
        return "Portier";
    }

    @Override
    public void shfaqInfo() {
        super.shfaqInfo();
        System.out.println("Pritjet: " + pritjet);
    }
}
