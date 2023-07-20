package Excel;

public class ExcelColumnNumber {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char ch = columnTitle.charAt(i);
            int value = ch - 'A' + 1; // Convert character to corresponding value (A=1, B=2, ...)
            result = result * 26 + value; // Multiply the result by 26 and add the value of the current character
        }
        return result;
    }

    public static void main(String[] args) {
        ExcelColumnNumber excelColumnNumber = new ExcelColumnNumber();
        String columnTitle1 = "A";
        int columnNumber1 = excelColumnNumber.titleToNumber(columnTitle1);
        System.out.println("Column Title: " + columnTitle1 + ", Column Number: " + columnNumber1);

        String columnTitle2 = "AB";
        int columnNumber2 = excelColumnNumber.titleToNumber(columnTitle2);
        System.out.println("Column Title: " + columnTitle2 + ", Column Number: " + columnNumber2);

        String columnTitle3 = "ZY";
        int columnNumber3 = excelColumnNumber.titleToNumber(columnTitle3);
        System.out.println("Column Title: " + columnTitle3 + ", Column Number: " + columnNumber3);
    }
}