package mathieu.pglp_9_9;

/**
 * classe d'execution.
 */
public enum App {
    /**
     * debut du programme.
     */
    Application;
    /**
     * methode d'execution.
     * @param args arguments pour executer
     */
    public static void main(final String[] args) {
        String s = "cacaCercle((12,10), 50)";
        /*String[]split = s.split("Cercle");
        for (String s2 : split) {
            System.out.println("<" + s2 + ">");
        }*/
        s = s.substring(1, s.length() - 1);
        System.out.println(s);
        
        s = "1".concat("2").concat("3");
        System.out.println(s);
        
    }
}
