package pro.sky;

import java.util.Arrays;

public class CustomArrayList implements StringList {

    private String[] customArray;
    private int size;
    private final int STARTER_VOLUME = 10;

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
        if (!Arrays.stream(customArray).equals(item)) {
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
        if (size == 0) {
            customArray[0] = item;
            size++;
        }
        if (size == customArray.length - 1) {
            increaseCapacity();
        }
        customArray[size] = item;
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
        System.arraycopy(customArray, index, customArray, index + 1, (size - 1) - index);

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
        int targetIndex = 0;
        for (int i = 0; i < customArray.length - 1; i++) {
            if (customArray[i].equals(item)) {
                targetIndex = i;
            }
        }
        System.arraycopy(customArray, targetIndex + 1, customArray, targetIndex, (size - 1) - targetIndex);

        return item;
    }

    @Override
    public String remove(int index) {
        indexIsInArray(index);
        if (index == size - 1) {
            customArray[index] = null;
        } else {
            System.arraycopy(customArray, index + 1, customArray, index, (size - 1) - index);
        }
        return null;
    }

    @Override
    public boolean contains(String item) {
        checkIfNull(item);
        return Arrays.stream(customArray).equals(item);
    }



    @Override
    public int indexOf(String item) {
        int indexOf = 0;
        containsItem(item);
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
        String targetItem = null;
        for (int i = 0; i < customArray.length - 1; i++) {
            if (i == index) {
                targetItem = customArray[i];
            }
        }
        return targetItem;
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null || otherList.size() != size) {
            return false;
        }
        for (int i = 0; i <= size; i++) {
            if (!customArray[i].equals(otherList.get(i))) {
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

    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(customArray, size);
    }
}
