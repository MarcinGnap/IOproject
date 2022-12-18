import java.lang.String;
import java.util.Scanner;
import java.util.Vector;

public class Pracownik extends Osoba {

    private char stanowisko;

    /**
     *
     * @param imie
     * @param nazwisko
     * @param pesel
     * @param numerTel
     * @param email
     */
    public Pracownik(String imie, String nazwisko, float pesel, float numerTel, String email, char stanowisko) {
        setImie(imie);
        setNazwisko(nazwisko);
        setPesel(pesel);
        setNumerTel(numerTel);
        setEmail(email);
        setStanowisko(stanowisko);
    }

    public char getStanowisko() {
        return this.stanowisko;
    }

    /**
     *
     * @param stanowisko
     */
    public void setStanowisko(char stanowisko) {
        this.stanowisko = stanowisko;
    }

    public Produkt stworzOferte() {
        // TODO - implement Pracownik.stworzOferte
        Scanner scOferta = new Scanner(System.in);
        System.out.println("Wpisz nazwe: ");
        String nazwa = scOferta.next();
        System.out.println("Wpisz cene: ");
        float cena = scOferta.nextFloat();
        Produkt nowyProdukt = new Produkt(nazwa, cena);
        System.out.println("Wpisz ilosc: ");
        int ilosc = scOferta.nextInt();
        nowyProdukt.setDostepny(ilosc);
        char status = 'd';
        nowyProdukt.setStatus(status);
        return nowyProdukt;
    }

    /**
     *
     * @param produkt
     */
    public boolean finalizacjaWypozyczenia(Produkt produkt) {
        // TODO - implement Pracownik.finalizacjaWypozyczenia
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param transakcja
     */
    public boolean nakazZwrotu(Transakcja transakcja) {
        // TODO - implement Pracownik.nakazZwrotu
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param transakcja
     * @param okresCzasu
     */
    public boolean przedluzenieFinalizacja(Transakcja transakcja, String okresCzasu) {
        // TODO - implement Pracownik.przedluzenieFinalizacja
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param zakupy
     */
    public Transakcja sprawdzHistorie(Transakcja zakupy) {
        // TODO - implement Pracownik.sprawdzHistorie
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param transakcja
     */
    public void szczegoly(Transakcja transakcja) {
        // TODO - implement Pracownik.szczegoly
        Vector<Produkt> tempSprzet = transakcja.getSprzet();
        System.out.println("Klient: ");
        for (int i = 0; i < tempSprzet.size(); i++){
            int b = i + 1;
            System.out.println(b + ".");
            System.out.println("Nazwa produkt: " + tempSprzet.get(i).getNazwa());
            System.out.println("Ilosc: " + tempSprzet.get(i).getDostepny());
        }
        System.out.println("Data poczatku: " + transakcja.getDataPaczatku());
        System.out.println("Koszt poczatkowy: " + transakcja.getKosztPocz());
        System.out.println("Doplata: " + transakcja.getDoplata());
    }

    /**
     *
     * @param transakcja
     */
    public float sprawdzDoplate(Transakcja transakcja) {
        // TODO - implement Pracownik.sprawdzDoplate
        return transakcja.getDoplata();
    }

    public void zmienDostepnosc(int ilosc, Produkt produkt){
        produkt.setDostepny(ilosc);
    }

}