package com.example.animals;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;
    private MediaPlayer player;
    private Animal[] animals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imageView = (ImageView) findViewById(R.id.pic);
        animals = new Animal[5];
        animals[0] = new Animal("gorilla", (Button) findViewById(R.id.gorilla), R.drawable.mancey,R.raw.gorilla);
        animals[1] = new Animal("where_am_i", (Button) findViewById(R.id.where_am_i), R.drawable.where_am_i,R.raw.azoly_is_blind);
        animals[2] = new Animal("get_out", (Button) findViewById(R.id.get_out), R.drawable.get_out,R.raw.get_out);
        animals[3] = new Animal("gay_hoter", (Button) findViewById(R.id.gay_hoter), R.drawable.gay_hoter,R.raw.gay_hoter);
        animals[4] = new Animal("dadon_meow", (Button) findViewById(R.id.dadon_meow), R.drawable.dadon_meow,R.raw.dadon_mew);
        for(int i = 0; i < animals.length; i++)
        {
            animals[i].getButton().setOnClickListener(this);
            animals[i].getButton().setText(animals[i].getName());
            //oskdf
        }
        player = null;
    }

    @Override
    public void onClick(View v) {
        for(int i = 0; i < animals.length; i++)
        {
            if(v == animals[i].getButton()){
                imageView.setImageResource(animals[i].getPicture());
                if(player != null){
                    if(player.isPlaying() == true){
                        player.reset();
                    }
                }
                player = new MediaPlayer();
                player = MediaPlayer.create(this,animals[i].getSound());
                player.start();
            }
        }
    }
}