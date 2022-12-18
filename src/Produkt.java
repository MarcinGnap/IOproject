import java.lang.String;

public class Produkt {

    private String nazwa;
    private float cena;
    private int dostepny;
    private char status;

    /**
     *
     * @param nazwa
     * @param cena
     */
    public Produkt(String nazwa, float cena) {
        this.nazwa = nazwa;
        setCena(cena);
    }

    public String getNazwa() {
        return this.nazwa;
    }

    public float getCena() {
        return this.cena;
    }

    /**
     *
     * @param cena
     */
    public void setCena(float cena) {
        this.cena = cena;
    }

    public int getDostepny() {
        return this.dostepny;
    }

    /**
     *
     * @param dostepny
     */
    public void setDostepny(int dostepny) {
        this.dostepny = dostepny;
    }

    public char getStatus() {
        return this.status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(char status) {
        this.status = status;
    }
}