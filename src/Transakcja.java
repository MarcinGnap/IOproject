import java.lang.String;
import java.util.Vector;
import java.time.LocalDate;

public class Transakcja {

    private LocalDate dataPaczatku;
    private LocalDate dataKonca;
    private float kosztPocz;
    private Vector<Produkt> sprzet = new Vector<>();
    private float doplata;

    /**
     *
     * @param dataPoczatku
     * @param koszt
     * @param sprzet
     */
    public Transakcja(LocalDate dataPoczatku, float koszt, Vector<Produkt> sprzet) {
        setDataPaczatku(dataPoczatku);
        setKosztPocz(koszt);
        this.sprzet = sprzet;
    }

    /**
     *
     * @param dataPoczatku
     * @param dataKonca
     * @param koszt
     * @param sprzet
     * @param doplata
     */

    public Transakcja(LocalDate dataPoczatku, LocalDate dataKonca, float koszt, Vector<Produkt> sprzet, float doplata) {
        setDataPaczatku(dataPoczatku);
        setDataKonca(dataKonca);
        setKosztPocz(koszt);
        this.sprzet = sprzet;
        setDoplata(doplata);
    }

    public LocalDate getDataPaczatku() {
        return this.dataPaczatku;
    }

    /**
     *
     * @param dataPaczatku
     */
    public void setDataPaczatku(LocalDate dataPaczatku) {
        this.dataPaczatku = dataPaczatku;
    }

    public LocalDate getDataKonca() {
        return this.dataKonca;
    }

    /**
     *
     * @param dataKonca
     */
    public void setDataKonca(LocalDate dataKonca) {
        this.dataKonca = dataKonca;
    }

    public float getKosztPocz() {
        return this.kosztPocz;
    }

    /**
     *
     * @param kosztPocz
     */
    public void setKosztPocz(float kosztPocz) {
        this.kosztPocz = kosztPocz;
    }

    public Vector<Produkt> getSprzet() {
        return this.sprzet;
    }

    /**
     *
     * @param sprzet
     */
    public void setSprzet(Vector<Produkt> sprzet) {
        this.sprzet = sprzet;
    }

    public float getDoplata() {
        return this.doplata;
    }

    /**
     *
     * @param doplata
     */
    public void setDoplata(float doplata) {
        this.doplata = doplata;
    }

}