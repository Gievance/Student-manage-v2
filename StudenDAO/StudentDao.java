package version2.StudenDAO;

import version2.bean.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    int add(Student s) throws SQLException;
    int deleteById(int id) throws SQLException;
    int deleteAll() throws SQLException;
    int update(Student s) throws SQLException;
    Student getById(int id) throws SQLException;
    List<Student> getAll() throws SQLException;
    List<Student> getByPage(int pagenum,int pagedex) throws SQLException;
}
