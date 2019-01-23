package com.se.team19.server;

import com.se.team19.server.Entity.Category;
import com.se.team19.server.Entity.Note;
import com.se.team19.server.Repository.AddProductsRepository;
import com.se.team19.server.Repository.CategoryRepository;
import com.se.team19.server.Repository.NoteRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}

	//<!==========  AddProductToStock ==========!>
	@Bean
	ApplicationRunner init(CategoryRepository categoryRepository, NoteRepository noteRepository, AddProductsRepository addProductsRepository) {
		return args -> {
			Category category1 = new Category();
			category1.setCategoryName("อุปกรณ์ทางการแพทย์");
			categoryRepository.save(category1);
			Category category2 = new Category();
			category2.setCategoryName("เครื่องมือซ่อมบำรุง");
			categoryRepository.save(category2);
			Category category3 = new Category();
			category3.setCategoryName("ของใช้ทั่วไป");
			categoryRepository.save(category3);
			Category category4 = new Category();
			category4.setCategoryName("อุปกรณ์สำนักงาน");
			categoryRepository.save(category4);

			Note note1 = new Note();
			note1.setNoteName("ได้รับจากการบริจาค");
			noteRepository.save(note1);
			Note note2 = new Note();
			note2.setNoteName("ได้รับจากการซื้อ");
			noteRepository.save(note2);
		};
	}
	//<!========== END!! AddProductToStock ==========!>

}
