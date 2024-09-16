package Transfer;

import java.util.Scanner;

import Bean.User;
import Service.userservice;
import Utils.Utils;
import Validate.validateuser;

public class accountfundtransfer implements userservice{
	Scanner scanner = new Scanner(System.in);
	User user1,user2;
	int user,active;
	{
		user1 = new User();
		user2 = new User();
	}
	public void mainmenu() {
	    int user =0 ;
	    if(user1.getUserName()==null) {
	    	user = 1;
	    }
	    else if(user2.getUserName()==null) {
	    	user = 2;
	    }
	    else {
	    	System.out.println("OOPPSS i can only create for two users for now stay tuned.......");
	    }
		System.out.println("");
		if(active !=0) {
			System.out.println("1 Logout");
			System.out.println("2 My account Details");
			System.out.println("3 Account activity");
			System.out.println("4 Fund transfer");
			System.out.println("5 withdraw");
			System.out.println("6 change pin");
			
		}
		
		else {
			System.out.println("1 Login");
			System.out.println("2 Create new account");
		}
		int menuchoice = scanner.nextInt();
		if(active==0) {
			if(menuchoice ==1) {
		
			this.login();
		}
		else {
			this.createaccount();
		}}
	else {
		User temp;
		if(user==1) {
			temp = user1;
		}
		else {
			temp = user2;
		}
		if(menuchoice==1) {
			logout(temp);
		}
		else if(menuchoice ==2) {
		accountdata(temp);	
		}
		else if(menuchoice==3) {
			accountactivity(temp);
		}
		else if(menuchoice == 4) {
		   int amount = scanner.nextInt();
		   String pin = scanner.next();
		   if(user==1) {
			   fundtransfer(amount ,pin , user1, user2);
		   }
		   else {
			   fundtransfer(amount ,pin , user2, user1);
		   }
		}
		else if(menuchoice ==5 ) {
			withdraw(temp);
		}
		else if(menuchoice==6) {
			changepin(temp);
			
		}
		else {
			System.out.println("please enter the correct choice");
		}
	}
	}
	
    public static void main(String args[]) {
    	accountfundtransfer fundtransfer = new accountfundtransfer();
    	fundtransfer.mainmenu();
    }
	
	@Override
	public void createaccount() {
		// TODO Auto-generated method stub

		String accounttype = null;
		System.out.println("--------------------Press 1 to continue any key to exit -----------\n");
		String r = scanner.next();	
	    if(!r.equals("1")) {
	    	return ;
	    }
		System.out.println("--------------------Enter the bank name---------------------------------\n ");
		String bankname = scanner.next();
		if(!validateuser.checkLength(3, bankname, false)) {
		System.out.println("-------------------Bank name must not be invalid or empty----Try again----\n");
			createaccount();
		}
	
		System.out.println("----------------------Enter the customer Full name--------------------------\n ");
		String fullname = scanner.next();
		if(!validateuser.checkLength(3, fullname, false)) {
		System.out.println("-------------------Bank name must not be invalid or empty----------------------\n");
			createaccount();
		}
		System.out.println("Enter the email name ");
		String email = scanner.next();
		if(!validateuser.checkLength(3, email, false)&& validateuser.validateEmail(email)) {
		System.out.println("--------------------------Email must not be invalid or empty---------------------\n");
			createaccount();
		}
		
		System.out.println("-------------------------------Enter the phone number  --------------------------\n ");
		String phonenumber = scanner.next();
		if(!validateuser.checkLength(10, phonenumber, true)) {
			System.out.println("--------------------phonenumber must not be invalid or empty-------------------\n");
			createaccount();
		}
		System.out.println("Enter the ifsc code");
		String ifsc = scanner.next();
		if(!validateuser.checkLength(11, ifsc, true)) {
			System.out.println("------------------------------ifsc must not be invalid or empty-------------------\n");
			createaccount();
		}
		System.out.println("-----------------------------Enter the account type --------------------------------------\n");
	
		
		System.out.println("----------------------------------1 savings account \n 2 current account-------------------\n");
		String acc = scanner.next();
		if(acc.equals("1")) {
			accounttype = "Savings";
		}
		else if(acc.equals("2")) {
			accounttype = "Current";
		}
		else {
			System.out.println("-------------------Please enter the correct type-------------------\n");
			createaccount();
		}
		
		System.out.println("-------------------Enter the amount you want to save-------------------\n");
		int amount = scanner.nextInt();
		
		
		System.out.println("-------------------Enter the 6 digit pin------------------- ");
		String pin = scanner.next();
		if(!validateuser.checkLength(6, pin, true)&&validateuser.validatePassword(pin)) {
			System.out.println("-------------------pin must not be invalid or empty-------------------\\n");
			createaccount();
		}
		System.out.println("-------------------Generating the account number -------------------\n");
		String accountnumber = Utils.generateAccNo();
		
	if(user==1) {	
		user1.setAccountbalance(amount);
		user1.setAccountnumber(accountnumber);
		user1.setBankname(bankname);
		user1.setEmail(email);
		user1.setHistory(Utils.getTimestamp());
		user1.setIfsccode(ifsc);
		user1.setMobile(phonenumber);
		user1.setPassword(pin);
		user1.setUserName(fullname);
		user1.setAccounttype(accounttype);
		this.createlog(user1,"Account created BINGOOOOOOO....");
		accountinfo(user1);
	}
	else {
		user2.setAccountbalance(amount);
		user2.setAccountnumber(accountnumber);
		user2.setBankname(bankname);
		user2.setEmail(email);
		user2.setHistory(Utils.getTimestamp());
		user2.setIfsccode(ifsc);
		user2.setMobile(phonenumber);
		user2.setPassword(pin);
		user2.setUserName(fullname);
		user2.setAccounttype(accounttype);
		this.createlog(user2,"Account created BINGOOOOOOOO...");
		accountinfo(user2);
	}
		
	}
	@Override
	public void login() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to our bank......");
		System.out.println("Enter your account number");
		String accoutnumber = scanner.next();
		if(user1.getAccountnumber().equalsIgnoreCase(accoutnumber)) {
			System.out.println("Please enter your 6 digit pin");
			String pin = scanner.next();
			for(int i =- 0;i<3;i++) {
				if(pin.equalsIgnoreCase(user1.getPassword())) {
					// Pin also correct
					active = 1;
					System.out.println("Account created successfully......");
					createlog(user1,"Account logged in "+Utils.getTimestamp());
					mainmenu();
				}
				else {
					System.out.println("you have entered the wrong pin you have "+(2-i)+ " atttemmpts press 1 to try again");
					int tryagain = scanner.nextInt();
					if(tryagain!=1||i==2) {
						return;
					}
				}
			}
		}
		else if(user2.getAccountnumber().equalsIgnoreCase(accoutnumber)) {
			// user2 name crct password .....
			System.out.println("Please enter your 6 digit pin");
			String pin = scanner.next();
			for(int i =- 0;i<3;i++) {
				if(pin.equalsIgnoreCase(user2.getPassword())) {
					// Pin also correct
					active = 1;
					System.out.println("Account logged in successfully");
					createlog(user2,"Account logged in "+Utils.getTimestamp());
					mainmenu();
				}
				else {
					System.out.println("you have entered the wrong pin you have "+(2-i)+ " atttemmpts press 1 to try again");
					int tryagain = scanner.nextInt();
					if(tryagain!=1||i==2) {
						return;
					}
				}
			}
		}
		else {
			System.out.println("No such user exist thankks for using our service");
			return;
		}
		
	}
	@Override
	public void logout(User user) {
		
	}
	@Override
	public void accountdata(User user) {
		// TODO Auto-generated method stub
		accountinfo(user);
		
	}
	@Override
	public void accountactivity(User user) {
		// TODO Auto-generated method stub
	  System.out.println(user.getHistory());
		
	}
	@Override
	public void fundtransfer(int amount , String pin, User from , User to) {
		// TODO Auto-generated method stub
		if(validateuser.verifyPin(pin,from)){
			if(amount>from.getAccountbalance()) {
				System.out.println(" Insufficient balance try again");
				
			}
			else {
				from.setAccountbalance(from.getAccountbalance()-amount);
				to.setAccountbalance(to.getAccountbalance()+amount);
				System.out.println("_____________SUCCESSFUL TRANSACTION________________");
				System.out.println("Available balance of "+from.getUserName()+" is : "+from.getAccountbalance() );
				System.out.println("Available balance of "+to.getUserName()+" is : "+to.getAccountbalance() );
				createlog(from, amount+" Transferred to "+ to.getUserName() + " on "+Utils.getTimestamp());
				createlog(to,amount + " is Credited by " + from.getUserName()+" on "+Utils.getTimestamp());
				mainmenu();
			}
		}
		else {
			System.out.println("Incorrect password try again");
            return;
		}
		
	}
	@Override
	public void withdraw( User user) {
		System.out.println("PLease enter the amount you wish to withdraw");
		int amount = scanner.nextInt();
		System.out.println("Please enter ur 6 digit pin ");
		String pin= scanner.next();
		
		// TODO Auto-generated method stub
		if(validateuser.verifyPin(pin,user)) {
			if(amount>user.getAccountbalance()){
				System.out.println("Insuffficient balance");
			}
			else {
				user.setAccountbalance(user.getAccountbalance()-amount);
				createlog(user,amount + " is withdrawl from your account on "+Utils.getTimestamp());
				System.out.println(amount + " Has been withdrawl successfully thanks ");
				mainmenu();
			}
		}
		else {
			System.out.println(" Wrong password please try again......");
		}
		
	}
	@Override
	public void changepin(User user) {
		// TODO Auto-generated method stub
		System.out.println("------------Enter the pin please -------");
		String pin = scanner.next();
		if(validateuser.verifyPin(pin, user)) {
			System.out.println("Please eneter the new pin ");
			String newpin = scanner.next();
			System.out.println("Please reenter the password to confirm");
			String confirm = scanner.next();
			if(newpin.equals(confirm)) {
				user.setPassword(newpin);
			}
			else {
				System.out.println(" Passwords dont match try again");
			}
			
		}
		else {
			System.out.println("Wrong password");
		}
		
	}
	@Override
	public void createlog(User user,String msg) {
		String history;
		if(user.getHistory()==null) {
			history = " ";
		}
		else {
			history = user.getHistory();
		}
		user.setHistory(msg+" on "+ Utils.getTimestamp()+"\n"+history);
	}
	
	
	
	public void accountinfo(User user) {
		System.out.println("-----------*******-------------");
		System.out.println("-----------***[ Account Created Successfully ]***-------------");
		System.out.println("!! Account Detail !!");
		System.out.println("!!~ Bank Name => " + user.getBankname());
		System.out.println("!!~ Account Name => " + user.getUserName());
		System.out.println("!!~ Account Email => " + user.getEmail());
		System.out.println("!!~ Mobile Number => " + user.getMobile());
		System.out.println("!!~ Account Number => " + user.getAccountnumber());
		System.out.println("!!~ Account Balance => " + user.getAccountbalance());
		System.out.println("!!~ Account Type => " + user.getAccounttype());
		System.out.println("!!~ IFSC Code => " + user.getIfsccode());
		System.out.println("!!~ Account Pin => " + user.getPassword());
		System.out.println("-----------*******-------------");
		this.mainmenu();
	
	
	}
}
