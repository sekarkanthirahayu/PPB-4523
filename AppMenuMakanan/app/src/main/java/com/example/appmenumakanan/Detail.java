package com.example.appmenumakanan;

import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.room.foodonline.Database.Database;
import com.room.foodonline.Model.Food;
import com.room.foodonline.Model.Order;
import com.squareup.picasso.Picasso;

public class Detail extends AppCompatActivity {

    TextView food_name,food_price,food_description;
    ImageView food_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;
    ElegantNumberButton numberButton;

    String foodId="";

    FirebaseDatabase database;
    DatabaseReference foods;

    Food curentFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        database = FirebaseDatabase.getInstance();
        foods = database.getReference("Foods");



        numberButton = (ElegantNumberButton)findViewById(R.id.number_button);
        btnCart = (FloatingActionButton)findViewById(R.id.btnCart);

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database(getBaseContext()).addToCart(new Order(
                        foodId,
                        curentFood.getName(),
                        numberButton.getNumber(),
                        curentFood.getPrice(),
                        curentFood.getDiscount()
                ));
                Toast.makeText(FoodDetail.this, "Add to cart", Toast.LENGTH_SHORT).show();
            }
        });

        food_description =  (TextView)findViewById(R.id.food_description);
        food_name =  (TextView)findViewById(R.id.food_name);
        food_price =  (TextView)findViewById(R.id.food_price);
        food_image = (ImageView)findViewById(R.id.img_food);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandeAdapter);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAdapter);


        if(getIntent() != null)
            foodId =  getIntent().getStringExtra("FoodId");
        if(!foodId.isEmpty())
        {
            getDetailFood(foodId);
        }

    }

    private void getDetailFood(final String foodId) {
        foods.child(foodId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                curentFood = dataSnapshot.getValue(Food.class);

                Picasso.with(getBaseContext()).load(curentFood.getImage())
                        .into(food_image);

                collapsingToolbarLayout.setTitle(curentFood.getName());
                food_price.setText(curentFood.getPrice());
                food_name.setText(curentFood.getName());
                food_description.setText(curentFood.getDescription());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
