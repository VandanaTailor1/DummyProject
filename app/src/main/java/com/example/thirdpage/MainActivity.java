package com.example.thirdpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    DrawerLayout drw;
    NavigationView nvdrw;
     BottomNavigationView bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottom = findViewById(R.id.bottom);
        drw=findViewById(R.id.nvgdrwn);
        bottom.bringToFront();
        nvdrw=findViewById(R.id.nvgview);
        drw.openDrawer(GravityCompat.START);
      img=findViewById(R.id.img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 drw.openDrawer(GravityCompat.START);
            }
        });

        nvdrw.bringToFront();
        nvdrw.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.home){
                    loadFragment(new HomeFragment());
                     drw.closeDrawer(GravityCompat.START);
                }else if(item.getItemId()==R.id.contact){
                    loadFragment(new AccountFragment());
                      drw.closeDrawer(GravityCompat.START);
                }else if(item.getItemId()==R.id.setting){
                    loadFragment(new SettingFragment());
                     drw.closeDrawer(GravityCompat.START);
                }
                return false;
            }
        });

        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.home){
                    loadFragment(new HomeFragment());
                 //   drw.closeDrawer(GravityCompat.START);
                }else if(item.getItemId()==R.id.person){
                    loadFragment(new AccountFragment());
                 //   drw.closeDrawer(GravityCompat.START);
                }else if(item.getItemId()==R.id.setting){
                    loadFragment(new SettingFragment());
                 // drw.closeDrawer(GravityCompat.START);
                }
                return false;
            }
        });
   }
        private void loadFragment(Fragment fragment){
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fm.beginTransaction();
            fragmentTransaction.replace(R.id.framelayout,fragment);
            fragmentTransaction.commit();
    }
}