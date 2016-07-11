package next.controller;

import java.util.HashMap;
import java.util.Map;

public class RequestMapping {
	
	public static Map<String, Controller> map; 
	
	public RequestMapping() {
		map = new HashMap<String, Controller>();
		
		map.put("", new HomeController());
		map.put("/", new HomeController());
		
		map.put("/users/create", new CreateUserController());
		
		map.put("/users/login", new LoginController());
		map.put("/users/loginForm", new LoginController());
		
		map.put("/users/logout", new LogoutController());
		
		map.put("/users", new ListUserController());
		
		map.put("/users/profile", new ProfileController());
		
		map.put("/users/form", new CreateUserController());
		
		map.put("/users/update", new UpdateUserController());
		map.put("/users/updateForm", new UpdateUserController());
	}
	
	public static Controller getController(String url) {
		return map.get(url);
	}

}
