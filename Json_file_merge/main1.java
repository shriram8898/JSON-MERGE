import java.io.*;
import java.util.*;
import com.google.gson.*;
import java.lang.reflect.*;
import com.google.gson.reflect.*;
class Employee{
  private String id;
  private String name;
  private String age;
  private String phone;
  private String salary;
  private String designation;
  public void setId(String id){
    this.id=id;
  }
  public String getId(){
    return this.id;
  }
  public void setName(String name){
    this.name=name;
  }
  public String getName(){
    return this.name;
  }
  public void setAge(String age){
    this.age=age;
  }
  public String getAge(){
    return this.age;
  }
  public void setPhone(String phone){
    this.phone=phone;
  }
  public String getPhone(){
    return this.phone;
  }
  public  void setSalary(String salary){
    this.salary=salary;
  }
  public String getSalary(){
    return this.salary;
  }
  public void setDesignation(String designation){
    this.designation=designation;
  }
  public String getDesignation(){
    return this.designation;
  }
  public String toString(){
    return id+"\t"+name+"\t\t"+salary+"\t"+designation;
  }
}
class main1{
	public static void main(String args[])throws Exception{
		String path,base_file_name,temp,save_file_name,merge;
		int file_count=1,count=0,file_size,count1=0,choice;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the path");
		path=input.next();																	//Getting the folder path             Eg.D:/freshworks/employee/
		System.out.println("Enter the base file name");
		base_file_name=input.next();														//Getting the base_file_name          Eg.emp
		System.out.println("Enter the save file name");
 		save_file_name=input.next();													//Getting output file name for only once  Eg.merge
		System.out.println("Enter the size");
		file_size=input.nextInt();															//Getting file size                   Eg.300(in bytes)
		input.nextLine();
		while(true){
		count1++;count=0;
		File f = new File(path);  									
		File[] files = f.listFiles();
		if (files != null)
		for (int i = 0; i < files.length; i++) {
        count++;																			//counting the number of json file present in path that much files to be merged  
		File file = files[i];

        if (file.isDirectory()) {   
             count--; 
        }
		}
        HashMap<String,strikers> hm;
		HashMap<String,strikers> hm1=new HashMap<>();
		Gson gson = new Gson();
		for(int j=1;j<=count;j++){
		temp=path+base_file_name+j+".json";
		BufferedReader br = new BufferedReader(new FileReader(temp));
		Type hmType = new TypeToken<HashMap<String,Employee>>(){}.getType();  
		hm = gson.fromJson(br,hmType);														//reading a json file to hashmap 
		hm1.putAll(hm);																		//combining all json files hashmap into single hashmap
		}
		merge=save_file_name+count1+".json";
		FileWriter writer = new FileWriter(merge);
		String json = gson.toJson(hm1);
		writer.write(json);																	//creating a json file basedd on op file name and writting the hashmap to it
		writer.close();
		File file=new File(merge);
		if(file.length()>file_size)															//Checking for the file size
			System.out.println("File size is exceded");
		else
			System.out.println("file size is not exceeded");
	System.out.println("Do YOU WANT TO CONTINUE\n1.YES\n2.NO");
    choice=input.nextInt();
	if(choice==2)
		break;
	else
	{
		System.out.println("Enter the path");
		path=input.next();																	//Getting the folder path
		System.out.println("Enter the base file name");
		base_file_name=input.next();														//Getting the base_file_name
		System.out.println("Enter the size");
		file_size=input.nextInt();
	}
	}
	}
}