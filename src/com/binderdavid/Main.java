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
           //Nem találkoznak
           if(karakterek[0].getPozicio() != karakterek[1].getPozicio()){

               palyaMegjelenito(  palya(karakterek[0], karakterek[1]), karakterek[0], karakterek[1]);
           }



            //harc
            if (karakterek[0].getPozicio() == karakterek[1].getPozicio()) {


                int sebzes = (int) (Math.random() * 6 + 1);
                //Harcos sebzi a varázslót
                karakterek[1].serul(sebzes);
                palyaMegjelenitoHarc(  palya(karakterek[0], karakterek[1]), karakterek[0], karakterek[1]);
                 //Varázsló sebzi a harcost
                if (karakterek[1].getEletero() > 0) {

                    int ellenCsapas = (int) (Math.random() * 6 + 1);
                    if (((Pajzsos)karakterek[0]).ved(sebzes)){

                        System.out.println("A harcos kivédte a sebzést");
                    }else{
                        karakterek[0].serul(ellenCsapas);
                        palyaMegjelenitoHarc(  palya(karakterek[0], karakterek[1]), karakterek[0], karakterek[1]);
                    }



                }
                if (karakterek[0].getEletero() <= 0 || karakterek[1].getEletero() <= 0) {
                    veg = true;
                    System.out.println("A  játék véget ért! ");
                }

            }

                karakterek[0].lep();
                karakterek[1].lep();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
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


}
