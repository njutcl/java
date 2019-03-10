package cn.sxt.myCollection;

/*
自定义实现一个ArrayList，体会底层原理
增加泛型
数组扩容
索引越界问题
remove两种实现

 */


public class ltcArrayList<E> {
    private Object[] elementData;
    private int size;
    private static final int default_capacity = 10;

    public ltcArrayList() {
        elementData = new Object[default_capacity];
    }

    public ltcArrayList(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException("容器的容量不能为复数");
        } else if (capacity == 0) {
            elementData = new Object[default_capacity];
        } else {
            elementData = new Object[capacity];
        }
    }
public int size(){
        return size;
}
public boolean isEmpty(){
return size==0?true:false;
    }

    public void add(E obj) {
        //什么时候扩容
        if (size == elementData.length) {
            //扩容操作
            Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }


        elementData[size++] = obj;
    }

    public E get(int index) {
        // 检查合法性
        checkRange(index);

        return (E) elementData[index];
    }

    public void set(E element, int index) {
        checkRange(index);
        elementData[index] = element;
    }

    public void remove(E element) {
        //element,将它和所有元素挨个比较，获得第一个比较为true的，返回
        for (int i = 0; i < size; i++) {
            if (element.equals(get(i))) {//容器中的比较都是equals而不是==
                remove(i);//删除
            }
        }
    }

    public void remove(int index) {
        int numMoved = elementData.length - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size]=null;
    }

    public void checkRange(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("索引不合法：" + index);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i] + ",");
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        ltcArrayList s1 = new ltcArrayList(20);
        s1.add("aa");
        s1.add("bb");

        for (int i = 0; i < 400; i++) {
            s1.add("moal" + i);
        }
        s1.set("messi", 10);
        s1.remove(3);
        System.out.println(s1);
        System.out.println(s1.get(10));
        System.out.println(s1.size);
    System.out.println(s1.isEmpty());
    }

}
