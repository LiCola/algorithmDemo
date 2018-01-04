package consumerproducer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by LiCola on 2017/11/20.
 */
public class BlockingQueueModel implements Model {

  //数据核心组件
  private final BlockingQueue<Task> queue;

  //原子id
  private final AtomicInteger increateTaskIds = new AtomicInteger(0);

  public BlockingQueueModel(int cap) {
    this.queue = new LinkedBlockingQueue<>(cap);
  }

  @Override
  public Runnable newRunnableConsumer() {
    return new ConsumerImpl();
  }

  @Override
  public Runnable newRunnableProducer() {
    return new ProducerImpl();
  }

  private class ConsumerImpl extends AbstractConsumer implements Consumer, Runnable {

    @Override
    public void consume() throws InterruptedException {
      Task task = queue.take();
      Thread.sleep(500 + (long) (Math.random() * 500));
      System.out.println("consume:" + task.taskId);
    }
  }

  private class ProducerImpl extends AbsrcactProducer implements Producer, Runnable {

    @Override
    public void produce() throws InterruptedException {
      Thread.sleep((long) (Math.random() * 1000));
      Task task = new Task(increateTaskIds.getAndIncrement());
      queue.put(task);
      System.out.println("produce:" + task.taskId);
    }
  }


}
