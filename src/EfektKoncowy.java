import java.util.ArrayList;
import java.util.Scanner;

public class EfektKoncowy {
    public static  void main(String[] args) {
        ArrayList<Class_FV> WszystkieFV = new ArrayList<Class_FV>();
        Program moj = new Program();
        Szablon_CSV nowy = new Szablon_CSV();
        String miesiac = "LUTY_2019.txt";
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj nazwe pliku, z ktorego mam pobrac dane?");
        String msc = scan.nextLine() + ".txt";
        System.out.println("Podaj nazwe pliku, do którego mam zapisać plik csv?");
        String csv = scan.nextLine() + ".csv";
        moj.setFakturki(msc);
        WszystkieFV = moj.getFakturki();
        //nowy.tworzSzablonCSV("LUTY_2019.csv");
        nowy.tworzSzablonCSV(csv);
        int i = 1;
        for (Class_FV x : WszystkieFV) {
            //x.wypisz();
            //x.zapiszDoTXT("WYNIK2.txt");
            //x.zapiszDoCSV("LUTY_2019.csv",i);
            x.zapiszDoCSV(csv, i);
            i++;

        }
        System.out.println("ZAKONCZONO");
    }
}
