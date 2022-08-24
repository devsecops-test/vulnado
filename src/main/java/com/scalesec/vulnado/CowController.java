package com.scalesec.vulnado;

import org.springframework.web.bind.annotation.*;
import org.springframework.boot.autoconfigure.*;

import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;

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

@RestController
@EnableAutoConfiguration
public class CowController {
    @RequestMapping(value = "/cowsay")
    String cowsay(@RequestParam(defaultValue = "I love Linux!") String input) {
		System.out.println("test");
        return Cowsay.run(input);
    }
}
