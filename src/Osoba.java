import java.lang.String;

public abstract class Osoba{

    private String imie;
    private String nazwisko;
    private long pesel;
    private float numerTel;
    private String email;

    public String getImie() {
        return this.imie;
    }

    /**
     *
     * @param imie
     */
    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return this.nazwisko;
    }

    /**
     *
     * @param nazwisko
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public float getPesel() {
        return this.pesel;
    }

    /**
     *
     * @param pesel
     */
    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    public float getNumerTel() {
        return this.numerTel;
    }

    /**
     *
     * @param numerTel
     */
    public void setNumerTel(float numerTel) {
        this.numerTel = numerTel;
    }

    public String getEmail() {
        return this.email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}