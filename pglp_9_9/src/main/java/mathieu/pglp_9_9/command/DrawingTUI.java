package mathieu.pglp_9_9.command;

import java.util.ArrayList;
import java.util.Scanner;

import mathieu.pglp_9_9.dao.AbstractDao;
import mathieu.pglp_9_9.dao.DaoFactoryJDBC;
import mathieu.pglp_9_9.forme.Carre;
import mathieu.pglp_9_9.forme.Cercle;
import mathieu.pglp_9_9.forme.Forme;
import mathieu.pglp_9_9.forme.GroupeForme;
import mathieu.pglp_9_9.forme.Position;
import mathieu.pglp_9_9.forme.Rectangle;
import mathieu.pglp_9_9.forme.Triangle;

public class DrawingTUI {
    /**
     * lecture utilisateur.
     */
    private Scanner saisie;
    /**
     * constructeur de la classe.
     */
    public DrawingTUI() {
        saisie = new Scanner(System.in);
    }
    
    private Forme createCercle(final String variableName, String[] split) {
        split = split[1].split("Cercle");
        if (!split[0].equals("") ||
                !(split[1].charAt(0) == '(' && split[1].endsWith(")"))) {
            System.err.println("Commande invalide");
        } else {
            split[1] = split[1].substring(1, split[1].length() - 1);
            split = split[1].split(",");
            if (split.length != 3) {
                System.err.println("Commande invalide");
            } else {
                Position centre;
                int rayon;
                try {
                    centre = new Position(split[0] + "," + split[1]);
                    rayon = Integer.parseInt(split[2]);
                    return new Cercle(variableName, centre, rayon);
                } catch (Exception e) {
                    System.err.println("Commande invalide");
                }
            }
        }
        return null;
    }
    
    private Forme createCarre(final String variableName, String[] split) {
        split = split[1].split("Carre");
        if (!split[0].equals("") ||
                !(split[1].charAt(0) == '(' && split[1].endsWith(")"))) {
            System.err.println("Commande invalide");
        } else {
            split[1] = split[1].substring(1, split[1].length() - 1);
            split = split[1].split(",");
            if (split.length != 3) {
                System.err.println("Commande invalide");
            } else {
                Position topLeft;
                int longueur;
                try {
                    topLeft = new Position(split[0] + "," + split[1]);
                    longueur = Integer.parseInt(split[2]);
                    return new Carre(variableName, topLeft, longueur);
                } catch (Exception e) {
                    System.err.println("Commande invalide");
                }
            }
        }
        return null;
    }
    
    private Forme createRectangle(final String variableName, String[] split) {
        split = split[1].split("Rectangle");
        if (!split[0].equals("") ||
                !(split[1].charAt(0) == '(' && split[1].endsWith(")"))) {
            System.err.println("Commande invalide");
        } else {
            split[1] = split[1].substring(1, split[1].length() - 1);
            split = split[1].split(",");
            if (split.length != 4) {
                System.err.println("Commande invalide");
            } else {
                Position topLeft;
                int longueur;
                int largeur;
                try {
                    topLeft = new Position(split[0] + "," + split[1]);
                    longueur = Integer.parseInt(split[2]);
                    largeur = Integer.parseInt(split[3]);
                    return new Rectangle(variableName, topLeft, longueur, largeur);
                } catch (Exception e) {
                    System.err.println("Commande invalide");
                }
            }
        }
        return null;
    }
    
    private void createTriangle(final String variableName, String[] split) {
        split = split[1].split("Triangle");
        if (!split[0].equals("") ||
                !(split[1].charAt(0) == '(' && split[1].endsWith(")"))) {
            System.err.println("Commande invalide");
        } else {
            split[1] = split[1].substring(1, split[1].length() - 1);
            split = split[1].split(",");
            if (split.length != 6) {
                System.err.println("Commande invalide");
            }
            Position[] point = {null,null,null};
            try {
                point[0] = new Position(split[0] + "," + split[1]);
                point[1] = new Position(split[2] + "," + split[3]);
                point[2] = new Position(split[4] + "," + split[5]);
            } catch (Exception e) {
                System.err.println("Commande invalide");
                return;
            }
            Forme f = new Triangle(variableName, point[0], point[1], point[2]);
        }
    }
    
    private void createGroupe(final String variableName, String[] split) {
        split = split[1].split("Groupe");
        if (!split[0].equals("") ||
                !(split[1].charAt(0) == '(' && split[1].endsWith(")"))) {
            System.err.println("Commande invalide");
        } else {
            split[1] = split[1].substring(1, split[1].length() - 1);
            split = split[1].split(",");
            GroupeForme gf = new GroupeForme(variableName);
            for (String var : split) {
                //var = id d'une forme
            }
        }
    }
    
    private void create(String cmd) {
        String[] split;
        split = cmd.split("=");
        split[0].trim();
        String variableName = split[0];
        if (split[0].contains(" ")) {
            System.out.println("Le nom de la variable contient des espaces");
        }
        else {
            split[1].replace(" ", "");
            if (split[1].contains("Cercle")) {
                this.createCercle(variableName, split);
            } else if(split[1].contains("Carre")) {
                this.createCarre(variableName, split);
            } else if(split[1].contains("Rectangle")) {
                this.createRectangle(variableName, split);
            } else if(split[1].contains("Triangle")) {
                this.createTriangle(variableName, split);
            } else if(split[1].contains("Groupe")) {
                this.createGroupe(variableName, split);
            }
        }
    }
    
    private void move(String cmd) {
        cmd.replace(" ", "");
        String[] split = cmd.split("move");
        if (!split[0].equals("") ||
                !(split[1].charAt(0) == '(' && split[1].endsWith(")"))) {
            System.err.println("Commande invalide");
        } else {
            split = split[1].split(",");
            if (split.length != 3) {
                System.err.println("Commande invalide");
            }
            String variableName;
            Position deplacement;
            try {
                variableName = split[0];
                deplacement = new Position(split[1] + "," + split[2]);
            } catch (Exception e) {
                System.err.println("Commande invalide");
                return;
            }
            //move de variableName avec deplacement
        }
    }
    
    private void affiche(final String cmd) {
        cmd.replace(" ", "");
        String[] split = cmd.split("show");
        if (!split[0].equals("") ||
                !(split[1].charAt(0) == '(' && split[1].endsWith(")"))) {
            System.err.println("Commande invalide");
        } else {
            split[1] = split[1].substring(1, split[1].length() - 1);
            split = split[1].split(",");
            for (String var : split) {
                //var = id d'une forme a afficher
            }
        }
    }
    
    private void remove(final String cmd) {
        cmd.replace(" ", "");
        String[] split = cmd.split("remove");
        if (!split[0].equals("") ||
                !(split[1].charAt(0) == '(' && split[1].endsWith(")"))) {
            System.err.println("Commande invalide");
        } else {
            split[1] = split[1].substring(1, split[1].length() - 1);
            split = split[1].split(",");
            for (String var : split) {
                //var = id d'une forme a retirer
            }
        }
    }
    
    public void nextCommand() {
        String cmd = saisie.nextLine();
        if (cmd.contains("=")) {
            this.create(cmd);
        } else if (cmd.contains("move")) {
            this.move(cmd);
        } else if (cmd.contains("show")) {
            this.affiche(cmd);
        } else if (cmd.contains("showAll")) {
            this.afficheDessin(cmd);
        } else if (cmd.contains("remove")) {
            this.remove(cmd);
        } else if (cmd.equals("help")) {
            System.out.println("Commandes disponibles : "
                    + "Créer un cercle :                "
                    + "                    variableName "
                    + "= Cercle((x,y), rayon)"
                    + "Créer un carré :                 "
                    + "                    variableName "
                    + "= Carre((x,y), longueur)"
                    + "Créer un rectangle :             "
                    + "                    variableName "
                    + "= Cercle((x,y), longueur, largeur)"
                    + "Créer un triangle :              "
                    + "                    variableName "
                    + "= Triangle((x,y), (x,y), (x,y))"
                    + "Créer un groupe de forme(s) :    "
                    + "                    variableName "
                    + "= Groupe(variableName, ...)"
                    + "\n"
                    + "déplacer une forme ou un groupe :"
                    + "                    move(variable"
                    + "Name, (x,y))"
                    + "\n"
                    + "afficher une/des forme(s) ou un/d"
                    + "es groupe(s) :      show(varia"
                    + "bleName, ...)"
                    + "afficher toutes les formes et gro"
                    + "upes :              showAll"
                    + "\n"
                    + "supprimer une forme ou un groupe "
                    + ":                   remove(variab"
                    + "leName, ...)");
            
        } else {
            System.err.println("Commande non reconnu");
        }
    }
    
    public void afficheDessin(String cmd) {
        cmd.replace(" ", "");
        String[] split = cmd.split("show");
        if (!split[0].equals("") || !split[1].equals("")) {
            System.err.println("Commande invalide");
        } else {
            DaoFactoryJDBC factory = new DaoFactoryJDBC();
            AbstractDao<Cercle> daoCe = factory.getDaoCercle();
            AbstractDao<Carre> daoCa = factory.getDaoCarre();
            AbstractDao<Rectangle> daoR = factory.getDaoRectangle();
            AbstractDao<Triangle> daoT = factory.getDaoTriangle();
            ArrayList<Forme> formes = new ArrayList<Forme>();
            formes.addAll(daoCe.findAll());
            formes.addAll(daoCa.findAll());
            formes.addAll(daoR.findAll());
            formes.addAll(daoT.findAll());
            for (Forme f : formes) {
                f.affiche();
            }
        }
    }
}
