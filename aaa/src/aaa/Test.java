package aaa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Test {
	public static void main(String[] args) throws Exception {
		// 1、 加载驱动
					Class.forName("oracle.jdbc.OracleDriver");
					// 2、 使用驱动填入数据获取链接
					String url = "jdbc:oracle:thin:@172.16.5.170:1521:orcl";
					String user = "system";
					String password = "root";
					Connection connection = DriverManager.getConnection(url, user, password);
					// 3、 准备sql预编译语句
					String sql = "select * from test";
					PreparedStatement ps = connection.prepareStatement(sql);
					// 4、 执行返回结果集
					ResultSet rs = ps.executeQuery();
					// 5、 处理结果集
					ResultSetMetaData metaData = rs.getMetaData();
					int columnCount = metaData.getColumnCount();
					while (rs.next()) {
						for (int i = 1; i <= columnCount; i++) {
							System.out.print(rs.getObject(i));
						}
						System.out.println();
					}
					// 6、 关闭
					rs.close();
					ps.close();
					connection.close();
	}
	
}
