package dontlikenaming.project.sungjuk.dao;

import dontlikenaming.project.sungjuk.model.SungJukVO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class SungJukV3DAOImpl implements SungJukV3DAO{
    private String fname = "c:/Java/sungjukv3.dat";
    private FileWriter fw = null;
    private FileReader fr = null;
    private BufferedWriter bw = null;
    private BufferedReader br = null;

    // 입력한 성적 데이터를 파일에 저장
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

    // 파일에 저장된 성적 데이터들을 모두 읽어서
    // ArrayList 객체에 저장하고 리턴
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
            System.out.println("성적 데이터 불러오는 중 오류 발생!");
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

    // ArrayList에 저장된 모든 성적 데이터를 파일에 기록
    @Override
    public void writeSunJuk(List<SungJukVO> sj) {
        try {
            fw = new FileWriter(fname);
            bw = new BufferedWriter(fw);

            for(SungJukVO sjs : sj) {
                bw.write(sjs.toString());
            }
            System.out.println("성적 데이터를 기록 중입니다.");

        } catch (Exception ex){
            System.out.println("성적 데이터 기록 중 오류 발생!");
            System.out.println(ex.getMessage());
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
    }
}
