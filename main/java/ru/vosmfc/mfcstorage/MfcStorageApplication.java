package ru.vosmfc.mfcstorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.vosmfc.mfcstorage.domain.*;
import ru.vosmfc.mfcstorage.repository.*;
import ru.vosmfc.mfcstorage.security.domain.User;
import ru.vosmfc.mfcstorage.security.domain.UserRole;
import ru.vosmfc.mfcstorage.security.repository.UserRepository;
import ru.vosmfc.mfcstorage.security.repository.UserRoleRepository;

// TODO перед переходом на основную базу убрать создание тестовых данных

@SpringBootApplication
public class MfcStorageApplication implements CommandLineRunner {

	@Autowired
	private final DepartmentRepository departmentRepository;

	@Autowired
	private final PositionRepository positionRepository;

	@Autowired
	private final RecipientRepository recipientRepository;

	@Autowired
	private final ItemCategoryRepository itemCategoryRepository;

	@Autowired
	private final ItemRepository itemRepository;

	@Autowired
	private final StorageRepository storageRepository;

	@Autowired
	private final UserRepository userRepository;

	@Autowired
	private final UserRoleRepository userRoleRepository;

	public MfcStorageApplication(DepartmentRepository departmentRepository,
								 PositionRepository positionRepository,
								 RecipientRepository recipientRepository,
								 ItemCategoryRepository itemCategoryRepository,
								 ItemRepository itemRepository,
								 StorageRepository storageRepository,
								 UserRoleRepository userRoleRepository,
								 UserRepository userRepository) {
		this.departmentRepository = departmentRepository;
		this.positionRepository = positionRepository;
		this.recipientRepository = recipientRepository;
		this.itemCategoryRepository = itemCategoryRepository;
		this.itemRepository = itemRepository;
		this.storageRepository = storageRepository;
		this.userRoleRepository = userRoleRepository;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MfcStorageApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// save test departments
		Department department = new Department("ОИиХО");
		Department department1 = new Department("АУП");
		Department department2 = new Department("Отдел приема");
		departmentRepository.save(department);
		departmentRepository.save(department1);
		departmentRepository.save(department2);

		// save test positions
		Position position = new Position("Директор");
		Position position1 = new Position("Системный администратор");
		Position position2 = new Position("Главный специалист(универсальный специалист)");
		positionRepository.save(position);
		positionRepository.save(position1);
		positionRepository.save(position2);

		// save test recipients
		Recipient recipient = new Recipient("Иванов", "Иван", "Иванович", "8-926-735-05-40", department, position);
		Recipient recipient1 = new Recipient("Петров", "Петр", "8-926-735-05-41", department1, position1);
		Recipient recipient2 = new Recipient("Сидоров", "Геннадий", "Петрович", "8-926-735-05-42", department2, position2);
		recipientRepository.save(recipient);
		recipientRepository.save(recipient1);
		recipientRepository.save(recipient2);

		// save test item categories
		ItemCategory itemCategory = new ItemCategory("Картриджи");
		ItemCategory itemCategory1 = new ItemCategory("Канц товары");
		ItemCategory itemCategory2 = new ItemCategory("Бытовые товары");
		itemCategoryRepository.save(itemCategory);
		itemCategoryRepository.save(itemCategory1);
		itemCategoryRepository.save(itemCategory2);

		// save test items
		Item item = new Item("Краска белая", itemCategory2);
		Item item1 = new Item("Карандаши цветные", itemCategory1);
		Item item2 = new Item("DR-3400", itemCategory);
		itemRepository.save(item);
		itemRepository.save(item1);
		itemRepository.save(item2);

		// save test storages
		Storage storage = new Storage(item, 10);
		Storage storage1 = new Storage(item1, 10);
		Storage storage2 = new Storage(item2, 10);
		storageRepository.save(storage);
		storageRepository.save(storage1);
		storageRepository.save(storage2);

		// save test user roles
		UserRole admin = new UserRole("ROLE_ADMIN");
		UserRole user = new UserRole("ROLE_USER");
		userRoleRepository.save(admin);
		userRoleRepository.save(user);

		// save test users
		User userAdmin = new User(
				"admin",
				"$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW",
				"admin",
				"admin",
				"admin",
				"admin@mail.ru",
				true,
				admin);

		User userUser = new User(
				"user",
				"$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue",
				"user",
				"user",
				"user",
				"user@mail.ru",
				true,
				user
		);

		User inactiveUser = new User(
				"inactiveUser",
				"$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue",
				"inactiveUser",
				"inactiveUser",
				"inactiveUser@mail.ru",
				false,
				user
		);

		userRepository.save(userAdmin);
		userRepository.save(userUser);
		userRepository.save(inactiveUser);
	}

}
