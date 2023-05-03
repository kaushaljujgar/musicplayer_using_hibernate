package com.jspiders.hibernatemusicplayer.dao;

import java.util.Scanner;

public class MusicplayerDAO {
	
MusicplayerDAO musicplayerDAO=new MusicplayerDAO();
	
	static Scanner scanner=new Scanner(System.in);
	
	public static  boolean bool=true;
	
	
	public static void menu() {
		
			  //for changing the option we must have o use while loop.
			  while(bool){ 
				  System.out.println("1.Add/Remove Song");
					System.out.println("2.Play Song"); 
					System.out.println("3.Edit Song");
					System.out.println("4.Exit");
					int ip=scanner.nextInt();
				  switch(ip)
				  {
				  case 1:{
					  Operations.addOrRemo();
					
					break;
				  }
				  
				  case 2:{
					  Operations.playSong();
					  break;
				  }
				  
				  case 3:{
					  Operations.editSong();
					  break;
				  }
				  
				  case 4:{
					  Operations.exit();
					  break;
				  }
				 
				  }
			  }
		}
		 
	
	 public static void main(String[] args) {
		 menu();
	 }
			


}
