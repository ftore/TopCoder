package srm144dev2.time;
public class Time {

	public String whatTime(int seconds) {
		String time = "";
		
		int hours = seconds / 3600;
		seconds = seconds % 3600;
		int minutes = seconds /  60;
		seconds = seconds % 60;
		int sec = seconds % 60;
		time = hours + ":" + minutes + ":" + sec;
		return time;
	}

}
