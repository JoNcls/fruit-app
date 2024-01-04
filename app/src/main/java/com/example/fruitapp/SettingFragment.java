package com.example.fruitapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.fruitapp.helper.DBHelper;

public class SettingFragment extends Fragment {

    private TextView tV_Username;
    private EditText eT_OldPass, eT_NewPass, eT_ConfirmNewPass;
    private Button btn_ChangePass, btn_Logout, btn_DeleteAccount;

    private DBHelper dbHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, null);

        tV_Username = (TextView) view.findViewById(R.id.tV_Username);
        eT_OldPass = (EditText) view.findViewById(R.id.eT_OldPassword);
        eT_NewPass = (EditText) view.findViewById(R.id.eT_NewPassword);
        eT_ConfirmNewPass = (EditText) view.findViewById(R.id.eT_ConfirmPassword);
        btn_ChangePass = (Button) view.findViewById(R.id.btn_ChangePassword);
        btn_Logout = (Button) view.findViewById(R.id.btn_Logout);
        btn_DeleteAccount = (Button) view.findViewById(R.id.btn_DeleteAccount);

        dbHelper = new DBHelper(getActivity());
        String username = dbHelper.GetSession();

        tV_Username.setText("Your username: " + username);

        btn_ChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangePassword();
            }
        });

        btn_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.Logout();
                MainIntent();
            }
        });

        btn_DeleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = dbHelper.GetSession();
                dbHelper.Logout();
                dbHelper.DeteleAccount(username);
                MainIntent();
            }
        });

        return view;
    }

    private void ChangePassword(){
        String OldPassword = eT_OldPass.getText().toString();
        String NewPassword = eT_NewPass.getText().toString();
        String ConfirmNewPassword = eT_ConfirmNewPass.getText().toString();
        String CurrentPassword = dbHelper.GetPassword(dbHelper.GetSession());

        if (OldPassword.isEmpty() || NewPassword.isEmpty() || ConfirmNewPassword.isEmpty()){
            Toast.makeText(getActivity(), "Old Password, New Password and Confirm New Password Fields are Required", Toast.LENGTH_SHORT).show();
        }
        else if (!NewPassword.equals(ConfirmNewPassword))
        {
            Toast.makeText(getActivity(), "New Password and Confirm New Password must equal", Toast.LENGTH_SHORT).show();
        }
        else if (!OldPassword.equals(CurrentPassword))
        {
            Toast.makeText(getActivity(), "Old Password is wrong", Toast.LENGTH_SHORT).show();
        }
        else
        {
            dbHelper.ChangePassword(dbHelper.GetSession(), NewPassword);
            eT_OldPass.setText("");
            eT_NewPass.setText("");
            eT_ConfirmNewPass.setText("");
            Toast.makeText(getActivity(), "Success change password", Toast.LENGTH_SHORT).show();
        }
    }

    private void MainIntent(){
        Intent mainIntent = new Intent(getActivity(), MainActivity.class);
        startActivity(mainIntent);
    }

}
