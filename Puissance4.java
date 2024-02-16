import java.util.InputMismatchException;
import java.util.Scanner;

public class Puissance4 {
    private static final int lignes = 6;
    private static final int colonnes = 7;
    private static final int toursMax = lignes * colonnes;

    //Couleurs pour les jetons
    private static final String ansi_reset = "\u001B[0m"; //Réinitialise la couleur1
    private static final String ansi_rouge = "\u001B[31m"; //Rouge
    private static final String ansi_jaune = "\u001B[33m"; //Jaune

    public static void main(String[] args) {
        //Scanner pour récupérer l'input du joueur
        Scanner myObj = new Scanner(System.in);
        StringBuilder tableauBuilder = new StringBuilder();
        //Tableau de jeu
        char[][] jeu = new char[lignes][colonnes];

        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                tableauBuilder.append("- ");
                jeu[i][j] = ' ';
            }
            tableauBuilder.append("\n");
        }

        tableauBuilder.append("1 2 3 4 5 6 7");

        int turn = 1;
        String joueur1 = "Rouge";
        String joueur2 = "Jaune";
        boolean winner = false;
        int colonne = 0;

        System.out.println(tableauBuilder.toString());
        System.out.println("Bienvenue dans le jeu Puissance 4 !");

        while (!winner && turn < toursMax + 1) {


            if (turn % 2 != 0) {
                System.out.println("Joueur " + joueur1 + " choisissez une colonne (entre 1 et 7)");
            } else {
                System.out.println("Joueur " + joueur2 + " choisissez une colonne (entre 1 et 7)");
            }

            try {
                colonne = myObj.nextInt();
            } catch (InputMismatchException e) { //Si l'input n'est pas un chiffre
                System.out.println("Veuillez entrer un nombre valide.");
                myObj.next();
                continue;     //Redemande une colonne
            }

            if (colonne < 1 || colonne > 7) { //Si l'input est différent d'un chiffre entre 1 et 7
                System.out.println("Veuillez choisir une colonne entre 1 et 7.");
                continue;  //Redemande une colonne
            }

            if (!isColonneLibre(jeu, colonne)) { //Si la colonne est déjà remplie
                System.out.println("La colonne est déjà complète. Choisissez une autre colonne.");
                continue;  //Redemande une colonne
            }

            System.out.print("\033[H\033[2J"); //Clear la console

            //Selon un tour pair ou impair, place un jeton R (rouge) ou Y (jaune)
            jouerCoup(jeu, colonne, (turn % 2 == 1) ? 'R' : 'Y');
            afficherTableau(jeu);

            if (verifVictoire(jeu, colonne)) {
                winner = true;
                String gagnant = (turn % 2 == 1) ? joueur1 : joueur2;
                System.out.println("Le joueur " + gagnant + " a gagné ! Félicitations !");
            }

            turn += 1;
        }

        if (!winner) {
            System.out.println("Personne n'a gagné. Match nul !");
        }
    }

    private static boolean isColonneLibre(char[][] jeu, int colonne) {
        return jeu[0][colonne - 1] == ' ';
    }

    private static void jouerCoup(char[][] jeu, int colonne, char jeton) {
        for (int i = lignes - 1; i >= 0; i--) {
            if (jeu[i][colonne - 1] == ' ') {
                jeu[i][colonne - 1] = jeton;
                break;
            }
        }
    }

    private static void afficherTableau(char[][] jeu) {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                if (jeu[i][j] == ' ') {
                    System.out.print("- ");
                } else if (jeu[i][j] == 'R') {
                    System.out.print(ansi_rouge + "R " + ansi_reset);
                } else if (jeu[i][j] == 'Y') {
                    System.out.print(ansi_jaune + "Y " + ansi_reset);
                }
            }
            System.out.println();
        }
        System.out.println("1 2 3 4 5 6 7");
    }

    private static boolean verifVictoire(char[][] jeu, int colonne) {
        char jeton = (jeu[lignes - 1][colonne - 1] == 'R') ? 'R' : 'Y';
        //Vérif horizontale
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j <= colonnes - 4; j++) {
                if (jeu[i][j] == jeton && jeu[i][j + 1] == jeton && jeu[i][j + 2] == jeton && jeu[i][j + 3] == jeton) {
                    return true;
                }
            }
        }

        //Vérif verticale
        for (int i = 0; i <= lignes - 4; i++) {
            for (int j = 0; j < colonnes; j++) {
                if (jeu[i][j] == jeton && jeu[i + 1][j] == jeton && jeu[i + 2][j] == jeton && jeu[i + 3][j] == jeton) {
                    return true;
                }
            }
        }

        //Vérif diagonale bas-haut
        for (int i = 3; i < lignes; i++) {
            for (int j = 0; j <= colonnes - 4; j++) {
                if (jeu[i][j] == jeton && jeu[i - 1][j + 1] == jeton && jeu[i - 2][j + 2] == jeton && jeu[i - 3][j + 3] == jeton) {
                    return true;
                }
            }
        }

        //Vérif diagonale haut-bas
        for (int i = 0; i <= lignes - 4; i++) {
            for (int j = 0; j <= colonnes - 4; j++) {
                if (jeu[i][j] == jeton && jeu[i + 1][j + 1] == jeton && jeu[i + 2][j + 2] == jeton && jeu[i + 3][j + 3] == jeton) {
                    return true;
                }
            }
        }

        return false;
    }
}