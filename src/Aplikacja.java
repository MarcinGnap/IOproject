import java.lang.String;
import java.util.Scanner;
import java.util.Vector;
import java.time.LocalDate;

public class Aplikacja {

    private Vector<Produkt> oferty = new Vector<>();
    private Vector<Klient> klienci = new Vector<>();
    private Vector<Pracownik> pracownicy = new Vector<>();
    private Vector<Transakcja> transakcje = new Vector<>();

    public Aplikacja() {
        // TODO - implement Aplikacja.Aplikacja
        //throw new UnsupportedOperationException();
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
    public Vector<Produkt> szukajProdukt(String nazwa, float cena, int dostep) {
        // TODO - implement Aplikacja.szukajProdukt
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
        //throw new UnsupportedOperationException();
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
        // throw new UnsupportedOperationException();
    }

    /**
     *
     * @param produkt
     * @param ilosc
     */
    public boolean sprawdzDostepnoscIlosci(Produkt produkt, int ilosc) {
        // TODO - implement Aplikacja.sprawdzDostepnoscIlosci
        if (ilosc < produkt.getDostepny()){
            return false;
        }
        else{
            return true;
        }
        //throw new UnsupportedOperationException();
    }

    /**
     *
     * @param nazwisko
     * @param pesel
     * @param imie
     */
    public Vector<Klient> wyszukajKlienta(String imie, String nazwisko, float pesel) {
        // TODO - implement Aplikacja.wyszukajKlienta
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
        //throw new UnsupportedOperationException();
    }

    /**
     *  @param dataPoczatku
     * @param dataKonca
     * @param sprzet
     */
    public Vector<Transakcja> wyszukajTransakcja(LocalDate dataPoczatku, LocalDate dataKonca, Vector<Produkt> sprzet) {
        // TODO - implement Aplikacja.wyszukajTransakcja
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
        //throw new UnsupportedOperationException();
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
                    menuKlienta();
                    break;
                case 2:
                    menuPracownika();
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
            System.out.println("Wybierz opcje: ");
            int wyborKlienta = sck.nextInt();
            switch (wyborKlienta){
                case 1:
                    break;
                default:
                    System.out.println("Nie ma takiej opcji...");
            }
        }
    }

    public static void menuPracownika(){
        for (;;){
            Scanner scp = new Scanner(System.in);
            System.out.println("Wybierz opcje: ");
            int wyborPracownika = scp.nextInt();
            switch (wyborPracownika){
                case 1:
                    break;
                default:
                    System.out.println("Nie ma takiej opcji...");
            }
        }
    }

}