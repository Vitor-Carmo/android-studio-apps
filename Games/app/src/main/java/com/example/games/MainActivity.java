package com.example.games;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    int[] G_IMAGES = {
            R.drawable.dota,
            R.drawable.fifa19,
            R.drawable.fortnite,
            R.drawable.gfw,
            R.drawable.gta,
            R.drawable.lol,
            R.drawable.street_fighter,
            R.drawable.toram,
            R.drawable.skyrim
    };

    String[] G_NAMES = {
            "Dota",
            "Fifa 2019",
            "Fortnite",
            "God of War",
            "Grand Theft Auto V",
            "League of Legends",
            "Street Fighter",
            "Toram online",
            "Skyrim"
    };

    String[] G_GENRE = {
            "Arena de batalha online multiplayer",
            "Esporte/Simulação",
            "Vários",
            "Ação-aventura",
            "Ação-Aventura",
            "Arena de batalha online multiplayer",
            "Jogo de luta",
            "MMO RPG mobile multiplayer",
            "RPG eletrônico de ação"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mLvGames= (ListView) findViewById(R.id.lv_games);

        GameAdapter gameAdapter = new GameAdapter();
        mLvGames.setAdapter(gameAdapter);



        //crating the games
//        Game skyrim = new Game("Skyrim", "RPG eletrônico de ação", R.drawable.skyrim);
//        Game gta = new Game("Grand Theft Auto V", "Ação-Aventura", R.drawable.gta);
//        Game godOfWar = new Game("God of War", "Ação-aventura", R.drawable.gfw);
//        Game streetFighter = new Game("Street Fighter IV", "Jogo de luta", R.drawable.street_fighter);
//        Game lol = new Game("League of Legends", "Arena de batalha online multiplayer", R.drawable.lol);
//        Game toram = new Game("Toram Online", "MMO RPG mobile multiplayer", R.drawable.toram);
//        Game fifa19 = new Game("Fifa 2019", "Esporte/Simulação", R.drawable.fifa19);
//        Game fortnite = new Game("Fortinite", "Vários", R.drawable.fortnite);
//        Game dota = new Game("Dota", "Arena de batalha online multiplayer", R.drawable.dota);


//        ArrayList<Game> gameArrayList = new ArrayList<>();
//        gameArrayList.add(skyrim);
//        gameArrayList.add(gta);
//        gameArrayList.add(godOfWar);
//        gameArrayList.add(streetFighter);
//        gameArrayList.add(lol);
//        gameArrayList.add(toram);
//        gameArrayList.add(fifa19);
//        gameArrayList.add(fortnite);
//        gameArrayList.add(dota);



        //GameListAdapter adapter = new GameListAdapter(this, R.layout.adapter_view_layout, gameArrayList);
        //mLvGames.setAdapter(adapter);
    }




    public class GameAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return G_IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.adapter_view_layout, null, true);

            ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
            TextView txtTitle = (TextView) convertView.findViewById(R.id.txt_title);
            TextView txtGenre = (TextView) convertView.findViewById(R.id.txt_genre);

            imageView.setImageResource(G_IMAGES[position]);
            txtTitle.setText(G_NAMES[position]);
            txtGenre.setText(G_GENRE[position]);

            return convertView;
        }
    }


}
