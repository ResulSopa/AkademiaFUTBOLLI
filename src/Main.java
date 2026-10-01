import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Akademia akademia = new Akademia("Akademia Dardania");

        // Disa anëtarë fillestarë
        Lojtari l1 = new Lojtari("Arben", "Krasniqi", 9, "044111222", "Sulmues", 9);
        Lojtari l2 = new Lojtari("Dren", "Gashi", 13, "049333444", "Mbrojtës", 4);
        Portieri p1 = new Portieri("Leon", "Berisha", 16, "045555666", 1);
        Trajneri t1 = new Trajneri("Faton", "Hoxha", 35, "044777888", "UEFA B", 6);

        akademia.regjistro(l1);
        akademia.regjistro(l2);
        akademia.regjistro(p1);
        akademia.regjistro(t1);

        l1.shenoGol();
        l1.shenoGol();
        p1.shenoPritje();

        int zgjedhja;
        do {
            shfaqMenyne();
            zgjedhja = lexoNumer("Zgjedh: ");

            switch (zgjedhja) {
                case 1:
                    regjistroLojtar(akademia);
                    break;
                case 2:
                    regjistroPortier(akademia);
                    break;
                case 3:
                    regjistroTrajner(akademia);
                    break;
                case 4:
                    akademia.shfaqTeGjithe();
                    break;
                case 5:
                    String kategoria = lexoTekst("Kategoria (U8, U10, U12, U15, U18): ");
                    akademia.shfaqSipasKategorise(kategoria);
                    break;
                case 6:
                    String emri = lexoTekst("Shkruaj emrin: ");
                    akademia.kerkoSipasEmrit(emri);
                    break;
                case 7:
                    shenoGol(akademia);
                    break;
                case 8:
                    fshiAnetar(akademia);
                    break;
                case 9:
                    akademia.shfaqStatistikat();
                    break;
                case 0:
                    System.out.println("Mirupafshim!");
                    break;
                default:
                    System.out.println("Zgjedhje e gabuar!");
            }
        } while (zgjedhja != 0);
    }

    private static void shfaqMenyne() {
        System.out.println("\n========== MENYJA ==========");
        System.out.println("1. Regjistro lojtar");
        System.out.println("2. Regjistro portier");
        System.out.println("3. Regjistro trajner");
        System.out.println("4. Shfaq të gjithë anëtarët");
        System.out.println("5. Shfaq lojtarët sipas kategorisë");
        System.out.println("6. Kërko sipas emrit");
        System.out.println("7. Shëno gol për lojtar");
        System.out.println("8. Fshi anëtar");
        System.out.println("9. Statistikat");
        System.out.println("0. Dil");
    }

    private static void regjistroLojtar(Akademia akademia) {
        String emri = lexoTekst("Emri: ");
        String mbiemri = lexoTekst("Mbiemri: ");
        int mosha = lexoNumer("Mosha: ");
        String telefoni = lexoTekst("Telefoni: ");
        String pozicioni = lexoTekst("Pozicioni: ");
        int fanella = lexoNumer("Numri i fanellës: ");
        akademia.regjistro(new Lojtari(emri, mbiemri, mosha, telefoni, pozicioni, fanella));
    }

    private static void regjistroPortier(Akademia akademia) {
        String emri = lexoTekst("Emri: ");
        String mbiemri = lexoTekst("Mbiemri: ");
        int mosha = lexoNumer("Mosha: ");
        String telefoni = lexoTekst("Telefoni: ");
        int fanella = lexoNumer("Numri i fanellës: ");
        akademia.regjistro(new Portieri(emri, mbiemri, mosha, telefoni, fanella));
    }

    private static void regjistroTrajner(Akademia akademia) {
        String emri = lexoTekst("Emri: ");
        String mbiemri = lexoTekst("Mbiemri: ");
        int mosha = lexoNumer("Mosha: ");
        String telefoni = lexoTekst("Telefoni: ");
        String licenca = lexoTekst("Licenca (UEFA A / UEFA B / UEFA C): ");
        int vitet = lexoNumer("Vite përvoje: ");
        akademia.regjistro(new Trajneri(emri, mbiemri, mosha, telefoni, licenca, vitet));
    }

    private static void shenoGol(Akademia akademia) {
        int id = lexoNumer("ID e lojtarit: ");
        Personi p = akademia.gjejSipasId(id);
        if (p instanceof Lojtari) {
            ((Lojtari) p).shenoGol();
        } else {
            System.out.println("Nuk ka lojtar me këtë ID.");
        }
    }

    private static void fshiAnetar(Akademia akademia) {
        int id = lexoNumer("ID e anëtarit që do fshihet: ");
        if (akademia.fshi(id)) {
            System.out.println("Anëtari u fshi me sukses.");
        } else {
            System.out.println("Nuk u gjet anëtar me këtë ID.");
        }
    }

    // Lexon numër, dhe nëse shkruan shkronja të pyet prapë
    private static int lexoNumer(String mesazhi) {
        while (true) {
            System.out.print(mesazhi);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ju lutem shkruani numër!");
            }
        }
    }

    private static String lexoTekst(String mesazhi) {
        System.out.print(mesazhi);
        return scanner.nextLine().trim();
    }
}
