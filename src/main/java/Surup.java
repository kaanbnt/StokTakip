import java.util.Objects;
public class Surup extends Urun {
    private int adet;

    public Surup() {
    }

    public Surup(String urunAdi, double fiyat, int adet) {
        super(urunAdi, fiyat);
        this.adet = adet;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    @Override
    public String getUrunTuru() {
        return "Şurup";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), adet);
    }
}
