package mathieu.pglp_9_9;

import java.io.File;
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
        System.out.print("Entrez help pour obtenir la liste des commandes.\n");
        String cmd = saisie.nextLine();
        Command c;
        while (!cmd.equalsIgnoreCase("exit")) {
            c = dt.nextCommand(cmd);
            if (c != null) {
                c.execute();
            }
            dt.afficheDessin();
            cmd = saisie.nextLine();
        }
    }
    /**
     * demande si un dessin doit être repris.
     * @return nom du dessin
     * @throws Exception nom invalide
     */
    @SuppressWarnings("resource")
    public static String selectNameDessin() throws Exception {
        System.out.println("Modifier un dessin ? Y/N");
        Scanner s = new Scanner(System.in);
        String name = "";
        while (!name.equalsIgnoreCase("y") && !name.equalsIgnoreCase("n")
                && !name.equalsIgnoreCase("exit")) {
            name = s.nextLine();
        }
        if (name.equalsIgnoreCase("y")) {
            System.out.println("Entrez un nom de dessin : ");
            name = s.nextLine();
            Bdd.setNomDessin(name);
            File f = new File(name);
            if (!f.exists()) {
                System.err.println("Aucun dessin n'existe à ce nom");
                throw new Exception();
            }
            return name;
        }
        return "tmp";
    }
    /**
     * enregistrer un dessin.
     * @param name nom du dessin qui a été modifié
     */
    public static void enregistre(final String name) {
        Scanner s = new Scanner(System.in);
        if (!name.equals("tmp")) {
            System.out.println("1. Enregistrer vers \"" + name + "\"");
            System.out.println("2. Enregistrer sous ...");
            String reponse  = "";
            while (!reponse.equals("1") && !reponse.equals("2")
                    && !reponse.equalsIgnoreCase("exit")) {
                s = new Scanner(System.in);
            }
            if (reponse.equals("1") || reponse.equalsIgnoreCase("exit")) {
                s.close();
                return;
            }
        }
        System.out.println("entrez un nom pour sauvegarder votre dessin :");
        String reponse  = "tmp";
        while (reponse.equals("tmp") && new File(reponse).exists()) {
            reponse = s.nextLine();
        }
        if (reponse.equalsIgnoreCase("exit")) {
            s.close();
            return;
        } else {
            File f = new File(name);
            if (!f.exists()) {
                f.renameTo(new File(reponse));
            }
        }
        s.close();
    }
    /**
     * début du programme.
     * @param args arguments
     * @throws Exception erreur bdd
     */
    public static void main(final String[] args) throws Exception {
        try {
            String name = selectNameDessin();
            if (name.equals("tmp")) {
                Bdd.createDataBase();
                Bdd.resetDataBase();
            } else {
                Bdd.setNomDessin(name);
            }
            DrawingApp app = new DrawingApp();
            app.run();
            enregistre(name);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
