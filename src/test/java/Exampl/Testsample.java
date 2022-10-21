package Exampl;

import java.io.IOException;
import java.util.ArrayList;

public class Testsample {

	public static void main(String[] args) throws IOException {
		Datadr d = new Datadr();
		
		ArrayList<String> data= d.getData("AddPr");
		
		System.out.println(data);
		//System.out.println("data.get(0)");
	}

}
