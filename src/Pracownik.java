import java.lang.String;
import java.util.Scanner;
import java.util.Vector;

public class Pracownik extends Osoba {

    private String stanowisko;

    public Pracownik(String imie, String nazwisko, long pesel, float numerTel, String email, String stanowisko) {
        setImie(imie);
        setNazwisko(nazwisko);
        setPesel(pesel);
        setNumerTel(numerTel);
        setEmail(email);
        setStanowisko(stanowisko);
    }

    public String getStanowisko() {
        return this.stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public Produkt stworzOferte() {
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

    public void nakazZwrotu(Transakcja transakcja) {
        // TODO - implement Pracownik.nakazZwrotu
        szczegoly(transakcja);
        Vector<Produkt> tempSprzetNakaz = transakcja.getSprzet();
        System.out.println("Wybierz produkt, ktory ma zostac zwrocony (jesli wszystkie wybierz 0): ");
        Scanner scNakaz = new Scanner(System.in);
        int wyborNakaz = scNakaz.nextInt();
        if (wyborNakaz == 0){
            for (int i = 0; i < transakcja.getSprzet().size(); i++){
                tempSprzetNakaz.get(i).setStatus('n');
            }
            transakcja.setSprzet(tempSprzetNakaz);
        }
        else if (wyborNakaz > 0 && wyborNakaz <= transakcja.getSprzet().size()){
            tempSprzetNakaz.get(wyborNakaz).setStatus('n');
            transakcja.setSprzet(tempSprzetNakaz);
        }
        else{
            System.out.println("Wybrana pozycja nie znajduje się na liscie.");
        }
    }

    public void sprawdzHistorie(Klient klientHistoria) {
        System.out.println("Wszystkie wypozyczenia wybranego klienta: ");
        for (int j = 0; j < klientHistoria.getZakupy().size(); j++){
            int a = j + 1;
            System.out.println(a + ". ");
            for (int x = 0; x >  + klientHistoria.getZakupy().get(j).getSprzet().size(); x++){
                int c = x + 1;
                System.out.println("    " + c + ". " + klientHistoria.getZakupy().get(j).getSprzet().get(x).getNazwa() + "   x " + klientHistoria.getZakupy().get(j).getSprzet().get(x).getDostepny());
            }
        }
        System.out.println("Wybierz transakcje, ktorej szczegoly chcesz sprawdzic (jesli chcesz wrocic wybierz 0): ");
        Scanner scHistoria = new Scanner(System.in);
        int wyborHistoria = scHistoria.nextInt();
        if (wyborHistoria == 0){
            return;
        }
        else if (wyborHistoria > 0 && wyborHistoria <= klientHistoria.getZakupy().size()){
            szczegoly(klientHistoria.getZakupy().get(wyborHistoria));
        }
        else{
            System.out.println("Wybrana pozycja nie znajduje się na liscie.");
        }
    }

    public void szczegoly(Transakcja transakcja) {
        Vector<Produkt> tempSprzet = transakcja.getSprzet();
        System.out.println("Klient: ");
        for (int i = 0; i < tempSprzet.size(); i++){
            int b = i + 1;
            System.out.println(b + ".");
            System.out.println("Nazwa produkt: " + tempSprzet.get(i).getNazwa());
            System.out.println("Ilosc: " + tempSprzet.get(i).getDostepny());
        }
        System.out.println("Data poczatku: " + transakcja.getDataPaczatku());
        System.out.println("Data konca: " + transakcja.getDataKonca());
        System.out.println("Koszt poczatkowy: " + transakcja.getKosztPocz() + " zl");
        System.out.println("Doplata: " + transakcja.getDoplata() + " zl");
    }

    public void sprawdzDoplate(Transakcja transakcja) {
        System.out.println("Aktualna doplata wynosi: " + transakcja.getDoplata() + " zl");
    }

    public void zmienDostepnosc(int ilosc, Produkt produkt){
        produkt.setDostepny(ilosc);
    }

}