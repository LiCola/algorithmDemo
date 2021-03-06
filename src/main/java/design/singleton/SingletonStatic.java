package design.singleton;

import com.licola.llogger.LLogger;

/**
 * Created by LiCola on 2018/3/14.
 * 饿汉模式的 单例
 * 最简单的线程安全的单例模式，由JVM虚拟机保证线程安全（类加载的线程安全）。
 * 缺点：如果代码结构比较复杂，就不能达到延迟加载的效果，当访问非final的静态字段，虚拟机会加载该类，
 * 静态的单例变量也就初始化。典型如EventBus中的单例(有其他代码结构)，就不能使用该方式实现单例。
 * 反射的影响：使用Class.forName反射也会导致加载类，单例延迟加载失效
 */
public class SingletonStatic {

  public static String Invalidate_Var = "当外部访问先访问该字段";
  public static final String Validate_delivery_var = "被编译器优化的传播字段";

  private static SingletonStatic INSTANCE = new SingletonStatic();

  public static SingletonStatic getInstance() {
    return INSTANCE;
  }

  private SingletonStatic() {
    LLogger.d("单例被实例化");
  }

  static {
    LLogger.d("单例类初始化");
  }
}
