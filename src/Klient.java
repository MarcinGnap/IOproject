import java.lang.String;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Klient extends Osoba {

    private Vector<Transakcja> zakupy = new Vector<>();
    private Vector<Produkt> oferty = new Vector<>();

    /**
     *
     * @param imie
     * @param nazwisko
     * @param pesel
     * @param numerTel
     * @param email
     */
    public Klient(String imie, String nazwisko, long pesel, float numerTel, String email) {
        setImie(imie);
        setNazwisko(nazwisko);
        setPesel(pesel);
        setNumerTel(numerTel);
        setEmail(email);
    }

    public Klient(String imie, String nazwisko, long pesel, float numerTel, String email, Vector<Transakcja> zakupy) {
        setImie(imie);
        setNazwisko(nazwisko);
        setPesel(pesel);
        setNumerTel(numerTel);
        setEmail(email);
        setZakupy(zakupy);
    }

    public Vector<Transakcja> getZakupy() {
        return this.zakupy;
    }

    /**
     *
     * @param zakupy
     */
    public void setZakupy(Vector<Transakcja> zakupy) {
        this.zakupy = zakupy;
    }

    public Vector<Produkt> getOferty() {
        return oferty;
    }

    /**
     *
     * @param produkt
     */
    public Vector<LocalDate> rezerwacja(Produkt produkt) {
        // TODO - implement Klient.rezerwacja
        Vector<LocalDate> data = new Vector<>();
        Scanner screzerwacja = new Scanner(System.in);
        System.out.println("Podaj date poczatku wypozyczenia (YYYY-MM-DD): ");
        String wyborKlientaPocz = screzerwacja.next();
        LocalDate dataPocz = LocalDate.parse(wyborKlientaPocz);
        System.out.println("Podaj date konca wypozyczenia (YYYY-MM-DD): ");
        String wyborKlientaKon = screzerwacja.next();
        LocalDate dataKonca = LocalDate.parse(wyborKlientaKon);
        data.add(dataPocz);
        data.add(dataKonca);

        return data;
    }

    /**
     *
     * @param produkt
     */
    public Vector<LocalDate> wypozyczenieKlienta(Produkt produkt) {
        // TODO - implement Klient.wypozyczenieKlienta
        Vector<LocalDate> data = new Vector<>();
        Scanner screzerwacjarok = new Scanner(System.in);
        Scanner screzerwacjamiesiac = new Scanner(System.in);
        Scanner screzerwacjadzien = new Scanner(System.in);
        System.out.println("Podaj dzisiejsza date: ");
        System.out.println("Podaj rok: ");
        int rok = screzerwacjarok.nextInt();
        System.out.println("Podaj miesiac (liczbowo): ");
        int miesiac = screzerwacjamiesiac.nextInt();
        System.out.println("Podaj dzien: ");
        int dzien = screzerwacjadzien.nextInt();
        LocalDate dataPocz = LocalDate.of(rok, miesiac, dzien);
        System.out.println("Podaj przwidywana date konca wypozyczenia: ");
        System.out.println("Podaj rok: ");
        rok = screzerwacjarok.nextInt();
        System.out.println("Podaj miesiac (liczbowo): ");
        miesiac = screzerwacjamiesiac.nextInt();
        System.out.println("Podaj dzien: ");
        dzien = screzerwacjadzien.nextInt();
        LocalDate dataKonca = LocalDate.of(rok, miesiac, dzien);
        data.add(dataPocz);
        data.add(dataKonca);

        return data;
    }

    /**
     *
     * @param transakcja
     * @param okresCzasu
     */
    public boolean przedluzenie(Transakcja transakcja, String okresCzasu) {
        // TODO - implement Klient.przedluzenie
        // z menu klienta?
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param aktualnaData
     * @param transakcja
     */
    public boolean anulujRezerwacje(Transakcja transakcja, LocalDate aktualnaData) {
        if (aktualnaData.isBefore(transakcja.getDataPaczatku())){
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
    public void zgubienie(Transakcja transakcja) {
        // TODO - implement Klient.zgubienie
        Vector<Produkt> tempSprzetzgubienie = transakcja.getSprzet();
        System.out.println("Wybierz produkt, ktory zostal zgubiony (jesli wszystkie wybierz 0): ");
        Scanner scZgubienie = new Scanner(System.in);
        int wyborZgubienie = scZgubienie.nextInt();
        if (wyborZgubienie == 0){
            for (int i = 0; i < transakcja.getSprzet().size(); i++){
                tempSprzetzgubienie.get(i).setStatus('z');
            }
            transakcja.setSprzet(tempSprzetzgubienie);
        }
        else if (wyborZgubienie > 0 && wyborZgubienie <= transakcja.getSprzet().size()){
            tempSprzetzgubienie.get(wyborZgubienie).setStatus('z');
            transakcja.setSprzet(tempSprzetzgubienie);
        }
        else{
            System.out.println("Wybrana pozycja nie znajduje się na liscie.");
        }
    }

}