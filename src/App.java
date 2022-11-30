import java.util.Scanner;

public class App {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        // exo1();
        // exo2();
        // exo_supp1();
        exo_supp2();
    }

    public static void exo1() {
        int ask;
        boolean verification = false;
        int verif = 0;
        int table[] = new int[10];
        for (int i = 0; i < table.length; i++) {
            System.out.println("Veuillez rentrer un nombre");
            table[i] += s.nextInt();
        }
        System.out.println("Verifier si votre nombre est dans le tableau");
        ask = s.nextInt();
        for (int i = 0; i < table.length; i++) {
            if (table[i] == ask) {
                verification = true;
                verif = i;
            }
        }
        if (verification == true) {
            System.out.println("Ce nombre fais partie du tableau voici son indice = " + verif);
        } else {
            System.out.println("Votre nombre ne fait pas partie du tableau");
        }

    }

    public static void exo2() {
        int ask;
        int indice = 0;
        boolean verification = false;
        int tableau[] = new int[10];
        int tableauReverse[] = Table_X();

        // On fait appel à Reverse_Table qui est une méthode que j'ai crée plus bas.
        tableauReverse = Reverse_Table(tableau, tableau.length);

        // on affiche le reverse table
        System.out.println();
        for (int i = 0; i < tableauReverse.length; i++) {
            System.out.print(tableauReverse[i] + ", ");
        }
        // fin affichage du reverse table

        // On vérifie si le nombre est présent.
        System.out.println();
        System.out.println("Veuillez donner un nouveau nombre");
        ask = s.nextInt();
        for (int i = 0; i < tableauReverse.length; i++) {
            if (tableauReverse[i] == ask) {
                verification = true;
                indice = i;
            }
        }
        if (verification == true) {
            for (int i = indice; i < tableauReverse.length; i++) {
                tableauReverse[i] = i + 1;
                if (i == 9) {
                    tableauReverse[i] = 0;
                }
            }
        } else {
            System.out.println("nombre non présent dans le tableau bonne soirée.");
        }
        for (int i = 0; i < tableauReverse.length; i++) {
            System.out.print(tableauReverse[i] + ", ");
        }
    }

    public static void exo_supp1() {
        int compteur_croissant = 0;
        int compteur_decroissant = 0;
        int compteur_constant = 0;
        int compteur_quelconque = 0;
        int tableau[] = Table_X();
        tableau = Reverse_Table(tableau, tableau.length);

        for (int i = 0; i < tableau.length; i++) {
            System.out.println(tableau[i]);
        }

        // ici on va compter à chaque fois que le nombre qui suit l'indice est plus
        // grand.
        for (int i = 0; i < tableau.length; i++) {
            if (i < tableau.length - 1 && tableau[i + 1] > tableau[i]) {
                compteur_croissant += 1;
            } else if (i < tableau.length - 1 && tableau[i + 1] < tableau[i]) {
                compteur_decroissant += 1;
            } else {
                compteur_constant += 1;
            }
        }
        System.out.println(compteur_croissant);
        System.out.println(compteur_decroissant);
        System.out.println(compteur_constant);
        System.out.println(compteur_quelconque);
        if (compteur_croissant > compteur_decroissant && compteur_croissant > compteur_constant) {
            System.out.println("ceci est un tableau croissant " + compteur_croissant);
        } else if (compteur_decroissant > compteur_croissant && compteur_decroissant > compteur_constant) {
            System.out.println("ceci est un tableau decroissant " + compteur_decroissant);
        } else if (compteur_constant > compteur_decroissant && compteur_constant > compteur_constant) {
            System.out.println("ceci est un tableau constant " + compteur_constant);
        } else {
            System.out.println("c'est un tableau qq");
        }

    }

    // exo supp2 Permet de trier un tableau
    public static void exo_supp2() {
        int table[] = Table_X();
        table = Reverse_Table(table, table.length);
        int temp = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i] < table[j]) {
                    temp = table[i];
                    table[i] = table[j];
                    table[j] = temp;
                }
            }
        }
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i]);
        }

    }

    // !!!!PARTIE CREATION DE METHODE.!!!!
    // creation de la méthode Reverse_Table
    static int[] Reverse_Table(int[] table, int n) {
        int tableauReverse[] = new int[n];
        for (int i = 0; i < table.length; i++) {
            tableauReverse[i] = table[(n - 1) - i];
        }
        for (int i = 0; i < tableauReverse.length; i++) {
            System.out.print(table[i] + ", ");
        }
        return tableauReverse;
    }

    // Creation tableau de x
    static int[] Table_X() {
        System.out.println("Veuillez donner une taille pour votre tableau");
        int taille_tableau = s.nextInt();
        int tableau[] = new int[taille_tableau];
        for (int i = tableau.length - 1; i >= 0; i--) {
            System.out.println("Rentrer " + (i + 1) + " nombre");
            tableau[i] = s.nextInt();
        }
        return tableau;
    }
    

}
