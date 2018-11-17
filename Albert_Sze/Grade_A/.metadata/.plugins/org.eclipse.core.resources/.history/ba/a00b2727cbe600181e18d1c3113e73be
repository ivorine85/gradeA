import java.util.*; 

public class Testing extends Adjustments{

	public static void main(String[] args) {
		// Load list of profiles
		//if (profileList
		Scanner scan_test = new Scanner(System.in).useLocale(Locale.US);  // Reading from System.in
		String answer = "null";
		String answer2 = "null";
		boolean valid = false;
		ArrayList<Profile> profileList = new ArrayList<Profile> (1);
		ArrayList<String> usernameList = new ArrayList<String> (1);
		
		System.out.println("Select Option");
		for (int i=0; i<usernameList.size();i++) {
			System.out.print((i+1) + ". ");
			System.out.println(usernameList.get(i));
		}
		System.out.print((usernameList.size()+1) + ". ");
		System.out.println("Create new user");
		System.out.print("choose: ");
		answer = scan_test.next();
		
		profileList.add(Createuser());
		usernameList.add(profileList.get(profileList.size()-1).getUsername());
		
		System.out.println(" ");
		System.out.println("Select Option");
		for (int i=0; i<usernameList.size();i++) {
			System.out.print((i+1) + ". ");
			System.out.println(usernameList.get(i));
		}
		System.out.print((usernameList.size()+1) + ". ");
		System.out.println("Create new user");
		System.out.print("choose: ");
		answer = scan_test.next();
		
		if (Integer.parseInt(answer) != usernameList.size()+1) {
			System.out.println(usernameList.get(Integer.parseInt(answer)-1));
			System.out.print("Enter Password: ");
			answer2 = scan_test.next();
			valid = Checklogin(profileList.get(Integer.parseInt(answer)-1),answer2);
		}
		
		System.out.println(valid);
		
		profileList.set(0, Forgetpassword(profileList.get(0)));
		
		System.out.println(profileList.get(0).getPassword());
		
		
		
	}

}
