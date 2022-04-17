package com.example.smai;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaActionSound;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends AppCompatActivity {
    private int drawableId;
    private String drawables;
    private Button btnPar;
    private Button btnImpar;
    private Button btnResto;
    private Button btnRs;
    private ImageView btnRotar;
    private ImageView btnRotar2;
    private ImageView img;
    private TextView txt;
    private int rally;
    private String player;
    private int playerID;
    private int zona;
    private int ef;
    private int z0;
    private int z1;
    private int z2;
    private int z3;
    private int zs;
    private int zm;
    private int zlong;
    private int zlet;
    private int es;
    private int zs0;
    private int zs1;
    private int zs2;
    private int ace;
    private int zs02nd;
    private int zs12nd;
    private int zs22nd;
    private int ace2nd;
    private int efrally;
    private int z0rally;
    private int z1rally;
    private int z2rally;
    private int z3rally;
    private int lastbutton;
    private List<String> lz0;
    private List<String> lz1;
    private List<String> lz2;
    private List<String> lz3;
    private List<String> lout;
    private List<String> llet;
    private List<String> lnet;
    private List<String> lserve;
    private List<String> lmid;
    private List<String> llong;
    private List<String> sdelpo;
    private List<String> snadal;
    private List<String> sroger;


    private void InicializarVariables()
    {
        int[]resto=getIntent().getExtras().getIntArray("Resto");
        int[]saque=getIntent().getExtras().getIntArray("Saque");
        int[]rsaque=getIntent().getExtras().getIntArray("RSaque");
        ef=resto[0];
        z0=resto[1];
        z1=resto[2];
        z2=resto[3];
        z3=resto[4];
        efrally=resto[5];
        z0rally=resto[6];
        z1rally=resto[7];
        z2rally=resto[8];
        z3rally=resto[9];
        es=saque[0];
        zs0=saque[1];
        zs1=saque[2];
        zs2=saque[3];
        ace=saque[4];
        zs02nd=saque[5];
        zs12nd=saque[6];
        zs22nd=saque[7];
        ace2nd=saque[8];
        zlet=rsaque[0];
        zs=rsaque[1];
        zm=rsaque[2];
        zlong=rsaque[3];
        player=getIntent().getExtras().getString("Name");
        playerID=0;
        rally=0;
        lastbutton=0;

    }


    private void HitSound(int i)
    {   try{
        String string="";
        MediaPlayer hsound;
        MediaPlayer bounce;
        int id=0;
        switch (i) {
            case 1: string = sroger.get(new Random().nextInt(sroger.size())).toString();break;
            case 2: string = snadal.get(new Random().nextInt(snadal.size())).toString();break;
            default:string = sdelpo.get(new Random().nextInt(sdelpo.size())).toString();break;
        }
        id=getResources().getIdentifier(string,"raw",getPackageName());
        hsound=MediaPlayer.create(this,id);
        hsound.start();
        Thread.sleep(1000);
        bounce=MediaPlayer.create(this,R.raw.bounce);
        bounce.start();
        hsound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                hsound.release();
            }
        });
        bounce.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                bounce.release();
            }
        });
    }   catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void OutSound(int i)
    {   try{
        String string="";
        MediaPlayer hsound;
        MediaPlayer out;
        int id=0;
        switch (i) {
            case 1: string = sroger.get(new Random().nextInt(sroger.size())).toString();break;
            case 2: string = snadal.get(new Random().nextInt(snadal.size())).toString();break;
            default:string = sdelpo.get(new Random().nextInt(sdelpo.size())).toString();break;
        }
        id=getResources().getIdentifier(string,"raw",getPackageName());
        hsound=MediaPlayer.create(this,id);
        hsound.start();
        Thread.sleep(1000);
        if(new Random().nextInt(2)==1)
        out=MediaPlayer.create(this,R.raw.out_01);else out=MediaPlayer.create(this,R.raw.out_02);
        out.start();
        hsound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                hsound.release();
            }
        });
        out.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                out.release();
            }
        });
    }   catch (InterruptedException e) {
        e.printStackTrace();
    }
    }

    private void FaultSound(int i)
    {   try{
        String string="";
        MediaPlayer hsound;
        MediaPlayer fault;
        int id=0;
        switch (i) {
            case 1: string = sroger.get(new Random().nextInt(sroger.size())).toString();break;
            case 2: string = snadal.get(new Random().nextInt(snadal.size())).toString();break;
            default:string = sdelpo.get(new Random().nextInt(sdelpo.size())).toString();break;
        }
        id=getResources().getIdentifier(string,"raw",getPackageName());
        hsound=MediaPlayer.create(this,id);
        hsound.start();
        Thread.sleep(1000);
        fault=MediaPlayer.create(this,R.raw.fault);
        fault.start();
        hsound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                hsound.release();
            }
        });
        fault.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                fault.release();
            }
        });
    }   catch (InterruptedException e) {
        e.printStackTrace();
    }
    }

    private void AceSound()
    {
        MediaPlayer ace;
        ace=MediaPlayer.create(this,R.raw.ace);
        ace.start();
        ace.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                ace.release();
            }
        });

    }

    private void CrowdSound()
    {
        MediaPlayer media;
        media=MediaPlayer.create(this,R.raw.crowd);
        media.start();
        media.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                media.release();
            }
        });

    }
    private void NetSound(int i)
    {
        try{
            String string="";
            MediaPlayer hsound;
            MediaPlayer net;
            int id=0;
            switch (i) {
                case 1: string = sroger.get(new Random().nextInt(sroger.size())).toString();break;
                case 2: string = snadal.get(new Random().nextInt(snadal.size())).toString();break;
                default:string = sdelpo.get(new Random().nextInt(sdelpo.size())).toString();break;
            }
            id=getResources().getIdentifier(string,"raw",getPackageName());
            hsound=MediaPlayer.create(this,id);
            hsound.start();
            Thread.sleep(700);
            net=MediaPlayer.create(this,R.raw.net);
            net.start();
            hsound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    hsound.release();
                }
            });
            net.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    net.release();
                }
            });
        }   catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int Zona(int ef,int z0,int z1,int z2,int z3)
    {
        //String random = "sm_init";

        int indice=-1;
        int rngz;
        int rng = new Random().nextInt(101);
        if(rng<=ef) {
            int[] prob ={z0, z1, z2, z3};
            int[] acc = {prob[0], prob[1] + prob[0], prob[2] + prob[1] + prob[0], prob[3] + prob[2] + prob[1] + prob[0]};
            rngz = new Random().nextInt(101);
          // Toast.makeText(this,Integer.toString(rngz), Toast.LENGTH_LONG).show();

            for (int i = 0; i < 4; i++) {
                if (acc[i] >= rngz) {
                    indice = i;
                    break;
                }
            }
        }
        else{
            if ((new Random().nextInt(2))==1) indice=-1;else indice=-2;
        }

          return indice;
    }

    private String Resto(int indice)
    {   String string = "sm_init";
        switch (indice)
        {
            case 0:string=lz0.get(new Random().nextInt(lz0.size())).toString();break;
            case 1:string=lz1.get(new Random().nextInt(lz1.size())).toString();break;
            case 2:string=lz2.get(new Random().nextInt(lz2.size())).toString();break;
            case 3:string=lz3.get(new Random().nextInt(lz3.size())).toString();break;
            case -1:string=lout.get(new Random().nextInt(lout.size())).toString();break;
            default:string=lnet.get(new Random().nextInt(lnet.size())).toString();break;
        }

        return string;

    }

    private String RestarSaque(int indice)
    {   String string = "sm_init";
        switch (indice)
        {
            case 0:string=llet.get(new Random().nextInt(llet.size())).toString();break;
            case 1:string=lserve.get(new Random().nextInt(lserve.size())).toString();break;
            case 2:string=lmid.get(new Random().nextInt(lmid.size())).toString();break;
            case 3:string=llong.get(new Random().nextInt(llong.size())).toString();break;
            case -1:string=lout.get(new Random().nextInt(lout.size())).toString();break;
            default:string=lnet.get(new Random().nextInt(lnet.size())).toString();break;
        }

        return string;

    }

    private String SaquePar(int indice)
    {   String string="sm_init";
        switch (indice)
        {
            case 0:string="sm_00_serve";break;
            case 1:if((new Random().nextInt(2))==1)
                        string="sm_10_serve_drop";
                        else string="sm_12_serve";break;
            case 2:string="sm_20_serve_drop";break;
            case 3:if((new Random().nextInt(2))==1)
                        string="sm_ace2";
                        else string="sm_ace";break;
            case -1:string=lmid.get(new Random().nextInt(lmid.size())).toString();break;
            default:string=lnet.get(new Random().nextInt(lnet.size())).toString();break;
        }

        return string;
    }

    private String SaqueImpar(int indice)
    {   String string="sm_init";
        switch (indice)
        {
            case 0:string="sm_01_serve";break;
            case 1:if((new Random().nextInt(2))==1)
                        string="sm_11_serve_drop";
                        else string="sm_13_serve";break;
            case 2:string="sm_21_serve_drop";break;
            case 3:if((new Random().nextInt(2))==1)
                    string="sm_ace2";
                    else string="sm_ace3";break;
            case -1:string=lmid.get(new Random().nextInt(lmid.size())).toString();break;
            default:string=lnet.get(new Random().nextInt(lnet.size())).toString();break;
        }

        return string;
    }

    private void CrearListaDelpo()
    {
        sdelpo=new ArrayList<String>();
        sdelpo.add("delpotro_01");
        sdelpo.add("delpotro_02");
        sdelpo.add("serve_03");
        sdelpo.add("stroke_03");
    }

    private void CrearListaNadal()
    {
        snadal=new ArrayList<String>();
        snadal.add("nadal");
        snadal.add("serve_02");
        snadal.add("stroke_02");
    }
    private void CrearListaRoger()
    {
        sroger=new ArrayList<String>();
        sroger.add("federer");
        sroger.add("serve_01");
        sroger.add("stroke_01");
    }

    private void CrearListaZona0()
    {
        lz0=new ArrayList<String>();
        lz0.add("sm_00_serve");
        lz0.add("sm_01_serve");
        lz0.add("sm_02_mid");
        lz0.add("sm_03_mid");
        lz0.add("sm_04_mid");
    }

    private void CrearListaZona1()
    {
        lz1=new ArrayList<String>();
        lz1.add("sm_10_serve_drop");
        lz1.add("sm_11_serve_drop");
        lz1.add("sm_12_serve");
        lz1.add("sm_13_serve");
        lz1.add("sm_14_mid");
        lz1.add("sm_15_mid");
        lz1.add("sm_16_mid");
        lz1.add("sm_17_mid");
    }
    private void CrearListaZona2()
    {
        lz2=new ArrayList<String>();
        lz2.add("sm_20_serve_drop");
        lz2.add("sm_21_serve_drop");
        lz2.add("sm_22_mid");
        lz2.add("sm_23_mid");
        lz2.add("sm_24_long");
        lz2.add("sm_25_long");
        lz2.add("sm_26_long");
        lz2.add("sm_let2");
    }
    private void CrearListaZona3() {
        lz3=new ArrayList<String>();
        lz3.add("sm_30_long");
        lz3.add("sm_31_long");
        lz3.add("sm_let");
        lz3.add("sm_let3");
    }

    private void CrearListaOut()
    {
        lout=new ArrayList<String>();
        lout.add("sm_out");
        lout.add("sm_out2");
        lout.add("sm_out3");
        lout.add("sm_out4");
        lout.add("sm_out5");
        lout.add("sm_out6");
        lout.add("sm_out7");
        lout.add("sm_out8");
        lout.add("sm_out9");
    }

    private void CrearListaLet()
    {
        llet=new ArrayList<String>();
        llet.add("sm_let");
        llet.add("sm_let2");
        llet.add("sm_let3");
    }

    private void CrearListaNet()
    {
        lnet=new ArrayList<String>();
        lnet.add("sm_net");
        lnet.add("sm_net2");
        lnet.add("sm_net3");
    }

    private void CrearListaServe()
    {
        lserve=new ArrayList<String>();
        lserve.add("sm_00_serve");
        lserve.add("sm_10_serve_drop");
        lserve.add("sm_20_serve_drop");
        lserve.add("sm_01_serve");
        lserve.add("sm_11_serve_drop");
        lserve.add("sm_21_serve_drop");
    }

    private  void CrearListaMid()
    {
        lmid=new ArrayList<String>();
        lmid.add("sm_02_mid");
        lmid.add("sm_03_mid");
        lmid.add("sm_04_mid");
        lmid.add("sm_14_mid");
        lmid.add("sm_15_mid");
        lmid.add("sm_16_mid");
        lmid.add("sm_17_mid");
        lmid.add("sm_22_mid");
        lmid.add("sm_23_mid");

    }
    private  void CrearListaLong()
    {
        llong=new ArrayList<String>();
        llong.add("sm_24_long");
        llong.add("sm_25_long");
        llong.add("sm_26_long");
        llong.add("sm_30_long");
        llong.add("sm_31_long");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().hide();
        CrearListaLet();
        CrearListaLong();
        CrearListaMid();
        CrearListaNet();
        CrearListaOut();
        CrearListaServe();
        CrearListaZona0();
        CrearListaZona1();
        CrearListaZona2();
        CrearListaZona3();
        CrearListaDelpo();
        CrearListaRoger();
        CrearListaNadal();
        InicializarVariables();
        if(player.equals("FEDERER")) playerID=1;
        if(player.equals("NADAL")) playerID=2;
        if(player.equals("DEL POTRO")) playerID=3;
        txt=findViewById(R.id.txt);
        txt.setText(player);
        btnRotar2=findViewById(R.id.btnRotar2);
        btnRotar=findViewById(R.id.btnRotar);
        btnPar=findViewById(R.id.btnPar);
        btnImpar=findViewById(R.id.btnImpar);
        btnResto=findViewById(R.id.btnResto);
        btnRs=findViewById(R.id.btnRs);
        img=findViewById(R.id.img);
        btnRotar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setRotation(img.getRotation()+180);
            }
        });
        btnRotar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setRotation(img.getRotation()+180);
            }
        });
        btnPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rally=0;
                txt.setText(player);
                if (lastbutton==btnPar.getId()) zona=Zona(es,zs02nd,zs12nd,zs22nd,ace2nd);
                else zona=Zona(es,zs0,zs1,zs2,ace);
                if(zona>=0 && zona<3) HitSound(playerID);
                if(zona==3) {HitSound(playerID);txt.setText("ACE!");}
                if(zona==-1) {FaultSound(playerID);txt.setText("FAULT!");}
                if(zona==-2) {NetSound(playerID);}
                drawables=SaquePar(zona);
                drawableId= getResources().getIdentifier(drawables,"drawable",getPackageName());
                img.setImageResource(drawableId);
                if(zona==3)AceSound();
                lastbutton=btnPar.getId();

            }
        });
        btnImpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rally=0;
                txt.setText(player);
                if (lastbutton==btnImpar.getId()) zona=Zona(es,zs02nd,zs12nd,zs22nd,ace2nd);
                else zona=Zona(es,zs0,zs1,zs2,ace);
                if(zona>=0 && zona<3) HitSound(playerID);
                if(zona==3) {HitSound(playerID);txt.setText("ACE!");}
                if(zona==-1) {FaultSound(playerID);txt.setText("FAULT!");}
                if(zona==-2) {NetSound(playerID);}
                drawables=SaqueImpar(zona);
                drawableId= getResources().getIdentifier(drawables,"drawable",getPackageName());
                img.setImageResource(drawableId);
                if(zona==3)AceSound();
                lastbutton=btnImpar.getId();
            }
        });
        btnResto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(player);
                if(rally>7) zona=Zona(efrally,z0rally,z1rally,z2rally,z3rally);
                    else zona=Zona(ef,z0,z1,z2,z3);
                if (zona>=0) {HitSound(playerID);rally=rally+1;}
                if (zona==-1){OutSound(playerID);txt.setText("OUT!");}
                if (zona==-2)NetSound(playerID);
                drawables=Resto(zona);
                drawableId= getResources().getIdentifier(drawables,"drawable",getPackageName());
                img.setImageResource(drawableId);
                if(drawables=="sm_let"||drawables=="sm_let2"||drawables=="sm_let3") {txt.setText("LET!");CrowdSound();}
                lastbutton=btnResto.getId();

            }

        });
        btnRs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rally=0;
                txt.setText(player);
                zona=Zona(ef,zlet,zs,zm,zlong);
                if (zona>0) HitSound(playerID);
                if (zona==0){HitSound(playerID);CrowdSound();txt.setText("LET!");}
                if (zona==-1){OutSound(playerID);txt.setText("OUT!");}
                if (zona==-2)NetSound(playerID);
                drawables=RestarSaque(zona);
                drawableId= getResources().getIdentifier(drawables,"drawable",getPackageName());
                img.setImageResource(drawableId);
                lastbutton=btnRs.getId();
            }
        });


    }
}