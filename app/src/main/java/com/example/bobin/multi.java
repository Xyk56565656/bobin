package com.example.bobin;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class multi extends AppCompatActivity {
    private int[][] resultnum;
    private int playernum;
    private int playernow;
    private int[] gradeint;
    private String[] gradestr;
    private TextView player;
    private int[] cnm= new int[6];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi);
        playernow=0;
    }
    public void cnm(View view){
        finish();
    }
    public void ok(View view){

        EditText editText =(EditText) findViewById(R.id.num);
        int a=Integer.parseInt(editText.getText().toString());
        if (a>1 && a<=100){
            playernum=a;
            resultnum =new int[a][6];
            setContentView(R.layout.multibobin);
            gradeint=new int[a];
            gradestr=new String[a];
            player=findViewById(R.id.player);
            player.setText("player:"+(playernow+1));
        }
    }
    public void begin(View view){
        for(int i=0;i<6;i++){
            int j=new Random().nextInt(5);
            resultnum[playernow][j]++;
            setContentView(R.layout.multibobin2);
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
                switch (j) {
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
        if (resultnum[playernow][3]==4 && resultnum[playernow][0]==2){
            gradeint[playernow]=1;
            gradestr[playernow]="状元插金花";
        }
        else if (resultnum[playernow][3]==6){
            gradeint[playernow]=2;
            gradestr[playernow]="六杯红";
        }
        else if (resultnum[playernow][0]==6){
            gradeint[playernow]=3;
            gradestr[playernow]="遍地锦";
        }
        else if (resultnum[playernow][3]==5){
            gradeint[playernow]=4;
            gradestr[playernow]="五红";
        }
        else if (resultnum[playernow][1]>=5){
            gradeint[playernow]=5;
            gradestr[playernow]="五子登科";
        }
        else if (resultnum[playernow][3]==4){
            gradeint[playernow]=6;
            gradestr[playernow]="四点红";
        }
        else if (resultnum[playernow][0]==1 &&resultnum[playernow][1]==1 &&resultnum[playernow][2]==1 &&resultnum[playernow][3]==1 &&resultnum[playernow][4]==1 &&resultnum[playernow][5]==1 ){
            gradeint[playernow]=7;
            gradestr[playernow]="榜眼";
        }
        else if (resultnum[playernow][3]==3){
            gradeint[playernow]=8;
            gradestr[playernow]="探花";
        }
        else if (resultnum[playernow][1]==4){
            gradeint[playernow]=9;
            gradestr[playernow]="进士";
        }
        else if (resultnum[playernow][3]==2){
            gradeint[playernow]=10;
            gradestr[playernow]="举人";
        }
        else if (resultnum[playernow][3]==1){
            gradeint[playernow]=11;
            gradestr[playernow]="秀才";
        }
        else{
            gradeint[playernow]=12;
            gradestr[playernow]="啥也不是";
        }
        AlertDialog.Builder aaaa= new AlertDialog.Builder(this);
        aaaa.setMessage("恭喜您获得\n"+gradestr[playernow]+"!")
                .create()
                .show();

    }
    public void next(View view){
        String cnmd="";
        for (int i=0;i<playernum;i++){
            cnmd=cnmd+"player:"+(i+1)+"  "+gradestr[i]+"\n";
        }
        if(playernow+1==playernum){
            AlertDialog.Builder aaaa= new AlertDialog.Builder(this);
            aaaa.setMessage(cnmd)
                    .create()
                    .show();
        }
        else{
            playernow++;
            setContentView(R.layout.multibobin);
            player=findViewById(R.id.player);
            player.setText("player:"+(playernow+1));
        }
    }
}
