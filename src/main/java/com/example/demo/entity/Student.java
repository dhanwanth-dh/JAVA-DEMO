// package com.example.demo.entity;

// import org.springframework.data.annotation.Id;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// // import jakarta.persistence.Id;
// import jakarta.persistence.Table;

// @Entity
// @Table(name="students")
// public class Student {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String name;
//     private int age;
//     private String email;

//     public Student() {}

//     public Student(String name, int age, String email)
//     {
//         this.name=name;
//         this.age=age;
//         this.email=email;

//     }
//     public Long getId() {return id;}
//     public void setId(Long id){this.id=id;}

//     public String getName() {return name;}
//     public void setName(String name) {this.name=name;}

//     public int getAge() {return age;}
//     public void setAge(int age) {this.age=age;}

//     public String getEmail() {return email;}
//     public void setEmail(String email){this.email=email;}
// }


package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;       // ✅ Use this one!
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String email;

    public Student() {}

    public Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
