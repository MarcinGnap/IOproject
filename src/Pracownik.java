import java.lang.String;

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

    public boolean stworzOferte() {
        // TODO - implement Pracownik.stworzOferte
        throw new UnsupportedOperationException();
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