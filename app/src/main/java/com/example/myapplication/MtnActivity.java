package com.example.myapplication;

import static com.example.myapplication.R.*;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MtnActivity extends AppCompatActivity {
    private TextInputEditText inputBal,inputSend,inputRem,inputRam,inputTcharge,inputElevy,inputTotalCharge,inputDuctAmount;
    private TextInputLayout hint1,hint2,hint3;
    private CheckBox ppCheck,pmCheck,poCheck;
    private String balVal,sendVal,telVal,elevyVal,tchargeVal,ductVal;
    private double valBal;
    private double valSn;
    private double valDuct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.mtncal);

        inputBal = findViewById(R.id.input1);
        inputSend = findViewById(R.id.input2);
        inputRem = findViewById(id.input3);
        inputRam = findViewById(R.id.input4);
        inputTcharge = findViewById(R.id.input5);
        inputElevy = findViewById(R.id.input6);
        inputTotalCharge = findViewById(R.id.input7);
        inputDuctAmount = findViewById(R.id.input8);

        hint1 = findViewById(R.id.textInputLayout4);

        ppCheck = findViewById(id.checkBox4);
        pmCheck = findViewById(id.checkBox3);
        poCheck = findViewById(id.checkBox2);

        Button calculate = findViewById(R.id.button6);

        calculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkMthod();
                firstMthod();
                secMthod();


                checkerBtn();

            }

            @SuppressLint("SetTextI18n")
            public void firstMthod() {
                if (Objects.requireNonNull(inputBal.getText()).length() > 0) {
                    balVal = inputBal.getText().toString();
                    inputBal.setText(balVal);

                    valBal = Double.parseDouble((balVal));

                }
                else {
                    inputRem.setText("Nothing");
                }
            }

            @SuppressLint("SetTextI18n")
            public void secMthod() {
                if (Objects.requireNonNull(inputSend.getText()).length() > 0) {
                    sendVal = inputSend.getText().toString();
                    inputSend.setText(sendVal);

                    valSn = Double.parseDouble((sendVal));
                    inputRam.setText(sendVal);
                }else {
                    inputRam.setText("Nothing");
                }
            }

            public void rmMthod() {

                if (valBal > 1) {
                    String valRem1 = String.valueOf(valBal - (valDuct+valSn));
                    inputRem.setText(valRem1);

                    inputRam.setText(sendVal);
                }
            }
            final double telCharge = 0.75;
            final double elevyCharge = 1.50;
            final double telCharge1 = 7.50;
            final double telCharge2 = 0.38;
            final double telChargeM1 = 0.50;
            final double telChargeM2 = 1.00;
            final double telChargeM3 = 10.00;
            final double small = 50;
            final double medium = 1000;

            public void chargeMthodptp(){

                if (valSn <= small) {


                    telVal = String.valueOf((telCharge2));
                    elevyVal = String.valueOf(((elevyCharge * valSn)/100));
                    tchargeVal = String.valueOf(((elevyCharge * valSn)/100)+telCharge2);

                    hint1.setHint("Telco @+0.38");
                    inputTcharge.setText(telVal);
                    inputElevy.setText(elevyVal);
                    inputTotalCharge.setText(tchargeVal);

                }else if (valSn <= medium ){

                    telVal = String.valueOf(((telCharge * valSn ) /100));
                    elevyVal = String.valueOf(((elevyCharge * valSn)/100 ));
                    tchargeVal = String.valueOf(((elevyCharge+telCharge)*valSn)/100);

                    hint1.setHint("Telco @0.75%");
                    inputTcharge.setText(telVal);
                    inputElevy.setText(elevyVal);
                    inputTotalCharge.setText(tchargeVal);

                }else if (valSn >= medium){

                    telVal = String.valueOf((telCharge1));
                    elevyVal = String.valueOf(((elevyCharge * valSn)/100 ));
                    tchargeVal = String.valueOf(((elevyCharge * valSn)/100)+telCharge1);

                    hint1.setHint("Telco @+7.50");
                    inputTcharge.setText(telVal);
                    inputElevy.setText(elevyVal);
                    inputTotalCharge.setText(tchargeVal);
                }
            }
            public void chargeMthodptm(){

                if (valSn <= small) {


                    telVal = String.valueOf((telChargeM1));
                    elevyVal = String.valueOf(((elevyCharge * valSn)/100));
                    tchargeVal = String.valueOf(((elevyCharge * valSn)/100)+telChargeM1);

                    hint1.setHint("Telco @+0.50");
                    inputTcharge.setText(telVal);
                    inputElevy.setText(elevyVal);
                    inputTotalCharge.setText(tchargeVal);



                }if (valSn > small && valSn <= medium ){

                    telVal = String.valueOf(((telChargeM2 * valSn ) /100));
                    elevyVal = String.valueOf(((elevyCharge * valSn)/100 ));
                    tchargeVal = String.valueOf(((elevyCharge+telChargeM2)*valSn)/100);

                    hint1.setHint("Telco @1.0%");
                    inputTcharge.setText(telVal);
                    inputElevy.setText(elevyVal);
                    inputTotalCharge.setText(tchargeVal);

                }if (valSn >= medium){

                    telVal = String.valueOf((telChargeM3));
                    elevyVal = String.valueOf(((elevyCharge * valSn)/100 ));
                    tchargeVal = String.valueOf(((elevyCharge * valSn)/100)+telChargeM3);

                    hint1.setHint("Telco @+10.00");
                    inputTcharge.setText(telVal);
                    inputElevy.setText(elevyVal);
                    inputTotalCharge.setText(tchargeVal);
                }
            }

            public void chargeMthodpto(){

                if (valSn <= small) {


                    telVal = String.valueOf((telCharge2));
                    elevyVal = String.valueOf(((elevyCharge * valSn)/100));
                    tchargeVal = String.valueOf(((elevyCharge * valSn)/100)+telCharge2);

                    hint1.setHint("Telco @+0.38");
                    inputTcharge.setText(telVal);
                    inputElevy.setText(elevyVal);
                    inputTotalCharge.setText(tchargeVal);

                }if (valSn <= medium && valSn >= small ){

                    telVal = String.valueOf(((telCharge * valSn ) /100));
                    elevyVal = String.valueOf(((elevyCharge * valSn)/100 ));
                    tchargeVal = String.valueOf(((elevyCharge+telCharge)*valSn)/100);

                    hint1.setHint("Telco @0.75%");
                    inputTcharge.setText(telVal);
                    inputElevy.setText(elevyVal);
                    inputTotalCharge.setText(tchargeVal);

                }else if (valSn >= medium){

                    telVal = String.valueOf((telCharge1));
                    elevyVal = String.valueOf(((elevyCharge * valSn)/100 ));
                    tchargeVal = String.valueOf(((elevyCharge * valSn)/100)+telCharge1);

                    hint1.setHint("Telco @+7.50");
                    inputTcharge.setText(telVal);
                    inputElevy.setText(elevyVal);
                    inputTotalCharge.setText(tchargeVal);
                }
            }

            public void checkerBtn() {


                if (ppCheck.isChecked()&& !pmCheck.isChecked() && !poCheck.isChecked()){

                    chargeMthodptp();
                    tamMthod();
                    rmMthod();
                    Toast.makeText(getApplicationContext(), "Peer-to-Peer",Toast.LENGTH_LONG).show();

                }

                if (pmCheck.isChecked() && !ppCheck.isChecked() && !poCheck.isChecked()){

                    chargeMthodptm();
                    tamMthod();
                    rmMthod();
                    Toast.makeText(getApplicationContext(), "Peer-to-Merchant",Toast.LENGTH_LONG).show();

                }

                if (poCheck.isChecked() && !pmCheck.isChecked() && !ppCheck.isChecked()){

                    chargeMthodpto();
                    tamMthod();
                    rmMthod();
                    Toast.makeText(getApplicationContext(), "Peer-to-Other Networks",Toast.LENGTH_LONG).show();


                }else if (!ppCheck.isChecked()&& !pmCheck.isChecked() && !poCheck.isChecked()){


                    Toast.makeText(getApplicationContext(), "Select One Transaction Type",Toast.LENGTH_LONG).show();

                }else if (ppCheck.isChecked()&& pmCheck.isChecked() && !poCheck.isChecked()){


                    Toast.makeText(getApplicationContext(), "Select One Transaction Type",Toast.LENGTH_LONG).show();

                }else if (!ppCheck.isChecked()&& pmCheck.isChecked() && poCheck.isChecked()){


                    Toast.makeText(getApplicationContext(), "Select One Transaction Type",Toast.LENGTH_LONG).show();

                }
                else if (ppCheck.isChecked()&& !pmCheck.isChecked() && poCheck.isChecked()){


                    Toast.makeText(getApplicationContext(), "Select One Transaction Type",Toast.LENGTH_LONG).show();

                }
            }


            public void tamMthod() {
                if ((Objects.requireNonNull(inputTotalCharge.getText()).length()>0)) {
                    ductVal = inputTotalCharge.getText().toString();



                    valDuct = Double.parseDouble((ductVal));
                    String valDuct1 = String.valueOf(valDuct + valSn);
                    inputDuctAmount.setText(valDuct1);
                }
            }

            public void checkMthod() {
                if (valSn > valBal) {

                    Toast.makeText(getApplicationContext(), "Balance is low",Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}
