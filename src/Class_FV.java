import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
//import com.opencsv.CSVWriter;

public class Class_FV {
    private int nr_FV;
    private String data;
    private String sprzedawca;
    private String adres_sprzedawcy;
    private String NIP_sprzedawcy;
    private String nabywca;
    private String adres_nabywcy;
    private String NIP_nabywcy;
    private String netto;
    private String podatek;
    private String VAT;

    public void zapiszDoCSV (String sciezka,int index){
        try{
            //Charset ch = Charset.forName("WINDOWS-1250");
            //Charset ch = Charset.forName("ISO-8859-2");
            Charset ch = Charset.forName("UTF-8");

            ArrayList<String > help = new ArrayList<String>();
            try {
                File mojPlik = new File(sciezka);
                FileReader czytelnikF = new FileReader(mojPlik);
                BufferedReader czytelnik = new BufferedReader(new InputStreamReader(new FileInputStream(sciezka),ch));

                String wiersz = null;

                while ((wiersz = czytelnik.readLine()) != null) {
                    help.add(wiersz);
                }
                czytelnik.close();
            }catch (Exception zd){
                zd.printStackTrace();
            }
            FileWriter plik = new FileWriter(sciezka);
            int i=0;
            for(String x:help){
                plik.write(help.get(i)+"\n");
                ++i;
            }
            plik.write(";;;;;;;;;;;;");
            plik.write(index+";");
            plik.write( NIP_nabywcy+ ";");
            plik.write(nabywca+ ";");
            plik.write(adres_nabywcy+ ";");
            plik.write( nr_FV + ";");
            plik.write(data+ ";");
            plik.write(data+ ";");
            //plik.write(sprzedawca+ ";");
            //plik.write(adres_sprzedawcy+ ";");
            //plik.write(NIP_sprzedawcy+ ";");


            //if(VAT == " 5") {             //zrobić if'a który będzie sprawdzał ile wynosi podate i przez to wpisywał do odpowiedniej kolumny kwoty
                plik.write( "0;0;0;0;0;" + netto + ";" + podatek + ";0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;");
            //}
            //System.out.println("VAT:" + VAT+"\n");
            plik.write("\n");



            plik.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }


    public void zapiszDoTXT(String sciezka){          //metoda zapisująca faktury do pliku TXT
        try{
            Charset ch = Charset.forName("UTF-8");
            ArrayList<String > help = new ArrayList<String>();
            try {
                File mojPlik = new File(sciezka);
                FileReader czytelnikF = new FileReader(mojPlik);
                BufferedReader czytelnik = new BufferedReader(new InputStreamReader(new FileInputStream(sciezka),ch));

                String wiersz = null;

                while ((wiersz = czytelnik.readLine()) != null) {
                    help.add(wiersz);
                }
                czytelnik.close();
            }catch (Exception zd){
                zd.printStackTrace();
            }
            FileWriter plik = new FileWriter(sciezka);
            int i=0;
            for(String x:help){
                plik.write(help.get(i)+"\n");
                ++i;
            }

            plik.write("Faktura nr: " + nr_FV + "\n");
            plik.write("Data: " + data+ "\n");
            plik.write("Sprzedawca: " + sprzedawca+ "\n");
            plik.write("Adres sprzedawcy: " + adres_sprzedawcy+ "\n");
            plik.write("NIP sprzedawcy: " + NIP_sprzedawcy+ "\n");
            plik.write("Nabywca: " + nabywca+ "\n");
            plik.write("Adres nabywcy: " + adres_nabywcy+ "\n");
            plik.write("NIP Nabywcy: " + NIP_nabywcy+ "\n");
            plik.write("VAT: " + VAT + "%  , Kwota netto = " + netto + ", podatek = " + podatek+ "\n");
            plik.write("\n");



            plik.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public void wypisz(){           //metoda wypisująca na ekran informacje o fakturze
        System.out.println("Faktura nr: " + nr_FV);
        System.out.println("Data: " + data);
        System.out.println("Sprzedawca: " + sprzedawca);
        System.out.println("Adres sprzedawcy: " + adres_sprzedawcy);
        System.out.println("NIP sprzedawcy: " + NIP_sprzedawcy);
        System.out.println("Nabywca: " + nabywca);
        System.out.println("Adres nabywcy: " + adres_nabywcy);
        System.out.println("NIP Nabywcy: " + NIP_nabywcy);
        System.out.println("VAT: " + VAT + "%  , Kwota netto = " + netto + ", podatek = " + podatek);
        System.out.println();
    }
    public void setNetto(String buffor){
        this.netto = buffor;
    }

    public void setVAT(String buffor){
        this.VAT = buffor;
    }

    public void setPodatek(String buffor){
        this.podatek = buffor;
    }
    public void setNr_FV(String buffor) {
        this.nr_FV = Integer.parseInt(buffor);
    }

    public void setData(String buffor) {
        this.data = buffor;
    }

    public void setSprzedawca(String buffor) {
        this.sprzedawca = buffor;
    }

    public void setAdres_sprzedawcy(String adres_sprzedawcy) {
        this.adres_sprzedawcy = adres_sprzedawcy;
    }

    public void setNIP_sprzedawcy(String buffor) {
        this.NIP_sprzedawcy = buffor;
    }

    public void setNabywca(String nabywca) {
        this.nabywca = nabywca;
    }

    public void setAdres_nabywcy(String adres_nabywcy) {
        this.adres_nabywcy = adres_nabywcy;
    }

    public void setNIP_nabywcy(String NIP_nabywcy) {
        this.NIP_nabywcy = NIP_nabywcy;
    }

    public String getNetto(){
        return  this.netto ;
    }

    public String getVAT(){
        return this.VAT ;
    }

    public String getPodatek(){
        return this.podatek;
    }
    public int getNr_FV() {
        return this.nr_FV;
    }

    public String getData() {
        return this.data;
    }

    public String getSprzedawca() {
        return this.sprzedawca;
    }

    public String getAdres_sprzedawcy() {
        return this.adres_sprzedawcy;
    }

    public String getNIP_sprzedawcy() {
        return this.NIP_sprzedawcy;
    }

    public String getNabywca() {
        return this.nabywca;
    }

    public String getAdres_nabywcy() {
        return this.adres_nabywcy ;
    }

    public String getNIP_nabywcy() {
        return this.NIP_nabywcy;
    }


}
