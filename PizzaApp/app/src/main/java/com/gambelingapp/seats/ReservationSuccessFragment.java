package com.gambelingapp.seats;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.gambelingapp.R;

public class ReservationSuccessFragment extends Fragment implements View.OnClickListener {
    Button Menu;
    public ReservationSuccessFragment() {
        super(R.layout.fragment_reservation_seucsess);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Menu = (Button) view.findViewById(R.id.Menu);
        Menu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        Intent i = new Intent(getApplicationContext(), com.gambelingapp.menu.Menu.class);
//        startActivity(i);
    }
}

