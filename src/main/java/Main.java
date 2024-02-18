import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        check1();
        System.out.println();
        check2();
        System.out.println();
        check3();
        System.out.println();
        check4();
    }

    public static void check1() {
        System.out.println("check1");
        List nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        List<Integer> integers = new ArrayList<>(nums);
        integers.stream()
                .filter(s -> s % 2 != 0)
                .forEach(System.out::println);
    }

    public static void check2() {
        System.out.println("check2");
        List nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        Set<Integer> set = new TreeSet<>(nums);
        set.stream()
                .filter(s -> s % 2 == 0)
                .forEach(System.out::println);
    }

    public static void check3() {
        System.out.println("check3");
        List strings = new ArrayList<>(List.of("один", "два", "два", "три", "три", "три"));
        Set<String> set = new HashSet<>(strings);
        set.forEach(System.out::println);
    }

    public static void check4() {
        System.out.println("check4");
        List strings = new ArrayList<>(List.of("один", "два", "два", "три", "три", "три"));
        List<String> list = new ArrayList<>(strings);
        System.out.println("Вариант как в образце дз:");
        list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("Вариант мой:");
        list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
    }
}