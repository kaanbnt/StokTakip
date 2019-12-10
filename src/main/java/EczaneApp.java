import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EczaneApp {

    static List<Satis> satisList = new ArrayList<>();
    static List<Personel> personelList = new ArrayList<>();
    static List<Musteri> musteriList = new ArrayList<>();
    static ArrayList<Stok> stokList = new ArrayList();
    static boolean cikis = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("************Eczane Stok Takip************");
        System.out.println("1. Ürün Eklemek\n" +
                "2. Satış Yapmak\n" +
                "3. Stok Liste\n" +
                "4. Raporlar\n"+
                "5. Çıkış");
        System.out.println("************Eczane Stok Takip************");

        while (!cikis) {
            System.out.print("\nHangi İşlemi Yapmak İstiyorsunuz: ");
            int secimMenu=scanner.nextInt();
            switch (secimMenu) {
                case 1:
                    urunEkle(stokList, scanner);
                    break;
                case 2:
                    urunSat(scanner);
                    break;
                case 3:
                    stokTakip(stokList, scanner);
                    break;
                case 4:
                    System.out.println("************Raporlama************");
                    System.out.println("1. Personel\n" +
                            "2. Müşteri\n" +
                            "3. Stok\n");
                    System.out.println("Raporlamak İstediğiniz Başlığı Seçiniz: ");
                    int secimRapor=scanner.nextInt();
                    switch (secimRapor) {
                        case 1:
                            raporPersonel();
                            break;
                        case 2:
                            raporMusteri();
                            break;
                        case 3:
                            raporStok();
                            break;
                    }
                    break;
                case 5:
                    cikis=true;
                break;
            }
        }
    }

    public static void listele() {
        System.out.println();
        System.out.println("\tİlaç NO\t\tAdı\t\tAdet");
        System.out.println("-------------------------------");
        for (Stok stok: stokList) {
            System.out.println("\t" +stok.getUrun().getId() + "\t\t" + stok.getUrun().getUrunAdi()+"\t\t"+stok.getAdet());
        }
    }

    private static void urunSat(Scanner scanner) {
        System.out.print("Müşteri Adı: ");
        scanner.nextLine();
        String gelenMusteri=scanner.nextLine();
        Musteri musteri=new Musteri(gelenMusteri);
        musteriList.add(musteri);

        listele();
        System.out.print("\nİstediğiniz İlacın ID'sini Giriniz: ");
        int istedigiUrun=scanner.nextInt();

        System.out.print("Adetini Giriniz: ");
        int istedigiAdet=scanner.nextInt();


        Satis satis= new Satis();
        for (Stok stok:stokList) {
            if(stok.getUrun().getId()==istedigiUrun)
            {
                if (stok.getAdet()>=istedigiAdet)
                {
                    stok.setAdet(stok.getAdet()-istedigiAdet);
                    satis = new Satis(musteri, stok.getUrun(),istedigiAdet, LocalDateTime.now());
                    satisList.add(satis);
                }else{
                    System.out.println("Stokda Yeterli Ürün Adeti Yok. Stok Adeti : " +stok.getAdet());
                }
            }
        }
        listele();
    }

    private static void urunEkle(ArrayList<Stok> stokList, Scanner scanner) {
        System.out.print("Personel Adınızı Giriniz: ");
        scanner.nextLine();
        String gelenPersonel = scanner.nextLine();
        Personel personel = new Personel(gelenPersonel);
        personelList.add(personel);
        System.out.println("Şurup Eklemek İçin 1'i Seçiniz ********** Hap eklemek için 2'yi Seçiniz");
        int secimUrun = scanner.nextInt();
        if (secimUrun == 1) {
            System.out.print("Ürünün Adı: ");
            scanner.nextLine();
            String gelenUrunAd = scanner.nextLine();

            System.out.print("Ürünün Fiyatı: ");
            double gelenFiyat = scanner.nextInt();

            System.out.print("Ürünün Adet:");
            int gelenAdet = scanner.nextInt();

            Surup surup = new Surup(gelenUrunAd, gelenFiyat, gelenAdet);
            Stok stok=new Stok(personel,surup,gelenAdet);
            stokList.add(stok);
        }
        else if (secimUrun == 2) {
            System.out.print("Ürünün Adı: ");
            String gelenUrunAd = scanner.next();

            System.out.print("Ürünün Fiyatı: ");
            double gelenFiyat = scanner.nextInt();

            System.out.print("Ürünün Adeti:");
            int gelenUrunAdet = scanner.nextInt();

            Hap hap = new Hap(gelenUrunAd, gelenFiyat, gelenUrunAdet);
            Stok stok=new Stok(personel,hap,gelenUrunAdet);
            stokList.add(stok);
        }
    }

    private static void stokTakip(ArrayList<Stok> stokList, Scanner scanner) {
        System.out.println("Listelemek istediğiniz ürünü seçin");
        System.out.println("Şurup için 1'e ******** Hap için 2'ye\"");
        int toplamAdet=0;
        int girilenDeger = scanner.nextInt();
        if(girilenDeger==1){
            for (Stok stok : stokList) {
                if(stok.getUrun().getUrunTuru().equals("Şurup")){
                    toplamAdet += stok.getAdet();

                }
            }
            System.out.println("Şurup'un toplam adet : "+toplamAdet);
        }
        else if(girilenDeger==2){
            for (Stok stok : stokList) {
                if(stok.getUrun().getUrunTuru().equals("Hap")){
                    toplamAdet += stok.getAdet();
                }
            }
            System.out.println("Hap'ın toplam adeti : "+toplamAdet);
        }
    }

    private static void personelYaz(List<Personel> personelList){
        File file=new File(".\\VeriTabani\\Personel.txt");
        try (FileOutputStream fileOutputStream=new FileOutputStream(file,false);
             ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(personelList);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void stokYaz(List<Stok> Stok){
        File file=new File(".\\VeriTabani\\Stok.txt");
        try (FileOutputStream fileOutputStream=new FileOutputStream(file,false);
             ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(stokList);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void musteriYaz(List<Musteri> musteri){
        File file=new File(".\\VeriTabani\\Musteri.txt");
        try (FileOutputStream fileOutputStream=new FileOutputStream(file,false);
             ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(musteri);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static List<Personel> personelOku() {
        List<Personel> personelList = null;
        try (FileInputStream fileOut = new FileInputStream(".\\VeriTabani\\Personel.txt");
             ObjectInputStream objectOut = new ObjectInputStream(fileOut);) {
            personelList = (List<Personel>) objectOut.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return personelList;
    }

    private static List<Stok> stokOku() {
        List<Stok> stokList = null;
        try (FileInputStream fileOut = new FileInputStream(".\\VeriTabani\\Stok.txt");
             ObjectInputStream objectOut = new ObjectInputStream(fileOut);) {
            stokList = (List<Stok>) objectOut.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return stokList;
    }

    private static List<Musteri> musteriOku() {
        List<Musteri> musteriList = null;
        try (FileInputStream fileOut = new FileInputStream(".\\VeriTabani\\Musteri.txt");
             ObjectInputStream objectOut = new ObjectInputStream(fileOut);) {
            musteriList = (List<Musteri>) objectOut.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return musteriList;
    }

    private static void raporStok() {
        stokYaz(stokList);

        System.out.println();
        System.out.println("\tİlaç NO\t\tAdı\t\tAdet");
        System.out.println("-------------------------------");
        for (Stok stok: stokOku()) {
            System.out.println("\t" +stok.getUrun().getId() + "\t\t" + stok.getUrun().getUrunAdi()+"\t\t"+stok.getAdet());
        }
    }

    private static void raporMusteri() {
        musteriYaz(musteriList);

        System.out.println();
        System.out.println("\tMüşteri NO\t\tAdı");
        System.out.println("-------------------------------");
        for (Musteri musteri: musteriOku()) {
            System.out.println("\t" +musteri.getId() + "\t\t" + musteri.getAdi());
        }
    }

    private static void raporPersonel() {
        personelYaz(personelList);

        System.out.println();
        System.out.println("\tPersonel NO\t\tAdı");
        System.out.println("-------------------------------");
        for (Personel personel: personelOku()) {
            System.out.println("\t" + personel.getId() + "\t\t" + personel.getPersonelAdi());
        }
    }
}