package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
  @Autowired
  StudentRepository studentRepository;
 public void  addStudent(Student student)
    {
      studentRepository.createStudent(student);
    }
  public void  addTeacher(Teacher teacher)
  {
    studentRepository.createTeacher(teacher);
  }

  public void addStudentTeacherPair(String student,String teacher)
  {
    studentRepository.createStudentTeacher(student,teacher);
  }

  public Student getStudentByName(String name)
  {
    return studentRepository.getStudentByName(name);
  }

  public Teacher getTeacherByName(String name)
  {
    return studentRepository.getTeacherByName(name);
  }

  public List<String> getStudentsByTeacherName(String teacher)
  {
    return studentRepository.getStudentsByTeacherName(teacher);
  }
  public List<String> getAllStudents()
  {
    return studentRepository.getAllStudents();
  }
  public void deleteTeacherByName(String teacherName)
  {
    studentRepository.deleteTeacherByName(teacherName);
  }

  public void deleteAllTeachers()
  {
    studentRepository.deleteAllTeachers();
  }
}
