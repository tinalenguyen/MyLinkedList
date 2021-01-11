public class MyLinkedList{

 private int size;
 private Node start,end;
 public MyLinkedList(){
    size = 0;
    start = null;
    end = null;
 }

 public int size(){
    return size;

 }

 public boolean add(String value){
  //appends to the end of the linkedlist
   Node input = new Node(value);
    if (size==0){
      start = input;
      end = input;
      size++;

    } else {
      end = input;
      end.setNext(input);
      input.setPrev(end);
      end = input;

    }

 }
 public void add(int index, String value);

 public String get(int index){
    if (index >= size || index < 0){
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }

    if (index == 0) return start;
    if (index == size-1) return end;

    Node val = start;
    for (int i = 0; i < index; i++){
      val = val.getNext();
      i++;
    }
    return val;
 }
 public String set(int index, String value);
 public String toString();
 //Any helper method that returns a Node object MUST BE PRIVATE!





}
