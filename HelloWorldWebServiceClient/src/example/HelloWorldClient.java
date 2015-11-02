package example;
import com.jeffreyhwang.java.HelloWorldService;
/**


 * Created by Hwang on 10/5/15.
 */
public class HelloWorldClient {
  public static void main(String[] argv) {
    com.jeffreyhwang.java.HelloWorld service = new HelloWorldService().getHelloWorldPort();
    //invoke business method
    System.out.println(service.sayHelloWorldFrom(" Madison Wisconsin"));
  }
}
