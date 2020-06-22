package APITest;

public class Payload {
	  
	// 1.. register successful
	public static String register()
		{
			String payload = "{\r\n" + 
					"    \"email\": \"eve.holt@reqres.in\",\r\n" + 
					"    \"password\": \"pistol\"\r\n" + 
					"}";
	        return payload;
		}

    // 2.. register unsuccessful
	public static String register_unsuccess()
	    {
		String payload = "{\r\n" + 
				"    \"email\": \"sydney@fife\"\r\n" + 
				"}";
        return payload;
	    }   

    // 3..Login Successful
	public static String login()
	{
		String payload = "{\r\n" + 
				"    \"email\": \"eve.holt@reqres.in\",\r\n" + 
				"    \"password\": \"cityslicka\"\r\n" + 
				"}";
        return payload;
	    }   

    // 4..Login unSuccessful
	public static String unsuccessful_login()
	{
		String payload = "{\r\n" + 
				"    \"email\": \"peter@klaven\"\r\n" + 
				"}";
        return payload;
	    }   

	//sending multipledata dynamically.
    public static String  create_multiple_user(String name, String job, int id)
     {
      String payload= "{\r\n" + 
      		"    \"name\": \""+name+"\",\r\n" + 
      		"    \"job\": \""+job+"\",\r\n" + 
      		"    \"id\": "+id+"";
      return payload;
    }

}
