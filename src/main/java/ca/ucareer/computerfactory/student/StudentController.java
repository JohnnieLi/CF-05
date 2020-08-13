package ca.ucareer.computerfactory.student;

import ca.ucareer.computerfactory.ResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class StudentController {


    //list
    @GetMapping("/students")
    public ResponseEntity<ResponseBody> getStudents(@RequestParam(required = false) Optional<Integer> page) {
        Student student1 = new Student();
        student1.setAge(10);
        student1.setId(1);
        student1.setName("A");

        Student student2 = new Student();
        student2.setAge(11);
        student2.setId(2);
        student2.setName("B");

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        String message;
        if(page != null){
            message = "page is " + page;
        }else{
            message = "no page";
        }
        ResponseBody responseBody = new ca.ucareer.computerfactory.ResponseBody<List<Student>>(students, message, null);
        return ResponseEntity.ok(responseBody);
    }

    //retrieve
    @GetMapping("/students/{id}")
    public ResponseEntity<ResponseBody> getStudent(@PathVariable int id) {
        Student student1 = new Student();
        student1.setAge(10);
        student1.setId(id);
        student1.setName("A");
        ResponseBody responseBody = new ca.ucareer.computerfactory.ResponseBody<Student>(student1, "test message", null);
        return ResponseEntity.ok(responseBody);
    }

    //create
    @PostMapping("/students")
    public ResponseEntity<ResponseBody> createStudent(@RequestBody Student studentBody) {
        Student savedStudent = new Student();
        savedStudent.setName(studentBody.getName());
        savedStudent.setAge(studentBody.getAge());
        savedStudent.setId(100);
        ResponseBody responseBody = new ResponseBody<Student>(savedStudent, "test message", null);
        return ResponseEntity.ok(responseBody);
    }

    //update
    @PostMapping("/students/{id}")
    public ResponseEntity<ResponseBody> updateStudent(@PathVariable int id, @RequestBody Student studentBody) {
        Student savedStudent = new Student();
        savedStudent.setName(studentBody.getName());
        savedStudent.setAge(studentBody.getAge());
        savedStudent.setId(id);
        ResponseBody responseBody = new ResponseBody<Student>(savedStudent, "updated", null);
        return ResponseEntity.ok(responseBody);
    }


    //delete
    @DeleteMapping("/students/{id}")
    public ResponseEntity<ResponseBody> deleteStudent(@PathVariable int id) {
        ResponseBody responseBody = new ResponseBody<Student>(null, "deleted successfully", null);
        return ResponseEntity.ok(responseBody);
    }
}
