package com.example.demo.Payload;

import com.example.demo.Entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Putdto
{
    private Student s;
    private String message;
}
