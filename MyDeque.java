public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 0;
    start = 0;
    end = 9;
  }

  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
    start = 0;
    end = initialCapacity - 1;
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
      System.out.println("a");
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
      System.out.println("b");
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
    if(start == 0){
      data[data.length - 1] = element;
      start = data.length - 1;
    }
    else{
      data[start - 1] = element;
      start--;
    }
    size+= 1;
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
      E[] d = (E[])new Object[size*2];
      for (int i = 0; i < data.length; i++){
        if (start <= end){
          for (int x = start; x <= end; x++){
            d[i] = data[x];
          }
        }
        else{
          for (int x = start; x < data.length; x++){
            d[i] = data[x];
          }
          for (int x = 0; x <= end; x++){
            d[i] = data[x];
          }
        }
      }
      data = d;
    }
  }


  public void addLast(E element){
    resize();
    data[size] = element;
    end = size;
    size++;
  }


  /*  public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){ }
  public E getLast(){ }
  */

  public static void main (String[] args){
    MyDeque test = new MyDeque(4);
    test.addFirst(1);
    System.out.println(test.toString());
    test.addFirst(2);
    System.out.println(test.toString());
    test.addFirst(3);
    System.out.println(test.toString());
    test.addFirst(4);
    System.out.println(test.toString());
    test.addFirst(5);
    System.out.println(test.toString());

  }


}
