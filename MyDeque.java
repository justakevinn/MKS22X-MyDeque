import java.util.*;
import java.io.*;



public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 0;
    start = 0;
    end = 0;
  }

  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
    start = 0;
    end = 0;
  }


  public int size(){
    return size;
  }

  public String toString(){
    String s = "{";
    if (start <= end){
      for (int x = start; x <= end; x++){
        if( data[x]!= null ){
          s += data[x] + " ";
        }
      }
      //  System.out.println("a");
    }
    else{
      for (int x = start; x < data.length; x++){
        if( data[x]!= null ){
          s += data[x] + " ";
        }
      }
      for (int x = 0; x <= end; x++){
        if( data[x]!= null ){
          s += data[x] + " ";
        }
      }
      //    System.out.println("b");
    }
    s += "}";
    return s;
  }

  public void addFirst(E element){
    if(element == null){
      throw new NullPointerException();
    }
    resize();
    //There are two cases for adding first:
    if (size == 0){
      data[start] = element;
    }
    else if(start == 0){
      data[data.length - 1] = element;
      start = data.length - 1;
    }
    else{
      data[start - 1] = element;
      start--;
    }
    size++;
    //System.out.println(size);
    //System.out.println(data.length);
  }


  public void addLast(E element){
    if(element == null){
      throw new NullPointerException();
    }
    resize();
    if(size == 0){
      data[end] = element;
    }
    else if(end == data.length - 1){
      data[0] = element;
      end = 0;
    }
    else{
      data[end + 1] = element;
      end++;
    }
    size+= 1;
  }


  private void resize(){
    if (size == data.length){
      E[] temp = (E[]) new Object[2 * data.length];
      int oldIndex = start;
      int newIndex = 0;
      while(oldIndex != end){
        temp[newIndex] = data[oldIndex];
        oldIndex = (oldIndex + 1) % data.length; //Makes it so the oldIndex just loops over
        newIndex++;
      }
      temp[newIndex] = data[end];
      data = temp;
      start = 0;
      end = newIndex;
    }
  }



  public E getFirst(){
    if(size == 0){
      throw new NoSuchElementException();
    }
    return data[start];
  }

  public E getLast(){
    if(size == 0){
      throw new NoSuchElementException();
    }
    return data[end];
  }

  public E removeFirst(){
    if(size == 0){
      throw new NoSuchElementException();
    }
    E answer = data[start];
    data[start] = null;
    if(start == data.length - 1){
      start = 0;
    }
    else{
      start++;
    }
    size--;
    return answer;

  }


  public E removeLast(){
    if(size == 0){
      throw new NoSuchElementException();
    }
    E answer = data[end];
    data[end] = null;
    if(end == 0){
      end = data.length - 1;
    }
    else{
      end--;
    }
    size--;
    return answer;
  }

  public String array(){
    return Arrays.toString(data);
  }

  public static void main (String[] args){
    MyDeque test = new MyDeque(4);
  /*  test.addFirst(1);
    System.out.println(test.array());
    System.out.println(test.toString());

    test.addFirst(2);
    System.out.println(test.array());
    System.out.println(test.toString());

    test.addFirst(3);
    System.out.println(test.array());
    System.out.println(test.toString());

    test.addFirst(4);
    System.out.println(test.array());
    System.out.println(test.toString());

    test.addFirst(5);
    System.out.println(test.array());
    System.out.println(test.toString());

    test.addFirst(6);
    System.out.println(test.array());
    System.out.println(test.toString());

    test.addFirst(7);
    System.out.println(test.array());
    System.out.println(test.toString());

    test.addFirst(8);
    System.out.println(test.array());
    System.out.println(test.toString());*/

    test.addLast(1);
    System.out.println(test.array());
    System.out.println(test.toString());

    test.addLast(2);
    System.out.println(test.array());
    System.out.println(test.toString());

    test.addLast(3);
    System.out.println(test.array());
    System.out.println(test.toString());

    test.addLast(4);
    System.out.println(test.array());
    System.out.println(test.toString());

    test.addLast(5);
    System.out.println(test.array());
    System.out.println(test.toString());

    test.addLast(6);
    System.out.println(test.array());
    System.out.println(test.toString());

    test.addLast(7);
    System.out.println(test.array());
    System.out.println(test.toString());

    test.addLast(8);
    System.out.println(test.array());
    System.out.println(test.toString());

    test.addFirst(0);
    System.out.println(test.array());
    System.out.println(test.toString());

    test.addLast(9);
    System.out.println(test.array());
    System.out.println(test.toString());

    test.removeFirst();
    System.out.println(test.array());
    System.out.println(test.toString());

    test.removeFirst();
    System.out.println(test.array());
    System.out.println(test.toString());

    test.addFirst(1);
    System.out.println(test.array());
    System.out.println(test.toString());

    test.removeLast();
    System.out.println(test.array());
    System.out.println(test.toString());

    test.removeLast();
    System.out.println(test.array());
    System.out.println(test.toString());
  }


}
