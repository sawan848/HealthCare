package org.java.healthcare.Activity;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import org.java.healthcare.R;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {

    private ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        imageSlider=findViewById(R.id.imageSlider);

        ArrayList<SlideModel>slideModels=new ArrayList<>();
        slideModels.add(new SlideModel("https://images.pexels.com/photos/4033148/pexels-photo-4033148.jpeg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://images.pexels.com/photos/236380/pexels-photo-236380.jpeg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://reliabledelivery.com/wp-content/uploads/2014/11/bigstock-Medical-physician-doctor-woma-101147165.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://images.pexels.com/photos/139398/thermometer-headache-pain-pills-139398.jpeg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://images.pexels.com/photos/1250655/pexels-photo-1250655.jpeg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://images.pexels.com/photos/247786/pexels-photo-247786.jpeg", ScaleTypes.FIT));
        imageSlider.setImageList(slideModels,ScaleTypes.FIT);

        CardView cardViewDoctor=findViewById(R.id.homeCardViewDoctor);
        CardView cardViewHospital=findViewById(R.id.homeCardViewHospital);
        CardView cardViewBloodBank=findViewById(R.id.homeCardViewBloodBank);
        CardView cardViewPharmacy=findViewById(R.id.homeCardFindPharmacy);
        CardView cardViewAmbulance=findViewById(R.id.homeCardViewAmbulance);



        cardViewDoctor.setOnClickListener(view -> {
            startActivity(new Intent(HomeActivity.this,DoctorActivity.class));
        });
        cardViewHospital.setOnClickListener(view -> {
            startActivity(new Intent(HomeActivity.this,HospitalActivity.class));
        });
        cardViewBloodBank.setOnClickListener(view -> {
            startActivity(new Intent(HomeActivity.this,BloodBankActivity.class));
        });
        cardViewPharmacy.setOnClickListener(view -> {
            startActivity(new Intent(HomeActivity.this,PharmacyActivity.class));
        });
        cardViewAmbulance.setOnClickListener(view -> {
            startActivity(new Intent(HomeActivity.this,AmbulanceActivity.class));
        });




//
//        logout.setOnClickListener(view -> {
//            SharedPreferences.Editor editor=sharedPreferences.edit();
//            editor.clear();
//            editor.apply();
//            Toast.makeText(getApplicationContext(), "logout successfull", Toast.LENGTH_SHORT).show();
//            startActivity(new Intent(HomeActivity.this,SignInActivity.class));
//
//        });



    }


}