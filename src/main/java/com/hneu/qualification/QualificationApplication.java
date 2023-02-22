package com.hneu.qualification;

import com.hneu.qualification.entity.Faculty;
import com.hneu.qualification.entity.Group;
import com.hneu.qualification.entity.Lector;
import com.hneu.qualification.entity.Lecture;
import com.hneu.qualification.entity.LectureType;
import com.hneu.qualification.entity.Student;
import com.hneu.qualification.entity.Subject;
import com.hneu.qualification.repository.FacultyRepository;
import com.hneu.qualification.repository.GroupRepository;
import com.hneu.qualification.repository.LectorRepository;
import com.hneu.qualification.repository.LectureRepository;
import com.hneu.qualification.repository.StudentRepository;
import com.hneu.qualification.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@SpringBootApplication
public class QualificationApplication implements CommandLineRunner {

	private final StudentRepository studentRepository;
	private final LectorRepository lectorRepository;
	private final LectureRepository lectureRepository;
	private final GroupRepository groupRepository;
	private final FacultyRepository facultyRepository;
	private final SubjectRepository subjectRepository;

	public static void main(String[] args) {
		SpringApplication.run(QualificationApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Faculty faculty1 = Faculty.builder()
				.name("Грифиндор")
				.build();
		Faculty faculty2 = Faculty.builder()
				.name("Пуффендуй")
				.build();

		facultyRepository.save(faculty1);
		facultyRepository.save(faculty2);

		Group group1 = Group.builder()
				.name("Перша группа")
				.faculty(faculty1)
				.build();
		Group group2 = Group.builder()
				.name("Друга группа")
				.faculty(faculty2)
				.build();

		groupRepository.save(group1);
		groupRepository.save(group2);

		Student student1 = Student.builder()
				.name("Микита Труфанов")
				.phone("12359632")
				.address("Харків")
				.group(group1)
				.build();
		Student student2 = Student.builder()
				.name("Олег Сергеєв")
				.phone("23145813")
				.address("Київ")
				.group(group2)
				.build();
		Student student3 = Student.builder()
				.name("Максим Ходак")
				.phone("92340224")
				.address("Львів")
				.group(group1)
				.build();
		Student student4 = Student.builder()
				.name("Дмитро Денисенко")
				.phone("12390123")
				.address("Житомир")
				.group(group2)
				.build();
		Student student5 = Student.builder()
				.name("Данил Шаповалов")
				.phone("934913795")
				.address("Вінниця")
				.group(group1)
				.build();
		Student student6 = Student.builder()
				.name("Володимир Білий")
				.phone("23347920")
				.address("Дніпро")
				.group(group1)
				.build();

		studentRepository.save(student1);
		studentRepository.save(student2);
		studentRepository.save(student3);
		studentRepository.save(student4);
		studentRepository.save(student5);
		studentRepository.save(student6);

		Lector lector1 = Lector.builder()
				.name("Миколаєнко Микола Миколайович")
				.address("Харків")
				.salary(100)
				.phone("0506789456")
				.build();
		Lector lector2 = Lector.builder()
				.name("Петренко Петро Петрович")
				.address("Київ")
				.phone("0577021831")
				.salary(125)
				.build();
		Lector lector3 = Lector.builder()
				.name("Ушакова Ірина Олексіївна")
				.address("Харків")
				.phone("0577021831")
				.salary(140)
				.build();

		lectorRepository.save(lector1);
		lectorRepository.save(lector2);
		lectorRepository.save(lector3);

		Subject subject1 = Subject.builder()
				.name("Мобільні технології")
				.build();
		Subject subject2 = Subject.builder()
				.name("Філософія")
				.build();
		Subject subject3 = Subject.builder()
				.name("Алгоритми та структури даних")
				.build();
		Subject subject4 = Subject.builder()
				.name("Економіка та право")
				.build();

		subjectRepository.save(subject1);
		subjectRepository.save(subject2);
		subjectRepository.save(subject3);
		subjectRepository.save(subject4);

		Lecture lecture1 = Lecture.builder()
				.lector(lector1)
				.lectureType(LectureType.LECTURE)
				.group(group1)
				.subject(subject1)
				.time(LocalDateTime.of(2023, 2, 20, 8, 30))
				.build();
		Lecture lecture2 = Lecture.builder()
				.lector(lector2)
				.lectureType(LectureType.LECTURE)
				.group(group1)
				.subject(subject2)
				.time(LocalDateTime.of(2023, 2, 20, 12, 10))
				.build();
		Lecture lecture3 = Lecture.builder()
				.lector(lector1)
				.lectureType(LectureType.LECTURE)
				.group(group2)
				.subject(subject3)
				.time(LocalDateTime.of(2023, 2, 21, 10, 15))
				.build();
		Lecture lecture4 = Lecture.builder()
				.lector(lector1)
				.lectureType(LectureType.PRACTICE)
				.group(group1)
				.subject(subject1)
				.time(LocalDateTime.of(2023, 2, 22, 13, 55))
				.build();
		Lecture lecture5 = Lecture.builder()
				.lector(lector1)
				.lectureType(LectureType.PRACTICE)
				.group(group2)
				.subject(subject3)
				.time(LocalDateTime.of(2023, 2, 23, 10, 15))
				.build();
		Lecture lecture6 = Lecture.builder()
				.lector(lector2)
				.lectureType(LectureType.LECTURE)
				.group(group2)
				.subject(subject4)
				.time(LocalDateTime.of(2023, 2, 23, 13, 55))
				.build();

		lectureRepository.save(lecture1);
		lectureRepository.save(lecture2);
		lectureRepository.save(lecture3);
		lectureRepository.save(lecture4);
		lectureRepository.save(lecture5);
		lectureRepository.save(lecture6);
	}
}
