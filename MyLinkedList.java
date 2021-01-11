public class MyLinkedList{

 private int size;
 private Node start,end;
 public MyLinkedList(){
    size = 0;

 }

 public int size(){
    return size;

 }

 private Node getVal(int index){
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

    } else {
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

  if (size == 0){
    end = input;
    start = input;
  }else if (index == 0){
    //append to the beginning
    start.setPrev(input);
    input.setNext(start);
    start = input;
  }else if (index == size){
    end.setNext(input);
    input.setPrev(end);
    end = input;

  }else{
  Node prevv = getVal(index-1) ;
  Node nextt = getVal(index) ;
  input.setPrev( prevv );
  input.setNext( nextt );
  prevv.setNext(input);
  nextt.setPrev(input);


  }
  size++;
 }

 public String get(int index){
    if (index >= size || index < 0){
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }
    return getVal(index).getData();
 }

 public String set(int index, String value){
   if (index >= size || index < 0){
     throw new IndexOutOfBoundsException("Index " +index+ " is out of bounds");
   }
   Node prevv = getVal(index-1) ;
   Node nextt = getVal(index+1) ;
   Node current = getVal(index) ;

  String old = current.getData();
  current.setData(value);
  return old;

 }

 public String toString(){
   String result = "";
   if (size==0) return "[]";
   Node curr = start;

   while (curr.getNext() != null){
       result += curr.getData() + ", ";
       curr = curr.getNext();
   }
   return "[" +result+ curr.getData() + "]";
 }

 public String toStringReversed(){
   String result = "";
   if (size==0) return "[]";
   Node curr = end;

   while (curr.getPrev() != null){
      result += curr.getData() + ", ";
      curr = curr.getPrev();

   }

   return "[" +result+ curr.getData() + "]";
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
