package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentMap= new HashMap<>();
    HashMap<String,Teacher> teacherMap= new HashMap<>();

    HashMap<String,List<String>> studentTeacherMap= new HashMap<>();
  public void createStudent(Student student)
    {
        studentMap.put(student.getName(),student);
    }
  public void createTeacher(Teacher teacher)
   {
       teacherMap.put(teacher.getName(),teacher);
   }
//6 7 D d &
   public void createStudentTeacher(String student,String teacher)
   {
       if(studentMap.containsKey(student) && teacherMap.containsKey(teacher))
       {
           studentMap.put(student,studentMap.get(student));
           teacherMap.put(teacher,teacherMap.get(teacher));
           List<String> createStudents = new ArrayList<>();
           if(studentTeacherMap.containsKey(teacher))
               createStudents=studentTeacherMap.get(teacher);
           createStudents.add(student);
           studentTeacherMap.put(teacher,createStudents);

       }
   }
   public Student getStudentByName(String name)
    {
       return studentMap.get(name);
    }

   public Teacher getTeacherByName(String name)
    {
        return teacherMap.get(name);
    }
    List<String>  getStudentsByTeacherName(String teacher)
    {   List<String> studentList = new ArrayList<>();
        if(studentTeacherMap.containsKey(teacher))
            studentList=studentTeacherMap.get(teacher);
           return studentList;
    }
   public List<String> getAllStudents()
    {
        List<String> allStudents = new ArrayList<>();
        for(String s : studentMap.keySet())
            allStudents.add(s);
        return allStudents;
    }

  public void deleteTeacherByName(String teacherName)
    {
        List<String> students=new ArrayList<>();
        if(studentTeacherMap.containsKey(teacherName)) {
            students = studentTeacherMap.get(teacherName);
            for (String s : students) {
                if(studentMap.containsKey(s))
                  students.remove(s);
            }
        }
        if(teacherMap.containsKey(teacherName))
        teacherMap.remove(teacherName);
    }
    public void deleteAllTeachers()
    {
        for(String teacherName:teacherMap.keySet())
            deleteTeacherByName(teacherName);
    }
}
