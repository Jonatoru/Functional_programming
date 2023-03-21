import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Первая часть
        System.out.println("Введите слова через пробел: ");
        String words = scanner.nextLine();
        int count = 0;

        if (words.length() != 0) {
            count++;
            for (int i = 0; i < words.length(); i++) {
                if (words.charAt(i) == ' ') {
                    count++;
                }
            }
        }
        System.out.println("Всего слов: " + count);
        //Вторая часть
        List<String> words1 = new ArrayList<>();
        for (String s : words.split(" ")) {
            words1.add(s.replaceAll("[^a-zA-Zа-яёА-ЯЁ]", "").toLowerCase());
        }
        Map<String, Long> wordCount = countDuplicates(words1);
        System.out.println("Список слов от большего к меньшему (слово=количество): ");
        wordCount.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).forEach(System.out::println);
    }
    public static Map<String, Long> countDuplicates(List<String> inputList) {
        return inputList.stream().collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
    }
}