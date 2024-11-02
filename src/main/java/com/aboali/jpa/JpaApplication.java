package com.aboali.jpa;

import com.aboali.jpa.models.Author;
import com.aboali.jpa.models.Video;
import com.aboali.jpa.repositories.AuthorRepository;
import com.aboali.jpa.repositories.ResourseRepository;
import com.aboali.jpa.repositories.VideoRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
//	create cmdlinerunner
	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository authorRepository
	, VideoRepository videoRepository, ResourseRepository resourseRepository) {
		return args -> {
//			use builder
//			var author = Author.builder()
//					.firstName("Aboali")
//					.lastName("Mansour")
//					.email("a@ddd.com")
//					.age(25)
//					.createdAt(java.time.LocalDateTime.now())
//					.build();
//			save author
//			authorRepository.save(author);
//			create video
//			var video = Video.builder()
//					.length(10)
//					.resourceName("video title")
//					.build();
////			save video
//			videoRepository.save(video);
////			get all resources
//			resourseRepository.findAll().forEach(System.out::println);
			for (int i = 0; i < 50; i++) {
				Faker faker = new Faker();
				var author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(19, 50))
						.email(faker.internet().emailAddress())
						.build();

				authorRepository.save(author);
			}
//			update Author with ID 1
						var author = Author.builder()
					.firstName("Aboali")
								.id(1)
					.lastName("Mansour")
					.email("a@ddd.com")
					.age(25)
					.createdAt(java.time.LocalDateTime.now())
					.build();
			authorRepository.save(author);
			//if i want to update author a to set a.age to 20 where a.id=1
//			authorRepository.updateAuthor(200,1);
//			to update all the ages
//			authorRepository.updateAllAuthorsByAge(1000);
//			update by named query
			authorRepository.updateByNamedQuery(10);
//			find by named query
			authorRepository.findByAgeRange(20).forEach(System.out::println);
		};

	}
}