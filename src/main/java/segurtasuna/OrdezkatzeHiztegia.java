package segurtasuna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class OrdezkatzeHiztegia {
    ArrayList<Character> mezua=new ArrayList<>();
    String key=null;
    //  String key="ZXCVBNMASDFGHJKLQWERTYUIOP";
    //char[] keyArray=key.toCharArray();
    String al="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char[]keyArray=al.toCharArray();
    ArrayList kriptograma=new ArrayList();
    ArrayList<Character> alfa=new ArrayList<>();


    public OrdezkatzeHiztegia(){

    }
    static void shuffleArray(char[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            char a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public void keySortu(){
        shuffleArray(keyArray);
        key=new String(keyArray);
        // Collections.shuffle(Arrays.asList(keyArray));
        /*for(int i=0;i<keyArray.length;i++) {
            System.out.print(keyArray[i]);
        }
*/
    }
    public void alfabetoa(){
        for (char a='A';a<='Z';a++){
            alfa.add(a);
        }
    }
    public ArrayList<Character> zifratu (String pMezua){
        //KEY RANDOM BIDEZ SORTU
        char[] mezuArray = pMezua.toCharArray();

        for (int i = 0; i < mezuArray.length; i++) {
            if(alfa.contains(mezuArray[i])) {
                mezua.add(keyArray[alfa.indexOf(mezuArray[i])]);
            }else{
                mezua.add(mezuArray[i]);
            }
        }
        return mezua;
    }

    public ArrayList desZifratu (String pKriptograma,String pkey){
        char[] kripArray = pKriptograma.toCharArray();
        for (int i = 0; i < kripArray.length; i++) {
            if(pkey.contains((String.valueOf(kripArray[i])))){
                kriptograma.add(alfa.get(pkey.indexOf(kripArray[i])));
            }else{
                kriptograma.add(kripArray[i]);
            }
        }
        return kriptograma;
    }

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
                inprimatu(desZifratu(krip,pkey));
            }else if(aukera!=0){
                System.out.println("Sartu duzun karakterea ez da zuzena");
            }

        }
    }



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
}