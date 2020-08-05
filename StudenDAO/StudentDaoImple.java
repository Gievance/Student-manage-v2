package version2.StudenDAO;

import version2.bean.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImple extends BasicDao implements StudentDao{

    @Override
    public int add(Student s) throws SQLException {
        String sql="insert into student values(null,?,?,?,?,?,?,?,?)";
        return dupdate(sql, s.getName(), s.getAge(), s.getPyhton(), s.getJava(), s.getLinux(), s.getSql(), s.getAvg(), s.getSum());

    }

    @Override
    public int deleteById(int id) throws SQLException {
        String sql="delete from student where id=?";
        return dupdate(sql, id);
    }

    @Override
    public int deleteAll() throws SQLException {
        String sql="delete from student";
        return dupdate(sql);
    }

    @Override
    public int update(Student s) throws SQLException {
        String sql="update student set name=?,age=?,python=?,java=?,linux=?,`sql`=?,avg=?,sum=? where id=?";
        return dupdate(sql, s.getName(), s.getAge(), s.getPyhton(), s.getJava(), s.getLinux(), s.getSql(), s.getAvg(), s.getSum(), s.getId());
    }

    @Override
    public Student getById(int id) throws SQLException {
       String sql="select * from student where id=?";
        List<Student> query = query(sql,id);
        return query.get(0);
    }

    @Override
    public List<Student> getAll() throws SQLException {
        String sql="select * from student";
        return query(sql);
    }

    @Override
    public List<Student> getByPage(int pagenum, int pagedex) throws SQLException {
        String sql="select * from student limit ?,?";
        return query(sql, (pagenum - 1) * pagedex, pagedex);
    }
}
