package design.decorator;

import com.licola.llogger.LLogger;

/**
 * Created by LiCola on 2018/4/17.
 */
public class ConcreteComponent extends Component {

  @Override
  public String operation() {
    //具体功能处理
    LLogger.d("被包装的类方法");
    return "包装原始值";
  }
}
