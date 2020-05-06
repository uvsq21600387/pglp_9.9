package mathieu.pglp_9_9;

import java.util.Scanner;

import mathieu.pglp_9_9.bdd.Bdd;
import mathieu.pglp_9_9.command.Command;
import mathieu.pglp_9_9.command.DrawingTUI;

/**
 * implémentation de drawingApp.
 */
public class DrawingApp {
    /**
     * lecture utilisateur.
     */
    private Scanner saisie;
    /**
     * interpreteur de commande.
     */
    private DrawingTUI dt;
    /**
     * constructeur de la classe.
     */
    public DrawingApp() {
        dt = new DrawingTUI();
        saisie = new Scanner(System.in);
    }
    /**
     * exécution de la boucle de commandes.
     */
    public void run() {
        System.out.print("Entrez help pour obtenir la liste des commandes.\n>");
        String cmd = saisie.nextLine();
        Command c;
        while (!cmd.equals("exit")) {
            c = dt.nextCommand(cmd);
            if (c != null) {
                c.execute();
            }
            System.out.print(">");
            cmd = saisie.nextLine();
        }
    }
    /**
     * début du programme.
     * @param args arguments
     * @throws Exception erreur bdd
     */
    public static void main(final String[] args) throws Exception {
        Bdd.createDataBase();
        Bdd.resetDataBase();
        DrawingApp app = new DrawingApp();
        app.run();
    }
}
