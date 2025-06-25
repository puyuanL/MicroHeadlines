package test;

import org.testng.annotations.Test;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestJDBCConnection {
    @Test
    public void testConnection() {
        Connection conn = null;
        Statement stmt = null;
//        ResultSet rs = null;

        try {
            // 获取数据库连接
            conn = JDBCUtil.getConnection();
            System.out.println("数据库连接成功: " + conn);

            // 创建Statement对象
            stmt = conn.createStatement();

            // 执行SQL查询
            String sql = "select tid,tname from news_type;";
            try (Statement statement = conn.createStatement();
                 ResultSet rs = statement.executeQuery(sql)) {

                // 获取结果集的元数据，查看列信息
                java.sql.ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                System.out.println("结果集列数: " + columnCount);

                // 打印列名
                StringBuilder columnNames = new StringBuilder("列名: ");
                for (int i = 1; i <= columnCount; i++) {
                    columnNames.append(metaData.getColumnName(i)).append(" (").append(metaData.getColumnTypeName(i)).append(")");
                    if (i < columnCount) columnNames.append(", ");
                }
                System.out.println(columnNames);

                // 遍历结果集
                while (rs.next()) {
                    // 根据列名获取值（修正：使用实际列名 tid 和 tname）
                    int tid = rs.getInt("tid");
                    String tname = rs.getString("tname");
                    System.out.println("行数据: tid=" + tid + ", tname=" + tname);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("数据库连接测试失败");
        }
    }

}
