import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.sql.*;

/**
 * Created by xuwei on 2016/11/19.
 * JDBC程序编写
 */
public class Demo {

    //此注释标记为此方法是用于测试的方法，用@Test方法标记的方法必须是public void的无参方法
    @Test
    public void fun1() throws SQLException {
        //1.导入mysql-connector-java包
        //2.注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //3.连接数据库
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
        //4.操作数据库
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM t_user";
        ResultSet rs = statement.executeQuery(sql); //执行查询语句
        while (rs.next()) { //向下移动一行并判断这一行是否有数据
            int id = rs.getInt(1);//jdbc的下标索引从1开始
            System.out.println("id = " + id);

            String name = rs.getString(2);
            System.out.println("name = " + name);

            String gender = rs.getString(3);
            System.out.println("gender = "+gender);
        }
        //关闭资源
        connection.close();
        statement.close();
    }
}
