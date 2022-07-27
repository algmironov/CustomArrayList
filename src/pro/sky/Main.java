package pro.sky;
import pro.sky.stringList.CustomArrayList;
import pro.sky.stringList.StringList;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        StringList customArrayList = new CustomArrayList();

        customArrayList.add("test1");
        customArrayList.add("test2");
        customArrayList.add("test3");
        customArrayList.add("test4");

        System.out.println(customArrayList.size());

        customArrayList.add(4, "test5");

        customArrayList.printAll();

        System.out.println(customArrayList.size());

        customArrayList.set(2, "test3_1");

        customArrayList.printAll();

        System.out.println(customArrayList.size());

        customArrayList.remove(2);

        System.out.println(customArrayList.size());

        customArrayList.printAll();

        System.out.println(customArrayList.get(1).equals("test2"));

        System.out.println("customArrayList.remove(\"test5\") = " + customArrayList.remove("test5"));

        customArrayList.printAll();

        System.out.println(customArrayList.contains("test1"));

        System.out.println("customArrayList.size() = " + customArrayList.size());

        System.out.println("customArrayList.indexOf(\"test1\") = " + customArrayList.indexOf("test1"));
        System.out.println("customArrayList.lastIndexOf(\"test1\") = " + customArrayList.lastIndexOf("test1"));

        String[] otherList = new String[10];
        otherList[0] = "test1";
        otherList[1] = "test2";
        otherList[2] = "test4";
        customArrayList.printAll();

        System.out.println(otherList.length);


        System.out.println("customArrayList.equals(otherList) = " + Arrays.equals(customArrayList.getArray(), otherList));

        System.out.println("customArrayList.toArray() = " + customArrayList.toArray());



    }
}
