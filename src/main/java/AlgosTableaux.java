import java.util.Scanner;

public class AlgosTableaux {

    /**
     * Demande à l'utilisateur de saisir un entier, jusqu'à ce que
     * l'entier saisi soit entre les deux bornes en paramètres.
     *
     * @param pfBorneInf IN : borne inférieure
     * @param pfBorneSup IN : borne supérieure
     *
     * @return un entier entre pfBorneInf et pfBorneSup, compris
     */
    public static int saisieIntC (int pfBorneInf, int pfBorneSup){
        int valeur;
        Scanner clavier = new Scanner(System.in) ;
        System.out.println("Donnez une valeur comprise entre "+pfBorneInf+" et "+pfBorneSup+ "?");
        valeur = clavier.nextInt();
        while (valeur<pfBorneInf || valeur>pfBorneSup){
            System.out.println("Erreur ! Donnez une valeur comprise entre "+pfBorneInf+" et "+pfBorneSup+ "?");
            valeur = clavier.nextInt();
        }
        return valeur;
    }

    /**
     * Demande à l'utilisateur :
     *   1. de saisir le nombre de cases qu'il souhaite remplir, et
     *      répète l'opération, jusqu'à ce que ce nombre soit
     *      acceptable
     *   2. de remplir les cases une à une.
     *
     * @param pfTab OUT : tableau à remplir
     *
     * @return le nombre de cases remplies dans le tableau
     */
    public static int saisirTableau (int[] pfTab){
        Scanner clavier = new Scanner(System.in);
        System.out.println("Saisir le nombre de cases :");
        int nbEl= saisieIntC(1,pfTab.length);

        for(int i=1; i<=nbEl; i++){
            System.out.println("Saisir la valeur de la case numéro "+ i+":");
            pfTab[i-1] = clavier.nextInt();
        }

        System.out.println("J'avais " + pfTab.length
            + " cases disponibles, et j'en ai rempli "
            + nbEl);
        return nbEl ;
    }

    /**
     * Affiche le tableau en paramètre.
     *
     * @param pfTab IN : tableau
     * @param pfNbEl IN : nombre de cases remplies dans le tableau
     *
     */
    public static void afficherTableau(int[] pfTab, int pfNbEl) {
        for(int i=0; i<pfNbEl; i++){
            System.out.print(pfTab[i]+ " ");
        }
        System.out.println("");
    }

    /**
     * Inverse le tableau en paramètre.
     *
     * @param pfTab IN : tableau
     * @param pfNbEl IN : nombre de cases remplies dans le tableau
     *
     */
    public static void inverserTableau(int[] pfTab, int pfNbEl) {
        for(int i = 0; i<pfNbEl/2; i++) {
            int temp = pfTab[i];
            pfTab[i]= pfTab[pfNbEl-1-i];
            pfTab[pfNbEl-1-i] = temp;
        }
    }

    /**
     * Elimine les doublons dans le tableau en paramètre.
     *
     * @param pfTab IN : tableau
     * @param pfNbEl IN : nombre de cases remplies dans le tableau
     *
     */
    public static int eliminerDoublons(int[] pfTab, int pfNbEl) {
        for(int i = 0; i<pfNbEl-1; i++) {
            for(int j = i+1; j<pfNbEl;){
                if (pfTab[i] == pfTab[j]){
                    for(int k=j; k<pfNbEl-1; k++){
                        pfTab[k]= pfTab[k+1];

                    }
                    pfNbEl--;
                }
                else{
                    j++;
                }
            }
        }
        return pfNbEl;
    }

    /*
     * Stocke les indices des occurences du maximum
     *
     * @param pfTab    IN  : un tableau de valeurs entières
     * @param pfNbEl   IN  : le nombre de valeurs
     * @param pfIndice OUT : le tableau des indices
     *
     * @return le nombre d'occurrences du max
     */
    public static int indicesMax(int[] pfTab, int pfNbEl, int[] pfIndices){
        int max= pfTab[0];
        int cpt=0;
        for(int i=0; i<pfNbEl; i++){
            if (pfTab[i]>max){
                max = pfTab[i];
                cpt=1;
                pfIndices[0]= i;
            }
            else if (pfTab[i]==max){
                pfIndices[cpt]= i;
                cpt++;
            }
        }
        return cpt;
    }

    public static void main(String[] args){
        /* Declaration des variables */
        int nbVal ; //nombre de valeurs a traiter
        int tab[]  ; // tableau permettant de stocker les valeurs

        tab = new int[100] ;
        int[] indices = new int[10] ;
        int nbOccurrences ;

        // Ajouter les appels aux algorithmes :
        //   - à saisirTableau
        nbVal = saisirTableau(tab);

        //   - puis à afficherTableau
        System.out.print("\nLe tableau saisi est : ");
        afficherTableau(tab,nbVal);
        //   - puis ...
        inverserTableau(tab, nbVal);
        System.out.print("\nLe tableau inversé est : ");
        afficherTableau(tab,nbVal);

        nbVal= eliminerDoublons(tab,nbVal);
        
        //   - puis ...
        //CalculValeurNégative(tab, nbVal);
        
        System.out.print("\nLe tableau sans doublons est : ");
        afficherTableau(tab,nbVal);
        System.out.print("\nVeuillez mettre les appels des autres fonctions en commentaires afin que ce programme fonctionne");
        System.out.print("\nLes indice des plus grandes valeurs de max sont : ");
        nbOccurrences = indicesMax(tab, tab.length, indices);
        afficherTableau(indices, nbOccurrences);
    }

    /*public static double CalculValeurNégative(int[] tabVal, int nbVal) {
        int nbNeg= 0;
        double somme = 0;
        for (int i = 0; i < nbVal; i++){
            if (tabVal[i]<0){
                somme = somme + tabVal[i];
                nbNeg+=1;
            }
        }
        
        if(nbNeg ==0){
            throw new ArithmeticException("Moyenne de 0 négatifs");
        }
        else {
            return somme/ nbNeg;
        }
    }*/
}
/****************************************
Jeu d'essais pour AlgosTableaux
 *******************************************
A vous !!!

 ****************************************/