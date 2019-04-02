package com.crud.tasks;

import java.util.Random;
import java.util.Scanner;

public class PaperScissorStone {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Jak sie nazywasz? Ile zagrasz rund?");
        String name = sc.next();
        int ilosc = sc.nextInt();
        Boolean end = false;
        int playerWin = 0;
        int computerWin = 0;
        Random randomGenerator = new Random();
        System.out.println("Witaj  " + name + "\nklawisz 1 - zagranie \"kamień\",\n" +
                "klawisz 2 - zagranie \"papier\",\n" +
                "klawisz 3 - zagranie \"nożyce\",\n" +
                "klawisz x - zakończenie gry, poprzedzone pytaniem \"Czy na pewno zakończyć grę?\",\n" +
                "klawisz n - uruchomienie gry od nowa, poprzedzone pytaniem \"Czy na pewno zakończyć aktualną grę?\",");
        while(!end){
            System.out.println("Wykonaj ruch");
            int ruchGracza = sc.nextInt();
            int ruchKomputera = randomGenerator.nextInt(3) + 1;
            if(ruchGracza == 1 && ruchKomputera == 2){
                computerWin ++;
                System.out.println("Komputer pokonal gracza papierem i wygral!!");
            }
            else if(ruchGracza == 1 && ruchKomputera == 3){
                playerWin ++;
                System.out.println("Gracz pokonal komputer kamieniem i wygral!!");
            }
            else if(ruchGracza == 2 && ruchKomputera == 1){
                playerWin ++;
                System.out.println("Gracz pokonal komputer papierem i wygral!!");
            }
            else if(ruchGracza == 2 && ruchKomputera == 3){
                computerWin ++;
                System.out.println("Komputer pokonal gracza nozycami i wygral!!");
            }
            else if(ruchGracza == 3 && ruchKomputera == 2){
                playerWin++;
                System.out.println("Gracz pokonal komputer nozycami i wygral!!");
            }
            else if(ruchGracza == 3 && ruchKomputera == 1){
                computerWin++;
                System.out.println("Komputer pokonal gracza kamieniem i wygral!!");
            }
            else if(ruchGracza > 3){
                System.out.println("Stary użyj mózgu :)");
            }
            else{
                System.out.println("Remis");
            }
            if(playerWin == ilosc || computerWin == ilosc){
                end = true;
            }

        }
        System.out.println("Zwyciestwa gracza " + playerWin);
        System.out.println("Zwyciestwa komputera " + computerWin);





    }
}
