package com.gambelingapp.Reservation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.gambelingapp.PizzaStore;
import com.gambelingapp.R;
import com.gambelingapp.ReservationObject;
import com.gambelingapp.database.DataGetter;
import com.gambelingapp.database.OnGetDataListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class PickSeatsFragment extends Fragment {
    ReservationObject reservationObject;
    Button next, skip;
    PizzaStore pizzaRestaurant;

    ArrayList<String> unavailableTables = new ArrayList<>();

    public PickSeatsFragment() {
        super(R.layout.fragment_pick_seats);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        reservationObject = new ReservationObject(getArguments().getString("name"), getArguments().getInt("dinersNum"),
                getArguments().getString("date"), getArguments().getString("time"));
        next = view.findViewById(R.id.next);
        skip = view.findViewById(R.id.skip);
        pizzaRestaurant = ((MainActivity) requireActivity()).pizzaRestaurant;
        setUnavailability();
        setBtn(view);
        // load available table from database according to chosen date and time
        handelLoadedData(view);
    }


    private void handelLoadedData(View view) {
        new DataGetter().readData(reservationObject, new OnGetDataListener() {
            @Override
            public void onStart() {
            }

            @Override
            public void onSuccess(DataSnapshot data) {
                //check available tables according to database and number of diners
                checkAvailability(data);
                //set onClickListener for available tables
                reservationObject.RestaurantHandel(pizzaRestaurant, getContext(), unavailableTables);
                next.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Navigation.findNavController(view).navigate(R.id.action_pickSeatsFragment_to_reservationSuccessFragment);
                    }
                });
                skip.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        selectRandomPlace();
                    }
                });
            }

            @Override
            public void onFailed(DatabaseError databaseError) {
            }
        });

    }

    private void checkAvailability(DataSnapshot data) {
        for (DataSnapshot snapshot : data.getChildren()) {
            String currTable = snapshot.child("Table tag").getValue().toString();
            unavailableTables.add(currTable);
        }
    }

    private void registerReservation() {
        DatabaseReference db = FirebaseDatabase.getInstance().getReference();
        db.child("Reservations").child("date " + reservationObject.getDate())
                .child("time " + reservationObject.getTime()).child("Reservation 1")
                .child("Table tag").setValue(reservationObject.getChosenPlace());
        db.child("Reservations").child("date " + reservationObject.getDate())
                .child("time " + reservationObject.getTime()).child("Reservation 1")
                .child("Number of diners").setValue(reservationObject.getNumOfDiners());
        db.child("Reservations").child("date " + reservationObject.getDate())
                .child("time " + reservationObject.getTime()).child("Reservation 1")
                .child("Name of main diner").setValue(reservationObject.getDinerName());
    }

    private void selectRandomPlace() {
    }

    private void setBtn(View view) {
        pizzaRestaurant.getPlaces().get("pink1").setBtn(view.findViewById(R.id.pinkTable1));
        pizzaRestaurant.getPlaces().get("pink2").setBtn(view.findViewById(R.id.pinkTable2));
        pizzaRestaurant.getPlaces().get("pink3").setBtn(view.findViewById(R.id.pinkTable3));
        pizzaRestaurant.getPlaces().get("blue1").setBtn(view.findViewById(R.id.blueTable1));
        pizzaRestaurant.getPlaces().get("blue2").setBtn(view.findViewById(R.id.blueTable2));
        pizzaRestaurant.getPlaces().get("blue3").setBtn(view.findViewById(R.id.blueTable3));
        pizzaRestaurant.getPlaces().get("blue4").setBtn(view.findViewById(R.id.blueTable4));
        pizzaRestaurant.getPlaces().get("blue5").setBtn(view.findViewById(R.id.blueTable5));
        pizzaRestaurant.getPlaces().get("blue6").setBtn(view.findViewById(R.id.blueTable6));
        pizzaRestaurant.getPlaces().get("blue7").setBtn(view.findViewById(R.id.blueTable7));
        pizzaRestaurant.getPlaces().get("blue8").setBtn(view.findViewById(R.id.blueTable8));
        pizzaRestaurant.getPlaces().get("blue9").setBtn(view.findViewById(R.id.blueTable9));
        pizzaRestaurant.getPlaces().get("blue10").setBtn(view.findViewById(R.id.blueTable10));
        pizzaRestaurant.getPlaces().get("blue11").setBtn(view.findViewById(R.id.blueTable11));
        pizzaRestaurant.getPlaces().get("blue12").setBtn(view.findViewById(R.id.blueTable12));
        pizzaRestaurant.getPlaces().get("green1").setBtn(view.findViewById(R.id.greenTable1));
        pizzaRestaurant.getPlaces().get("green2").setBtn(view.findViewById(R.id.greenTable2));
        pizzaRestaurant.getPlaces().get("green3").setBtn(view.findViewById(R.id.greenTable3));
        pizzaRestaurant.getPlaces().get("green4").setBtn(view.findViewById(R.id.greenTable4));
        pizzaRestaurant.getPlaces().get("orange1").setBtn(view.findViewById(R.id.orangeTable1));
        pizzaRestaurant.getPlaces().get("orange2").setBtn(view.findViewById(R.id.orangeTable2));
        pizzaRestaurant.getPlaces().get("orange3").setBtn(view.findViewById(R.id.orangeTable3));
        pizzaRestaurant.getPlaces().get("orange4").setBtn(view.findViewById(R.id.orangeTable4));
        pizzaRestaurant.getPlaces().get("orange5").setBtn(view.findViewById(R.id.orangeTable5));
    }

    private void setOrangeTableUnavailability() {
        unavailableTables.add("orange1");
        unavailableTables.add("orange2");
        unavailableTables.add("orange3");
        unavailableTables.add("orange4");
        unavailableTables.add("orange5");
    }

    private void setBlueTableUnavailability() {
        unavailableTables.add("blue1");
        unavailableTables.add("blue2");
        unavailableTables.add("blue3");
        unavailableTables.add("blue4");
        unavailableTables.add("blue5");
        unavailableTables.add("blue6");
        unavailableTables.add("blue7");
        unavailableTables.add("blue8");
        unavailableTables.add("blue9");
        unavailableTables.add("blue10");
        unavailableTables.add("blue11");
        unavailableTables.add("blue12");
    }

    private void setPinkTableUnavailability() {
        unavailableTables.add("pink1");
        unavailableTables.add("pink2");
        unavailableTables.add("pink3");
    }

    private void setGreenTableUnavailability() {
        unavailableTables.add("green1");
        unavailableTables.add("green2");
        unavailableTables.add("green3");
        unavailableTables.add("green4");
    }

    private void setUnavailability() {
        if (reservationObject.getNumOfDiners() == 1 || reservationObject.getNumOfDiners() == 2) {
            setBlueTableUnavailability();
            setPinkTableUnavailability();
            setGreenTableUnavailability();
        }
        if (reservationObject.getNumOfDiners() == 3 || reservationObject.getNumOfDiners() == 4) {
            setOrangeTableUnavailability();
            setPinkTableUnavailability();
            setGreenTableUnavailability();
        }
        if (reservationObject.getNumOfDiners() == 5 || reservationObject.getNumOfDiners() == 6) {
            setBlueTableUnavailability();
            setOrangeTableUnavailability();
            setGreenTableUnavailability();
        }
        if (reservationObject.getNumOfDiners() == 7 || reservationObject.getNumOfDiners() == 8) {
            setBlueTableUnavailability();
            setPinkTableUnavailability();
            setOrangeTableUnavailability();
        }
    }
}