package metiers;

public class StringUtils {

    public static String fizzBuzz(int value) {
        if (value == 0) return "0";
        if (value % 15 == 0) return "FizzBuzz";
        if (value % 3 == 0) return "Fizz";
        if (value % 5 == 0) return "Buzz";
        return String.valueOf(value);
    }

    public static String toNomPropre(String chaine) {
        if (!chaine.isEmpty()) {
            StringBuilder resulta = new StringBuilder();
            resulta.append(chaine.substring(0, 1).toUpperCase().trim());

            for (int i = 1; i < chaine.length(); i++) {
                if (chaine.charAt(i - 1) == ' ' || chaine.charAt(i - 1) == '-') {
                    resulta.append(chaine.substring(i, i + 1).toUpperCase());
                } else {
                    resulta.append(chaine.substring(i, i + 1).toLowerCase());
                }
            }
            return resulta.toString();
        } else {
            return "";
        }
    }

    public static String toAccent(String mots) {
        String origine = "àâäçéèêëìîïòôöùûüµÿ'-_";
        String substitution = "aaaceeeeiiiooouuuuy   ";
        StringBuilder resultat = new StringBuilder();
        // pour chaque caractère de la chaine reçue
        for (int cpt = 0; cpt < mots.length(); cpt++) {
            int pos = origine.indexOf(mots.charAt(cpt));
            if (pos == -1) {
                resultat.append(mots.charAt(cpt));
            } else {
                resultat.append(substitution.charAt(pos));
            }
        }
        return resultat.toString();
    }

    public static String doubleEspace(String chaine) {
        StringBuilder resulta = new StringBuilder();

        if (!chaine.isEmpty()) {
            resulta = new StringBuilder(chaine.substring(0, 1));
            for (int i = 1; i < chaine.length(); i++) {
                if ((chaine.charAt(i - 1) == ' ' && chaine.charAt(i) == ' ') ||
                        (chaine.charAt(i - 1) == '-' && chaine.charAt(i) == '-')) {
                    resulta.append("");
                } else {
                    resulta.append(chaine.charAt(i));
                }
            }
        }
        return resulta.toString();
    }

    public static String ponctuer(String chaine) {
        chaine = doubleEspace(chaine.trim());
        for (int i = 0; i < chaine.length(); i++) {
            String car = chaine.substring(i, 1);
            switch (car) {
                case "-":
                    // Si le caratere précédent est un espace, la nouvelle chaine est la concaténation
                    // de la sous-chaine qui va jusqu'à cet espace et de la sous-chaine qui commence au - et va jusqu'à la fin
                    if (i > 0 && chaine.substring(i - 1, 1) == " ")
                        chaine = chaine.substring(0, i - 1) + chaine.substring(i--); // i=i-1 car on a supprimer un espace avant le -
                    // Si le caratere suivant est un espace, la nouvelle chaine est la concaténation
                    // de la sous-chaine qui va jusqu'àu - et de la sous-chaine qui commence après l'espace et va jusqu'à la fin
                    if (i < chaine.length() - 1 && chaine.substring(i + 1, 1) == " ")
                        chaine = chaine.substring(0, i + 1) + chaine.substring(i + 2);
                    break;
                case ",":
                case ".":
                    // Si le caratere précédent est un espace, la nouvelle chaine est la concaténation
                    // de la sous-chaine qui va jusqu'à cet espace et de la sous-chaine qui commence au . ou à la , et va jusqu'à la fin
                    if (i > 0 && chaine.substring(i - 1, 1) == " ")
                        chaine = chaine.substring(0, i - 1) + chaine.substring(i--);// i=i-1 car on a supprimer un espace avant le . ou la ,
                    // si le caractère suivant n'est pas un espace, alors on l'ajoute
                    if (i < chaine.length() - 1 && chaine.substring(i + 1, 1) != " ")
                        chaine = chaine.substring(0, i + 1) + " " + chaine.substring(i++ + 1); // i = i+1 car on a ajouté un espace
                    break;
                case "?":
                case ";":
                case "!":
                case ":":
                    // si le caractère précédent n'est pas un espace, alors on l'ajoute
                    if (i > 0 && chaine.substring(i - 1, 1) != " ")
                        chaine = chaine.substring(0, i) + " " + chaine.substring(i++);// i = i+1 car on a ajouté un espace
                    // si le caractère suivant n'est pas un espace, alors on l'ajoute
                    if (i < chaine.length() - 1 && chaine.substring(i + 1, 1) != " ")
                        chaine = chaine.substring(0, i + 1) + " " + chaine.substring(i++ + 1);// i = i+1 car on a ajouté un espace
                    break;
                default:
                    break;
            }
        }
        // On convertit en majuscule le caractère qui suit un . ou un ? ou un !
        for (int i = 0; i < chaine.length() - 2; i++) {
            String car = chaine.substring(i, 1);
            String maj = ".?!";
            if (maj.indexOf(car) != -1) {
                chaine = chaine.substring(0, i + 2) + chaine.substring(i + 2, 1).toUpperCase() + chaine.substring(i + 3);
            }

        }
        return chaine;
    }

    public static String suprExtention(String chaine) {
        return chaine = chaine.substring(0, chaine.indexOf("."));
    }

    public static String classementLivre(String nom, String prenom) {
        String resulta = "";
        String prefix = "";

        if (nom.indexOf("de") != -1) {

            prefix = nom.substring(0, 2);
            resulta = nom.substring(nom.indexOf("de") + 2) + ", " + prenom + " (" + prefix + ")";
        } else if (nom.indexOf("d'") != -1) {
            prefix = "d'";
            resulta = nom.substring(nom.indexOf("d'") + 2) + ", " + prenom + " (" + prefix + ")";
        } else if (nom.indexOf("des") != -1) {
            prefix = " (de)";
            resulta = nom.substring(nom.indexOf("de") + 3) + ", " + prenom + " (" + prefix + ")";
        } else {

            resulta = nom + ", " + prenom;

        }
        //if (prenom == "") resulta = nom;
        return doubleEspace(resulta.trim());

    }

    public static String classementTitre(String titre) {
        titre.trim().toLowerCase();
        String resulta = "";
        String prefix = "";

        if (titre.indexOf("les") != -1) {

            prefix = "les";
            resulta = titre.substring(titre.indexOf("les") + 3) + " (" + prefix + ")";
        } else if (titre.indexOf("Les") != -1) {

            prefix = "Les";
            resulta = titre.substring(titre.indexOf("Les") + 3) + " (" + prefix + ")";
        } else if (titre.indexOf("l'") != -1) {
            prefix = "l'";
            resulta = titre.substring(titre.indexOf("l'") + 2) + " (" + prefix + ")";
        } else
            resulta = titre;
        return doubleEspace(resulta.trim());

    }

    public static String test(String titre) {
        return "";
    }

}
