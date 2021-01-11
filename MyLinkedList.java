public class MyLinkedList{

 private int size;
 private Node start,end;
 public MyLinkedList(){
    size = 0;

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
    return true;
 }

 public void add(int index, String value){
   if (index >size || index < 0){
     throw new IndexOutOfBoundsException("Index " +index+" is out of bounds");
   }

   Node input = new Node(value);

  if (size == 0 || index == size) add(value);
  if (index == 0){
    //append to the beginning
    start.setPrev(input);
    input.setNext(start);
    start = input;
  }else{
  Node prevv = new Node(get(index-1) );
  Node nextt = new Node(get(index+1) );
  prevv.setNext(input);
  nextt.setPrev(input);
  input.setNext( nextt );
  input.setPrev( prevv );

  }


 }

 public String get(int index){
    if (index >= size || index < 0){
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }

    if (index == 0) return start.getData();
    if (index == size-1) return end.getData();

    Node val = start;
    for (int i = 0; i < index; i++){
      val = val.getNext();
      i++;
    }
    return val.getData();
 }

 public String set(int index, String value){
   if (index >= size || index < 0){
     throw new IndexOutOfBoundsException("Index " +index+ " is out of bounds");
   }
   Node prevv = new Node(get(index-2) );
   Node nextt = new Node(get(index+2) );
   Node current = new Node(get(index) );
   Node val = new Node(value);

   if (index == 0) start.setPrev(val);
   if (index == size-1) end.setNext(val);
   else {
     prevv.setNext(val);
     nextt.setPrev(val);

   }
  String old = current.getData();
  current.setData(value);
  return old;

 }

 public String toString(){
   String result = "";

   Node curr = start;
   for (int i = 0 ; i < size-1;i++){
     result += curr.getData() + ", ";
     curr = curr.getNext();
   }
   result += curr.getData();
   return "[" +result+"]";
 }

 public String toStringReversed(){
   return "";

 }
 //Any helper method that returns a Node object MUST BE PRIVATE!





}
