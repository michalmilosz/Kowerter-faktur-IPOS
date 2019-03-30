import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;



public class OdczytZPlikuTXT {
    private ArrayList<String> DANE;

    public void wypisz(){
        for(String w:DANE) {
            //if(w.equals(fv)) {
            System.out.println(w);
            // }
        }
    }

    public ArrayList<String> getDANE() {
        return DANE;
    }

    public void setDANE(String sciezka){
            Charset ch = Charset.forName("UTF-8");
            ArrayList<String> Buffor = new ArrayList<String>();
            try {
                File mojPlik = new File(sciezka);
                FileReader czytelnikF = new FileReader(mojPlik);
                BufferedReader czytelnik = new BufferedReader(new InputStreamReader(new FileInputStream(sciezka),ch));

                String wiersz = null;

                while ((wiersz = czytelnik.readLine()) != null) {
                    Buffor.add(wiersz);
                }
                czytelnik.close();
            }catch (Exception zd){
                zd.printStackTrace();
            }
            DANE = Buffor;
        }

}
