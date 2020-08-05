package version2.StudenDAO;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import version2.bean.Student;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class BasicDao {//增删改查操作的封装
    private static DataSource ds = null;
    private static ThreadLocal<Connection> th = null;

    static {
        Properties pro = new Properties();
        try {
            pro.load(new FileReader("src\\main\\resources\\pro.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
            th = new ThreadLocal<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        Connection c = th.get();
        if (c == null) {
            c = ds.getConnection();
            th.set(c);
        }
        return c;
    }

    public void free() throws SQLException {
        Connection c = getConnection();
        if (c != null) {
            th.remove();
            c.close();
        }
    }

    public int dupdate(String sql, Object... args) throws SQLException {
        Connection connection =getConnection();
        PreparedStatement pre = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++)
            pre.setObject(i + 1, args[i]);
        return pre.executeUpdate();
    }

    public List<Student> query(String sql, Object... args) throws SQLException {
        Connection c = getConnection();
        ArrayList<Map<String, Object>> maps = new ArrayList<>();
        PreparedStatement pre = c.prepareStatement(sql);
        if (args.length > 0)
            for (int i = 0; i < args.length; i++)
                pre.setObject(i + 1, args[i]);

        ResultSet resultSet = pre.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        while (resultSet.next()) {
            TreeMap<String, Object> tree = new TreeMap<>();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                tree.put(metaData.getColumnLabel(i + 1), resultSet.getObject(i + 1));
            }
            maps.add(tree);
        }
        List<Student> stu = new ArrayList<>();
        for (Map<String, Object> m : maps) {
            Student s = new Student();
            s.setId((Integer) m.get("id"));
            s.setAge((Integer) m.get("age"));
            s.setJava((Integer) m.get("java"));
            s.setName((String) m.get("name"));
            s.setPyhton((Integer) m.get("python"));
            s.setLinux((Integer) m.get("linux"));
            s.setAvg((Integer) m.get("avg"));
            s.setSql((Integer) m.get("sql"));
            s.setSum((Integer) m.get("sum"));
            stu.add(s);
        }
        return stu;
    }
}
