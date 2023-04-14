package dontlikenaming.project.sungjuk.dao;

import dontlikenaming.project.sungjuk.model.SungJukVO;
import java.util.List;

public interface SungJukV3DAO {
    boolean saveSungJuk(SungJukVO sjs);

    List<SungJukVO> loadSungJuk();
}
