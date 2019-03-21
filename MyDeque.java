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
    for (int x = start; x < size; x++){
      s += data[x] + " ";
    }
    for (int x = 0; x < end; x++){
      s+= data[x] + " ";
    }
    s += "}";
    return s;
  }*/

  public void addFirst(E element){
    resize();
    data[size] = element;
    start = size;
    size ++;
  }

  private void resize(){
    if (size == data.length){
      E[] d = (E[])new Object[size*2];
      for (int x = 0; x < data.length; x++){
        d[x] = data[x];
      }
      data = d;
    }
  }


  public void addLast(E element){
    resize();
    data[size] = element;
    last = size;
    size++;
  }


  /*  public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){ }
  public E getLast(){ }*/
}
