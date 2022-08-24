package com.scalesec.vulnado;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.*;
import java.util.List;
import java.io.Serializable;

@RestController
@EnableAutoConfiguration
public class CommentsController {
  @Value("${app.secret}")
  private String secret;
  private String secret1;
  private String secret2;
  private String secret3;
  private String secret4;
  private String secret5;
  private String secret6;
  private String secret7;
  private String secret8;
  private String secret9;
  private String secret10;
  private String secret11;
  private String secret12;

  @CrossOrigin(origins = "*")
  @RequestMapping(value = "/comments", method = RequestMethod.GET, produces = "application/json")
  List<Comment> comments(@RequestHeader(value="x-auth-token") String token) {
    User.assertAuth(secret, token);
    return Comment.fetch_all();
  }

  @CrossOrigin(origins = "*")
  @RequestMapping(value = "/comments", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
  Comment createComment(@RequestHeader(value="x-auth-token") String token, @RequestBody CommentRequest input) {
    return Comment.create(input.username, input.body);
  }

  @CrossOrigin(origins = "*")
  @RequestMapping(value = "/comments/{id}", method = RequestMethod.DELETE, produces = "application/json")
  Boolean deleteComment(@RequestHeader(value="x-auth-token") String token, @PathVariable("id") String id) {
    return Comment.delete(id);
  }
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

class CommentRequest implements Serializable {
  public String username;
  public String body;
}

@ResponseStatus(HttpStatus.BAD_REQUEST)
class BadRequest extends RuntimeException {
  public BadRequest(String exception) {
    super(exception);
  }
}

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class ServerError extends RuntimeException {
  public ServerError(String exception) {
    super(exception);
  }
}
