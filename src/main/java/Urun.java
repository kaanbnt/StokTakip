import java.io.Serializable;

public abstract class Urun implements Serializable {
    private static int idcounter=0;
    private int id;
    private String urunAdi;
    private double fiyat;
    public abstract String getUrunTuru();

    public Urun() {
    }

    public Urun(String urunAdi, double fiyat) {
        idcounter++;
        this.id = idcounter;
        this.urunAdi = urunAdi;
        this.fiyat = fiyat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Urun urun = (Urun) o;
        return id == urun.id;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

}
