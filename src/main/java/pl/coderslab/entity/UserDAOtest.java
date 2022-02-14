package pl.coderslab.entity;

public class UserDAOtest {

    public static void main(String[] args) {

        User user1 = new User();
        user1.setUserName("Tom");
        user1.setEmail("trojnart@hotmail.com");
        user1.setPassword("abc321");
        user1.setId(10);

        UserDao uDao = new UserDao();
//        uDao.create(user1);
        uDao.read(4);
        uDao.update(user1);
    }
}
