package pl.coderslab.entity;

public class UserDAOtest {

    public static void main(String[] args) {

        User user1 = new User();
//        user1.setId(1);
        user1.setUserName("P");
        user1.setEmail("pt@onet.pl");
        user1.setPassword("abc321");

        User user2 = new User();
        user2.setUserName("M");
        user2.setEmail("mt@gmail.com");
        user2.setPassword("123abc");

        User user3 = new User();
        user3.setUserName("T");
        user3.setEmail("tt@hotmail.com");
        user3.setPassword("A1b2c3");


        UserDao uDao = new UserDao();
        uDao.create(user1);
        uDao.create(user2);
        uDao.create(user3);
//        uDao.read(14);
//        uDao.update(user1);
//        uDao.delete(15);
        uDao.findAll();
    }
}
