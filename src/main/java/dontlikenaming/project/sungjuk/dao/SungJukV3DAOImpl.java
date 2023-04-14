package dontlikenaming.project.sungjuk.dao;

import dontlikenaming.project.sungjuk.model.SungJukVO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SungJukV3DAOImpl implements SungJukV3DAO{
    private String fname = "c:/Java/sungjukv3.dat";
    private FileWriter fw = null;
    private FileReader fr = null;
    private BufferedWriter bw = null;
    private BufferedReader br = null;

    @Override
    public boolean saveSungJuk(SungJukVO sjs) {

        // 생성된 성적 데이터를 파일에 저장
        try {
            // 파일 기록 시 추가(append 기능 활성화)
            fw = new FileWriter(fname, true);
            bw = new BufferedWriter(fw);

            bw.write(sjs.toString());

        } catch (Exception ex){
            System.out.println("성적 데이터 저장 중 오류 발생!");
            System.out.println(ex.getMessage());
            return false;
        } finally {
            if(bw!=null) {
                try {
                    bw.close();
                } catch (Exception ex) {}
            }

            if(fw!=null) {
                try {
                    fw.close();
                } catch (Exception ex) {}
            }
        }
        return true;
    }

    @Override
    public List<SungJukVO> loadSungJuk() {
        List<SungJukVO> sjdata = new ArrayList<>();

        try {
            fr = new FileReader(fname);
            br = new BufferedReader(fr);
            String[] vals = null;

            while (br.ready()){
                // 파일에서 성적 데이터 한 줄을 읽어서
                // SungJuk 객체에 개별 값을 저장하고
                // ArrayList 객체에 저장
                vals = br.readLine().split("\n");

                for(String valOne : vals) {
                    String[] val = valOne.split(", ");

                    SungJukVO sj = new SungJukVO(
                            Integer.parseInt(val[0]),
                            val[1],
                            Integer.parseInt(val[2]),
                            Integer.parseInt(val[3]),
                            Integer.parseInt(val[4]),
                            Integer.parseInt(val[5]),
                            Double.parseDouble(val[6]),
                            val[7].charAt(0),
                            val[8]);

                    sjdata.add(sj);
                }
            }


        } catch (Exception ex){
            System.out.println("성적 데이터 불러오기 중 오류 발생!");
            System.out.println(ex.getMessage());
            return null;
        } finally {
            if(br!=null) {
                try {
                    br.close();
                } catch (Exception ex) {}
            }

            if(fr!=null) {
                try {
                    fr.close();
                } catch (Exception ex) {}
            }
        }
        return sjdata;
    }


}
