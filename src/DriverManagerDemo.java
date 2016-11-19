import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by xuwei on 2016/11/19.
 * DriverManager的两个作用：注册驱动、获得连接
 */
public class DriverManagerDemo {
    public void fun1() throws Exception {
        //注册驱动的方法
//        DriverManager.registerDriver(new Driver()); //方法1(不推荐)：驱动实现类中的静态代码块中已经调用过
        Class.forName("com.mysql.jdbc.Driver"); //方法2：通过反射获取(推荐)
    }
    public void func2() throws SQLException {
        //url完整格式：大协议：子协议：//ip地址：端口/库名？参数键=参数值
        //如果数据库地址是本机地址，端口为默认端口，可直接写成
//        String url = "jdbc:mysql:///jdbc";
        String url = "jdbc:mysql://localhost:3306/jdbc";
        Connection conn = DriverManager.getConnection(url, "root", "123456");
    }
}
