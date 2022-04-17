package com.example.smai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView fed;
    ImageView nad;
    ImageView del;
    String player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        fed=findViewById(R.id.roger);
        nad=findViewById(R.id.nadal);
        del=findViewById(R.id.delpo);
        fed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] RRoger={80,25,40,25,10,70,25,40,25,10};
                int[] SRoger={85,5,20,60,15,20,50,25,5};
                int[] RsRoger={5,10,70,15};
                player="FEDERER";
                Intent i=new Intent(getApplicationContext(),Game.class);
                i.putExtra("Resto",RRoger);
                i.putExtra("Saque",SRoger);
                i.putExtra("RSaque",RsRoger);
                i.putExtra("Name",player);
                startActivity(i);
            }
        });
        nad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player="NADAL";
                int[]RNadal={90,35,35,20,10,90,35,35,20,10};
                int[]SNadal={80,35,40,20,5,40,40,18,2};
                int[]RsNadal={7,13,10,70};
                Intent i=new Intent(getApplicationContext(),Game.class);
                i.putExtra("Resto",RNadal);
                i.putExtra("Saque",SNadal);
                i.putExtra("RSaque",RsNadal);
                i.putExtra("Name",player);
                startActivity(i);
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player="DEL POTRO";
                int[]RDelpo={70,20,35,35,10,55,10,25,45,20};
                int[]SDelpo={85,10,25,55,10,20,55,20,5};
                int[]RsDelpo={10,20,50,20};
                Intent i=new Intent(getApplicationContext(),Game.class);
                i.putExtra("Resto",RDelpo);
                i.putExtra("Saque",SDelpo);
                i.putExtra("RSaque",RsDelpo);
                i.putExtra("Name",player);
                startActivity(i);
            }
        });
    }
}