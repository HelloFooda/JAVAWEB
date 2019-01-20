package com.shero.db;

import java.sql.*;

public class JdbcUtils {

    private static String url = "jdbc:mysql://localhost:3309/shoppingweb";
    private static String username = "root";
    private static String password = "root";
    // 闈欐�佷唬鐮佸潡鍙墽琛屼竴娆★紝鍥犱负闈欐�佷唬鐮佸潡鍦ㄧ被鍔犺浇鏃舵墽琛岋紝绫绘案杩滃彧鍔犺浇涓�娆�
    static {
        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
        } catch (Exception e) {
            /*
             * db.properties鏂囦欢閮芥棤娉曡鍙栵紝閭ｄ箞鏁翠釜搴旂敤绋嬪簭鏃犳硶杩炴帴鏁版嵁搴擄紱
             * 椹卞姩閮藉姞杞戒笉浜嗭紝閭ｄ箞鏁翠釜搴旂敤绋嬪簭閮芥棤娉曞伐浣滐紝
             * 鎵�浠ラ兘搴旇鎶涗竴涓敊璇�(ExceptionInInitializerError)
             */
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static void release(Connection conn, Statement st, ResultSet rs) {

        if (rs!=null) {
            try {
                rs.close(); // 鍋囪throw寮傚父
            } catch (Exception e) {
                e.printStackTrace(); // 鍙渶鍦ㄥ悗鍙拌褰曞紓甯�
            }
            rs = null; // 鍋囪rs瀵硅薄娌℃湁閲婃斁锛屽皢鍏剁疆涓簄ull锛岃瀵硅薄灏卞彉鎴愬瀮鍦撅紝鐢盝ava鍨冨溇鍥炴敹鍣ㄥ洖鏀�
        }
        if (st!=null) {
            try {
                st.close(); // 鍋囪throw寮傚父
            } catch (Exception e) {
                e.printStackTrace(); // 鍙渶鍦ㄥ悗鍙拌褰曞紓甯�
            }
            st = null;
        }
        if (conn!=null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace(); // 鍙渶鍦ㄥ悗鍙拌褰曞紓甯�
            }
        }

    }
}