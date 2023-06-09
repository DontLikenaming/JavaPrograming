package dontlikenaming.project.sungjuk.dao;

import dontlikenaming.project.sungjuk.model.SungJukVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SungJukV4DAOImpl implements SungJukV4DAO{
    private String insertSjSQL = " insert into sungjuk" +
            " (name, kor, eng ,mat, tot, avg, grd) VALUES (?, ?, ?, ?, ?, ?, ?) ";
    private String selectSjSQL = " select * from sungjuk " +
            " order by sjno asc ";
    private String selectOneSjSQL = " select * from sungjuk " +
            " where sjno = ? ";
    private String updateSjSQL = " update sungjuk set " +
            " kor = ?, eng = ?, mat = ?," +
            " tot = ?, avg = ?, grd = ? " +
            " where sjno = ? ";
    private String deleteSjSQL = " delete from sungjuk where " +
            " sjno = ? ";

    @Override
    public int insertSungJuk(SungJukVO sjs) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int cnt = -1;

        try{
            conn = MariaDB.makeConn();
            pstmt = conn.prepareStatement(insertSjSQL);
            pstmt.setString(1, sjs.getName());
            pstmt.setInt(2, sjs.getKor());
            pstmt.setInt(3, sjs.getEng());
            pstmt.setInt(4, sjs.getMat());
            pstmt.setInt(5, sjs.getTot());
            pstmt.setDouble(6, sjs.getAvg());
            pstmt.setString(7, sjs.getGrd()+"");

            cnt = pstmt.executeUpdate();

        }catch (Exception ex){
            System.out.println("insertSungJuk 에러!");
            ex.printStackTrace();   // 예외의 자세한 내용 출력
        }finally {
            MariaDB.closeConn(null, pstmt, conn);
        }
        return cnt;
    }

    @Override
    public List<SungJukVO> selectSungJuk() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<SungJukVO> sjdata = new ArrayList<>();

        try{
            conn = MariaDB.makeConn();
            pstmt = conn.prepareStatement(selectSjSQL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                SungJukVO sj = new SungJukVO(
                        rs.getInt("sjno"),
                        rs.getString("name"),
                        rs.getInt("kor"),
                        rs.getInt("eng"),
                        rs.getInt("mat"),
                        rs.getInt("tot"),
                        rs.getDouble("avg"),
                        rs.getString("grd").charAt(0),
                        rs.getString("regdate")
                );
                sjdata.add(sj);
            }
        }catch (Exception ex){
            System.out.println("selectSungJuk 에러!");
            ex.printStackTrace();
        }finally {
            MariaDB.closeConn(rs, pstmt, conn);
        }
        return sjdata;
    }

    @Override
    public SungJukVO selectOneSungJuk(int sjnum) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        SungJukVO sj = null;

        try{
            conn = MariaDB.makeConn();
            pstmt = conn.prepareStatement(selectOneSjSQL);
            pstmt.setInt(1, sjnum);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                sj = new SungJukVO(
                        rs.getInt("sjno"),
                        rs.getString("name"),
                        rs.getInt("kor"),
                        rs.getInt("eng"),
                        rs.getInt("mat"),
                        rs.getInt("tot"),
                        rs.getDouble("avg"),
                        rs.getString("grd").charAt(0),
                        rs.getString("regdate")
                );
            }
        }catch (Exception ex){
            System.out.println("selectOneSungJuk 에러!");
            ex.printStackTrace();
        }finally {
            MariaDB.closeConn(rs, pstmt, conn);
        }
        return sj;
    }

    @Override
    public int updateSungJuk(SungJukVO sjs) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int cnt = -1;

        try{
            conn = MariaDB.makeConn();
            pstmt = conn.prepareStatement(updateSjSQL);
            pstmt.setInt(1, sjs.getKor());
            pstmt.setInt(2, sjs.getEng());
            pstmt.setInt(3, sjs.getMat());
            pstmt.setInt(4, sjs.getTot());
            pstmt.setDouble(5, sjs.getAvg());
            pstmt.setString(6, sjs.getGrd()+"");
            pstmt.setInt(7, sjs.getSjno());

            cnt = pstmt.executeUpdate();

        }catch (Exception ex){
            System.out.println("updateSungJuk 에러!");
            ex.printStackTrace();
        }finally {
            MariaDB.closeConn(null, pstmt, conn);
        }
        return cnt;
    }

    @Override
    public int deleteSungJuk(int sjnum) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int cnt = -1;

        try{
            conn = MariaDB.makeConn();
            pstmt = conn.prepareStatement(deleteSjSQL);
            pstmt.setInt(1, sjnum);

            cnt = pstmt.executeUpdate();

        }catch (Exception ex){
            System.out.println("deleteSungJuk 에러!");
            ex.printStackTrace();
        }finally {
            MariaDB.closeConn(null, pstmt, conn);
        }
        return cnt;
    }
}
