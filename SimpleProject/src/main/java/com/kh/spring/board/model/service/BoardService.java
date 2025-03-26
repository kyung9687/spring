package com.kh.spring.board.model.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.board.model.dto.BoardDTO;
import com.kh.spring.reply.model.dto.ReplyDTO;

public interface BoardService {

	

		//게시글 작성
		 void insertBoard(BoardDTO board,MultipartFile file, HttpSession session); 
		
		//게시글 목록 조회
		 Map<String, Object> selectBoardList(int currentPage);
		
		
		//게시글 상세보기
		 BoardDTO selectBoard(int boardNo);
		
		//게시글 수정
		 BoardDTO updateBoard(BoardDTO board,MultipartFile file);
		
		//게시글 삭제(딜리트인척하고 업데이트 할것
		 void deleteBoard(int boardNo);

		Map<String, Object> doSearch(Map<String, String> map);
		
		int insertReply(ReplyDTO reply,HttpSession session);
	

}
