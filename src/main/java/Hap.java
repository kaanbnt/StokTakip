public class Hap extends Urun {
    private int hapAdeti;

    public Hap() {
    }

    public Hap(String urunAdi, double fiyat, int hapAdeti) {
        super(urunAdi, fiyat);
        this.hapAdeti = hapAdeti;
    }

    public int getHapAdeti() {
        return hapAdeti;
    }

    public void setHapAdeti(int hapAdeti) {
        this.hapAdeti = hapAdeti;
    }

    @Override
    public String getUrunTuru() {
        return "Hap";
    }
}
