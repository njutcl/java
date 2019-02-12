package cn.sxt.myCollection;

public class Node {
Node previous;//前驱
Node next;//后继
Object element;//元素数据

    public Node(Node previous, Node next, Object element) {
        this.previous = previous;
        this.next = next;
        this.element = element;
    }

    public Node(Object element) {
        this.element = element;
    }
}
