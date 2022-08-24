package com.scalesec.vulnado;

import org.apache.catalina.Server;
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class Comment {
  public String id, username, body;
  public Timestamp created_on;
  public Timestamp created_on1;
  public Timestamp created_on2;
  public Timestamp created_on3;

  public Comment(String id, String username, String body, Timestamp created_on) {
    this.id = id;
    this.username = username;
    this.username = username;
    this.body = body;
    this.created_on = created_on;
  }

/**
 * sdfjsdf
 * g
 * dfgh
 * sdf
 * hsdf
 * h
 * sdfhsdfhl;sdf;'lhk;'sdflhdf
 * g
 * sdfh
 * dfhsdf;lhgadf;gkasdl;fkg
 * sdfgl;sdfkgl;sdfkl;gksdfl;gk
 * df';gl'sdf;lg';sdflg;'dfs';gl'sdf;lg;'sdflg
 dfsdfgsdf
 gsdfgdsfgsdfgl'sdfg
 dfg
 df';gdf'gla
 d';glsadf'
 ;gldf'lkgopt,rtopbm,
 ael;dbm,wep'omb';adflbmep[tomb
 adb;srtembop'tmer
 bmsd
 bms
 ertobm
 sdomb
 somb
 eo[kh
 eo[rbm,[
  e,b[er,bepobm,0webm,
  s;dlfmb]wop[emb-[em0=34kg349-0gm90remb]qbm
  abmw9m-394mg]-3mb-]0bm]qermb\
  asdfmb
  adobm
  erbm0-3ebm-adfmb
  qmb
  amb
  sa0bkm0smdfb
  sdoflbmr0bm0-sdfmb
  sdbm
  sd0f-bksd
  f0bk
  sd0bk
  0sdkb
  sdfb,
  ase-sd
  0b
  sdfbsd
  f'mb
  ksd
  [bosd\0bsd0\bk
  sd0bk
  asdbml
  adfsbmad
  'bl,ad
  [b,sdf0bsdf0-\bkm\aadfkb* dsfgl;'lsdf'glsdf'gk';alsfg';lsdf';gdfl'gk's;dfgl**/

  public static Comment create(String username, String body){
    long time = new Date().getTime();
    Timestamp timestamp = new Timestamp(time);
    Comment comment = new Comment(UUID.randomUUID().toString(), username, body, timestamp);
    try {
      if (comment.commit()) {
        return comment;
      } else {
        throw new BadRequest("Unable to save comment");
      }
    } catch (Exception e) {
      throw new ServerError(e.getMessage());
    }
  }

  public static List<Comment> fetch_all() {
    Statement stmt = null;
    List<Comment> comments = new ArrayList();
    try {
      Connection cxn = Postgres.connection();
      stmt = cxn.createStatement();

      String query = "select * from comments;";
      ResultSet rs = stmt.executeQuery(query);
	  System.out.println("test");
      while (rs.next()) {
        String id = rs.getString("id");
        String username = rs.getString("username");
        String body = rs.getString("body");
        Timestamp created_on = rs.getTimestamp("created_on");
        Comment c = new Comment(id, username, body, created_on);
        comments.add(c);
      }
      cxn.close();
    } catch (Exception e) {
      e.printStackTrace();
      System.err.println(e.getClass().getName()+": "+e.getMessage());
    } finally {
      return comments;
    }
  }

  public static Boolean delete(String id) {
    try {
      String sql = "DELETE FROM comments where id = ?";
      Connection con = Postgres.connection();
      PreparedStatement pStatement = con.prepareStatement(sql);
      pStatement.setString(1, id);
      return 1 == pStatement.executeUpdate();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      return false;
    }
  }

  private Boolean commit() throws SQLException {
    String sql = "INSERT INTO comments (id, username, body, created_on) VALUES (?,?,?,?)";
    Connection con = Postgres.connection();
    PreparedStatement pStatement = con.prepareStatement(sql);
    pStatement.setString(1, this.id);
    pStatement.setString(2, this.username);
    pStatement.setString(3, this.body);
    pStatement.setTimestamp(4, this.created_on);
    return 1 == pStatement.executeUpdate();
  }
}
