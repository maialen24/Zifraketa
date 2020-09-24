package segurtasuna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class OrdezkatzeHiztegia {
    /*
    ArrayList<Character> mezua=new ArrayList<>();
    //String key=null;   key random bat erabili nahi badugu
    char[] keyArray=key.toCharArray();
    //String al="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //char[]keyArray=al.toCharArray();
    ArrayList kriptograma=new ArrayList();
    ArrayList<Character> alfa=new ArrayList<>();
*/

    String key="ZXCVBNMASDFGHJKLQWERTYUIOP";
    ArrayList<Character> alfa=new ArrayList<>();

    public OrdezkatzeHiztegia(){

    }
    //Beheko metodo honek array-ak desordenatzen ditu, kasu honetan key desberdinak lortzeko
    /*
    static void shuffleArray(char[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            char a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }*/

     //Metodo honek aurreko metodoari deia egiten dio key berria lortzeko
     /*
    public void keySortu(){
        shuffleArray(keyArray);
        key=new String(keyArray);
        // Collections.shuffle(Arrays.asList(keyArray));
        /*for(int i=0;i<keyArray.length;i++) {
            System.out.print(keyArray[i]);
        }
    }*/
    public void alfabetoa(){
        for (char a='A';a<='Z';a++){
            alfa.add(a);
        }
    }
    public String zifratu (String pMezua){
        alfabetoa();
        String m= "";

        for (int i = 0; i < pMezua.length(); i++) {
            if(alfa.contains(pMezua.charAt(i))){
                m=m+(key.charAt(alfa.indexOf(pMezua.charAt(i))));
            }else{
                m=m+(pMezua.charAt(i));
            }
        }
        return m;
    }

    public String deszifratu (String pKriptograma /*,String pkey*/){ //Key finko bat ez dugunean erabiltzen
      // key=pkey;
        String kriptograma="";
        for (int i = 0; i < pKriptograma.length(); i++) {
            if(key.contains(pKriptograma.charAt(i)+"")){
                kriptograma=kriptograma+(alfa.get(key.indexOf(pKriptograma.charAt(i))));
            }else{
               kriptograma=kriptograma+(pKriptograma.charAt(i));
            }
        }
        return kriptograma;
    }
/*
    public void inprimatu(ArrayList print){
        System.out.println("Mezua:");
        System.out.println();
        for (int i=0;i<print.size();i++){
            System.out.print(print.get(i));
        }
        System.out.println();
        System.out.println("Honako gakoa erabili da:");
        System.out.println();
        for (int i=0;i<keyArray.length;i++){
            System.out.print(keyArray[i]);
        }
    }
*/
    //Erabiltzaileak egin nahi duena aukeratzeko, zifratu eta deszifratu metodoei deiak
    /*
    public void egin() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        alfabetoa();
        //menua sortu
        int aukera=1;
        while(aukera!=0) {
            System.out.println();
            System.out.println("Zer egin nahi duzu?");
            System.out.println("0-Irten");
            System.out.println("1-Zifratu");
            System.out.println("2-Deszifratu");

            aukera = Integer.parseInt (br.readLine());
            if(aukera==1){
                System.out.println("Sar ezazu zifratu nahi duzun mezua");
                String mezua=br.readLine();
                inprimatu(zifratu(mezua));
            }else if(aukera==2){
                System.out.println("Sar ezazu deszifratu nahi duzun kriptograma");
                String krip=br.readLine();
                System.out.println("Sar ezazu zifratzeko erabili den gakoa");
                String pkey=br.readLine();
                inprimatu(deszifratu(krip,pkey));
            }else if(aukera!=0){
                System.out.println("Sartu duzun karakterea ez da zuzena");
            }

        }
    }

     */

    //Main metodoa terminaletik programa exekutatzeko
    /*
    public static void main(String[] args) throws IOException {
        // write your code here
        try {

            OrdezkatzeHiztegia zf = new OrdezkatzeHiztegia();
            zf.keySortu();
            zf.egin();
        }
        catch (NumberFormatException e){
            System.out.println("Sartu duzun karakterea ez da zuzena");
        }
    }
     */
}