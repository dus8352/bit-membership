package membership;

public interface UserDao {
	public void insertUser(UserDto user);
	public UserDto login(UserDto user);
	public void changePwUser(UserDto user);
	public void deleteUser(UserDto user);
	public boolean selectcheckId(String id);
	public UserDto selectUser(UserDto user);
	public UserDto[] selectUser();
	public UserDto selectById(String id);
	public UserDto[] selectByName(String name);
	public int selectcount();
}
