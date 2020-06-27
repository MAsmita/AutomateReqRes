package pojo;

public class CreatePost2 {  
	private String name;
	private String job;
	private int id;
	
	public CreatePost2(String name, String job) {
		this.name = name;
		this.job = job;
	}
	
	public String getName() {
		return name;
	}
	public String setName(String name) {
		return this.name = name;
	}
	public String getJob() {
		return job;
	}
	public String setJob(String job) {
		return this.job = job;
		
	}
	public int getId() {
		return id;
	}
	public int setId(int id) {
		return this.id = id;
	}
}
