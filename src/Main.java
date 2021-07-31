import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        String str = "";
        double result = 0;
        try (FileReader reader = new FileReader("input.txt")) {
            char[] buf = new char[256];
            int c;
            while((c = reader.read(buf))>0){

                if(c < 256){
                    buf = Arrays.copyOf(buf, c);
                }
            }
            str = String.valueOf(buf);
            result = maths(str.split(" "));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try(FileWriter writer = new FileWriter("output.txt", false))
        {
            // запись всей строки
            String s = "" + result;
            writer.write(s);
            // запись по символам
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }


    }

    public static double maths (String[] arg) throws Exception{
        double a;
        double b;

        try {
            a = Double.parseDouble(arg[0]);
            b = Double.parseDouble(arg[2]);
        } catch (NumberFormatException e) {
            throw new Exception("Error! Not number");
        }

        if (!arg[1].equals("+") && !arg[1].equals("-") && !arg[1].equals("*") && !arg[1].equals("/")) {
            throw new Exception("Operation Error!");
        }

        if (arg[1].equals("+")) {
            return a + b;
        } else if (arg[1].equals("-")) {
            return a - b;
        } else if (arg[1].equals("*")) {
            return a * b;
        } else {
            if (b == 0.0) {
                throw new Exception("Error! Division by zero");
            }
            return a / b;
        }
    }

}
