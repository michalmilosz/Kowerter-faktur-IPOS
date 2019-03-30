import java.io.FileWriter;
import java.io.IOException;

public class Szablon_CSV {
    public void tworzSzablonCSV (String sciezka){
        try{
            FileWriter plik = new FileWriter(sciezka);
            plik.write("KodFormularza;kodSystemowy;wersjaSchemy;WariantFormularza;CelZlozenia;DataWytworzeniaJPK;DataOd;DataDo;NazwaSystemu;NIP;PelnaNazwa;Email;LpSprzedazy;NrKontrahenta;NazwaKontrahenta;AdresKontrahenta;DowodSprzedazy;DataWystawienia;DataSprzedazy;K_10;K_11;K_12;K_13;K_14;K_15;K_16;K_17;K_18;K_19;K_20;K_21;K_22;K_23;K_24;K_25;K_26;K_27;K_28;K_29;K_30;K_31;K_32;K_33;K_34;K_35;K_36;K_37;K_38;K_39;LiczbaWierszySprzedazy;PodatekNalezny;LpZakupu;NrDostawcy;NazwaDostawcy;AdresDostawcy;DowodZakupu;DataZakupu;DataWplywu;K_43;K_44;K_45;K_46;K_47;K_48;K_49;K_50;LiczbaWierszyZakupow;PodatekNaliczony\n" +
                    "JPK_VAT;JPK_VAT (3);1-1;3;0;2018-07-11T09:33:42;2018-06-01;2018-06-30;Klient JPK 2.0;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;\n" +
                    ";;;;;;;;;0010024412;ZPU Kartofelek;moj-email@mail.com");
            plik.write("\n");

            plik.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
