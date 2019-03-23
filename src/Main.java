import java.io.*;

public class Main {

    public static void main(String[] args) {
        String filename;
        String strategy;
        String[] interval;
        int lower;
        int upper;
        BoundedInteger bi1 = null;
        BoundedInteger bi2 = null;
        BoundedInteger bi3 = null;
        BufferedReader br;


        System.out.print("Type File Name: ");

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        try {
            filename = reader.readLine();
            File file = new File("src\\" + filename);
            br = new BufferedReader(new FileReader(file));
            File newFile = new File("src\\out-"+filename);
            FileWriter fileWriter = new FileWriter(newFile);
            strategy = br.readLine();
            interval = br.readLine().split(" ");
            lower = Integer.parseInt(interval[0]);
            upper = Integer.parseInt(interval[1]);
            if (strategy.equals("Cap")) {
                bi1 = new CapBoundedInteger((upper + lower) / 2, lower, upper);
                bi2 = new CapBoundedInteger((upper + lower) / 2, lower, upper);
                bi3 = new CapBoundedInteger((upper + lower) / 2, lower, upper);
            } else if (strategy.equals("Wrap")) {
                bi1 = new WrappedBoundedInteger((upper + lower) / 2, lower, upper);
                bi2 = new WrappedBoundedInteger((upper + lower) / 2, lower, upper);
                bi3 = new WrappedBoundedInteger((upper + lower) / 2, lower, upper);
            } else if (strategy.equals("Exception")) {
                bi1 = new ExceptionBoundedInteger((upper + lower) / 2, lower, upper);
                bi2 = new ExceptionBoundedInteger((upper + lower) / 2, lower, upper);
                bi3 = new ExceptionBoundedInteger((upper + lower) / 2, lower, upper);
            }
            if (bi1 != null)
                fileWriter.write(bi1.getValue() + "\n");

            String line;
            while ((line = br.readLine()) != null) {
                bi2.setValue(Integer.parseInt(line));
                fileWriter.write(bi2.getValue() + " ");
                bi3.setValue(Integer.parseInt(line)+ bi1.getValue());
                fileWriter.write(bi3.getValue()+"\n");
            }
            fileWriter.close();
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException exc) {
            System.out.println("There was an error during reading: "
                    + exc.getMessage());
        }


    }
}

