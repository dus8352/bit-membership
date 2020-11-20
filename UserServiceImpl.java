package membership;

public class UserServiceImpl implements UserService {
	
	private UserDto[] users;
	private int count;
	public UserServiceImpl() {
		users = new UserDto[3];
		count = 0;
	}
	
	@Override
	public void join(UserDto user) {
		
		users[count]  = user;
		count++;
	}

	@Override
	public UserDto login(UserDto user) {
		UserDto result = null;
		for(int i = 0; i< count; i++) {
			if(user.getUserId().equals(
					users[i].getUserId()) &&
					user.getPassword().equals(users[0].getPassword())) {
				result = users[i];
				break;
			}
			
		}
		return result;
	}

	@Override
	public void changePw(UserDto user) {
		for(int i = 0; i< count; i++) {
			if(user.getUserId().equals(users[i].getUserId())) {
				users[i].setPassword(user.getPassword());
				break;
			}
		}
	}

	@Override
	public void delete(UserDto user) {
		for(int i = 0; i<count; i++) {
			if(user.getUserId().equals(users[i].getUserId())
					&& user.getPassword().equals(users[i].getPassword())) {
				users[i] = users[count-1];
				users[count-1] = null;
				count--;
				break;
			}
		}
	}

	@Override
	public boolean checkId(String id) {
		boolean flag = false;
		for(int i = 0; i<count; i++) {
			if(id.equals(users[i].getUserId())) {
				flag = true;
				break;
				}
		}
		return flag;
	}

	@Override
	public UserDto mypage(UserDto user) {
		UserDto result = new UserDto();
		for(int i = 0; i<count; i++) {
			if(user.getUserId().equals(users[i].getUserId())) {
				result = users[i];
				break;
			}
		}		
		return result;
	}

	@Override
	public UserDto[] userList() {

		return users;
	}

	@Override
	public UserDto searchId(String id) {
		UserDto user = new UserDto();
		for(int i = 0; i < count; i++) {
			if(id.equals(users[i].getUserId())) {
				user = users[i];
				break;
			}
		}
		return user;
	}

	@Override
	public UserDto[] searchName(String name) {
		int num = 0;
		for(int i = 0; i< count; i++) {
			if(name.equals(users[i].getName())) {
				num++;
			}
		}
		UserDto[] usersWithSameName = new UserDto[num];
		int j = 0;
		for(int i = 0; i< count; i++) {
			if(name.equals(users[i].getName())) {
				usersWithSameName[j] = users[i]; 
				j++;
				if(j==num) {break;}
			}
		}
		return usersWithSameName;
	}

	@Override
	public int count() {
		return count;
	}
}