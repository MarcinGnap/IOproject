import java.lang.String;
import java.time.Month;
import java.util.Scanner;
import java.util.Vector;
import java.time.LocalDate;

public class Aplikacja {

    private static Vector<Produkt> oferty = new Vector<>();
    private static Vector<Klient> klienci = new Vector<>();
    private static Vector<Pracownik> pracownicy = new Vector<>();
    private static Vector<Transakcja> transakcje = new Vector<>();

    public Aplikacja() {
        // TODO - implement Aplikacja.Aplikacja
        Produkt produkt1 = new Produkt("Rower", 20, 3, 'd');
        Produkt produkt2 = new Produkt("Kije trekkingowe", 15, 1, 'd');
        Produkt produkt3 = new Produkt("Kask", 5, 0, 'z');
        Produkt produkt4 = new Produkt("Lodz", 500, 0, 'w');
        Produkt produkt5 = new Produkt("Kajak", 200, 0, 'n');
        oferty.add(produkt1);
        oferty.add(produkt2);
        oferty.add(produkt3);
        oferty.add(produkt4);
        oferty.add(produkt5);

        Klient klient1 = new Klient("Marcin", "Gnap", 12345678911l, 123456789, "email@email.email");
        Klient klient2 = new Klient("Jakub", "Fajkowski", 11987654321l, 123456798, "amail@email.email");
        Klient klient3 = new Klient("Dominik", "Gerlach", 11234567890l, 213456789, "bmail@email.email");
        Klient klient4 = new Klient("Klaudia", "Kowalska", 10230456789l, 124356789, "cmail@email.email");
        Klient klient5 = new Klient("Alicja", "Nowak", 54789632100l, 123457689, "dmail@email.email");
        klienci.add(klient1);
        klienci.add(klient2);
        klienci.add(klient3);
        klienci.add(klient4);
        klienci.add(klient5);

        Pracownik pracownik1 = new Pracownik("Martyna", "Wojciechowska", 56321478963l, 963258741, "pmail@email.email", "Wlasciciel");
        Pracownik pracownik2 = new Pracownik("Grzegorz", "Brzeczyszczykiewicz", 32145698741l, 147852369, "omail@email.email", "Manager");
        Pracownik pracownik3 = new Pracownik("Julia", "Nowakowska", 36985214789l, 632589741, "imail@email.email", "Ksiegowy");
        Pracownik pracownik4 = new Pracownik("Henryk", "Garncarski", 85214789632l, 578963214, "umail@email.email", "Ekspedient");
        Pracownik pracownik5 = new Pracownik("Edyta", "Kobieraj", 23654125879l, 653214987, "ymail@email.email", "Ekspedient");
        pracownicy.add(pracownik1);
        pracownicy.add(pracownik2);
        pracownicy.add(pracownik3);
        pracownicy.add(pracownik4);
        pracownicy.add(pracownik5);

        Vector<Produkt> oferty1 = new Vector<>();
        oferty1.add(produkt4);
        Transakcja transakcja1 = new Transakcja(LocalDate.of(2022, Month.MARCH, 12), LocalDate.of(2022, Month.MARCH, 16), 1000, oferty1, 1500);
        transakcje.add(transakcja1);

        Vector<Produkt> oferty2 = new Vector<>();
        oferty2.add(produkt1);
        Transakcja transakcja2 = new Transakcja(LocalDate.of(2022, Month.JULY, 4), LocalDate.of(2022, Month.JULY, 23), 300, oferty2, 100);
        transakcje.add(transakcja2);

        Vector<Produkt> oferty3 = new Vector<>();
        oferty3.add(produkt2);
        Transakcja transakcja3 = new Transakcja(LocalDate.of(2021, Month.DECEMBER, 20), LocalDate.of(2022, Month.JANUARY, 5), 255, oferty3, 0);
        transakcje.add(transakcja3);

        Vector<Produkt> oferty4 = new Vector<>();
        oferty4.add(produkt3);
        Transakcja transakcja4 = new Transakcja(LocalDate.of(2022, Month.JUNE, 10), LocalDate.of(2022, Month.JUNE, 11), 5, oferty4, 0);
        transakcje.add(transakcja4);

        Vector<Produkt> oferty5 = new Vector<>();
        oferty5.add(produkt3);
        Transakcja transakcja5 = new Transakcja(LocalDate.of(2022, Month.APRIL, 17), LocalDate.of(2022, Month.APRIL, 19), 5, oferty5, 5);
        transakcje.add(transakcja5);
    }

    public static void main(String[] args) {
        Aplikacja nowaApp = new Aplikacja();
        System.out.println("Starting...");
        menu();
    }

    /**
     *
     * @param dostep
     * @param cena
     * @param nazwa
     */
    public Vector<Produkt> wyszukajProdukt(String nazwa, float cena, int dostep) {
        Vector<Produkt> wyszukaneProdukty = oferty;
        if(nazwa != null){
            for(int x = 0; x < wyszukaneProdukty.size(); x++){
                if (nazwa != wyszukaneProdukty.get(x).getNazwa()){
                    wyszukaneProdukty.remove(x);
                }
            }
        }
        if(cena > 0){
            for(int x = 0; x < wyszukaneProdukty.size(); x++){
                if (cena > wyszukaneProdukty.get(x).getCena()){
                    wyszukaneProdukty.remove(x);
                }
            }
        }
        if(dostep > 0){
            for(int x = 0; x < wyszukaneProdukty.size(); x++){
                if (dostep > wyszukaneProdukty.get(x).getDostepny()){
                    wyszukaneProdukty.remove(x);
                }
            }
        }
        return wyszukaneProdukty;
    }

    /**
     *
     * @param pozadanyProdukt
     * @param dataPocz
     * @param dataKonca
     */
    public boolean sprawdzKolidacje(Produkt pozadanyProdukt, LocalDate dataPocz, LocalDate dataKonca) {
        if(pozadanyProdukt != null){
            Vector<Produkt> pozadanaOferta = new Vector<>();
            pozadanaOferta.add(pozadanyProdukt);
            Vector<Transakcja> mozliweKolidacje = wyszukajTransakcja(null, null, pozadanaOferta);
            for (int k = 0; k < mozliweKolidacje.size(); k++) {
                if (dataPocz.isAfter(mozliweKolidacje.get(k).getDataKonca()) || dataKonca.isBefore(mozliweKolidacje.get(k).getDataPaczatku())){
                    mozliweKolidacje.remove(k);
                }
            }
            if (mozliweKolidacje.size() > 0){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param produkt
     * @param ilosc
     */
    public boolean sprawdzDostepnoscIlosci(Produkt produkt, int ilosc) {
        if (ilosc < produkt.getDostepny()){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     *
     * @param nazwisko
     * @param pesel
     * @param imie
     */
    public Vector<Klient> wyszukajKlienta(String imie, String nazwisko, float pesel) {
        Vector<Klient> prawdopodobnyKlient = klienci;
        if(imie != null){
            for(int x = 0; x < prawdopodobnyKlient.size(); x++){
                if (imie != prawdopodobnyKlient.get(x).getImie()){
                    prawdopodobnyKlient.remove(x);
                }
            }
        }
        if(nazwisko != null){
            for(int x = 0; x < prawdopodobnyKlient.size(); x++){
                if (nazwisko != prawdopodobnyKlient.get(x).getNazwisko()){
                    prawdopodobnyKlient.remove(x);
                }
            }
        }
        if(pesel > 0){
            for(int x = 0; x < prawdopodobnyKlient.size(); x++){
                if (pesel != prawdopodobnyKlient.get(x).getPesel()){
                    prawdopodobnyKlient.remove(x);
                }
            }
        }
        return prawdopodobnyKlient;
    }

    /**
     *
     * @param dataPoczatku
     * @param dataKonca
     * @param sprzet
     */
    public Vector<Transakcja> wyszukajTransakcja(LocalDate dataPoczatku, LocalDate dataKonca, Vector<Produkt> sprzet) {
        Vector<Transakcja> mozliweTransakcje = transakcje;
        if(dataPoczatku != null){
            for(int x = 0; x < mozliweTransakcje.size(); x++){
                if (dataPoczatku != mozliweTransakcje.get(x).getDataPaczatku()){
                    mozliweTransakcje.remove(x);
                }
            }
        }
        if(dataKonca != null){
            for(int x = 0; x < mozliweTransakcje.size(); x++){
                if (dataKonca != mozliweTransakcje.get(x).getDataKonca()){
                    mozliweTransakcje.remove(x);
                }
            }
        }
        if(sprzet != null){
            for(int x = 0; x < mozliweTransakcje.size(); x++){
                if (sprzet != mozliweTransakcje.get(x).getSprzet()){
                    mozliweTransakcje.remove(x);
                }
            }
        }
        return mozliweTransakcje;
    }


    public void wyswietlWszystkieOferty(){
        System.out.println("Aktualnie dostepne produkty: ");
        int tempIterator = 0;
        for (int i = 0; i < oferty.size(); i++){
            if (oferty.get(i).getDostepny() > 0){
                tempIterator = tempIterator + 1;
                System.out.println(tempIterator + "." + oferty.get(i).getNazwa());
            }
        }
    }


    public static void menu(){
        for (; ;) {
            System.out.print("1. Klient\n" +
                            "2. Pracownik\n" +
                            "3. Wyjście\n");

            Scanner sc = new Scanner(System.in);
            System.out.println("Wybierz opcje: ");
            int wybor = sc.nextInt();
            switch (wybor) {
                case 1:
                    menuPosrednieKlienta();
                    break;
                case 2:
                    menuPosredniePracownika();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nie ma takiej opcji...");
            }
        }
    }

    public static void menuPosrednieKlienta(){
        for (; ;) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Wybierz opcje: " +
                                "1. ");
            int wybor = sc.nextInt();
            switch (wybor) {
                case 1:
                    menuKlienta();
                    break;
                case 2:
                    menuPosredniePracownika();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nie ma takiej opcji...");
            }
        }
    }

    public static void menuPosredniePracownika(){
        for (; ;) {
            System.out.print("1. Klient\n" +
                    "2. Pracownik\n" +
                    "3. Wyjście\n");

            Scanner sc = new Scanner(System.in);
            System.out.println("Wybierz opcje: ");
            int wybor = sc.nextInt();
            switch (wybor) {
                case 1:
                    menuPosrednieKlienta();
                    break;
                case 2:
                    menuPosredniePracownika();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nie ma takiej opcji...");
            }
        }
    }

    public static void menuKlienta(){
        for (;;){
            Scanner sck = new Scanner(System.in);
            System.out.println("Wybierz opcje: \n" +
                                "1. Wyswietlenie dostepnych ofert" +
                                "2. Wypozyczenie wybranego produktu" +
                                "3. Rezerwacja wybranego produktu" +
                                "4. Przedluzenie wypozyczenia" +
                                "5. Anulowanie rezerwacji" +
                                "6. Zgloszenie zgubienia wypozyczonego produktu" +
                                "7. Powrot");
            int wyborKlienta = sck.nextInt();
            switch (wyborKlienta){
                case 1:
                    System.out.println("Dostepne oferty: ");
                    for (int k = 0; k < oferty.size(); k++){
                        int kn = k + 1;
                        System.out.println(kn + ". " + oferty.get(k).getNazwa() + " x " + oferty.get(k).getDostepny());
                    }
                    break;
                case 2:
                    System.out.println("Wybierz numer produktu, ktory chcesz wypozyczyc: ");
                    Scanner scNumerProduktu = new Scanner(System.in);
                    int wyborWypozyczenie = scNumerProduktu.nextInt();

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:
                    return;
                default:
                    System.out.println("Nie ma takiej opcji...");
            }
        }
    }

    public static void menuPracownika(){
        for (;;){
            Scanner scp = new Scanner(System.in);
            System.out.println("Wybierz opcje: \n" +
                                "1. Stworzenie nowej oferty" +
                                "2. Nakazanie zwrotu" +
                                "3. Sprawdzenie historii wypozyczen" +
                                "5. Sprawdzenie zalegania z oplatami" +
                                "6. Powrot");
            int wyborPracownika = scp.nextInt();
            switch (wyborPracownika){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    return;
                default:
                    System.out.println("Nie ma takiej opcji...");
            }
        }
    }

}