package com.se.team19.server;

import com.se.team19.server.Entity.*;
import com.se.team19.server.Repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.text.SimpleDateFormat;
import java.util.stream.Stream;
import java.util.Date;

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
	ApplicationRunner init(TrainAndStaffRepository trainAndStaffRepository,
                           TrainTypeRepository trainTypeRepository,
                           TrainStaffRepository trainStaffRepository,
                           PositionRepository positionRepository,
						   ProvinceRepository provinceRepository,
						   GenderRepository genderRepository,
						   StaffRepository staffRepository,
						   CategoryRepository categoryRepository,
						   NoteRepository noteRepository,
						   AddProductsRepository addProductsRepository,
						   RoomStatusRepository roomStatusRepository,
						   TypeRoomRepository typeRoomRepository,
						   DataOlderRepository DataolderRepository,
						   RoomInformationRepository roomInformationRepository,
						   OlderDiseaseRepository olderDiseaseRepository,
						   DataOlderRepository dataOlderRepository,
						   CategoryActivityRepository categoryActivityRepository,
						   OutActivityRepository outActivityRepository,
						   OrganizedRepository organizedRepository,
						   PeriodTimeRepository periodTimeRepository,
						   DaysOfTheWeekRepository daysOfTheWeekRepository,
						   InternalActivityRepository internalActivityRepository,
						   TimeDurationRepository timeDurationRepository,
						   RelativesStatusRepository relativesStatusRepository,
						   VisitorRepository visitorRepository,
						   TypeHealthCheckRepository typeHealthCheckRepository,
						   HealthCheckRepository healthCheckRepository,
						   DepartmentRepository departmentRepository,
						   OlderDataAndDiseaseRepository olderDataAndDiseaseRepository,
						   PlaceTyRepository placeTyRepository,
						   PlaceRepository placeRepository,
						   MaintenanceStatusRepository maintenanceStatusRepository,
						   MaintenanceRepository maintenanceRepository
						   ) {
		return args -> {

			//<!==========  AddOlderDisease ==========!>
			Stream.of("โรคความดันโลหิตสูง","โรคเบาหวาน","โรคหัวใจขาดเลือด","โรคสมองเสื่อม","โรคกระดูกพรุน","โรคซึมเศร้า").forEach(Disseasename -> {
				olderDiseaseRepository.save(new OlderDisease(Disseasename));
			});
			//<!========== END!! AddOlderDisease ==========!>


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

			//<!==========  WithdrawToStock ==========!>
			Department department = new Department();
			department.setDepartmentName("ส่วนงานอาคารสถานที่");
			departmentRepository.save(department);
			Department department1 = new Department();
			department1.setDepartmentName("ส่วนงานพยาบาล");
			departmentRepository.save(department1);
			Department department2 = new Department();
			department2.setDepartmentName("ส่วนงานเอกสาร");
			departmentRepository.save(department2);
			Department department3 = new Department();
			department3.setDepartmentName("ส่วนงานกิจกรรม");
			departmentRepository.save(department3);
			//<!========== END!! WithdrawToStock ==========!>


			//<!==================== Staff ====================!>
			Stream.of("ชาย", "หญิง").forEach(GenderName -> {
				genderRepository.save(new Gender(GenderName));
			});

			Stream.of("ฝ่ายบุคคล", "พนักงานทั่วไป").forEach(PositionName -> {
				positionRepository.save(new Position(PositionName));
			});

			Stream.of("กระบี่","กรุงเทพมหานคร","กาญจนบุรี","กาฬสินธุ์","กำแพงเพชร","ขอนแก่น","จันทบุรี","ฉะเชิงเทรา" ,"ชลบุรี","ชัยนาท","ชัยภูมิ","ชุมพร","เชียงราย","เชียงใหม่","ตรัง","ตราด","ตาก","นครนายก","นครปฐม","นครพนม","นครราชสีมา" ,"นครศรีธรรมราช","นครสวรรค์","นนทบุรี","นราธิวาส","น่าน","บุรีรัมย์","บึงกาฬ","ปทุมธานี","ประจวบคีรีขันธ์","ปราจีนบุรี","ปัตตานี" ,"พะเยา","พังงา","พัทลุง","พิจิตร","พิษณุโลก","เพชรบุรี","เพชรบูรณ์","แพร่","ภูเก็ต","มหาสารคาม","มุกดาหาร","แม่ฮ่องสอน" ,"ยโสธร","ยะลา","ร้อยเอ็ด","ระนอง","ระยอง","ราชบุรี","ลพบุรี","ลำปาง","ลำพูน","เลย","ศรีสะเกษ","สกลนคร","สงขลา" ,"สตูล","สมุทรปราการ","สมุทรสงคราม","สมุทรสาคร","สระแก้ว","สระบุรี","สิงห์บุรี","สุโขทัย","สุพรรณบุรี","สุราษฎร์ธานี" ,"สุรินทร์","หนองคาย","หนองบัวลำภู","อยุธยา","อ่างทอง","อำนาจเจริญ","อุดรธานี","อุตรดิตถ์","อุทัยธานี","อุบลราชธานี").forEach(Provincename -> {
				provinceRepository.save(new Province(Provincename));
			});

			Staff S1 = new Staff();
			S1.setStaffName("SomA");
			S1.setAge(20);
			S1.setAddress("123/2");
			S1.setPhone("0812345678");
			S1.setUsername("S0001");
			S1.setPassword("123456");
			S1.setStaffGender(genderRepository.findById(1));
			S1.setStaffProvince(provinceRepository.findById(13));
			S1.setStaffPosition(positionRepository.findById(2));
			staffRepository.save(S1);

			Staff S2 = new Staff("SomB",21,"12/3","0823456789","S0002","123",genderRepository.findById(1),provinceRepository.findById(44),positionRepository.findById(2));
			staffRepository.save(S2);
			Staff S3 = new Staff("SomC",33,"13/1","0820987654","S0003","123",genderRepository.findById(1),provinceRepository.findById(32),positionRepository.findById(2));
			staffRepository.save(S3);
			Staff S4 = new Staff("SomD",26,"14/5","0845677868","S0004","123",genderRepository.findById(1),provinceRepository.findById(55),positionRepository.findById(2));
			staffRepository.save(S4);
			Staff S5 = new Staff("SomE",34,"15/4","0856785673","S0005","123",genderRepository.findById(2),provinceRepository.findById(23),positionRepository.findById(2));
			staffRepository.save(S5);
			Staff S6 = new Staff("SomF",31,"16/3","0854635635","S0006","123",genderRepository.findById(1),provinceRepository.findById(67),positionRepository.findById(2));
			staffRepository.save(S6);
			Staff S7 = new Staff("SomG",32,"17/2","0934634654","S0007","123",genderRepository.findById(2),provinceRepository.findById(23),positionRepository.findById(2));
			staffRepository.save(S7);
			Staff S8 = new Staff("SomH",21,"18/1","0943534654","S0008","123",genderRepository.findById(2),provinceRepository.findById(11),positionRepository.findById(2));
			staffRepository.save(S8);

			//<!================= END!! Staff =================!>

			//<!==========  Add DataOlder ==========!>
			DataOlder Older1 = new DataOlder("นายตาสว่าง ขนนิ่ม", new Date(60,1,1),"สมคิด","1/11","1111111111",genderRepository.findById(1),provinceRepository.findById(1));
			DataOlder Older2 = new DataOlder("นางหมู หน้ารัก", new Date(60,2,2),"สมใจ","2/22","2222222222",genderRepository.findById(2),provinceRepository.findById(2));
			DataOlder Older3 = new DataOlder("นายหนุ่ม จุกจอก", new Date(60,3,3),"สมนา","3/33","3333333333",genderRepository.findById(1),provinceRepository.findById(3));
			DataOlder Older4 = new DataOlder("นางสาวดำ ขำ", new Date(60,4,4),"หมาย","4/44","4444444444",genderRepository.findById(2),provinceRepository.findById(4));
			DataOlder Older5 = new DataOlder("นายโม็ะ โง๊ะ", new Date(60,5,5),"หนาม","5/55","5555555555",genderRepository.findById(1),provinceRepository.findById(5));
			DataOlder Older6 = new DataOlder("นายเอ บีซี", new Date(60,6,6),"เอ","6/66","6666666666",genderRepository.findById(1),provinceRepository.findById(6));
			DataOlder Older7 = new DataOlder("นางบี ซีดี", new Date(60,7,7),"บี","7/77","7777777777",genderRepository.findById(2),provinceRepository.findById(7));
			DataOlder Older8 = new DataOlder("นายซี บีเอฟ", new Date(60,8,8),"ซี","8/88","8888888888",genderRepository.findById(1),provinceRepository.findById(8));
			DataOlder Older9 = new DataOlder("นางดี จริงจริง", new Date(60,9,9),"ดี","9/99","9999999999",genderRepository.findById(2),provinceRepository.findById(9));
			DataOlder Older10 = new DataOlder("นายอี นี่", new Date(60,10,10),"เอฟ","1/00","0000000000",genderRepository.findById(1),provinceRepository.findById(10));

			dataOlderRepository.save(Older1);
			dataOlderRepository.save(Older2);
			dataOlderRepository.save(Older3);
			dataOlderRepository.save(Older4);
			dataOlderRepository.save(Older5);
			dataOlderRepository.save(Older6);
			dataOlderRepository.save(Older7);
			dataOlderRepository.save(Older8);
			dataOlderRepository.save(Older9);
			dataOlderRepository.save(Older10);


			//<!================= END!! Add DataOlder =================!>


			//<!==========  RoomInformation ==========!>
			Stream.of("ห้องว่าง","ขาด1คน","ขาด2คน","เต็ม").forEach(statusName -> {
				RoomStatus roomstatus = new RoomStatus ();
				roomstatus.setStatusname(statusName);
				roomStatusRepository.save(roomstatus);
			});
			Stream.of("พิเศษชาย","พิเศษหญิง","ทั่วไปชาย","ทั่วไปหญิง").forEach(typeName -> {
				TypeRoom typeRoom = new TypeRoom();
				typeRoom.setTyperoom(typeName);
				typeRoomRepository.save(typeRoom);
			});

			RoomInformation	room1 = new RoomInformation();
			room1.setRoomnumber("A101");
			room1.setRoomstatus(roomStatusRepository.findById(1));
			room1.setTyperoom(typeRoomRepository.findById(1));
			roomInformationRepository.save(room1);

			RoomInformation	room2 = new RoomInformation();
			room2.setRoomnumber("A102");
			room2.setRoomstatus(roomStatusRepository.findById(2));
			room2.setTyperoom(typeRoomRepository.findById(1));
			room2.setOlder1(DataolderRepository.findById(1));
			room2.setOlder2(DataolderRepository.findById(3));
			roomInformationRepository.save(room2);

			RoomInformation	room3 = new RoomInformation();
			room3.setRoomnumber("A103");
			room3.setRoomstatus(roomStatusRepository.findById(3));
			room3.setTyperoom(typeRoomRepository.findById(2));
			room3.setOlder1(DataolderRepository.findById(2));
			roomInformationRepository.save(room3);

			RoomInformation	room4 = new RoomInformation();
			room4.setRoomnumber("A104");
			room4.setRoomstatus(roomStatusRepository.findById(4));
			room4.setTyperoom(typeRoomRepository.findById(1));
			roomInformationRepository.save(room4);

			RoomInformation	room5 = new RoomInformation();
			room5.setRoomnumber("A105");
			room5.setRoomstatus(roomStatusRepository.findById(1));
			room5.setTyperoom(typeRoomRepository.findById(4));
			roomInformationRepository.save(room5);

			RoomInformation	room6 = new RoomInformation();
			room6.setRoomnumber("A106");
			room6.setRoomstatus(roomStatusRepository.findById(1));
			room6.setTyperoom(typeRoomRepository.findById(4));
			roomInformationRepository.save(room6);

			RoomInformation	room7 = new RoomInformation();
			room7.setRoomnumber("A107");
			room7.setRoomstatus(roomStatusRepository.findById(1));
			room7.setTyperoom(typeRoomRepository.findById(2));
			roomInformationRepository.save(room7);

			RoomInformation	room8 = new RoomInformation();
			room8.setRoomnumber("A108");
			room8.setRoomstatus(roomStatusRepository.findById(1));
			room8.setTyperoom(typeRoomRepository.findById(2));
			roomInformationRepository.save(room8);

			RoomInformation	room9 = new RoomInformation();
			room9.setRoomnumber("A109");
			room9.setRoomstatus(roomStatusRepository.findById(1));
			room9.setTyperoom(typeRoomRepository.findById(3));
			roomInformationRepository.save(room9);

			RoomInformation	room10 = new RoomInformation();
			room10.setRoomnumber("A110");
			room10.setRoomstatus(roomStatusRepository.findById(1));
			room10.setTyperoom(typeRoomRepository.findById(3));
			roomInformationRepository.save(room10);

			//<!==========  END RoomInformation ==========!>
			//<!==========  OutActivity ==========!>
			Stream.of("เกมส์ กีฬา", "ดนตรี", "กิจกรรมอาสาสมัคร", "ทัศนศึกษา", "อื่นๆ").forEach(namecategory -> {
						CategoryActivity categoryActivity = new CategoryActivity();
						categoryActivity.setNamecategory(namecategory);
						categoryActivityRepository.save(categoryActivity);
					}
			);
			Stream.of("จัดกิจกรรมภายในสถานที่", "จัดกิจกรรมนอกสถานที่").forEach(organized -> {
						Organized organiz = new Organized();
						organiz.setOrganized(organized);
						organizedRepository.save(organiz);
					}
			);
			Stream.of("06:00",
					"07:00",
					"08:00",
					"09:00",
					"10:00",
					"11:00",
					"12:00",
					"13:00",
					"14:00",
					"15:00",
					"16:00",
					"17:00",
					"18:00",
					"19:00",
					"20:00",
					"21:00",
					"22:00",
					"23:00",
					"00:00").forEach(periodTime -> {
						PeriodTime periodtime = new PeriodTime();
						periodtime.setPeriodTime(periodTime);
						periodTimeRepository.save(periodtime);
					}
			);
			OutActivity o = new OutActivity();
			o.setNameActivity("งานดนตรี");
			o.setNameRequestor("นายสมชาย");
			o.setDescriptionActivity("งายดนตรีกลางแจ้ง");
			o.setPhonenum("0922818151");
			o.setDate(new Date(1,1,2));
			o.setCategoryActivity(categoryActivityRepository.findById(1));
			o.setPeriodTimeS(periodTimeRepository.findById(1));
			o.setPeriodTimeE(periodTimeRepository.findById(3));
			o.setStaff(staffRepository.findById(1));
			o.setOrganized(organizedRepository.findById(1));
			Stream.of("ลานกว้าง", "ห้อง", "-").forEach(typePlace -> {
				placeTyRepository.save(new PlaceTy(typePlace));
			});
			outActivityRepository.save(new OutActivity("งานดนตรี","นายสมใจ มีหม้อ","งานดนตรีนอกสถานที่","0123456789",new Date(118,4,4),categoryActivityRepository.findById(2),periodTimeRepository.findById(1),periodTimeRepository.findById(3),organizedRepository.findById(2),staffRepository.findById(1)));
			placeTyRepository.save(placeTyRepository.findById(1));
			BookAPlace p = new BookAPlace();
			p.setCardid("1234567890123");
			p.setNameCaretaker("นายสมพร สีทา");
			p.setPhonCaretaker("0942381728");
			p.setNamePlace("สนามหญ้า");
			p.setDescriptionPlace("งานกีฬาผ่อนคายที่ต้องเล่นกลางแจ้ง");
			p.setOutActivity(outActivityRepository.findById(2));
			p.setPlaceTy(placeTyRepository.findById(1));
			//<!==========  End OutActivity ==========!>

			Stream.of("วันอาทิตย์", "วันจันทร์", "วันอังคาร", "วันพุธ", "วันพฤหัสบดี", "วันศุกร์", "วันเสาร์").forEach(dayName -> {
				daysOfTheWeekRepository.save(new DaysOfTheWeek(dayName));
			});
			Stream.of("06.00-07.00น.", "07.00-08.00น.", "08.00-09.00น.", "09.00-10.00น.", "10.00-11.00น.", "11.00-12.00น.", "12.00-13.00น.", "13.00-14.00น.",
					"14.00-15.00น.", "15.00-16.00น.", "16.00-17.00น.", "17.00-18.00น.", "18.00-19.00น.", "19.00-20.00น.").forEach(timeDuration -> {
				timeDurationRepository.save(new TimeDuration(timeDuration));
			});

			//<!==========  Add InternalActivity ==========!>
			internalActivityRepository.save(new InternalActivity("exercise", "ออกกำลังกายตอนเช้าเพื่อสุขภาพ", staffRepository.findById(2), daysOfTheWeekRepository.findById(6), timeDurationRepository.findById(3)));
			internalActivityRepository.save(new InternalActivity("exercise", "ออกกำลังกายตอนเช้าเพื่อสุขภาพ", staffRepository.findById(2), daysOfTheWeekRepository.findById(2), timeDurationRepository.findById(3)));
			//<!==========  End InternalActivity ==========!>

			Stream.of("ลูก", "หลาน", "เพื่อน", "คนรู้จัก", "พี่", "น้อง").forEach(relative -> {
				relativesStatusRepository.save(new RelativesStatus(relative));
			});

			visitorRepository.save(new Visitor("นายสมใจ มีหม้อ","1128192731234",34,"0891234579",new Date(),new Date(),"901 บ้านใหญ่",genderRepository.findById(1),provinceRepository.findById(65),relativesStatusRepository.findById(1),dataOlderRepository.findById(3)));
			visitorRepository.save(new Visitor("นางสมศรี มีไหม","1123334123432",34,"0891234579",new Date(),new Date(),"888 บ้านเล็ก",genderRepository.findById(2),provinceRepository.findById(62),relativesStatusRepository.findById(1),dataOlderRepository.findById(4)));
			visitorRepository.save(new Visitor("นายสมหมาย มีไห","1987138901123",25,"0123455559",new Date(),new Date(),"9/1 บ้านใน",genderRepository.findById(1),provinceRepository.findById(22),relativesStatusRepository.findById(2),dataOlderRepository.findById(1)));
			visitorRepository.save(new Visitor("นางสมใจ ไม่มี","1110923823411",39,"0878734529",new Date(),new Date(),"101 หลังบ้าน",genderRepository.findById(2),provinceRepository.findById(44),relativesStatusRepository.findById(3),dataOlderRepository.findById(2)));
			visitorRepository.save(new Visitor("นางสมหญิง ไม่รู้","1212341234343",50,"0498798674",new Date(),new Date(),"581 บนบ้าน",genderRepository.findById(2),provinceRepository.findById(28),relativesStatusRepository.findById(3),dataOlderRepository.findById(3)));


			//<!==========  TypeHealthCheck ==========!>
			Stream.of("ตรวจร่างกายทั่วไป", "ตรวจสุขภาพช่องปาก", "ตรวจการได้ยิน", "ตรวจสุขภาพประจำปี", "ตรวจสุขภาพด้วยเอกซเรย์").forEach(typename -> {
				typeHealthCheckRepository.save(new TypeHealthCheck(typename));
			});
			//<!==========  END TypeHealthCheck ==========!>

			//<!==========  HealthCheck ==========!>
			healthCheckRepository.save(new HealthCheck("โรงพยาบาลมหาวิทยาลัยเทคโนโลยีสุรนารี",new Date(118,1,1),1000 ,"เจ็บหน้า",typeHealthCheckRepository.findById(1),dataOlderRepository.findById(1)));
			healthCheckRepository.save(new HealthCheck("โรงพยาบาลเกษมราษฏร์",new Date(118,2,2),2000 ,"เจ็บหัว",typeHealthCheckRepository.findById(2),dataOlderRepository.findById(2)));
			healthCheckRepository.save(new HealthCheck("โรงพยาบาลจุฬารัตน์",new Date(118,3,3),3000 ,"เจ็บแขน",typeHealthCheckRepository.findById(3),dataOlderRepository.findById(3)));
			healthCheckRepository.save(new HealthCheck("โรงพยาบาลพญาไท",new Date(118,4,4),4000 ,"เจ็บขา" ,typeHealthCheckRepository.findById(4),dataOlderRepository.findById(4)));

			//<!==========  END HealthCheck ==========!>

			//<!==========  OlderDataAndDisease ==========!>
			olderDataAndDiseaseRepository.save(new OlderDataAndDisease(dataOlderRepository.findById(1),olderDiseaseRepository.findById(1)));
			olderDataAndDiseaseRepository.save(new OlderDataAndDisease(dataOlderRepository.findById(1),olderDiseaseRepository.findById(2)));
			olderDataAndDiseaseRepository.save(new OlderDataAndDisease(dataOlderRepository.findById(2),olderDiseaseRepository.findById(2)));
			olderDataAndDiseaseRepository.save(new OlderDataAndDisease(dataOlderRepository.findById(2),olderDiseaseRepository.findById(3)));
			olderDataAndDiseaseRepository.save(new OlderDataAndDisease(dataOlderRepository.findById(3),olderDiseaseRepository.findById(4)));
			olderDataAndDiseaseRepository.save(new OlderDataAndDisease(dataOlderRepository.findById(4),olderDiseaseRepository.findById(5)));
			olderDataAndDiseaseRepository.save(new OlderDataAndDisease(dataOlderRepository.findById(5),olderDiseaseRepository.findById(6)));
			olderDataAndDiseaseRepository.save(new OlderDataAndDisease(dataOlderRepository.findById(6),olderDiseaseRepository.findById(1)));
			olderDataAndDiseaseRepository.save(new OlderDataAndDisease(dataOlderRepository.findById(7),olderDiseaseRepository.findById(2)));
			olderDataAndDiseaseRepository.save(new OlderDataAndDisease(dataOlderRepository.findById(8),olderDiseaseRepository.findById(3)));
			olderDataAndDiseaseRepository.save(new OlderDataAndDisease(dataOlderRepository.findById(9),olderDiseaseRepository.findById(4)));
			olderDataAndDiseaseRepository.save(new OlderDataAndDisease(dataOlderRepository.findById(10),olderDiseaseRepository.findById(5)));

			//<!==========  END OlderDataAndDisease ==========!>

			//<!==================== TrainStaff ====================!>

			Stream.of("การแพทย์", "วิทยาศาสตร์สุขภาพ","ทักษะงานฝีมือ").forEach(typeName -> {
				trainTypeRepository.save(new TrainType(typeName));
			});


			TrainStaff T1 = new TrainStaff();
			T1.setTrainName("อมรมฝึกสอนฉีดยา");
			T1.setTrainDescription("การอบรมฝึกสอนวิธีการฉีดยาผู้สูงอายุตลอดจนถึงการดูแลรักษาอุปกรณื");
			T1.setTrainDate(new Date(118,2,9));
			T1.setTrainTime(timeDurationRepository.findById(8));
			T1.setTrainType(trainTypeRepository.findById(1));
			T1.setTrainStaff(staffRepository.findById(1));
			trainStaffRepository.save(T1);
			//<!================= END!! TrainStaff =================!>

			//<!==========  Add MaintenceStatus ==========!>
			Stream.of("อยู่ระหว่างการซ่อมบำรุง", "ซ่อมบำรุงสำเร็จ").forEach(statusName -> {
				maintenanceStatusRepository.save(new MaintenanceStatus(statusName));
			});
			//<!==========  END MaintenceStatus ==========!>

			//<!==========  Add Place ==========!>
			placeRepository.save(new Place("โถงกิจกรรม","โซนA ชั้น1"));
			placeRepository.save(new Place("โถงกิจกรรม","โซนฺB ชั้น1"));
			placeRepository.save(new Place("โถงกิจกรรม","โซนC ชั้น1"));
			placeRepository.save(new Place("โถงกิจกรรม","โซนA ชั้น2"));
			placeRepository.save(new Place("โถงกิจกรรม","โซนฺB ชั้น2"));
			placeRepository.save(new Place("โถงกิจกรรม","โซนC ชั้น2"));
			placeRepository.save(new Place("ห้องพักA101","โซนห้องพัก ชั้น1"));
			placeRepository.save(new Place("ห้องพักA102","โซนห้องพัก ชั้น1"));
			placeRepository.save(new Place("ห้องพักA103","โซนห้องพัก ชั้น1"));
			placeRepository.save(new Place("ห้องพักA104","โซนห้องพัก ชั้น1"));
			placeRepository.save(new Place("ห้องพักA105","โซนห้องพัก ชั้น1"));
			placeRepository.save(new Place("ห้องน้ำชาย","โซนA ชั้น1"));
			placeRepository.save(new Place("ห้องน้ำหญิง","โซนA ชั้น1"));
			placeRepository.save(new Place("ห้องน้ำชาย","โซนB ชั้น1"));
			placeRepository.save(new Place("ห้องน้ำหญิง","โซนB ชั้น1"));
			placeRepository.save(new Place("ห้องน้ำชาย","โซนC ชั้น1"));
			placeRepository.save(new Place("ห้องน้ำหญิง","โซนC ชั้น1"));
			placeRepository.save(new Place("ห้องน้ำชาย","โซนA ชั้น2"));
			placeRepository.save(new Place("ห้องน้ำหญิง","โซนA ชั้น2"));
			placeRepository.save(new Place("ห้องน้ำชาย","โซนB ชั้น2"));
			placeRepository.save(new Place("ห้องน้ำหญิง","โซนB ชั้น2"));
			placeRepository.save(new Place("ห้องน้ำชาย","โซนC ชั้น2"));
			placeRepository.save(new Place("ห้องน้ำหญิง","โซนC ชั้น2"));
			//<!==========  END Place ==========!>

			//<!==========  Add Maintenance ==========!>
			SimpleDateFormat formatterForMaintenance = new SimpleDateFormat("dd.MM.yyyy HH");
			Maintenance newMaintenance01 = new Maintenance();
			newMaintenance01.setMaintenanceName("ซ่อมเครื่องเสียง");
			newMaintenance01.setDescription("มันติดๆดับๆ");
			newMaintenance01.setDateStart(new Date(2019-1900,0,5));
			newMaintenance01.setTimeStart(new Date(0,0,0,12,0));
			newMaintenance01.setStatus(maintenanceStatusRepository.findById(1));
			newMaintenance01.setStaff(staffRepository.findById(1));
			newMaintenance01.setPlace(placeRepository.findById(1));

			maintenanceRepository.save(newMaintenance01);
			//<!==========  END Maintenance ==========!>
		};
	}
}
