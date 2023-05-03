package com.jspiders.hibernatemusicplayer.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.jspiders.hibernatemusicplayer.dto.Musicplayer;

public class Operations {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Scanner scanner=new Scanner(System.in);
	private static Query query;
	private static String jpqlQuery;
	
	
	private static void openConnection(){
		
		factory=Persistence.createEntityManagerFactory("musicplayer");
		
		manager=factory.createEntityManager();
		
		transaction=manager.getTransaction();
		
	}
	
	private static void closeConnection() {
		
		if (factory !=null) {
			factory.close();
			
		}
		if (manager !=null) {
			manager.close();
			
		}
		if (transaction.isActive()) {
			transaction.rollback();
			
		}
	}
	
	private static void addSong() {
		
		
		
		
			
	        openConnection();
			
			transaction.begin();
			
			Musicplayer song=new Musicplayer();
			
			System.out.println("Add ID For Song");
			int id=scanner.nextInt();
			song.setId(id);
			
			System.out.println("Add Name For Song");
			String name=scanner.next();
			song.setSongname(name);
			
			System.out.println("Add Movie Of Song");
			String movie =scanner.next();
			song.setSongMovie(movie);
			
			System.out.println("Add Singer Of Song");
			String singer=scanner.next();
			song.setSongSinger(singer);
			
			System.out.println("Add Lyricist Of Song");
			String lyricist=scanner.next();
			song.setSongLyricist(lyricist);
			
			System.out.println("Add Duration For Song");
			String duration=scanner.next();
			song.setSongDuration(duration);
			
			
			manager.persist(song);
			
			
			transaction.commit();
			System.out.println("Song Added Succesfully");
			
			
			closeConnection();
			
		
		
	}
	
	private static void removeSong() {
		
		
		
			
			openConnection();
			
			transaction.begin();
			
			System.out.println("Enter Id Of Song Which You Want To Delete");
			int id=scanner.nextInt();
			
	        Musicplayer song=manager.find(Musicplayer.class, id);
			
			manager.remove(song);
			
			transaction.commit();
			
			closeConnection();
		
	}
	
	private static void editWholeSong(){
		
		
        openConnection();
		
		transaction.begin();
		
		Musicplayer song=new Musicplayer();
		
		System.out.println("Enter Id Of Song Which You Want To Edit");
		int id1=scanner.nextInt();
		
        song=manager.find(Musicplayer.class, id1);
		
		System.out.println("Enter New Duration Of Song ");
		String duration=scanner.next();
		song.setSongDuration(duration);
		
		System.out.println("Enter New Lyricist Of Song ");
		String lyricist=scanner.next();
		song.setSongLyricist(lyricist);
		
		System.out.println("Enter New Singer Of Song ");
		String singer=scanner.next();
		song.setSongSinger(singer);
		
		System.out.println("Enter New Movie Of Song ");
		String movie=scanner.next();
		song.setSongMovie(movie);
		
		System.out.println("Enter New Name Of Song ");
		String name=scanner.next();
		song.setSongname(name);
		
		System.out.println("Enter ID Of Song ");
		int id=scanner.nextInt();
		song.setId(id);
		
		
		manager.persist(song);
		
		transaction.commit();
		
		closeConnection();
		
	    }

private static void displayAllSongs() {
	
	
    openConnection();
	
	transaction.begin();
	
	Musicplayer song=new Musicplayer();
	
	jpqlQuery="from Musicplayer";
	
	query=manager.createQuery(jpqlQuery);
	
	List<Musicplayer>resultList=query.getResultList();
	
	for (Musicplayer musicplayer : resultList) {
		
		System.out.println(musicplayer);
		
	}
	
	
	
	
	transaction.commit();
	
	closeConnection();
	
	
	
}

public static void addOrRemo(){
	System.out.println("-----Menu-----");
	System.out.println("1.Add Song");
	System.out.println("2.Remove  Song");
	System.out.println("3.Back");
    System.out.println("----Choose The Option-------");
    int ip2=scanner.nextInt();
    switch (ip2)
	  {
	  case 1:{
		addSong();
		break;
	  }
	  case 2:{
    removeSong();
    break;
	  }
	  case 3:{
		back();
		break;
	  }
	  
		
	}
}
	public static void playSong(){
		System.out.println("-----Menu-----");
		System.out.println("1.Play All Songs");
		System.out.println("2.Choose Songs");
		//System.out.println("3.Shuffle");
		System.out.println("3.Back");
      System.out.println("----Choose The Option-------");
      int ip3=scanner.nextInt();
		switch (ip3)
	  {
	  case 1:{
		playAllSongs();
		
	  break;
	  }
	  
	  case 2:{
	 chooseSong();
	  break;
	  }
	  
	  //case 3:{
		//shuffle();
		// break;

	 // }
	 
	case 3:{
		 back();
	  break;
	  }
	  
	  
		
	}
}
	
	
	



	public static void exit(){
		MusicplayerDAO.bool=false;
		System.out.println("You Are Exited Succesfully");
		
	}
	
public static void playAllSongs() {
    	
	   
		displayAllSongs();
		System.out.println(" id 1 Song Is Playing Now");
	}
  	
public static void chooseSong(){
  		 
  		openConnection();
  		
  		transaction.begin();
  		
  		System.out.println("Choose Id Of Song You Want To See");
  		int id=scanner.nextInt();
  		
  		
  	   Musicplayer song=manager.find(Musicplayer.class, id);
  	   System.out.println(song);
  	
  	    transaction.commit();
  	
         closeConnection();
  		
  		
  	}
  	public static void back() {
  		MusicplayerDAO.menu();
  		
  	}
  	
  	
  	public static void editSong(){
  		
  		editWholeSong();
  		
  		
  	}
	
	

}
