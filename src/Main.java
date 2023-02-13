import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String sortType = args[0];
        String arrayType = args[1];
        String outputFileName = args[2];
        ArrayList<String> rawData = new ArrayList<>();

        for (int i = 3; i < args.length; i++) {
            try (BufferedReader reader = new BufferedReader(new FileReader(args[i]))) {
                while (reader.ready())
                    rawData.add(reader.readLine());
            } catch (FileNotFoundException e) {
                System.out.println("Входной файл с заданным именем не найден.");
                System.exit(1);
            } catch (IOException e) {
                System.out.println("Ошибка чтения входных данных.");
                System.exit(1);
            }
        }

        int[] intArr;
        boolean isAscending = checkSortType(sortType);
        String[] data = new String[rawData.size()];
        rawData.toArray(data);
        arrayType = checkArrayType(data, arrayType);

        try (FileWriter writer = new FileWriter(outputFileName)) {
            if (arrayType.equals("-i")) {
                intArr = Arrays.stream(data).mapToInt(Integer::parseInt).toArray();
                MergeSort.sortInt(intArr, isAscending);
                for (int j : intArr) writer.write(j + "\n");
            } else {
                MergeSort.sortString(data, isAscending);
                for (String word : data) writer.write(word + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи выходных данных.");
        }
    }

    public static String checkArrayType(String[] arr, String expectedType) {
        if (expectedType.equals("-i")) {
            try {
                int[] intArr = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
            } catch (NumberFormatException e) {
                System.out.println("Вы пытаетесь отсортировать массив, содержащий строки, как массив целых чисел. Тип сортируемых данных будет изменён.");
                return "-s";
            }
        } else if (expectedType.equals("-s")) {
            try {
                int[] intArr = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
                System.out.println("Вы пытаетесь отсортировать массив целых чисел как массив строк. Тип сортируемых данных будет изменён.");
                return "-i";
            } catch (NumberFormatException e) {
                return expectedType;
            }
        } else {
            System.out.println("Вы указали неверный тип входных данных. Проверьте правильность вводимых аргументов.");
            System.exit(1);
        }
        return expectedType;
    }

    public static boolean checkSortType(String sortType) {
        if (sortType.equals("-a"))
            return true;
        else if (sortType.equals("-d"))
            return false;
        System.out.println("Вы неверно указали тип сортировки. Проверьте правильность вводимых аргументов.");
        System.exit(1);
        return true;
    }
}