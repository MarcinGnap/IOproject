import java.lang.String;
import java.time.LocalDate;
import java.util.ArrayList;

public class Klient extends Osoba {

    private ArrayList<Transakcja> zakupy = new ArrayList<Transakcja>();
    private ArrayList<Produkt> oferty = new ArrayList<Produkt>();

    /**
     *
     * @param imie
     * @param nazwisko
     * @param pesel
     * @param numerTel
     * @param email
     */
    public Klient(String imie, String nazwisko, float pesel, float numerTel, String email) {
        setImie(imie);
        setNazwisko(nazwisko);
        setPesel(pesel);
        setNumerTel(numerTel);
        setEmail(email);
        //throw new UnsupportedOperationException();
    }

    public ArrayList<Transakcja> getZakupy() {
        return this.zakupy;
    }

    /**
     *
     * @param zakupy
     */
    public void setZakupy(ArrayList<Transakcja> zakupy) {
        this.zakupy = zakupy;
    }

    public ArrayList<Produkt> getOferty() {
        // TODO - implement Klient.getOferty
        //throw new UnsupportedOperationException();
        return oferty;
    }

    /**
     *
     * @param produkt
     */
    public boolean rezerwacja(Produkt produkt) {
        // TODO - implement Klient.rezerwacja
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param produkt
     * @param okresCzasu
     */
    public boolean wypozyczenieKlienta(Produkt produkt, String okresCzasu) {
        // TODO - implement Klient.wypozyczenieKlienta
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param transakcja
     * @param okresCzasu
     */
    public boolean przedluzenie(Transakcja transakcja, String okresCzasu) {
        // TODO - implement Klient.przedluzenie
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param aktualnaData
     * @param transakcja
     */
    public boolean anulujRezerwacje(Transakcja transakcja, LocalDate aktualnaData) {
        // TODO - implement Klient.anulujRezerwacje
        if (aktualnaData.compareTo(transakcja.getDataPaczatku()) > 0){
            zakupy.remove(transakcja);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     *
     * @param transakcja
     */
    public float zgubienie(Transakcja transakcja) {
        // TODO - implement Klient.zgubienie
        throw new UnsupportedOperationException();
    }

}