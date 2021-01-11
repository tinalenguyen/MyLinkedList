public class MyLinkedList{

 private int size;
 private Node start,end;
 public MyLinkedList(){
    size = 0;

 }

 public int size(){
    return size;

 }

 private Node getIndex(int index){
   if (index == 0) return start;
   if (index == size-1) return end;
   int counter = 0 ;
   Node val = start;
   while (counter < index){
     val = val.getNext();
     counter++;
   }
   return val;
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
    size++;
    return true;

 }

 public void add(int index, String value){
   if (index > size || index < 0){
     throw new IndexOutOfBoundsException("Index " +index+" is out of bounds");
   }

   Node input = new Node(value);

  if (size == 0 || index == size){
    add(value);
  }else if (index == 0){
    //append to the beginning
    start.setPrev(input);
    input.setNext(start);
    start = input;
  }else{
  Node prevv = new Node(get(index-1) );
  Node nextt = new Node(get(index) );
  prevv.setNext(input);
  nextt.setPrev(input);
  input.setNext( nextt );
  input.setPrev( prevv );

  }
  size++;
 }

 public String get(int index){
    if (index >= size || index < 0){
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }
    return getIndex(index).getData();
 }

 public String set(int index, String value){
   if (index >= size || index < 0){
     throw new IndexOutOfBoundsException("Index " +index+ " is out of bounds");
   }
   Node prevv = getIndex(index-2) ;
   Node nextt =getIndex(index+2) ;
   Node current = getIndex(index) ;
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

   while (curr != null){
     if (curr !=start || curr != end){
       result += curr.getData() + ", ";
     }
     else {
       result += curr.getData();
     }
     curr = curr.getNext();
   }
   return "[" +result+"]";
 }

 public String toStringReversed(){
   String result = "";

   Node curr = end;

   for (int i = 0; i <size-1;i++){
     result += curr.getData()+", ";
     curr = curr.getPrev();
   }

   result += curr.getData();
   return "[]" +result+ "]";
 }
 //Any helper method that returns a Node object MUST BE PRIVATE!

  public String remove(int index){
    String before = "";

    if (index < 0 || index >= size){
      throw new IndexOutOfBoundsException("Index " +index+ " is out of bounds");
    } else if (size == 1){
      before = start.getData();
      start = null;
      end = null;
    } else if (index == 0){
      before = start.getData();
      Node nextt = start.getNext();
      nextt.setPrev(null);
      start.setNext(null);
      start = nextt;
    } else if (index==size-1){
      before = end.getData();
      end = end.getPrev();
      end.setNext(null);
    } else {
      Node oldie = new Node(get(index));
      before = oldie.getData();
      oldie.getPrev().setNext(oldie.getNext());
      oldie.getNext().setPrev(oldie.getPrev());
      oldie.setNext(null);
      oldie.setPrev(null);

    }

      size--;
      return before;
  }

  public void extend(MyLinkedList other){
      size = size + other.size;
      end.setNext(other.start);
      other.start.setPrev(end);
      other.end = null;
      other.start = null;
      other.size = 0;

  }

}
