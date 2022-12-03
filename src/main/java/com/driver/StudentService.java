package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
  @Autowired
  StudentRepository studentRepository;
  void  addStudent(Student student)
    {
      studentRepository.createStudent(student);
    }
  void  addTeacher(Teacher teacher)
  {
    studentRepository.createTeacher(teacher);
  }

  void addStudentTeacherPair(String student,String teacher)
  {
    studentRepository.createStudentTeacher(student,teacher);
  }

  Student getStudentByName(String name)
  {
    return studentRepository.getStudentByName(name);
  }

  Teacher getTeacherByName(String name)
  {
    return studentRepository.getTeacherByName(name);
  }

  List<String> getStudentsByTeacherName(String teacher)
  {
    return studentRepository.getStudentsByTeacherName(teacher);
  }
  List<String> getAllStudents()
  {
    return studentRepository.getAllStudents();
  }
  void deleteTeacherByName(String teacherName)
  {
    studentRepository.deleteTeacherByName(teacherName);
  }

  void deleteAllTeachers()
  {
    studentRepository.deleteAllTeachers();
  }
}
