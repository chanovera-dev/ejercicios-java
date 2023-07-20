package leetcode; // 44

public class WildcardPatternMatching {

    public static boolean isMatch(String s, String p) {
        int m = s.length(); // Longitud de la cadena de entrada 's'.
        int n = p.length(); // Longitud del patrón 'p'.
        boolean[][] dp = new boolean[m + 1][n + 1]; // Matriz para almacenar los resultados de subproblemas.

        dp[0][0] = true; // Ambas cadenas vacías, por lo que hay coincidencia.

        // Llenar la primera fila de la matriz.
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Llenar la matriz utilizando programación dinámica.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1); // Carácter actual de la cadena de entrada 's'.
                char pc = p.charAt(j - 1); // Carácter actual del patrón 'p'.

                if (sc == pc || pc == '?') {
                    dp[i][j] = dp[i - 1][j - 1]; // Caracteres coinciden o hay un comodín '?'
                } else if (pc == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j]; // Comodín '*': ignorar o omitir el carácter actual.
                }
            }
        }

        return dp[m][n]; // El resultado final se encuentra en la esquina inferior derecha de la matriz.
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