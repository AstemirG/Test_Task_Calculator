import java.io.IOException;
import java.util.Scanner;

public class Main
{
    static int romanToInt(String s) //Преобразование из римских в арабские
    {
        int sum = 0;
        for (char i:s.toCharArray())
        {
            if (i == 'I')
            {
                if (i == 'V')
                {
                    sum += 4;
                    continue;
                }
                else if (i == 'X')
                {
                    sum += 9;
                    continue;
                }
                else
                    sum += 1;
            }
            else if (i == 'V')
                sum += 5;
            else if (i == 'X')
            {
                if (i == 'L')
                {

                    sum += 40;
                    continue;
                }
                else if (i == 'C')
                {
                    sum += 90;
                    continue;
                }
                else
                    sum += 10;
            }
            else if (i == 'L')
                sum += 50;
        }
        return sum;
    }

    private static String intToRoman (int numArabian) //Преобразование из арабских в римские.
    // Выбрал такой метод т.к этот метод легкодоступный и очень быстрый.
    // Быстрее запросить по индексу массива, чем в цикле с условиями преобразовывать.
    // Единственный минус, что этот метод менее гибкий, но для наших целей он подходит
    {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }


    public static void main(String[] args)
    {
        Scanner cin=new Scanner(System.in);
        String input = cin.nextLine();
        String[] arr_s=input.split(" ");
        if(arr_s.length>3)//Проверка валидности данных
        {
            try
            {
                throw new IOException();
            }
            catch (IOException e)
            {
                System.out.println("Exception формат математической операции не удовлетворяет " +
                        "заданию - два операнда и один оператор (+, -, /, *)");
            }
            return;
        }
        if(arr_s.length<3)//Проверка валидности данных
        {
            try
            {
                throw new IOException();
            }
            catch (IOException e)
            {
                System.out.println("Exception строка не является математической операцией");
            }
            return;
        }
        String num1=arr_s[0];
        String num2=arr_s[2];
        String action=arr_s[1];
        int result=0,result_num1,result_num2;
        result_num1=romanToInt(num1);
        result_num2=romanToInt(num2);
        if((result_num1!=0 && result_num2==0) || (result_num1==0 && result_num2 !=0))//Проверка валидности данных
        {
            try {
                throw new IOException();
            }
            catch (IOException e)
            {
                System.out.println("Exception используются одновременно разные системы счисления ");
                return;
            }
        }
        if(result_num1!=0 && result_num2!=0)//Проверка валидности данных
        {
            try {
                switch (action) {
                    case "+":
                        result = result_num1 + result_num2;
                        break;
                    case "-":
                        result = result_num1 - result_num2;
                        break;
                    case "*":
                        result = result_num1 * result_num2;
                        break;
                    case "/":
                        result = result_num1 / result_num2;
                        break;
                    default:
                        throw new IOException();
                }
            } catch (IOException e) {
                System.out.println("Exception формат математической операции не удовлетворяет " +
                        "заданию - два операнда и один оператор (+, -, /, *)");
                return;
            }
            if(result<0)
            {
                try{
                    throw new IOException();
                }
                catch (IOException e)
                {
                    System.out.println("Exception в римской системе нет отрицательных чисел ");
                    return;
                }
            }
            String result_s = intToRoman(result);
            System.out.println(result_s);
        }
        else
        {


            result_num1 = Integer.parseInt(num1);
            result_num2 = Integer.parseInt(num2);
            try {
                switch (action) {
                    case "+":
                        result = result_num1 + result_num2;
                        break;
                    case "-":
                        result = result_num1 - result_num2;
                        break;
                    case "*":
                        result = result_num1 * result_num2;
                        break;
                    case "/":
                        result = result_num1 / result_num2;
                        break;
                    default:
                        throw new IOException();
                }
            } catch (IOException e) {
                System.out.println("Exception формат математической операции не удовлетворяет " +
                        "заданию - два операнда и один оператор (+, -, /, *)");
                return;
            }
            System.out.println(result);
        }
    }
}
