import java.io.Serializable;

public class Stok implements Serializable {
    private Personel personel;
    private Urun urun;
    private int adet;

    public Stok() {
    }

    public Stok(Personel personel, Urun urun, int adet) {
        this.personel = personel;
        this.urun = urun;
        this.adet = adet;
    }


    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }
}
