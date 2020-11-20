package membership;

public class UserController {
	private UserService userService;

	public UserController() {
		userService = new UserServiceImpl();
	}

	public void postJoin(UserDto user) {
		userService.join(user);
	}

	public UserDto postLogin(UserDto user) {
		return userService.login(user);
	}

	public void putChangepw(UserDto user) {
		userService.changePw(user);
	}

	public void deleteUser(UserDto user) {
		userService.delete(user);
	}

	public boolean getCheckId(String id) {
		return userService.checkId(id);
	}

	public UserDto getMmypage(UserDto user) {
		return userService.mypage(user);
	}

	public UserDto[] getUserList() {
		return userService.userList();
	}

	public UserDto getSearchId(String id) {
		return userService.searchId(id);
	}

	public UserDto[] getSearchName(String name) {
		return userService.searchName(name);
	}

	public int getCount() {
		return userService.count();
	}
}
