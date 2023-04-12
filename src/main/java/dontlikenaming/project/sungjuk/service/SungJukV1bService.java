package dontlikenaming.project.sungjuk.service;

import dontlikenaming.project.sungjuk.model.SungJukVO;

public interface SungJukV1bService {
    String displayMenu();
    void processMenu(String selectMenu);
    void newSungJuk();
    void computeSungJuk(SungJukVO sj);
    void readSungJuk();
    void readOneSungJuk();
    void modifySungJuk();
    void removeSungJuk();
}

