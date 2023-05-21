package com.binderdavid;

public class Main {

    public static void main(String[] args) {

        JatekTer jatekTer = new JatekTer();
        Karakter[] karakterek = jatekTer.getKarakterek();



        run(karakterek);
    }

    private static void run(Karakter[] karakterek) {
        boolean veg = false;

        while (!veg) {

           if(!karakterekEgyMezonAlnak(karakterek)){

               palyaMegjelenito(  palya(karakterek[0], karakterek[1]), karakterek[0], karakterek[1]);
           }




            if (karakterekEgyMezonAlnak(karakterek)) {


                int sebzes = 0;
                try {
                    sebzes = sebzesD6Kockával();
                } catch (KarakterNullatSebezKivetel e) {
                    System.out.println(karakterek[0].getNev()+e.getMessage());
                    break;
                }

                if(varazsloVed(sebzes, 1, karakterek)){

                    System.out.println("A varázsló kivédte a sebzést");
                }else{


                    karakterek[1].serul(sebzes);
                    palyaMegjelenitoHarc(  palya(karakterek[0], karakterek[1]), karakterek[0], karakterek[1]);
                }


                if (varazsloEleteNagyobbMintNulla(karakterek[1])) {

                    int ellenCsapas =0;
                    try {
                        ellenCsapas = sebzesD6Kockával();
                    } catch (KarakterNullatSebezKivetel e) {
                        System.out.println(karakterek[1].getNev()+e.getMessage());
                        break;
                    }
                    if (harcosVed(sebzes, 0, karakterek)){

                        System.out.println("A harcos kivédte a sebzést");
                    }else{
                        karakterek[0].serul(ellenCsapas);
                        palyaMegjelenitoHarcEllencsapás(  palya(karakterek[0], karakterek[1]), karakterek[0], karakterek[1]);
                    }



                }
                if (MeghaltEValamelyikKarakter(karakterek)) {
                    veg = true;
                    System.out.println("A  játék véget ért! ");
                }

            }

            harcosLep(karakterek, 0);
            varaszloLep(karakterek, 1);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    private static void varaszloLep(Karakter[] karakterek, int i) {
        karakterek[i].lep();
    }

    private static void harcosLep(Karakter[] karakterek, int i) {
        karakterek[i].lep();
    }

    private static boolean MeghaltEValamelyikKarakter(Karakter[] karakterek) {
        return karakterek[0].getEletero() <= 0 || karakterek[1].getEletero() <= 0;
    }

    private static boolean varazsloEleteNagyobbMintNulla(Karakter karakter) {
        return karakter.getEletero() > 0;
    }

    private static boolean harcosVed(int sebzes, int i, Karakter[] karakterek) {
        return ((Pajzsos) karakterek[i]).ved(sebzes);
    }

    private static boolean varazsloVed(int sebzes, int i, Karakter[] karakterek) {
        return ((Pajzsos) karakterek[i]).ved(sebzes);
    }

    private static boolean karakterekEgyMezonAlnak(Karakter[] karakterek) {
        return karakterek[0].getPozicio() == karakterek[1].getPozicio();
    }

    private static int sebzesD6Kockával () throws KarakterNullatSebezKivetel {
        int sebzes=(int) (Math.random() * 7 );


         if (sebzes==0){

             throw  new KarakterNullatSebezKivetel(" elesett támadás közben és szörnyet halt, a játék véget ért.");
         }


        return  sebzes;
    }

    public static String[] palya(Karakter k1, Karakter k2){
         String[]ter=new String[]{"_","_","_"};
        if(k1.getPozicio()!=k2.getPozicio()){

            ter[k1.getPozicio()]= k1.getNev();
            ter[k2.getPozicio()]= k2.getNev();

              return ter;
        }else{
            ter[k1.getPozicio()]= "X";
           return ter;
        }

    }
    public static  void palyaMegjelenito(String[]palya,Karakter k1,Karakter k2 ){
          String palyaKiiras="";
        for (int i = 0; i < palya.length; i++) {
            palyaKiiras+=palya[i];

        }
        System.out.println(new StringBuilder()
                .append(palyaKiiras)
                .append("-->")
                .append(k1.getNev())
                .append(":")
                .append(k1.getEletero())
                .append(", ")
                .append(k2.getNev())
                .append(":")
                .append(k2.getEletero()).toString());
    }
    public static  void palyaMegjelenitoHarc(String[]palya,Karakter k1,Karakter k2 ){
        String palyaKiiras="";
        for (int i = 0; i < palya.length; i++) {
            palyaKiiras+=palya[i];

        }
        System.out.println(new StringBuilder()
                .append(palyaKiiras)
                .append("-->")
                .append("harc: ")
                .append(k1.getNev())
                .append(":")
                .append(k1.getEletero())
                .append(", ")
                .append(k2.getNev())
                .append(":")
                .append(k2.getEletero()).toString());
    }
    public static  void palyaMegjelenitoHarcEllencsapás(String[]palya,Karakter k1,Karakter k2 ){
        String palyaKiiras="";
        for (int i = 0; i < palya.length; i++) {
            palyaKiiras+=palya[i];

        }
        System.out.println(new StringBuilder()
                .append(palyaKiiras)
                .append("-->")
                .append("ellencsapás: ")
                .append(k1.getNev())
                .append(":")
                .append(k1.getEletero())
                .append(", ")
                .append(k2.getNev())
                .append(":")
                .append(k2.getEletero()).toString());
    }


}
