import javax.rmi.CORBA.StubDelegate;
import java.util.List;

public class Teacher {
    String username;  //用户名，即学工号号
    String password;   //密码
    String phonenumber; //电话号码
    String id;    //身份id

    List<Course> courseList;
    List<Student> studentList;
}
