package leetcode; // 44

public class WildcardPatternMatchingAlt1 {

    public static boolean isMatch(String s, String p) {
        int sIndex = 0; // Índice de caracteres en la cadena 's'.
        int pIndex = 0; // Índice de caracteres en el patrón 'p'.
        int match = 0; // Índice de caracteres coincidentes en 's' después de encontrar un '*'.
        int starIndex = -1; // Índice del último '*' encontrado en 'p'.

        while (sIndex < s.length()) {
            // Caso 1: Los caracteres coinciden o hay un comodín '?'.
            if (pIndex < p.length() && (p.charAt(pIndex) == '?' || p.charAt(pIndex) == s.charAt(sIndex))) {
                sIndex++;
                pIndex++;
            }
            // Caso 2: Se encuentra un comodín '*'.
            else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                starIndex = pIndex; // Almacenar el índice del '*' actual en 'p'.
                match = sIndex; // Almacenar el índice de caracteres coincidentes en 's'.
                pIndex++;
            }
            // Caso 3: No hay coincidencia, pero se encontró un '*' anteriormente.
            else if (starIndex != -1) {
                pIndex = starIndex + 1; // Volver al siguiente carácter después del '*' en 'p'.
                match++; // Incrementar el índice de caracteres coincidentes en 's'.
                sIndex = match; // Volver a comparar los caracteres restantes en 's'.
            }
            // Caso 4: No hay coincidencia y no se encontró un '*' anteriormente.
            else {
                return false;
            }
        }

        // Verificar los caracteres restantes en 'p'.
        while (pIndex < p.length() && p.charAt(pIndex) == '*') {
            pIndex++;
        }

        return pIndex == p.length();
    }

    public static void main(String[] args) {
        // Ejemplos de uso
        String s1 = "aa";
        String p1 = "a";
        System.out.println(isMatch(s1, p1)); // Salida: false

        String s2 = "aa";
        String p2 = "*";
        System.out.println(isMatch(s2, p2)); // Salida: true

        String s3 = "cb";
        String p3 = "?a";
        System.out.println(isMatch(s3, p3)); // Salida: false
    }
}

