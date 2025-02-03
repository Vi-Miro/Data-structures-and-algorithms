public class LCS {
    // Метод для нахождения LCS
    public static String longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // Создаем таблицу для хранения длины LCS
        int[][] dp = new int[m + 1][n + 1];
        // Заполняем таблицу
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i- 1) == text2.charAt(j- 1)) {
                    dp[i][j] = dp[i- 1][j- 1] + 1; // если символы совпадают
                } else {
                    dp[i][j] = Math.max(dp[i- 1][j], dp[i][j- 1]); // если не совпадают
                }
            }
        }

        // Восстанавливаем LCS из таблицы
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (text1.charAt(i- 1) == text2.charAt(j- 1)) {
                lcs.append(text1.charAt(i- 1)); // совпадающий символ
                i--;
                j--;
            } else if (dp[i- 1][j] > dp[i][j- 1]) {
                i--; // идем вверх
            } else {
                j--; // идем влево
            }
        }
        // Возвращаем LCS в обратном порядке
        return lcs.reverse().toString();
    }
    public static void main(String[] args) {
        String text1 = "BANA_NA";
        String text2 = "ANA_NAB";
        String lcs = longestCommonSubsequence(text1, text2);
        System.out.println("LCS: \n" + lcs);
    }
}
