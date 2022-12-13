import java.lang.String;
import java.util.Scanner;

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
        //throw new UnsupportedOperationException();
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
        //throw new UnsupportedOperationException();
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
    public Transakcja szczegoly(Transakcja transakcja) {
        // TODO - implement Pracownik.szczegoly
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param transakcja
     */
    public float sprawdzDoplate(Transakcja transakcja) {
        // TODO - implement Pracownik.sprawdzDoplate
        return transakcja.getDoplata();
        //throw new UnsupportedOperationException();
    }

    public void zmienDostepnosc(int ilosc, Produkt produkt){
        produkt.setDostepny(ilosc);
    }

}