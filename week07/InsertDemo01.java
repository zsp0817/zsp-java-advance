import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.UUID;

/**
 * Created by zhangshaopeng on 2021/8/8.
 */
public class InsertDemo01 {

    /**
     * 使用每次insert都commit的方式，插入100万条数据耗时197573ms
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/zsp_test?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String username = "root";
        String password = "123456";

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO `order`(order_code, goods_code, sale_amount, num, total_amount, user_id, creator, modifier) VALUE (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);

            String userName = "张三";
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                pstmt.setString(1, UUID.randomUUID().toString());
                pstmt.setString(2, UUID.randomUUID().toString());

                // 设置售价和数量
                double random = Math.random() * 100;
                BigDecimal saleAmount = new BigDecimal(random);
                BigDecimal totalAmount = saleAmount.multiply(BigDecimal.ONE);
                pstmt.setBigDecimal(3, saleAmount);
                pstmt.setInt(4, 1);
                pstmt.setBigDecimal(5, totalAmount);

                pstmt.setInt(6, 1);
                pstmt.setString(7, userName);
                pstmt.setString(8, userName);
                pstmt.executeUpdate();
            }
            System.out.println(System.currentTimeMillis() - startTime);
        } finally {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
    }
}
