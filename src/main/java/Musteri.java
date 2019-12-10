import java.io.Serializable;

public class Musteri implements Serializable {
    private static int idcounter=0;
    private int id;
    private String adi;

    public Musteri(String adi) {
        idcounter++;
        this.id = idcounter;
        this.adi = adi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }
}
