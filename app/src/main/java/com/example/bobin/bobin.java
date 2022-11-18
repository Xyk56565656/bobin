package com.example.bobin;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.concurrent.Delayed;

public class bobin extends AppCompatActivity {
    private int[] resultnum=new int[6];
    private int[] b= new int[6];
    private int gradeint;
    private String gradestr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bobin);

    }
    public void cli(){
        for(int i=0;i<6;i++){
            resultnum[new Random().nextInt(5)]++;
        }
    }
    public void quit(View view){
        finish();
    }
    public void level(View view){
        AlertDialog.Builder aaaa= new AlertDialog.Builder(this);
        View dailogView =getLayoutInflater().inflate(R.layout.rule,null);
        aaaa.setView(dailogView)
                .create()
                .show();
    }
    void clic(){
        setContentView(R.layout.bobin2);
        for (int i=0;i<6;i++){
            ImageView a=findViewById(R.id.i1);
            switch (i){
                case 0:
                    a=findViewById(R.id.i1);
                    break;
                case 1:
                    a=findViewById(R.id.i2);
                    break;
                case 2:
                    a=findViewById(R.id.i3);
                    break;
                case 3:
                    a=findViewById(R.id.i4);
                    break;
                case 4:
                    a=findViewById(R.id.i5);
                    break;
                case 5:
                    a=findViewById(R.id.i6);
                    break;
            }
            switch (b[i]) {
                case 0:
                    a.setImageResource(R.drawable.s1);
                    break;
                case 1:
                    a.setImageResource(R.drawable.s2);
                    break;
                case 2:
                    a.setImageResource(R.drawable.s3);
                    break;
                case 3:
                    a.setImageResource(R.drawable.s4);
                    break;
                case 4:
                    a.setImageResource(R.drawable.s5);
                    break;
                case 5:
                    a.setImageResource(R.drawable.s6);
                    break;
            }
        }

        AlertDialog.Builder aaaa= new AlertDialog.Builder(this);
        View daig =getLayoutInflater().inflate(R.layout.seibei,null);

        aaaa.setIcon(R.drawable.senbei)
                .setMessage("恭喜您获得\n"+gradestr+"!")
                .setView(daig)
                .create()
                .show();
        ImageView img =daig.findViewById(R.id.senbei114);
        if(gradeint<=6){
            img.setImageResource(R.drawable.senbei_happy);
        }
        else if(gradeint<=11){
            img.setImageResource(R.drawable.senbei);
        }
        else{
            img.setImageResource(R.drawable.senbei_sad);
        }
    }
    public void restart(View view){
        setContentView(R.layout.bobin);
    }
    public void begin(View view){
        for (int i=0;i<6;i++){
            resultnum[i]=0;
        }
        for(int i=1;i<7;i++){
            int j=new Random().nextInt(5);
            resultnum[j]++;
            b[i-1]=j;
        }
        if (resultnum[3]==4 && resultnum[0]==2){
            gradeint=1;
            gradestr="状元插金花";
        }
        else if (resultnum[3]==6){
            gradeint=2;
            gradestr="六杯红";
        }
        else if (resultnum[0]==6){
            gradeint=3;
            gradestr="遍地锦";
        }
        else if (resultnum[3]==5){
            gradeint=4;
            gradestr="五红";
        }
        else if (resultnum[1]>=5){
            gradeint=5;
            gradestr="五子登科";
        }
        else if (resultnum[3]==4){
            gradeint=6;
            gradestr="四点红";
        }
        else if (resultnum[0]==1 &&resultnum[1]==1 &&resultnum[2]==1 &&resultnum[3]==1 &&resultnum[4]==1 &&resultnum[5]==1 ){
            gradeint=7;
            gradestr="榜眼";
        }
        else if (resultnum[3]==3){
            gradeint=8;
            gradestr="探花";
        }
        else if (resultnum[1]==4){
            gradeint=9;
            gradestr="进士";
        }
        else if (resultnum[3]==2){
            gradeint=10;
            gradestr="举人";
        }
        else if (resultnum[3]==1){
            gradeint=11;
            gradestr="秀才";
        }
        else{
            gradeint=12;
            gradestr="啥也不是";
        }
        if (gradeint<=6){
            AlertDialog.Builder aaaa= new AlertDialog.Builder(this);
            View dailogView =getLayoutInflater().inflate(R.layout.seibei_weak,null);
            aaaa.setView(dailogView)
                    .setCancelable(false)
                    .create();
            Dialog dia=aaaa.show();

            new Handler().postDelayed(new Runnable(){
                public void run(){
                    dia.dismiss();
                    clic();
                }},500);

        }
        else{
            clic();
        }


    }

}
