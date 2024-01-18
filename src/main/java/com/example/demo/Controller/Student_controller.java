package com.example.demo.Controller;

import com.example.demo.Entity.Student;
import com.example.demo.Entity.Studentdto;
import com.example.demo.ExceptionHandling.ResourceNotFoundException;
import com.example.demo.Payload.Getdto;
import com.example.demo.Payload.Postdto;
import com.example.demo.Payload.Putdto;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/postData")
public class Student_controller
{
    StudentRepository repo;

    public Student_controller(StudentRepository repo) {
        //constructor based injection is = to autowired.
        this.repo = repo;
    }

@PostMapping

    public ResponseEntity<?> postData(@RequestBody Student s)
    {
        Student save = repo.save(s);
        Postdto dto =new Postdto();
        dto.setSave(save);
        dto.setMessage("Your Data is saved");
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
        // http://localhost:8080/api/postData
    }

@GetMapping
// http://localhost:8080/api/postData?id=5
public ResponseEntity<?> getData(@RequestParam("id")int id)
{
//    List<Student> get = repo.findAll();
//    Getdto dto= new Getdto();
//    dto.setGet(get);
//    dto.setMessage("your data is viewed");
//    return new ResponseEntity<>(dto,HttpStatus.OK);
// http://localhost:8080/api/postData
    Student student = repo.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("The data is not present in this id " + id));

    return new ResponseEntity<>(student,HttpStatus.OK);
}

@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteData(@PathVariable int id)
{
    repo.deleteById(id);
    return new ResponseEntity<>("the data is deleted",HttpStatus.OK);
}

@PutMapping
    public ResponseEntity<?> putData(@RequestParam("id") int id , @RequestBody Studentdto dto)
{
    Student updatedto = repo.findById(id).get();
    updatedto.setId(dto.getId());
    updatedto.setName(dto.getName());
    updatedto.setRollno(dto.getRollno());

    Student s = repo.save(updatedto);
    Putdto dto1=new Putdto();
    dto1.setS(s);
    dto1.setMessage("your Data is updated");
    return new ResponseEntity<>(dto1,HttpStatus.OK);


}





}
