package com.gambelingapp.Reservation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gambelingapp.R;
import com.gambelingapp.ReservationObject;

public class ReservationSuccessFragment extends Fragment{
    Button Menu;
    EditText date, time;
    ReservationObject reservationObject;

    public ReservationSuccessFragment() {
        super(R.layout.fragment_reservation_seucsess);
    }
    @SuppressLint("SetTextI18n")
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        reservationObject= (ReservationObject) bundle.getParcelable("ResObj");
        date = (EditText) view.findViewById(R.id.Date);
        time = (EditText) view.findViewById(R.id.Time);
        date.setText("We will see you on "+reservationObject.getDate());
        time.setText("at "+reservationObject.getTime());
        Menu = (Button) view.findViewById(R.id.Menu);

    }

}

