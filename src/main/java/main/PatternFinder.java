package main;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 Осуществляет поиск строк по шаблону и записывает найденные строки в новый файл
 Принимает в качестве аргументов шаблон поиска, путь к основному файлу и имя нового файла
 */
public class PatternFinder{
    String pattern;
    String pathToFile;
    String nameResultFile;
    String replaceFor = null;

    public PatternFinder(String pattern, String pathToFile, String nameResultFile) throws FileNotFoundException, IOException {
        this.pattern = pattern;
        this.pathToFile = pathToFile;
        this.nameResultFile = nameResultFile;
    }

    public PatternFinder(String pattern, String pathToFile, String nameResultFile, String replaceFor) throws FileNotFoundException, IOException {
        this.pattern = pattern;
        this.pathToFile = pathToFile;
        this.nameResultFile = nameResultFile;
        this.replaceFor = replaceFor;
    }

    public void findStringByPattern() {

        try{
            File file = new File(pathToFile);
            String pathForNewFile = file.getParent() + "/" + nameResultFile;

            File fileOutput = new File(pathForNewFile);
            FileWriter writer = new FileWriter(fileOutput, true);

            Pattern pattern = Pattern.compile(this.pattern);

            FileInputStream finput = new FileInputStream(pathToFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(finput));

            String strLine;
            System.out.println("Started write select to new file.");
            while ((strLine = br.readLine()) != null)   {
                Matcher matcher = pattern.matcher(strLine);
                if (matcher.matches()){
                    writer.write(strLine + "\n");
                }
            }
            System.out.println("New file have written and by path " + pathForNewFile);
            finput.close();
            writer.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void replace() {

        try{

            File file = new File(pathToFile);
            String pathForNewFile = file.getParent() + "/" + nameResultFile;
            FileWriter writer = new FileWriter(new File(pathForNewFile), true);

            FileInputStream finput = new FileInputStream(pathToFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(finput));

            String strLine;
            System.out.println("Started replace and write to new file.");
            while ((strLine = br.readLine()) != null)   {
                writer.write(strLine.replace(" ", replaceFor) + "\n");
            }
            System.out.println("New file have written and by path " + pathForNewFile);
            finput.close();
            writer.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }



}
