import java.io.Serializable;
import java.util.Objects;
public class Personel implements Serializable {
    private static int idcounter=0;
    private int id;
    private String personelAdi;

    public Personel(String personelAdi) {
        this.personelAdi = personelAdi;
        idcounter++;
        this.id=idcounter;
    }

    public int getId() {
        return id;
    }

    public String getPersonelAdi() {
        return personelAdi;
    }

    public void setPersonelAdi(String personelAdi) {
        this.personelAdi = personelAdi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personel personel = (Personel) o;
        return id == personel.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
