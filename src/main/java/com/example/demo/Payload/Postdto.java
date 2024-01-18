package com.example.demo.Payload;

import com.example.demo.Entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Postdto {

    private Student save;
    private String message;
}
