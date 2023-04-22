// declare variables
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;
import javax.swing.JFileChooser;
public class test
{
    public static void main(String[] args)
    {
        // declare variables 
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec;

        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();

                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                int line = 0;
                int words = 0;
                int characters = 0;
                while (reader.ready())
                {
                    // read and count the characters, words, and lines
                    rec = reader.readLine();
                    line++;
                    String[] myWords = rec.replaceAll("\\s+", " ").split(" ");
                    for (String s : myWords) {
                        characters += s.length();
                    }
                    words += myWords.length;

                    System.out.println(rec);
                }
                reader.close();
                // print characters lines and words
                System.out.println("There are " + line + " lines.");
                System.out.println("There are " + words + " words.");
                System.out.println("There are " + characters + " characters.");
            }

        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
