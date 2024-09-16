package Service;

import Bean.User;

public interface userservice {
   public void login();
   public void createaccount();
   public void logout(User user);
   public void accountdata(User user);
   public void accountactivity(User user);
   public void fundtransfer(int amount , String pin , User fromuser,User touser);
   public void withdraw( User user);
   public void changepin(User user);
   public void createlog(User user, String msg);
}
