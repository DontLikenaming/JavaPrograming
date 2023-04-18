package dontlikenaming.project.sungjuk.dao;

import dontlikenaming.project.sungjuk.model.SungJukVO;

import java.util.List;

public interface SungJukV4DAO {
    int insertSungJuk(SungJukVO sjs);
    List<SungJukVO> selectSungJuk();
    SungJukVO selectOneSungJuk(int sjnum);
    int updateSungJuk(SungJukVO sjs);
    int deleteSungJuk(int sjnum);
}
