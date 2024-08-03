import java.io.*;

class p1 {
    public static void main(String[] args) throws IOException {
        String file = "input.txt";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        }
        catch (FileNotFoundException e) {
            System.out.println("File '" + file + "' not found");
            return;
        }
        
        int total = 0;
        String line = "";
        line = reader.readLine();
        while(line != null) {
            int lineLength = line.length();
            boolean firstFound = false;
            boolean secondFound = false;
            for(int i = 0; i < lineLength; i++) {

                if (!firstFound) {
                    char firstChar = line.charAt(i);
                    if (firstChar >= '0' && firstChar <= '9') {
                        firstFound = true;
                        total += Character.getNumericValue(firstChar) * 10;
                    }
                }
                
                if (!secondFound) {
                    char secondChar = line.charAt((lineLength - 1) - i);
                    if (secondChar >= '0' && secondChar <= '9') {
                        secondFound = true;
                        total += Character.getNumericValue(secondChar);
                    }
                }
            }
            line = reader.readLine();
        }
        reader.close();
        System.out.println(total);
    }
}
