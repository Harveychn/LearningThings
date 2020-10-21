package newACK;

import java.util.stream.Stream;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/10/14 19:34
 * [description]:
 */
public class StreamDemo {
    public static void main(String[] args) {
        StreamDemo streamDemo = new StreamDemo();
        streamDemo.mapMethod();
        System.out.println();
        streamDemo.map2IntMethod();
        System.out.println();
        streamDemo.flatmapMethod();
        System.out.println();
        streamDemo.limitMethod();
        System.out.println();
        streamDemo.distinctMethod();
    }

    public void mapMethod() {
        Stream.of("apple", "banana", "orange", "waltermeleon", "grape")
                .map(e -> e.length())
                .forEach(e -> System.out.println(e));
    }

    public void map2IntMethod() {
        Stream.of("apple", "banana", "orange", "waltermeleon", "grape")
                .mapToInt(e -> e.length())
                .forEach(e -> {
                    System.out.println(e);
                });
    }

    public void flatmapMethod() {
        Stream.of("a-b-c-d", "e-f-i-h")
                .flatMap(e -> Stream.of(e.split("-")))
                .forEach(e -> System.out.println(e));
    }

    public void limitMethod() {
        Stream.of("1", "2", "3", "4")
                .limit(3)
                .forEach(e -> System.out.println(e));
    }

    public void distinctMethod() {
        Stream.of(1, 2, 3, 1, 2, 5, 6, 7, 8, 0, 0, 1, 2, 3, 1)
                .distinct() //去重
                .forEach(e -> System.out.println(e));
    }
}
