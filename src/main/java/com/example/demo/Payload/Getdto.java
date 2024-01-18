package com.example.demo.Payload;
import com.example.demo.Entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Getdto {

    private List<Student> get;
    private String message;

}
