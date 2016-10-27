package com.mycompany.myweb.service;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.mycompany.myweb.dao.PhotoBoardDao;
import com.mycompany.myweb.dto.PhotoBoard;

@Controller
public class PhotoBoardService {
	private static final int WRITE_SUCCESS=0;
	private static final int WRITE_FAIL=1;
	
	private static final int MODIFY_SUCCESS=0;
	private static final int MODIFY_FAIL=1;
	
	private static final int REMOVE_SUCCESS=0;
	private static final int REMOVE_FAIL=1;
	private PhotoBoardDao photoBoardDao;

	public List<PhotoBoard> list(int pageNo, int rowsPerPage) {

		return photoBoardDao.selectByPage(pageNo, rowsPerPage);
	}

	public int write(PhotoBoard freeBoard) {
		int row = photoBoardDao.insert(freeBoard);
		return WRITE_SUCCESS;
	}

	public int modify(PhotoBoard freeBoard) {
		int row = photoBoardDao.update(freeBoard);
		if (row == 0)
			return MODIFY_FAIL;
		return MODIFY_SUCCESS;
	}

	public int remove(int bno) {
		int row = photoBoardDao.delete(bno);
		if (row == 0)
			return REMOVE_FAIL;
		return REMOVE_SUCCESS;
	}

	public PhotoBoard info(int bno) {
		return photoBoardDao.selectByBno(bno);
	}
}
