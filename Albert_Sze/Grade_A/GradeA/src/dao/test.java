package dao;

public class test {


    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
//        userDAO.insert("jing","1234",new String[]{"q1","q2","q3"},new String[]{"a1","a2","a3"});
        for(String str:userDAO.getSecurityInfo("jing")){
            System.out.println(str);
        }
    }
}
