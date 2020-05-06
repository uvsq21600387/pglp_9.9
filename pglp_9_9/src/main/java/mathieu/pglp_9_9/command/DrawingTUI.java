package mathieu.pglp_9_9.command;

import java.util.ArrayList;

import mathieu.pglp_9_9.dao.AbstractDao;
import mathieu.pglp_9_9.dao.DaoFactoryJDBC;
import mathieu.pglp_9_9.forme.Carre;
import mathieu.pglp_9_9.forme.Cercle;
import mathieu.pglp_9_9.forme.Forme;
import mathieu.pglp_9_9.forme.GroupeForme;
import mathieu.pglp_9_9.forme.Position;
import mathieu.pglp_9_9.forme.Rectangle;
import mathieu.pglp_9_9.forme.Triangle;

/**
 * interpréteur de commandes utilisateur.
 */
public class DrawingTUI {
    /**
     * interprète la commande de création d'un cercle.
     * @param variableName nom de la variable
     * @param split2 données après le '='
     * @return le cercle ou null en cas d'erreurs
     */
    private Forme createCercle(
            final String variableName, final String[] split2) {
        final int trois = 3;
        String[] split = split2[1].split("Cercle");
        if (!split[0].equals("")
                || !(split[1].startsWith("(") && split[1].endsWith(")"))) {
            System.err.println("Commande invalide, parenthèses manquantes");
        } else {
            split[1] = split[1].substring(1, split[1].length() - 1);
            split = split[1].split(",");
            if (split.length != trois) {
                System.err.println("Commande invalide, "
                        + split.length + "/" + trois +" arguments");
            } else {
                Position centre;
                int rayon;
                try {
                    centre = new Position(split[0] + "," + split[1]);
                    rayon = Integer.parseInt(split[2]);
                    return new Cercle(variableName, centre, rayon);
                } catch (Exception e) {
                    System.err.println("Commande invalide, "
                            + "impossible de créer la forme");
                }
            }
        }
        return null;
    }
    /**
     * interprète la commande de création d'un carré.
     * @param variableName nom de la variable
     * @param split2 données après le '='
     * @return le carré ou null en cas d'erreurs
     */
    private Forme createCarre(
            final String variableName, final String[] split2) {
        final int trois = 3;
        String[] split = split2[1].split("Carre");
        if (!split[0].equals("")
                || !(split[1].startsWith("(") && split[1].endsWith(")"))) {
            System.err.println("Commande invalide, parenthèses manquantes");
        } else {
            split[1] = split[1].substring(1, split[1].length() - 1);
            split = split[1].split(",");
            if (split.length != trois) {
                System.err.println("Commande invalide, "
                        + split.length + "/" + trois +" arguments");
            } else {
                Position topLeft;
                int longueur;
                try {
                    topLeft = new Position(split[0] + "," + split[1]);
                    longueur = Integer.parseInt(split[2]);
                    return new Carre(variableName, topLeft, longueur);
                } catch (Exception e) {
                    System.err.println("Commande invalide, "
                            + "impossible de créer la forme");
                }
            }
        }
        return null;
    }
    /**
     * interprète la commande de création d'un rectangle.
     * @param variableName nom de la variable
     * @param split2 données après le '='
     * @return le rectangle ou null en cas d'erreurs
     */
    private Forme createRectangle(
            final String variableName, final String[] split2) {
        final int quatre = 4;
        String[] split = split2[1].split("Rectangle");
        if (!split[0].equals("")
                || !(split[1].startsWith("(") && split[1].endsWith(")"))) {
            System.err.println("Commande invalide, parenthèses manquantes");
        } else {
            split[1] = split[1].substring(1, split[1].length() - 1);
            split = split[1].split(",");
            if (split.length != quatre) {
                System.err.println("Commande invalide, "
                        + split.length + "/" + quatre +" arguments");
            } else {
                Position topLeft;
                int longueur;
                int largeur;
                try {
                    final int trois = 3;
                    topLeft = new Position(split[0] + "," + split[1]);
                    longueur = Integer.parseInt(split[2]);
                    largeur = Integer.parseInt(split[trois]);
                    return new Rectangle(
                            variableName, topLeft, longueur, largeur);
                } catch (Exception e) {
                    System.err.println("Commande invalide, "
                            + "impossible de créer la forme");
                }
            }
        }
        return null;
    }
    /**
     * interprète la commande de création d'un triangle.
     * @param variableName nom de la variable
     * @param split2 données après le '='
     * @return le triangle ou null en cas d'erreurs
     */
    private Forme createTriangle(
            final String variableName, final String[] split2) {
        final int six = 6;
        String[]  split = split2[1].split("Triangle");
        if (!split[0].equals("")
                || !(split[1].startsWith("(") && split[1].endsWith(")"))) {
            System.err.println("Commande invalide, parenthèses manquantes");
        } else {
            split[1] = split[1].substring(1, split[1].length() - 1);
            split = split[1].split(",");
            if (split.length != six) {
                System.err.println("Commande invalide, "
            + split.length +"/" + six +" arguments");
            }
            Position[] point = {null, null, null};
            try {
                final int trois = 3, quatre = 4, cinq = 5;
                point[0] = new Position(split[0] + "," + split[1]);
                point[1] = new Position(split[2] + "," + split[trois]);
                point[2] = new Position(split[quatre] + "," + split[cinq]);
                return new Triangle(variableName, point[0], point[1], point[2]);
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Commande invalide, "
                        + "impossible de créer la forme");
            }
        }
        return null;
    }
    /**
     * interprète la commande de création d'un groupe.
     * @param variableName nom de la variable
     * @param split2 données après le '='
     * @return le groupe ou null en cas d'erreurs
     */
    private Forme createGroupe(
            final String variableName, final String[] split2) {
        String[] split = split2[1].split("Groupe");
        if (!split[0].equals("")
                || !(split[1].startsWith("(") && split[1].endsWith(")"))) {
            System.err.println("Commande invalide, parenthèses manquantes");
        } else {
            split[1] = split[1].substring(1, split[1].length() - 1);
            split = split[1].split(",");
            Forme f = createGroupeComposants(variableName, split);
            if(f == null) {
                System.err.println("Commande invalide, "
                        + "impossible de créer la forme");
            }
            return f;
        }
        return null;
    }
    /**
     * interprète la commande de création d'un groupe (partie composants).
     * @param variableName nom de la variable
     * @param split données après le '='
     * @return le groupe ou null en cas d'erreurs
     */
    private Forme createGroupeComposants(
            final String variableName, final String[] split) {
        GroupeForme gf = new GroupeForme(variableName);
        for (String s : split) {
            Forme f = this.getForme(s);
            if (f != null) {
                gf.add(f);
            } else {
                return null;
            }
        }
        return gf;
    }
    /**
     * obtenir la forme avec son nom de variable.
     * @param variableName nom de la forme
     * @return la forme
     */
    private Forme getForme(final String variableName) {
        DaoFactoryJDBC factory = new DaoFactoryJDBC();
        AbstractDao<Cercle> daoCe = factory.getDaoCercle();
        AbstractDao<Carre> daoCa = factory.getDaoCarre();
        AbstractDao<Rectangle> daoR = factory.getDaoRectangle();
        AbstractDao<Triangle> daoT = factory.getDaoTriangle();
        AbstractDao<GroupeForme> daoG = factory.getDaoGroupeForme();
        Forme f = daoCe.find(variableName);
        if (f == null) {
            f = daoCa.find(variableName);
        }
        if (f == null) {
            f = daoR.find(variableName);
        }
        if (f == null) {
            f = daoT.find(variableName);
        }
        if (f == null) {
            f = daoG.find(variableName);
        }
        factory.close();
        return f;
    }
    /**
     * interprète la commande de création de forme.
     * @param cmd2 la commande
     * @return la forme générée
     */
    private Forme create(final String cmd2) {
        String[] split;
        split = cmd2.split("=");
        split[0] = split[0].trim();
        String variableName = split[0];
        if (split[0].contains(" ")) {
            System.out.println("Le nom de la variable contient des espaces");
        } else {
            split[1] = split[1].replace(" ", "");
            Forme f = null;
            if (split[1].contains("Cercle")) {
                f = this.createCercle(variableName, split);
            } else if (split[1].contains("Carre")) {
                f = this.createCarre(variableName, split);
            } else if (split[1].contains("Rectangle")) {
                f = this.createRectangle(variableName, split);
            } else if (split[1].contains("Triangle")) {
                f = this.createTriangle(variableName, split);
            } else if (split[1].contains("Groupe")) {
                f = this.createGroupe(variableName, split);
            }
            return f;
        }
        return null;
    }
    /**
     * interprète la commande de déplacement d'une forme.
     * @param cmd2 commande de déplacement
     * @return la commande de déplacement
     */
    private Command move(final String cmd2) {
        final int trois = 3;
        String cmd = cmd2.replace(" ", "");
        String[] split = cmd.split("move");
        if (!split[0].equals("")
                || !(split[1].startsWith("(") && split[1].endsWith(")"))) {
            System.err.println("Commande invalide, parenthèses manquantes");
        } else {
            split[1] = split[1].substring(1, split[1].length() - 1);
            split = split[1].split(",");
            if (split.length != trois) {
                System.err.println("Commande invalide, "
                        + split.length + "/" + trois +" arguments");
            } else {
                String variableName;
                Position deplacement;
                try {
                    variableName = split[0];
                    deplacement = new Position(split[1] + "," + split[2]);
                    Forme f = this.getForme(variableName);
                    if (f != null) {
                        return new MoveCommand(f, deplacement);
                    }
                } catch (Exception e) {
                    System.err.println("Commande invalide");
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    /**
     * interprète la commande d'affichage de formes.
     * @param cmd2 commande d'affichage
     * @return la commande d'affichage
     */
    private Command affiche(final String cmd2) {
        String cmd = cmd2.replace(" ", "");
        String[] split = cmd.split("show");
        if (!split[0].equals("")
                || !(split[1].startsWith("(") && split[1].endsWith(")"))) {
            System.err.println("Commande invalide, parenthèses manquantes");
        } else {
            split[1] = split[1].substring(1, split[1].length() - 1);
            split = split[1].split(",");
            ArrayList<Forme> list = new ArrayList<Forme>();
            for (String var : split) {
                Forme f = this.getForme(var);
                if (f != null) {
                    list.add(f);
                } else {
                    System.err.println("Commande invalide, forme inconnu");
                    return null;
                }
            }
            return new AfficheCommand(list);
        }
        return null;
    }
    /**
     * interprète la commande de suppression de formes.
     * @param cmd2 commande de suppression
     * @return la commande de suppression
     */
    private Command remove(final String cmd2) {
        String cmd = cmd2.replace(" ", "");
        String[] split = cmd.split("delete");
        if (!split[0].equals("")
                || !(split[1].startsWith("(") && split[1].endsWith(")"))) {
            System.err.println("Commande invalide, parenthèses manquantes." + split[1]);
        } else {
            split[1] = split[1].substring(1, split[1].length() - 1);
            split = split[1].split(",");
            ArrayList<Forme> list = new ArrayList<Forme>();
            for (String var : split) {
                Forme f = this.getForme(var);
                if (f != null) {
                    list.add(f);
                } else {
                    System.err.println("Commande invalide, forme inconnu");
                    return null;
                }
            }
            return new RemoveCommand(list);
        }
        return null;
    }
    /**
     * interprète une commande.
     * @param cmd commande à interpréter.
     * @return une commande à exécuter ou null s'il n'y en a pas.
     */
    public Command nextCommand(final String cmd) {
        if (cmd.contains("=")) {
            Forme f = this.create(cmd);
            if (f != null) {
                return new CreateCommand(f);
            }
        } else if (cmd.contains("move")) {
            return this.move(cmd);
        } else if (cmd.contains("show(")) {
            return this.affiche(cmd);
        } else if (cmd.equals("showAll")) {
            this.afficheDessin();
        } else if (cmd.contains("delete")) {
            return this.remove(cmd);
        } else if (cmd.equals("help")) {
            System.out.println("Commandes disponibles : \n"
                    + "Créer un cercle :                                    variableName = Cercle((x,y), rayon)\n"
                    + "Créer un carré :                                     variableName = Carre((x,y), longueur)\n"
                    + "Créer un rectangle :                                 variableName = Rectangle((x,y), longueur, largeur)\n"
                    + "Créer un triangle :                                  variableName = Triangle((x,y), (x,y), (x,y))\n"
                    + "Créer un groupe de forme(s) :                        variableName = Groupe(variableName, ...)\n"
                    + "\n"
                    + "déplacer une forme ou un groupe :                    move(variableName, (x,y))\n"
                    + "\n"
                    + "afficher une/des forme(s) ou un/des groupe(s) :      show(variableName, ...)\n"
                    + "afficher toutes les formes et groupes :              showAll"
                    + "\n"
                    + "supprimer une forme ou un groupe :                   delete(variableName, ...)");
        } else if (!cmd.equals("exit")) {
            System.err.println("Commande non reconnu");
        }
        return null;
    }
    /**
     * affiche toutes les formes du dessin (sauf les groupes).
     */
    public void afficheDessin() {
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
        factory.close();
    }
}
