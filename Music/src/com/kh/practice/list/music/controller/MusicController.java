package com.kh.practice.list.music.controller;

import java.util.ArrayList;
import java.util.List;

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
		// TODO
		return null;
	}
	public Music setMusic(String title, Music music) {
		// TODO
		return null;
	}
	public int ascTitle() {
		int result = 0;
		// TODO
		return result;
	}
	public int descSinger() {
		int result = 0;
		// TODO
		return result;
	}
	
}
