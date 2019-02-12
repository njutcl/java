package cn.sxt.myCollection;

//自定义一个链表 增加add方法
//增加get方法
//remove移除节点
//插入节点
//增加泛型/封装


public class ltcLinkedList <E>{
    private Node first;
    private Node last;
    private int size;


    private Node getNode(int index) {
        checkRange(index);
        Node temp = null;
        if (index <= (size >> 1)) {
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = last;
            for (int i = size - 1; i > index; i--) {
                temp = temp.previous;
            }
        }
        return temp;
    }

    public void  add(int index,E element){
        checkRange(index);
        Node newNode =new Node(element);
        Node temp=getNode(index);
        if(temp!=null){
            Node up=temp.previous;

            up.next=newNode;
            newNode.next=temp;
         temp.previous=newNode;

        }
    }

    private void checkRange(int index){
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("索引序列不合法：" + index);
        }
    }

    public E get(int index) {
checkRange(index);
        Node temp = getNode(index);
        return temp != null ? (E)temp.element : null;
    }

    public void remove(int index) {
        checkRange(index);
        Node temp = getNode(index);
        if (temp != null) {

            Node up = temp.previous;
            Node down = temp.next;

            if (up != null) {
                up.next = down;
                if (down != null) {
                    down.previous = up;
                }
                if (index == 0) {
                    first = down;
                }
                if (index == size - 1) {
                    last = down;
                }
                size--;
            }

        }
    }

    //
    public void add(E obj) {

        Node node = new Node(obj);
        if (first == null) {
            first = node;
            last = node;
        } else {
            node.previous = last;
            node.next = null;
            last.next = node;
            last = node;
        }

        size++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = first;
        while (temp != null) {
            sb.append(temp.element + ",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        ltcLinkedList list = new ltcLinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add(3,"abc");
        list.remove(2);
        System.out.println(list);
        System.out.println(list.get(1));

    }

}
