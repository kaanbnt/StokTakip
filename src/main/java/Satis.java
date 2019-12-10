import java.time.LocalDateTime;
public class Satis {
    private Musteri musteri;
    private Urun urun;
    private int adet;
    private LocalDateTime tarih;

    public Satis() {
    }

    public Satis(Musteri musteri, Urun urun, int adet, LocalDateTime tarih) {
        this.musteri = musteri;
        this.urun = urun;
        this.adet = adet;
        this.tarih = tarih;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    public LocalDateTime getTarih() {
        return tarih;
    }

    public void setTarih(LocalDateTime tarih) {
        this.tarih = tarih;
    }
}
