package com.kh.practice.list.music.controller;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.kh.practice.list.music.model.compare.AscTitle;
import com.kh.practice.list.music.model.vo.Music;

public class MusicController {
	private List<Music>	list = new ArrayList<Music>();
	
	public MusicController() {
	// list에 초기값 10곡 미리 입력해두기
		list.add(new Music("aa", "aaa"));
		list.add(new Music("bb", "bbb"));
		list.add(new Music("cc", "ccc"));
		list.add(new Music("dd", "ddd"));
		list.add(new Music("ee", "eee"));
		list.add(new Music("ff", "fff"));
		list.add(new Music("gg", "ggg"));
		list.add(new Music("hh", "hhh"));
		list.add(new Music("ii", "iii"));
		list.add(new Music("jj", "jjj"));
	}
	
	public int addList(Music music) {
		// ****** 마지막 위치에 곡 추가 ******
		int result = 0;	// 0:추가실패, 1:추가성공
		if(list.add(music)) {	// 추가
			result = 1;
		}
		return result;
	}
	public int addAtZero(Music music) {
		// ****** 첫 위치에 곡 추가 ******
		int result = 0; // 0:추가실패, 1:추가성공
		int cnt = list.size();
		((ArrayList<Music>)list).add(0, music);
		int cntAfter = list.size();
		if(cnt < cntAfter) {
			result = 1; 
		}
		return result;
	}
	public List<Music> printAll(){
		// TODO
		return list;
	}
	public Music searchMusic(String title) {
		Music result = null;
		for(Music vo : list) {
			if(vo.getTitle().equals(title)) {
				result = vo;
				break;
			}
		}
		return result;
	}
	public Music removeMusic(String title) {
		Music result = null;
		for(Music vo : list) {
			if(vo.getTitle().equals(title)) {
				list.remove(vo);
				result = vo;
				break;
			}
		}
		return result;
	}
	public Music setMusic(String title, Music music) {
		Music result = null;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				result = list.get(i);
				list.set(i,  music);
				break;
			}
		}
//		for(Music vo : list) {
//			if(vo.getTitle().equals(title) ) {	// title이 같은 것을 찾아
//				result = vo;					// 찾은 Music 객체 vo를 return 하면 됨.
////				vo = music; - 불가능 / vo는 for문의 새로운 지역변수로 list와는 무관한 공간임.
//				int findidx = list.indexOf(vo);
//				list.set(findidx, music);
//				break;
//			}
//		}
		return result;
	}
	public int ascTitle() {
		int result = 0;
		try {
		for(int i=0; i<list.size()-1; i++) {
			for(int j=0; j<list.size()-1-i; j++) {
				if(list.get(j).getTitle().compareTo(list.get(j+1).getTitle())>0) {		//오름차순
//				if(list.get(j).getTitle().compareTo(list.get(j+1).getTitle())<0) {		//내림차순
					// Swap
					Music tmp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, tmp);
				}
				}
			}
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int descSinger() {
		// 착각하지 말자 list에서 singer는 없다. list의 1개 객체에서 singer가 있다.
		// 즉, list.get(0).getSinger();
		int result = 0;
		try {
			for(int i=0; i<list.size()-1; i++) {
				for(int j=0; j<list.size()-1-i; j++) {
//					if(list.get(j).compareTo(nameArr[j+1]) > 0) {		//오름차순
					if(list.get(j).getSinger().compareTo(list.get(j+1).getSinger())<0){		//내림차순
						// 정렬기준은 list의 Music 형태의 객체 중 signer 값으로 비교함.
						// Swap // list에 있는 Music 형태의 객체를 swap
						Music tmp = list.get(j);
						list.set(j, list.get(j+1));
						list.set(j+1, tmp);
					}
				}
			}
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int ascTitle2() {
		int result = 1;
//		ArrayList<Music> arrlist = new ArrayList<Music>();
//		arrlist.add(new Music("a","vb"));
//		list.removeAll(arrlist);
		
		try {
			Collections.sort(list, new AscTitle());
		} catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public int descSinger2() {
		int result = 0;
		Collections.sort(list);
		return result;
	}
	
	public int saveFile(String filepath) {
		int result = 0; // 0 : 저장실패, 1 : 저장성공
		
		// filePath에 list의 Music 객체들을 저장함.
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		BufferedOutputStream bos = null;
		try {
			 fos = new FileOutputStream(filepath);
			 bos = new BufferedOutputStream(fos);
			 oos = new ObjectOutputStream(bos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bos!=null) bos.close();
				if(oos!=null) oos.close();
				if(fos!=null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
}





















