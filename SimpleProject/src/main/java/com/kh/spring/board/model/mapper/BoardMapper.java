package com.kh.spring.board.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import com.kh.spring.board.model.dto.BoardDTO;
import com.kh.spring.reply.model.dto.ReplyDTO;

@Mapper
public interface BoardMapper {
	
	void insertBoard(BoardDTO board);
	
	@Select("select COUNT(*) FROM TB_SPRING_BOARD WHERE STATUS ='Y'")
	int selectTotalCount();
	
	List<BoardDTO> selectBoardList(RowBounds rowBounds);
	
	BoardDTO selectBoard(int boardNo);
	
	List<ReplyDTO> selectReply(int boardNo);
	
	BoardDTO selectBoardAndReply(int board);
	
	int updateBoard(BoardDTO board);
	
	int deleteBoard(BoardDTO board);
	
	
	int searchedCount(Map<String, String> map);
	
	List<BoardDTO> SelectSearchList(Map<String,String> map,RowBounds rb);

	int insertReply(ReplyDTO reply);
}
