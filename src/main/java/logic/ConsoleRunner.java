package logic;

import logic.entities.Album;
import logic.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Component
public class ConsoleRunner implements CommandLineRunner  {


    private final UserRepository userRepository;

    @Autowired
    public ConsoleRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        int rnd = new Random().nextInt(100);

        String rmail = "alabala"+rnd+"@abv.bg";
        String ruser = "Ma57eR" + rnd;

    User user = new User(ruser, "123", rmail, LocalDateTime.now(), 20, "Ivan", "Georgiev");
    Album album = new Album("Mega snimka","Black", user);
//    Picture picture = new Picture("First Picture", "This is caption");

        //printUser(user);

        this.userRepository.save(user);

        List<User> allUsers = this.userRepository.findAll();

        allUsers.forEach(u -> System.out.println(u.getAge() + " " + u.getEmail()));

    }

    private void printUser(User user) {
        System.out.printf(
                "Username:              %s%n " +
                        "Email:                 %s%n " +
                        "Date of Registration:  %s%n " +
                        "Age:                   %d%n " +
                        "First Name:            %s%n " +
                        "Last Name:             %s%n",
                user.getUsername(), user.getEmail(), user.getRegisteredOn(),
                user.getAge(), user.getFirstName(), user.getLastName()
        );
    }
}
