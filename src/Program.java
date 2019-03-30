import java.util.ArrayList;

public class Program {
    private ArrayList<Class_FV> Fakturki;

    public ArrayList<Class_FV> getFakturki() {  //metoda, która daje mi tablicę faktur.
        return Fakturki;
    }

    public void setFakturki(String miesiac) {                 //metoda, która ma ustawić faktury z pliku w tablicy faktur w programie.
        OdczytZPlikuTXT plik = new OdczytZPlikuTXT();
        //String miesiac = "Maj_2018.txt";
        ArrayList<String> Dane = new ArrayList<String>();
        ArrayList<Class_FV> FAKTURY = new ArrayList<Class_FV>();
        plik.setDANE(miesiac);
        Dane = plik.getDANE();

        int k=0;
        for(int i=0; i<Dane.size();i++){
            Class_FV fv1 = new Class_FV();
            if(Dane.get(i).equals("FAKTURA VAT KOPIA")){
                String buffor = Dane.get(++i);
                String empty;
                String buffor2;
                k++;
                fv1.setNr_FV(buffor.substring(33));      //Zapisuję nr faktury z odpowiedniego wiersza
                //System.out.println(fv1.nr_FV);
                buffor = Dane.get(++i);
                fv1.setData(buffor.substring(19));      //Zapisuję datę faktury z odpowiedniego wiersza
                //System.out.println(fv1.data);
                buffor = Dane.get(i+3); i+=3;
                String d = buffor;
                fv1.setSprzedawca(buffor.substring(5));         //Zapisuję nazwę sprzedawcy z odpowiedniego wiersza
                //System.out.println(buffor.substring(5));
                buffor = Dane.get(++i);
                empty = Dane.get(++i);
                buffor = buffor.substring(16) +"," + empty.substring(10);   //Składam w całość nazwę sprzedawcy
                fv1.setAdres_sprzedawcy(buffor);
                //System.out.println(fv1.adres_sprzedawcy);
                ++i;
                buffor = Dane.get(++i);
                fv1.setNIP_sprzedawcy(buffor.substring(4));             ////Zapisuję NIP Sprzedawcy z odpowiedniego wiersza
                //System.out.println(fv1.NIP_sprzedawcy);
                ++i;
                buffor = Dane.get(++i);
                //System.out.println(buffor);
                //System.out.println(buffor.length());
                empty = Dane.get(++i);
                buffor2 = Dane.get(++i);
                String adres;
                //System.out.println(empty.length());
                int aba = i;
                int aba2 = i;
                if(empty.length()==40){                // Przypadek ,gdy nazwa nie zmiescila się w 2 linijkach
                        buffor = buffor+empty+buffor2;
                    fv1.setAdres_nabywcy(Dane.get(++aba) + " , " + Dane.get(++aba));
                }
                else if(buffor.length() == 40)         // Tu jest warunek, który jest potrzebny, ponieważ niektóre nazwy firm
                {
                                                                                     //nie zmieściły się w jednej linii(która ma 40 znaków długości)
                    fv1.setAdres_nabywcy(buffor2+ ", " + Dane.get(++aba));
                    buffor = buffor + empty;                                            //pobieram obie cześci nazwy
                    empty = Dane.get(++aba);                                         //pobieram wiersz w którym jest NIP
                    fv1.setNIP_nabywcy(empty.substring(5));                          //Przypisuję NIP do mojego obiektu

                }
                else {                          // Przypadek, gdy nazwa zmieściła się w jednym wierszu
                    adres = empty;
                    fv1.setAdres_nabywcy(adres + ", " +buffor2);
                    empty = Dane.get(++aba2);
                    fv1.setNIP_nabywcy(empty.substring(5));
                }
                fv1.setNabywca(buffor);
                while (!buffor.equals("")) {   // Szukam wiersza, który jest pusty i znajduje się tuż przed zsumowaną kwotą za zakupy.
                    i++;
                    buffor = Dane.get(i);
                }
                i+=4;
                buffor = Dane.get(i);       //Wybieram wiersz w którym mam zsumowane kwoty z całej faktury, oraz wypisany VAT, netto i podatek.
                fv1.setVAT(buffor.substring(2,4));
                fv1.setPodatek(buffor.substring(18,23));
                fv1.setNetto(buffor.substring(32,40));

                FAKTURY.add(fv1);                      // Dodaję  klasę faktura do tablicy, która ma przechowywać faktury.
                //fv1.wypisz();                          // Wypisuję fakturę na ekran (wszystko jest elegancko)
            }

        }

        Fakturki = FAKTURY;                     // Przypisuję tablicę z fakturami do pustej tablicy, którą jest składową klasy Program
       // for(int i=0; i<FAKTURY.size();i++){      //Próbuję wypisać na ekran wszystkie faktury, lecz wyświetla się wiele razy tylko ta ostatnia. Tak jakby nadpisała się 31 razy w tablicy.
        //    Class_FV zzz = FAKTURY.get(i);
       //     zzz.wypisz();
       // }
    }
}
