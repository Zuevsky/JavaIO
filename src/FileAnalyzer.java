import java.io.*;
import java.util.*;

public class FileAnalyzer {
    public static void main(String[] args) throws IOException {
        FileAnalyzeUtil file = new FileAnalyzeUtil();
        String fileHello = "resources/hello.txt";
        String fileNumbers = "resources/numbers.txt";
        String fileNewNumbers = "resources/newNumbers.txt";
        System.out.println("Список строк в файле: \n" + file.getArrayOfStrings(fileHello));
        System.out.println();
        System.out.println("Список слов, которые начинаются на гласную в файле: \n" + file.getArrayOfWordsStartingWithVowel(fileHello));
        System.out.println();
        System.out.println("Список слов, последняя буква которых совпадает с первой буквой следующего за ними слова: \n" + file.getArrayOfSpecificWords(fileHello));
        System.out.println();
        System.out.println("Списки из трех максимальных цифр каждой строки в порядке убывания, взятых из файла:");
        for(String lineOfNumbers : file.getArrayOfMaxNumbersInEachLine(fileNumbers)) {
            System.out.println(lineOfNumbers);
        }
        System.out.println();
        System.out.println("Количество каждой из использованных букв в тексте (без учета регистра):");
        for(String counterOfChar : file.getAmountOfEachCharInText(fileHello)) {
            System.out.println(counterOfChar);
        }
        System.out.println();
        System.out.println("Как часто встречается каждое слово в тексте:");
        for(String counterOfWord : file.getAmountOfEachWordInText(fileHello)) {
            System.out.println(counterOfWord);
        }
        file.sortAndSaveDataInNewFile(fileNumbers, fileNewNumbers);
    }

    static class FileAnalyzeUtil {

        // Метод, который принимает путь к файлу и возвращает список строк этого файла.
        public ArrayList<String> getArrayOfStrings(String path) throws IOException {
            BufferedReader buffer = new BufferedReader(new FileReader(path));
            ArrayList<String> linesOfFile = new ArrayList<>();
            String line;
            while ((line = buffer.readLine()) != null) {
                linesOfFile.add(line);
            }
            buffer.close();
            return linesOfFile;
        }

        // Метод, который принимает путь к файлу и возвращает список слов начинающихся с гласной буквы.
        public ArrayList<String> getArrayOfWordsStartingWithVowel(String path) throws IOException {
            BufferedReader buffer = new BufferedReader(new FileReader(path));
            ArrayList<String> allWordsInFile = new ArrayList<>();
            ArrayList<String> wordsStartingWithVowel = new ArrayList<>();
            String line;
            char[] vowels = {'а', 'у', 'о', 'ы', 'и', 'э', 'я', 'ю', 'ё', 'е', 'А', 'У', 'О', 'Ы', 'И', 'Э', 'Я', 'Ю', 'Ё', 'Е'};
            String vowelsInString = new String(vowels);
            while ((line = buffer.readLine()) != null) {
                line.trim();
                String[] wordsInLine = line.split(" ");
                allWordsInFile.addAll(Arrays.asList(wordsInLine));
            }
            for(String word : allWordsInFile) {
                int indexOfElem = vowelsInString.indexOf(word.charAt(0));
                if(indexOfElem > -1) {
                    wordsStartingWithVowel.add(word);
                }
            }
            buffer.close();
            return wordsStartingWithVowel;
        }

        // Метод, который принимает путь к файлу и возвращает список слов, для которых последняя буква совпадает с первой буквой следующего за ним слова
        public ArrayList<String> getArrayOfSpecificWords(String path) throws IOException {
            BufferedReader buffer = new BufferedReader(new FileReader(path));
            ArrayList<String> allWordsInFile = new ArrayList<>();
            ArrayList<String> specificWords = new ArrayList<>();
            String line;
            ArrayList<String[]> lines = new ArrayList<>();
            while ((line = buffer.readLine()) != null) {
                line.trim();
                String[] wordsInLine = line.split(" ");
                allWordsInFile.addAll(Arrays.asList(wordsInLine));
            }
            for(int i = 0; i+1 < allWordsInFile.size(); i++) {
                String actualWord = allWordsInFile.get(i);
                String nextWord = allWordsInFile.get(i+1);
                if(actualWord.charAt(actualWord.length()-1) == nextWord.charAt(0)) {
                    specificWords.add(actualWord);
                }
            }
            buffer.close();
            return specificWords;
        }

        // Метод, который принимает путь к файлу и возвращает список наибольшей комбинации цифр для каждой строки, которые идут в порядке возрастания.
        public ArrayList<String> getArrayOfMaxNumbersInEachLine(String path) throws IOException {
            BufferedReader buffer = new BufferedReader(new FileReader(path));
            ArrayList<String> arrayOfMaxNumbersInEachLine = new ArrayList<>();
            String line;
            while ((line = buffer.readLine()) != null) {
                line.trim();
                String[] numbers = line.split(" ");
                String bubble;
                boolean isBubbled;
                do {
                    isBubbled = false;
                    for (int i = 0; i < numbers.length; i++) {
                        if (i + 1 < numbers.length) {
                            if (Integer.parseInt(numbers[i]) < Integer.parseInt(numbers[i + 1])) {
                                bubble = numbers[i];
                                numbers[i] = numbers[i + 1];
                                numbers[i + 1] = bubble;
                                isBubbled = true;
                            }
                        }
                    }
                } while (isBubbled);
                String finalNumbers = "";
                if (numbers.length >= 3) {
                    for (int j = 0; j < 3; j++) {
                        if (j == 2) {
                            finalNumbers += numbers[j];
                        } else {
                            finalNumbers += numbers[j] + ", ";
                        }
                    }
                } else {
                    for (int j = 0; j < numbers.length; j++) {
                        if (j + 1 == numbers.length) {
                            finalNumbers += numbers[j];
                        } else {
                            finalNumbers += numbers[j] + ", ";
                        }
                    }
                }
                arrayOfMaxNumbersInEachLine.add(finalNumbers);
            }
            buffer.close();
            return arrayOfMaxNumbersInEachLine;
        }

        // Метод, который принимает путь к файлу и возвращает частоту повторяемости всех букв в тексте, игнорируя регистр.
        public ArrayList<String> getAmountOfEachCharInText(String path) throws IOException {
            BufferedReader buffer = new BufferedReader(new FileReader(path));
            ArrayList<String> amountOfEachCharInText = new ArrayList<>();
            String line;
            char[] alphabet = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р',
                    'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
            StringBuilder allText = new StringBuilder();
            while ((line = buffer.readLine()) != null) {
                String newLine = line.trim().toLowerCase();
                String[] words = newLine.split(" ");
                for(String word : words) {
                    allText.append(word);
                }
            }
            for(char charInAlphabet : alphabet) {
                int counter = 0;
                for(char charInText : allText.toString().toCharArray()) {
                    if(charInAlphabet == charInText) {
                        counter++;
                    }
                }
                if(counter > 0) {
                    amountOfEachCharInText.add("Буква " + charInAlphabet + " встречается в тексте " + counter + " раз.");
                }
            }
            buffer.close();
            return amountOfEachCharInText;
        }

        // Метод, который принимает путь к файлу и возвращает частоту повторяемости всех слов в тексте в порядке возрастания частоты повторяемости.
        public ArrayList<String> getAmountOfEachWordInText(String path) throws IOException {
            BufferedReader buffer = new BufferedReader(new FileReader(path));
            ArrayList<String> amountOfEachWordInText = new ArrayList<>();
            ArrayList<String> allWordsInText = new ArrayList<>();
            ArrayList<String> iterations = new ArrayList<>();
            String line;
            while ((line = buffer.readLine()) != null) {
                String newLine = line.trim().toLowerCase();
                String[] words = newLine.split(" ");
                allWordsInText.addAll(Arrays.asList(words));
            }
            for(String word : allWordsInText) {
                if(!iterations.contains(word)) {
                    int counter = 0;
                    for(String eachWord : allWordsInText) {
                        if(word.equals(eachWord)) {
                            counter++;
                        }
                    }
                    amountOfEachWordInText.add("Слово " + word + " повторяется в тексте " + counter + " раз.");
                    iterations.add(word);
                }
            }
            buffer.close();
            return amountOfEachWordInText;
        }

        // метод, который принимает путь к файлу с целыми числами и сортирующий содержимое файла по возрастанию и сохраняющий результат в новый файл.
        public void sortAndSaveDataInNewFile(String pathRead, String pathWrite) throws IOException {
            BufferedReader bufferReader = new BufferedReader(new FileReader(pathRead));
            ArrayList<Integer> allIntegersInFile = new ArrayList<>();
            String line;
            while ((line = bufferReader.readLine()) != null) {
                String newLine = line.trim();
                String[] numbers = newLine.split(" ");
                for(String number : numbers) {
                    allIntegersInFile.add(Integer.parseInt(number));
                }
            }
            Collections.sort(allIntegersInFile);
            bufferReader.close();
            BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(pathWrite));
            for(int number : allIntegersInFile) {
                bufferWriter.write(number + " ");
            }
            bufferWriter.close();
        }
    }
}