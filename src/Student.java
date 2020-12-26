import java.util.List;

public class Student {
    String username;  //用户名，即学号
    String password;   //密码
    String phonenumber; //电话号码
    String id;    //身份id

    List<Course> courseList;   //一个学生有很多科目
    List<Teacher> teacherList;  //一个学生有很多老师， 列表，老师
}
