import javax.xml.stream.events.ProcessingInstruction;
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
    public static Vector<Integer> wyszukajProdukt(String nazwa, float cena, int dostep) {
        Vector<Integer> indeksyProduktow = new Vector<Integer>();
        for (int index = 0; index < oferty.size(); index++){
            indeksyProduktow.add(index);
        }
        if(nazwa != null){
            for(int x = 0; x < oferty.size(); x++){
                if (nazwa != oferty.get(x).getNazwa()){
                    indeksyProduktow.remove(x);
                }
            }
        }
        if(cena > 0){
            for(int x = 0; x < oferty.size(); x++){
                if (cena > oferty.get(x).getCena()){
                    indeksyProduktow.remove(x);
                }
            }
        }
        if(dostep > 0){
            for(int x = 0; x < oferty.size(); x++){
                if (dostep > oferty.get(x).getDostepny()){
                    indeksyProduktow.remove(x);
                }
            }
        }
        return indeksyProduktow;
    }

    /**
     *
     * @param pozadanyProdukt
     * @param dataPocz
     * @param dataKonca
     */
    public static boolean sprawdzKolidacje(Produkt pozadanyProdukt, LocalDate dataPocz, LocalDate dataKonca) {
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

    public boolean sprawdzDostepnoscIlosci(Produkt produkt, int ilosc) {
        if (ilosc < produkt.getDostepny()){
            return false;
        }
        else{
            return true;
        }
    }

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

    public static Vector<Transakcja> wyszukajTransakcja(LocalDate dataPoczatku, LocalDate dataKonca, Vector<Produkt> sprzet) {
        Vector<Transakcja> tempTransakcje = new Vector<>();
        for (int g = 0; g < klienci.size(); g++){
            for (int h = 0; h < klienci.get(g).getZakupy().size(); h++){
                tempTransakcje.add(klienci.get(g).getZakupy().get(h));
            }
        }
        if(dataPoczatku != null){
            for(int x = 0; x < tempTransakcje.size(); x++){
                if (dataPoczatku != tempTransakcje.get(x).getDataPaczatku()){
                    tempTransakcje.remove(x);
                }
            }
        }
        if(dataKonca != null){
            for(int x = 0; x < tempTransakcje.size(); x++){
                if (dataKonca != tempTransakcje.get(x).getDataKonca()){
                    tempTransakcje.remove(x);
                }
            }
        }
        if(sprzet != null){
            for(int x = 0; x < tempTransakcje.size(); x++){
                if (sprzet != tempTransakcje.get(x).getSprzet()){
                    tempTransakcje.remove(x);
                }
            }
        }
        return tempTransakcje;
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
            Scanner sck = new Scanner(System.in);
            System.out.println("Wybierz opcje: \n" +
                                "1. Marcin Gnap\n" +
                                "2. Jakub Fajkowski\n" +
                                "3. Dominik Gerlach\n" +
                                "4. Klaudia Kowalska\n" +
                                "5. Alicja Nowak\n" +
                                "6. Powrot\n");
            int PK = sck.nextInt();
            int wyborPK = PK + 1;
            if (wyborPK > klienci.size() + 2 || wyborPK < 1){
                System.out.println("Nie ma takiej opcji...");
            }
            else if (wyborPK == klienci.size() + 2) {
                return;
            }
            else {
                menuKlienta(wyborPK-1);
            }
        }
    }

    public static void menuPosredniePracownika(){
        for (; ;) {
            Scanner scp = new Scanner(System.in);
            System.out.println("Wybierz opcje: \n" +
                    "1. Martyna Wojciechowska\n" +
                    "2. Grzegorz Brzeczyszczykiewicz\n" +
                    "3. Julia Nowakowska\n" +
                    "4. Henryk Garncarski\n" +
                    "5. Edyta Kobieraj\n" +
                    "6. Powrot\n");
            int PK = scp.nextInt();
            int wyborPK = PK + 1;
            if (wyborPK > pracownicy.size() + 2 || wyborPK < 1){
                System.out.println("Nie ma takiej opcji...");
            }
            else if (wyborPK == pracownicy.size() + 2) {
                return;
            }
            else {
                menuPracownika(wyborPK-1);
            }
        }
    }

    public static void menuKlienta(int klient){
        for (;;){
            Scanner sck = new Scanner(System.in);
            System.out.println("Wybierz opcje: \n" +
                                "1. Wyswietlenie dostepnych ofert\n" +
                                "2. Wypozyczenie wybranego produktu\n" +
                                "3. Rezerwacja wybranego produktu\n" +
                                "4. Przedluzenie wypozyczenia\n" +
                                "5. Anulowanie rezerwacji\n" +
                                "6. Zgloszenie zgubienia wypozyczonego produktu\n" +
                                "7. Powrot\n");
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
                    Vector<Produkt> zamowienie = new Vector<>();
                    zamowienie.add(oferty.get(wyborWypozyczenie - 1));
                    oferty.get(wyborWypozyczenie - 1).setDostepny(oferty.get(wyborWypozyczenie - 1).getDostepny() - 1);
                    Vector<LocalDate> dataWypozyczenia = klienci.get(klient).okresCzasuKlienta(oferty.get(wyborWypozyczenie));

                    Transakcja transakcja = new Transakcja(dataWypozyczenia.get(0), dataWypozyczenia.get(1), 0, zamowienie, 0);
                    klienci.get(klient).dodajTransakcje(transakcja);
                    break;
                case 3:
                    System.out.println("Wybierz numer produktu, ktory chcesz zarezerwowac: ");
                    Scanner scNumerProduktuRezerwacja = new Scanner(System.in);
                    int wyborRezerwacja = scNumerProduktuRezerwacja.nextInt();
                    Vector<Produkt> rezerwacja = new Vector<>();
                    rezerwacja.add(oferty.get(wyborRezerwacja - 1));
                    if(oferty.get(wyborRezerwacja - 1).getDostepny() > 0) {
                        Vector<LocalDate> dataRezerwacji = klienci.get(klient).okresCzasuKlienta(oferty.get(wyborRezerwacja - 1));
                        if(!sprawdzKolidacje(oferty.get(wyborRezerwacja - 1), dataRezerwacji.get(0), dataRezerwacji.get(1))){
                            oferty.get(wyborRezerwacja - 1).setDostepny(oferty.get(wyborRezerwacja - 1).getDostepny() - 1);
                            Transakcja transakcjaRezerwacja = new Transakcja(dataRezerwacji.get(0), dataRezerwacji.get(1), 0, rezerwacja, 0);
                            klienci.get(klient).dodajTransakcje(transakcjaRezerwacja);
                        }
                        else {
                            System.out.println("Rezerwacja pokrywa sie z innym zamowieniem...");
                        }
                    }
                    else{
                        System.out.println("Brak wystarczajacej liczby produktow...");
                    }
                    break;
                case 4:
                    System.out.println("Twoje transakcje: ");
                    for (int k = 0; k < klienci.get(klient).getZakupy().size(); k++){
                        int kn = k + 1;
                        System.out.println(kn + ". ");
                        for (int kns = 0; kns < klienci.get(klient).getZakupy().get(k).getSprzet().size(); kns++) {
                            System.out.println(klienci.get(klient).getZakupy().get(k).getSprzet().get(kns).getNazwa() + " x " + klienci.get(klient).getZakupy().get(k).getSprzet().get(kns).getDostepny());
                        }
                    }
                    System.out.println("Wybierz transakcje, ktora chcesz przedluzyc: ");
                    Scanner scPrzedluzenie = new Scanner(System.in);
                    int wyborPrzedluzenie = scPrzedluzenie.nextInt() - 1;

                    Scanner scKoniecRok = new Scanner(System.in);
                    Scanner scKoniecMiesiac = new Scanner(System.in);
                    Scanner scKoniecDzien = new Scanner(System.in);
                    System.out.println("Podaj nowa date koncowa: ");
                    System.out.println("Podaj rok: ");
                    int rok = scKoniecRok.nextInt();
                    System.out.println("Podaj miesiac (liczbowo): ");
                    int miesiac = scKoniecMiesiac.nextInt();
                    System.out.println("Podaj dzien: ");
                    int dzien = scKoniecDzien.nextInt();
                    LocalDate nowaDataKonca = LocalDate.of(rok, miesiac, dzien);

                    if (sprawdzKolidacje(klienci.get(klient).getZakupy().get(wyborPrzedluzenie).getSprzet().get(0), klienci.get(klient).getZakupy().get(wyborPrzedluzenie).getDataPaczatku(), nowaDataKonca)){
                        System.out.println("Nie mozna przedluzyc wypozyczenia...");
                    }
                    else {
                        klienci.get(klient).przedluzenie(wyborPrzedluzenie, nowaDataKonca);
                    }
                    break;
                case 5:
                    if(klienci.get(klient).getZakupy().size() > 0){
                        System.out.println("Twoje transakcje: ");
                         for (int k = 0; k < klienci.get(klient).getZakupy().size(); k++){
                            int kn = k + 1;
                            System.out.println(kn + ". ");
                                for (int kns = 0; kns < klienci.get(klient).getZakupy().get(k).getSprzet().size(); kns++) {
                                System.out.println(klienci.get(klient).getZakupy().get(k).getSprzet().get(kns).getNazwa() + " x " + klienci.get(klient).getZakupy().get(k).getSprzet().get(kns).getDostepny());
                            }
                        }
                        System.out.println("Wybierz rezerwacje do anulowania: ");
                        Scanner scAnulowanie = new Scanner(System.in);
                        int wyborAnulowanie = scAnulowanie.nextInt();

                        Scanner screzerwacjarok = new Scanner(System.in);
                        Scanner screzerwacjamiesiac = new Scanner(System.in);
                        Scanner screzerwacjadzien = new Scanner(System.in);
                        System.out.println("Podaj dzisiejsza date: ");
                        System.out.println("Podaj rok: ");
                        int rokr = screzerwacjarok.nextInt();
                        System.out.println("Podaj miesiac (liczbowo): ");
                        int miesiacr = screzerwacjamiesiac.nextInt();
                        System.out.println("Podaj dzien: ");
                        int dzienr = screzerwacjadzien.nextInt();
                        LocalDate dataDzisiaj = LocalDate.of(rokr, miesiacr, dzienr);

                        if(dataDzisiaj.isBefore(klienci.get(klient).getZakupy().get(wyborAnulowanie - 1).getDataPaczatku())){
                            klienci.get(klient).anulujRezerwacje(klienci.get(klient).getZakupy().get(wyborAnulowanie - 1), dataDzisiaj);
                        }
                        else{
                            System.out.println("Nie mozna anulowac wybranej transakcji...");
                        }
                    }
                    else {
                        System.out.println("Nie masz zadnej rezerwacji.");
                    }
                    break;
                case 6:
                    System.out.println("Twoje transakcje: ");
                    for (int k = 0; k < klienci.get(klient).getZakupy().size(); k++){
                        int kn = k + 1;
                        System.out.println(kn + ". ");
                        for (int kns = 0; kns < klienci.get(klient).getZakupy().get(k).getSprzet().size(); kns++) {
                            System.out.println(klienci.get(klient).getZakupy().get(k).getSprzet().get(kns).getNazwa() + " x " + klienci.get(klient).getZakupy().get(k).getSprzet().get(kns).getDostepny());
                        }
                    }
                    System.out.println("Wybierz zgubiony produkt: ");
                    Scanner scZgubienie = new Scanner(System.in);
                    int wyborZgubienie = scZgubienie.nextInt();
                    klienci.get(klient).zgubienie(klienci.get(klient).getZakupy().get(wyborZgubienie - 1));
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Nie ma takiej opcji...");
            }
        }
    }

    public static void menuPracownika(int pracownik){
        for (;;){
            Scanner scp = new Scanner(System.in);
            System.out.println("Wybierz opcje: \n" +
                                "1. Stworzenie nowej oferty\n" +
                                "2. Nakazanie zwrotu\n" +
                                "3. Sprawdzenie historii wypozyczen\n" +
                                "4. Sprawdzenie zalegania z oplatami\n" +
                                "5. Powrot\n");
            int wyborPracownika = scp.nextInt();
            switch (wyborPracownika){
                case 1:
                    Produkt nowyProdukt = pracownicy.get(pracownik).stworzOferte();
                    Vector<Integer> indeksy = new Vector<Integer>();
                    indeksy = wyszukajProdukt(nowyProdukt.getNazwa(), nowyProdukt.getCena(), 0);
                    if (indeksy.size() != 0){
                        oferty.get(indeksy.get(0)).setDostepny(oferty.get(indeksy.get(0)).getDostepny() + nowyProdukt.getDostepny());
                    }
                    else {
                        oferty.add(nowyProdukt);
                    }
                    break;
                case 2:
                    System.out.println("Wybierz klienta: ");
                    for (int k = 0; k < klienci.size(); k++){
                        int kn = k + 1;
                        System.out.println(kn + ". " + klienci.get(k).getImie() + " " + klienci.get(k).getNazwisko());
                    }
                    Scanner scWyborKlienta = new Scanner(System.in);
                    int wyborKlienta = scWyborKlienta.nextInt() - 1;
                    System.out.println("Wybierz transakcje wybranego klienta: ");
                    for (int k = 0; k < klienci.get(wyborKlienta).getZakupy().size(); k++){
                        int kn = k + 1;
                        System.out.println(kn + ". ");
                        for (int kns = 0; kns < klienci.get(wyborKlienta).getZakupy().get(k).getSprzet().size(); kns++) {
                            System.out.println(klienci.get(wyborKlienta).getZakupy().get(k).getSprzet().get(kns).getNazwa() + " x " + klienci.get(wyborKlienta).getZakupy().get(k).getSprzet().get(kns).getDostepny());
                        }
                    }
                    Scanner scWyborTransakcji = new Scanner(System.in);
                    int wyborTransakcji = scWyborTransakcji.nextInt() - 1;
                    pracownicy.get(pracownik).nakazZwrotu(klienci.get(wyborKlienta).getZakupy().get(wyborTransakcji));
                    break;
                case 3:
                    System.out.println("Wybierz klienta: ");
                    for (int k = 0; k < klienci.size(); k++){
                        int kn = k + 1;
                        System.out.println(kn + ". " + klienci.get(k).getImie() + " " + klienci.get(k).getNazwisko());
                    }
                    Scanner scWyborKlientaSzczegoly = new Scanner(System.in);
                    int wyborKlientaSzczegoly = scWyborKlientaSzczegoly.nextInt() - 1;
                    pracownicy.get(pracownik).sprawdzHistorie(klienci.get(wyborKlientaSzczegoly));
                    break;
                case 4:
                    System.out.println("Wybierz klienta: ");
                    for (int k = 0; k < klienci.size(); k++){
                        int kn = k + 1;
                        System.out.println(kn + ". " + klienci.get(k).getImie() + " " + klienci.get(k).getNazwisko());
                    }
                    Scanner scWyborKlientaDoplaty = new Scanner(System.in);
                    int wyborKlientaDoplaty = scWyborKlientaDoplaty.nextInt() - 1;
                    float sumaDoplat = 0;
                    for (int wkd = 0; wkd < klienci.get(wyborKlientaDoplaty).getZakupy().size(); wkd++){
                        sumaDoplat = sumaDoplat + klienci.get(wyborKlientaDoplaty).getZakupy().get(wkd).getDoplata();
                    }
                    System.out.println("Suma oczekiwanych srodkow wynosi: " + sumaDoplat + " zl");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Nie ma takiej opcji...");
            }
        }
    }

}