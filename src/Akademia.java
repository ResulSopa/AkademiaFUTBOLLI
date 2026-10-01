import java.util.ArrayList;

public class Akademia {
    private String emri;
    private ArrayList<Personi> anetaret = new ArrayList<>();

    public Akademia(String emri) {
        this.emri = emri;
    }

    public String getEmri() { return emri; }

    // Polimorfizëm: pranon Lojtari, Portieri ose Trajneri, sepse të gjithë janë Personi
    public void regjistro(Personi personi) {
        anetaret.add(personi);
        System.out.println(personi.getEmriPlote() + " u regjistrua si "
                + personi.getRoli() + " (ID: " + personi.getId() + ")");
    }

    public void shfaqTeGjithe() {
        if (anetaret.isEmpty()) {
            System.out.println("Nuk ka anëtarë të regjistruar.");
            return;
        }
        System.out.println("\n===== ANËTARËT E " + emri.toUpperCase() + " =====");
        for (Personi p : anetaret) {
            p.shfaqInfo(); // Java e thërret automatikisht versionin e duhur
            System.out.println("------------------------------");
        }
    }

    public void shfaqSipasKategorise(String kategoria) {
        boolean uGjet = false;
        System.out.println("\n===== LOJTARËT " + kategoria.toUpperCase() + " =====");
        for (Personi p : anetaret) {
            if (p instanceof Lojtari) {
                Lojtari lojtari = (Lojtari) p;
                if (lojtari.getKategoria().equalsIgnoreCase(kategoria)) {
                    lojtari.shfaqInfo();
                    System.out.println("------------------------------");
                    uGjet = true;
                }
            }
        }
        if (!uGjet) {
            System.out.println("Nuk ka lojtarë në këtë kategori.");
        }
    }

    public void kerkoSipasEmrit(String teksti) {
        boolean uGjet = false;
        for (Personi p : anetaret) {
            if (p.getEmriPlote().toLowerCase().contains(teksti.toLowerCase())) {
                p.shfaqInfo();
                System.out.println("------------------------------");
                uGjet = true;
            }
        }
        if (!uGjet) {
            System.out.println("Nuk u gjet asnjë anëtar me emrin '" + teksti + "'.");
        }
    }

    public Personi gjejSipasId(int id) {
        for (Personi p : anetaret) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean fshi(int id) {
        Personi p = gjejSipasId(id);
        if (p == null) {
            return false;
        }
        anetaret.remove(p);
        return true;
    }

    // Sa para hyjnë në muaj nga lojtarët
    public double llogaritTeHyrat() {
        double totali = 0;
        for (Personi p : anetaret) {
            if (p instanceof Lojtari) {
                totali += ((Lojtari) p).getPagesaMujore(); // Portieri jep 40, lojtari 30
            }
        }
        return totali;
    }

    // Sa para dalin në muaj për trajnerët
    public double llogaritPagat() {
        double totali = 0;
        for (Personi p : anetaret) {
            if (p instanceof Trajneri) {
                totali += ((Trajneri) p).getPaga();
            }
        }
        return totali;
    }

    public void shfaqStatistikat() {
        int lojtare = 0;
        int portiere = 0;
        int trajnere = 0;
        Lojtari golashenuesi = null;

        for (Personi p : anetaret) {
            if (p instanceof Portieri) {
                portiere++;
            } else if (p instanceof Lojtari) {
                lojtare++;
            } else if (p instanceof Trajneri) {
                trajnere++;
            }

            if (p instanceof Lojtari) {
                Lojtari l = (Lojtari) p;
                if (golashenuesi == null || l.getGolat() > golashenuesi.getGolat()) {
                    golashenuesi = l;
                }
            }
        }

        System.out.println("\n===== STATISTIKAT E " + emri.toUpperCase() + " =====");
        System.out.println("Lojtarë: " + lojtare);
        System.out.println("Portierë: " + portiere);
        System.out.println("Trajnerë: " + trajnere);
        System.out.println("Të hyrat mujore: " + llogaritTeHyrat() + " EUR");
        System.out.println("Pagat e trajnerëve: " + llogaritPagat() + " EUR");
        System.out.println("Bilanci: " + (llogaritTeHyrat() - llogaritPagat()) + " EUR");
        if (golashenuesi != null) {
            System.out.println("Golashënuesi më i mirë: " + golashenuesi.getEmriPlote()
                    + " (" + golashenuesi.getGolat() + " gola)");
        }
    }
}
