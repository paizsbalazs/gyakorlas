package zarovizsga1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class People {

    int getNumberOfMales(String path) {
        Path ph = Path.of("C:/gyakorlas/" + path);

        try (BufferedReader br = Files.newBufferedReader(ph)) {
            return processFile(br);
        } catch (IOException ioe) {
                throw new IllegalStateException("Can't find file.", ioe);
        }
    }

    private int processFile (BufferedReader br){

            int result = 0;

            try {
                String line = br.readLine();
                while ((line = br.readLine()) != null) {
                    if (readFromLineisMale(line)) {
                        result +=1;
                    }
                }
            } catch (IOException e) {
                throw new IllegalArgumentException("File read error");
            }
            return result;
    }

        private boolean readFromLineisMale (String line){
            String field[] = line.split(",");
            if (field[4].equals("Male")) {
                return true;
            }
            return false;
        }
}
