package com.example.demo;

import com.example.demo.dao.StudentRepo;
import com.example.demo.dao.TeacherRepo;
import com.example.demo.dao.UserRepo;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner {

	@Autowired
	StudentRepo repoSt;

	@Autowired
	TeacherRepo repoTch;

	@Autowired
	UserRepo repoUsr;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		repoSt.save(new Student("Ana", "One"));
		repoSt.save(new Student("Bob", "Two"));
		repoSt.save(new Student("Charlie", "One"));
		repoSt.save(new Student("David", "Three"));

		repoTch.save(new Teacher("Edward", "English"));
		repoTch.save(new Teacher("Mary", "Math"));
		repoTch.save(new Teacher("Sana", "Science"));

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		repoUsr.save(new AppUser("user1","username1",encoder.encode("password1"),"USER"));
		repoUsr.save(new AppUser("user2","username2",encoder.encode("password2"),"ADMIN"));
		repoUsr.save(new AppUser("user","user",encoder.encode("password"),"USER"));
	}
}
