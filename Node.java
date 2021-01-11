public class Node {
  private Node next, prev;
  private String data;

//constructor
 public Node(String value){
   data = value;
 }

 //data methods
 public String getData(){
   return data;
 }

 public void setData(String value){
   data = value;
 }

//next methods

  public Node getNext(){
    return next;
  }

  public void setNext(Node value){
    next = value;
  }

  //prev methods

  public Node getPrev(){
    return prev;
  }

  public void setPrev(Node value){
    prev = value;
  }

}
