package com.example.studentSystem.service;

import com.example.studentSystem.dto.StudentDTO;
import com.example.studentSystem.entity.Student;
import com.example.studentSystem.repo.StudentRepo;
import com.example.studentSystem.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ModelMapper modelMapper;


    public String saveStudent(StudentDTO studentDTO){
        if(studentRepo.existsById(studentDTO.getStuID())){
            return VarList.RSP_DUPLICATED;

        }else {
            studentRepo.save(modelMapper.map(studentDTO, Student.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateStudent(StudentDTO studentDTO){
        if(studentRepo.existsById(studentDTO.getStuID())){
            studentRepo.save(modelMapper.map(studentDTO, Student.class));
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<StudentDTO> getAllStudents(){
        List<Student> studentList= studentRepo.findAll();
        return modelMapper.map(studentList, new TypeToken<ArrayList<StudentDTO>>(){
        }.getType());
    }

    public StudentDTO searchStudent(int stuID){
        if (studentRepo.existsById(stuID)){
            Student student= studentRepo.findById(stuID).orElse(null);
            return modelMapper.map(student, StudentDTO.class);
        }else {
            return null;
        }
    }


    public String deleteStudent(int stuID){
        if (studentRepo.existsById(stuID)){
            studentRepo.deleteById(stuID);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
