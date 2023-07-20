package leetcode; // 44

import java.util.HashMap;
import java.util.Map;

public class WildcardPatternMatchingAlt2 {
	
	public static boolean isMatch(String s, String p) {
        Map<String, Boolean> memo = new HashMap<>(); // Mapa para almacenar resultados intermedios.
        return isMatchHelper(s, p, 0, 0, memo);
    }

    private static boolean isMatchHelper(String s, String p, int sIndex, int pIndex, Map<String, Boolean> memo) {
        // Verificar si el resultado ya se ha calculado previamente.
        String key = sIndex + "|" + pIndex;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Caso base: Ambas cadenas llegaron al final.
        if (sIndex == s.length() && pIndex == p.length()) {
            return true;
        }

        // Caso base: Solo el patrón llegó al final, pero la cadena aún no.
        if (pIndex == p.length()) {
            return false;
        }

        // Caso base: Solo la cadena llegó al final, pero el patrón aún no.
        if (sIndex == s.length()) {
            while (pIndex < p.length() && p.charAt(pIndex) == '*') {
                pIndex++;
            }
            return pIndex == p.length();
        }

        char sc = s.charAt(sIndex);
        char pc = p.charAt(pIndex);

        // Comparar los caracteres actuales.
        if (pc == '?' || sc == pc) {
            boolean match = isMatchHelper(s, p, sIndex + 1, pIndex + 1, memo);
            memo.put(key, match); // Almacenar el resultado en el mapa.
            return match;
        }

        // Caso para el comodín '*'.
        if (pc == '*') {
            boolean match = isMatchHelper(s, p, sIndex, pIndex + 1, memo) || // Ignorar el '*'.
                           isMatchHelper(s, p, sIndex + 1, pIndex, memo);  // Coincidir con el '*'.
            memo.put(key, match); // Almacenar el resultado en el mapa.
            return match;
        }

        // Si ninguno de los casos anteriores coincide, retornar falso.
        memo.put(key, false); // Almacenar el resultado en el mapa.
        return false;
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
