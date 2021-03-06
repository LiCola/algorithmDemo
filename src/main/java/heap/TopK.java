package heap;

import java.util.Collection;
import java.util.PriorityQueue;

/**
 * Created by LiCola on 2017/9/5.
 * 求前K个最大元素，数据来源不固定且不停的加入新元素
 * 思路：末尾淘汰，永远保留当前数据源的前K个元素。只在固定K长度队列上的末尾比较能否替代
 * 代码实现：优先队列默认是最小堆，根元素永远是当前最小元素，
 * 新元素只需要和根比较，当大于根元素时加入队列，
 * 优先队列会自动调整堆，让最小元素为根。否则不变。
 */
public class TopK<E extends Comparable<E>> {

  private PriorityQueue<E> priorityQueue;

  private int k;

  public TopK(int k) {
    this.k = k;
    priorityQueue = new PriorityQueue<>(k);//优先队列 默认就是最小堆 每个节点都小于其子节点 根就是最小值
  }

  public void addAll(Collection<? extends E> collections) {
    for (E e : collections) {
      add(e);
    }
  }

  public void add(E e) {
    if (priorityQueue.size() < k) {
      priorityQueue.add(e);//还有空间 直接插入
    } else {
      Comparable<E> head = priorityQueue.peek();//访问 堆的头部元素 即最小值
      if (head.compareTo(e) < 0) {
        //堆中的最小值 小于插入值 需要末位淘汰（概念上的末位）
        //关于末位淘汰 就是为了保持堆上永远是前K个值
        priorityQueue.poll();//弹出最小值
        priorityQueue.add(e);//插入元素 即替换堆的最小值
      }
    }
  }

  public <T> T[] toArray(T[] a) {
    return priorityQueue.toArray(a);
  }

  public E getKth() {
    return priorityQueue.peek();
  }
}
