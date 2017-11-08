public interface Queue
{
  public void enqueue(Object x);
  public Object dequeue();
  public Object getFront();
  public int size();
  public void makeEmpty();
  public boolean isFull();
  public boolean isEmpty();
}