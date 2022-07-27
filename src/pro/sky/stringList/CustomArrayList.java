package pro.sky.stringList;

import pro.sky.exceptions.IncorrectIndexException;
import pro.sky.exceptions.ItemCannotBeNullException;
import pro.sky.exceptions.ItemIsntInArrayException;
import java.util.Arrays;

public class CustomArrayList implements StringList {

    private final int STARTER_VOLUME = 10;
    private String[] customArray ;
    private int size;

    public CustomArrayList() {
        this.customArray  = new String[STARTER_VOLUME];
    }

    private void checkIfNull(String item) {
        if (item == null) {
            throw new ItemCannotBeNullException("Item cannot be null!");
        }
    }

    private void increaseCapacity() {
        int newValue = customArray.length * 2;
        customArray = Arrays.copyOf(customArray, newValue);
    }

    private void containsItem(String item) {
        if (indexOf(item) == - 1) {
            throw new ItemIsntInArrayException("There is no item in array!");
        }
    }

    public void indexIsInArray(int index) {
        if (index < 0 || index > customArray.length - 1) {
            throw new IncorrectIndexException("Index cannot be outside of array!");
        }
    }

    @Override
    public String add(String item) {
        checkIfNull(item);
        if (size == customArray.length - 1) {
            increaseCapacity();
        }
        if (size == 0) {
            customArray[0] = item;
        } else {
            customArray[size] = item;
        }
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        checkIfNull(item);
        indexIsInArray(index);
        if (size == customArray.length) {
            increaseCapacity();
        }
        System.arraycopy(customArray, index, customArray, index + 1, size - index);

        customArray[index] = item;
        size++;

        return item;
    }

    @Override
    public String set(int index, String item) {
        checkIfNull(item);
        indexIsInArray(index);
        customArray[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        checkIfNull(item);
        containsItem(item);
        int targetIndex = indexOf(item);

        System.arraycopy(customArray, targetIndex + 1, customArray, targetIndex, size - targetIndex);
        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        indexIsInArray(index);
        String removedItem = customArray[index];
        System.arraycopy(customArray, index + 1, customArray, index, size - index);
        size--;
        return removedItem;
    }

    @Override
    public boolean contains(String item) {
        boolean contains = true;
        checkIfNull(item);
        for (int i = 0; i < size - 1; i++) {
            if (get(i).equals(item)) {
                return contains;
            } else{
                contains = false;
            }
        }
        return contains;
    }



    @Override
    public int indexOf(String item) {
        int indexOf;
        for (int i = 0; i < customArray.length -1; i++) {
            if (customArray[i].equals(item)) {
                indexOf = i;
                return indexOf;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        int lastIndex = 0;
        if (contains(item)) {
            int regularIndex = indexOf(item);
            return -(size - regularIndex);
        }
        return -1;
    }

    @Override
    public String get(int index) {
        indexIsInArray(index);
        return customArray[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null || otherList.size() != size) {
            return false;
        }
        for (int i = size - 1; i >= 0; i--) {
            if (!get(i).equals(otherList.get(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        customArray = new String[STARTER_VOLUME];
        size = 0;

    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(customArray, size);
    }

    @Override
    public void printAll(){
    for (int i = 0; i < size(); i++) {
        System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    @Override
    public String[] getArray() {
        return customArray;
    }
}
