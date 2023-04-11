package dontlikenaming;

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

