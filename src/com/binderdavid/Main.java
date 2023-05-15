package com.binderdavid;

public class Main {

    public static void main(String[] args) {

        JatekTer jatekTer = new JatekTer();
        Karakter[] karakterek = jatekTer.getKarakterek();

        //int kor=1;
        boolean veg = false;

        while (!veg) {

            System.out.println(new StringBuilder()

                    .append(karakterek[0].getNev())
                    .append("_")
                    .append(karakterek[1].getNev())
                    .append("-->")
                    .append(karakterek[0].getNev())
                    .append(" :")
                    .append(karakterek[0].getEletero()).append(", ")
                    .append(karakterek[1].getNev())
                    .append(":")
                    .append(karakterek[1].getEletero()).toString());

            if (karakterek[0].getPozicio() == karakterek[1].getPozicio()) {


                int sebzes = (int) (Math.random() * 6 + 1);
                karakterek[1].serul(sebzes);
                System.out.println(new StringBuilder()
                        .append("X__ --> harc: ")
                        .append(karakterek[0].getNev())
                        .append(":")
                        .append(karakterek[0].getEletero())
                        .append(", ")
                        .append(karakterek[1].getNev())
                        .append(":")
                        .append(karakterek[1].getEletero()).toString());
                if (karakterek[1].getEletero() > 0) {

                    int ellenCsapas = (int) (Math.random() * 6 + 1);
                    karakterek[0].serul(ellenCsapas);
                    System.out.println(new StringBuilder()
                            .append("X__ --> harc: ")
                            .append(karakterek[0].getNev())
                            .append(":")
                            .append(karakterek[0].getEletero())
                            .append(", ")
                            .append(karakterek[1].getNev())
                            .append(":")
                            .append(karakterek[1].getEletero()).toString());

                }
                if (karakterek[0].getEletero() <= 0 || karakterek[1].getEletero() <= 0) {
                    veg = true;
                    System.out.println("A jatek veget ert!");
                }

            }
            else {
                karakterek[0].lep();
                karakterek[1].lep();
            }

        }
    }
}
