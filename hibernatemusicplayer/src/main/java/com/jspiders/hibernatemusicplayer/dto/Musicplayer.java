package com.jspiders.hibernatemusicplayer.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Musicplayer {
	
	@Id
	private int id;
	private String songname;
	private String songMovie;
	private String songSinger;
	private String songLyricist;
	private String songDuration;

}
