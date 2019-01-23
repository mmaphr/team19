package com.se.team19.server;

import com.se.team19.server.Entity.*;
import com.se.team19.server.Repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import java.util.stream.Stream;

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


	@Bean
	ApplicationRunner init(PositionRepository positionRepository,
						   ProvinceRepository provinceRepository,
						   GenderRepository genderRepository,
						   StaffRepository staffRepository,
						   CategoryRepository categoryRepository,
						   NoteRepository noteRepository,
						   AddProductsRepository addProductsRepository) {
		return args -> {

			//<!==========  AddProductToStock ==========!>
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

			//<!========== END!! AddProductToStock ==========!>


			//<!==================== Staff ====================!>
			Stream.of("ชาย", "หญิง").forEach(GenderName -> {
				genderRepository.save(new Gender(GenderName));
			});
			genderRepository.findAll().forEach(System.out::println);

			Stream.of("ฝ่ายบุคคล", "พนักงานทั่วไป").forEach(PositionName -> {
				positionRepository.save(new Position(PositionName));
			});
			positionRepository.findAll().forEach(System.out::println);

			Stream.of("กระบี่","กรุงเทพมหานคร","กาญจนบุรี","กาฬสินธุ์","กำแพงเพชร","ขอนแก่น","จันทบุรี","ฉะเชิงเทรา" ,"ชลบุรี","ชัยนาท","ชัยภูมิ","ชุมพร","เชียงราย","เชียงใหม่","ตรัง","ตราด","ตาก","นครนายก","นครปฐม","นครพนม","นครราชสีมา" ,"นครศรีธรรมราช","นครสวรรค์","นนทบุรี","นราธิวาส","น่าน","บุรีรัมย์","บึงกาฬ","ปทุมธานี","ประจวบคีรีขันธ์","ปราจีนบุรี","ปัตตานี" ,"พะเยา","พังงา","พัทลุง","พิจิตร","พิษณุโลก","เพชรบุรี","เพชรบูรณ์","แพร่","ภูเก็ต","มหาสารคาม","มุกดาหาร","แม่ฮ่องสอน" ,"ยโสธร","ยะลา","ร้อยเอ็ด","ระนอง","ระยอง","ราชบุรี","ลพบุรี","ลำปาง","ลำพูน","เลย","ศรีสะเกษ","สกลนคร","สงขลา" ,"สตูล","สมุทรปราการ","สมุทรสงคราม","สมุทรสาคร","สระแก้ว","สระบุรี","สิงห์บุรี","สุโขทัย","สุพรรณบุรี","สุราษฎร์ธานี" ,"สุรินทร์","หนองคาย","หนองบัวลำภู","อยุธยา","อ่างทอง","อำนาจเจริญ","อุดรธานี","อุตรดิตถ์","อุทัยธานี","อุบลราชธานี").forEach(Provincename -> {
				provinceRepository.save(new Province(Provincename));
			});
			provinceRepository.findAll().forEach(System.out::println);

			Staff S1 = new Staff();
			S1.setStaffName("SomA");
			S1.setAge(20);
			S1.setAddress("123/2");
			S1.setPhone("081-2345678");
			S1.setUsername("SomA");
			S1.setPassword("123456");
			S1.setStaffGender(genderRepository.findById(1));
			S1.setStaffProvince(provinceRepository.findById(13));
			S1.setStaffPosition(positionRepository.findById(2));
			staffRepository.save(S1);
			staffRepository.findAll().forEach(System.out::println);

			//<!================= END!! Staff =================!>

		};
	}



}
