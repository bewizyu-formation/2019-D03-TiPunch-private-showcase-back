package fr.formation.validator;

public class CustomValidator {

    /**
     * checked password with 8 character minimum, 1 MAJ, 1 number
     * @param password
     * @return boolean
     */
    public boolean isValidPassword(String password){

        return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}$");
    }

    /**
     * checked texte no contains sql
     * @param texte
     * @return boolean
     */
    public boolean isNotContainSqlInjection(String texte){

        return texte.matches("^[a-zA-Z0-9-\\\\_\\\\ áàâäãåçéèêëíìîïñóòôöõúùûüýÿæœÁÀÂÄÃÅÇÉÈÊËÍÌÎÏÑÓÒÔÖÕÚÙÛÜÝŸÆŒ.!:;,\\\\(\\\\)\\\\\\']{3,}$");
    }

    /**
     * checked phone number
     * @param phone
     * @return boolean
     */
    public boolean isValidPhoneNumber(String phone){

        /*
            \d{10} matches 1234567890
            (?:\d{3}-){2}\d{4} matches 123-456-7890
            \(\d{3}\)\d{3}-?\d{4} matches (123)456-7890 or (123)4567890
         */

        return phone.matches("^\\\\d{10}|(?:\\\\d{3}-){2}\\\\d{4}|\\\\(\\\\d{3}\\\\)\\\\d{3}-?\\\\d{4}$");
    }

}
