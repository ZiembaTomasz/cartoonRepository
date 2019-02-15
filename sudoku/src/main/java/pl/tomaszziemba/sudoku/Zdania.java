package pl.tomaszziemba.sudoku;

public class Zdania {
    public static void main(String[]args){
        String[] listaSlow1 = {"architektura wielowarstwowa",
                "30000 metrów", "rozwizanie B-do-B", "aplikacja kliencka",
                "interfejs internetowy", "inteligentna karta", "rozwizanie dynamiczne", "sze sigma", "przenikliwo"};
        String[] listaSlow2 = {"zwiksza moliwoci", "poprawia atrakcyjno",
                "pomnaa warto", "opracowana dla", "|bazujca na", "rozproszona",
                "sieciowa", "skoncentrowana na", "podniesiona na wyszy poziom",
                "skierowanej", "udostpniona"};
        String[] listaSlow3 = {"procesu", "punktu wpisywania", "rozwizania",
                "strategii", "paradygmatu", "portalu", "witryny", "wersji", "misji"};
// okrelenie, ile jest sów w kadej z list
        int lista1Dlugosc = listaSlow1.length;
        int lista2Dlugosc = listaSlow2.length;
        int lista3Dlugosc = listaSlow3.length;
// generacja trzech losowych sów (lub zwrotów)
        int rnd1 = (int) (Math.random() * lista1Dlugosc);
        int rnd2 = (int) (Math.random() * lista2Dlugosc);
        int rnd3 = (int) (Math.random() * lista3Dlugosc);
        int rnd4 = (int) (Math.random() * 104);
// stworzenie zdania
        String zdanie = listaSlow1[rnd1] + " " + listaSlow2[rnd2] + " " +
                listaSlow3[rnd3];
// wywietlenie zdania
        System.out.println("To jest to, czego nam trzeba: " + zdanie);
        System.out.println(Math.random());
        System.out.println(rnd1);
        System.out.println(rnd2);
        System.out.println(rnd3);
        System.out.println(rnd4);
    }

}
