import component.ExtendedList;

public class Main {

    public static void main(String[] args) {

        ExtendedList<Integer> extendedList = new ExtendedList<>();
        extendedList.add(2);
        extendedList.add(4);

        ExtendedList<Integer> map = extendedList.map(e -> e * e);
        for (Integer integer : map) {
            System.out.println(integer);
        }

        ExtendedList<Integer> fill = extendedList.fill(10, () -> (int) (Math.random() * 101D));

        if (!fill.isEmpty()) {
            for (Integer integer : fill) {
                System.out.println(integer);
            }
        }

        ExtendedList<Integer> integers = new ExtendedList<>();
        integers.add(1);
        integers.add(4);
        integers.add(8);
        integers.add(5);

        boolean b = integers.forAll((i) -> i % 2 == 0);
        System.out.println(b);

        ExtendedList<ExtendedList<Integer>> partition = integers.partition((i) -> i % 2 == 0);

        for (ExtendedList<Integer> list : partition) {
            System.out.println(list);
        }

        Integer reduce = integers.reduce(1, Integer::sum);
        System.out.println(reduce);
    }

}
