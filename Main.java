import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void listeyi_bastir(LinkedList<String> gidilecek_yerler) { // LinkedList bastırmak için metod yazdık. //2

        /*for (String s : gidilecek_yerler)
            System.out.println(s);*/ /*LinkedListleri bu şekilde bastırabiliyoruz fakat üzerinde müdehale etdip gezinmemize
                                       izin vermiyor. LinkedListler üzerinde kompleks işlemler yapabilmemiz için bir
                                       Iterator oluşturmamız gerekiyor.*/ //3

        ListIterator<String> iterator = gidilecek_yerler.listIterator(); /*ListKIterator class'ını da alt + Enter ile
                                                                            projeye dahil ettik. */ //4

        /*
            ListIteratorun birden fazla metodu var. Bunlara bakabilmek için Google'a ListIterator yaz ve ilk çıkan Oracle
            linkine tıkla ve orada bulacaksın.
            Sitede dikkat edersek ListIterator'ün bir Interface olmuş olduğunu gözlemliyoruz.

        */ //5

        while(iterator.hasNext()) { /*has.Next(): iterator'un gösterdiği herhangi bir obje var mı? kısmını kontrol
                                                  eden bir metod. Iterator listenin başında bunu yapar ve her bir referans
                                                   bir objeyi sürekli olarak sırasıyla listede göstereceği için True değer
                                                   döner. Fakat listenin son objesine vardığında o objenin referansı herhangi bir
                                                   objeyi işaret etmediği için bu nedenle "null" göstereceği için False
                                                   dönecektir. */ //6

            System.out.println(iterator.next()); /* Bir sonraki yere gitmek için kullanıyoruz. Yani ilk referans noktasından
                                                    iterator Postaneyi gösterdiği için Postane basılacak. Sonrasında
                                                    iterator ile varmış olunan noktadaki referans'a gelmiş olacağız. Yani
                                                    Postane üzerinde yer alan ve bir sonraki yeri gösteren referenas noktasına.
                                                    Bu şekilde tüm listeyi gezmiş ve bastırmış olacağız.*/ //7

        }

    }
    public static void sirali_ekle(LinkedList<String> gidilecek_yerler,String yeni) {
        ListIterator<String> iterator = gidilecek_yerler.listIterator();

        while (iterator.hasNext()) { /*iterator herhangi bir yeri gösteriyor mu?. Eğer göstermiyorsa LinkedList boş
                                       demektir. Bu duruma karşı while döngüsünün bitimine listeye ekleme yapma metodu
                                       ekliyoruz.*/

            int karsilastir = iterator.next().compareTo(yeni); /* iteratorumuzun gösterdiği değerle gönderdiğimiz yeni
                                                                  değeri kıyaslıyoruz.
                                                                  Değerler eşitse, karsilastir değeri 0 oluyor.
                                                                  Eğer gönderdiğimiz yeni değeri, iteratorun gösterdiği
                                                                  yerin değerden daha büyükse karsilastir sonucu -1 çıkıyor.
                                                                  Küçükse de 0'dan büyük çıkıyor.
                                                                  Burada 3 durum var. Buna göre de yeni değerini listede
                                                                  nereye ekleyeceğimizi kararlaştıracağız. */
            if (karsilastir == 0) {
                // İki değer eşitse
                System.out.println("Listenizde bu eleman zaten var...");

                return; /* Fonksiyonu bitirmek için kullandık. Foksiyon void olduğu için sadece return yazdık. Herhangi
                          bir değer döndürmedik. Sadece metodu sonlandırmak için kullandık. */
            }
            else if (karsilastir < 0) {
                // yeni değer iteratorün gösterdiği değerden yani iterator.next'ten daha büyükse.
                //Bu durumda iteratorü ilerletmemiz gerekiyor. Hiçbir işlem yapmayıp ilerliyoruz.


            }
            else if (karsilastir > 0) {
                // yeni değer iteratorün gösterdiği değerden yani iterator.next'ten daha küçükse.
                // Bu durumda iteratorü geri almamız gerekiyor. Bu değerden bir önceye eklememiz gerekiyor.

                iterator.previous(); // iterator bir geri gelecek.
                iterator.add(yeni); // iteratoru geri aldıktan sonra bir öncesine değeri ekliyoruz.

                return; // Metodu yine aynı şekilde sonlandırdık.

            }




        }
        iterator.add(yeni);


    }
    public static void main(String[] args) {

        LinkedList<String> gidilecek_yerler = new LinkedList<String>();

        // Sabah uyandıktan sonra akşam eve girene kadar gidilecek yerlerin listesini hazırlıyoruz. //1

        /*gidilecek_yerler.add("Postane"); // Listeye birşey eklemek ArrayListlerdeki ile aynı. .add metodu kullanılıyor.

        gidilecek_yerler.add("Market");

        gidilecek_yerler.add("Okul");

        gidilecek_yerler.add("Kütüphane");

        gidilecek_yerler.add("Spor Salonu");

        gidilecek_yerler.add("Ev");

        listeyi_bastir(gidilecek_yerler); // main metodu dışında yazmış olduğumuz metodu burada çağırdık. Ve listeyi bastırdık.

        //Şimdi liste içerisine Spor Salonu yerine Alışveriş Merkezi eklemek istiyoruz. Spor salonu 4. indekste; //8

        System.out.println("------------------------------------------------------------------------------");

        // gidilecek_yerler.add(4,"Alışveriş Merkezi"); //9

        gidilecek_yerler.remove(3); //3. indeksteki Kütüphaneyi silmiş olduk. //10

        listeyi_bastir(gidilecek_yerler); */ /* Dersin son bölümüne geçmeden komple yoruma aldık. main metodu üstüne
                                                yeni bir metod yazdık */ //11

        sirali_ekle(gidilecek_yerler, "Postane");
        sirali_ekle(gidilecek_yerler, "Market");
        sirali_ekle(gidilecek_yerler, "Ev");

        listeyi_bastir(gidilecek_yerler); //Çıktıda Ev, Market, Postane şeklinde alt alta yazdı. Yani alfabetik olarak.


    }

}
