package com.example.mrsang.calculate;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.inputmethodservice.Keyboard;
import android.os.Build;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private TextView textView;

    private Button btnNumber0;
    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;

    private Button btnXoa;
    private Button btnCong;
    private Button btnTru;
    private Button btnNhan;
    private Button btnChia;

    private Button btnDayPhay;
    private Button btnDauBang;

    private Stack<Character> toanTu;
    private ArrayList<String> toanHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intnWigdet();
        setEventClickView();
        btnXoa.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                editText.setText("");
                textView.setText("");
                return true;
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(textView.getText());
                editText.setSelection(editText.length());
            }
        });
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/consola.ttf");
        editText.setTypeface(typeface);
        btnCong.setTypeface(typeface);
        btnTru.setTypeface(typeface);
        btnNhan.setTypeface(typeface);
        btnChia.setTypeface(typeface);
        btnDauBang.setTypeface(typeface);
        typeface = Typeface.createFromAsset(getAssets(),"fonts/Barcelona 2015 2016.ttf");
        btnNumber0.setTypeface(typeface);
        btnNumber1.setTypeface(typeface);
         btnNumber2.setTypeface(typeface);
         btnNumber3.setTypeface(typeface);
         btnNumber4.setTypeface(typeface);
         btnNumber5.setTypeface(typeface);
         btnNumber6.setTypeface(typeface);
         btnNumber7.setTypeface(typeface);
         btnNumber8.setTypeface(typeface);
         btnNumber9.setTypeface(typeface);
        btnDayPhay.setTypeface(typeface);

        editText.setInputType(InputType.TYPE_NULL);
        if(Build.VERSION.SDK_INT>=11){
           editText.setRawInputType(InputType.TYPE_CLASS_TEXT);
            editText.setTextIsSelectable(true);
        }
    }

    public void intnWigdet() {
        btnNumber0 = (Button) findViewById(R.id.btnNumber0);
        btnNumber1 = (Button) findViewById(R.id.btnNumber1);
        btnNumber2 = (Button) findViewById(R.id.btnNumber2);
        btnNumber3 = (Button) findViewById(R.id.btnNumber3);
        btnNumber4 = (Button) findViewById(R.id.btnNumber4);
        btnNumber5 = (Button) findViewById(R.id.btnNumber5);
        btnNumber6 = (Button) findViewById(R.id.btnNumber6);
        btnNumber7 = (Button) findViewById(R.id.btnNumber7);
        btnNumber8 = (Button) findViewById(R.id.btnNumber8);
        btnNumber9 = (Button) findViewById(R.id.btnNumber9);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);

        btnXoa = (Button) findViewById(R.id.btnXoa);
        btnCong = (Button) findViewById(R.id.btnCong);
        btnNhan = (Button) findViewById(R.id.btnNhan);
        btnChia = (Button) findViewById(R.id.btnChia);
        btnTru = (Button) findViewById(R.id.btnTru);

        btnDauBang = (Button) findViewById(R.id.btnDauBang);
        btnDayPhay = (Button) findViewById(R.id.btnDauCham);
    }

    public void setEventClickView() {
        btnNumber0.setOnClickListener(this);
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);

        btnXoa.setOnClickListener(this);
        btnCong.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);
        btnTru.setOnClickListener(this);

        btnDayPhay.setOnClickListener(this);
        btnDauBang.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String chuoiPhepTinh = editText.getText().toString();
        char[] mangPhepTinh = chuoiPhepTinh.toCharArray();
        char kiTuTaiViTriChuot = 'a';
        int viTriChuot = editText.getSelectionStart();
        int b = viTriChuot;
        if (viTriChuot > 0)
            kiTuTaiViTriChuot = mangPhepTinh[viTriChuot - 1];
        switch (view.getId()) {
            case R.id.btnNumber0:
                setKeyClick(KeyEvent.KEYCODE_0);
                break;
            case R.id.btnNumber1:
                setKeyClick(KeyEvent.KEYCODE_1);
                break;
            case R.id.btnNumber2:
                setKeyClick(KeyEvent.KEYCODE_2);
                break;
            case R.id.btnNumber3:
                setKeyClick(KeyEvent.KEYCODE_3);
                break;
            case R.id.btnNumber4:
                setKeyClick(KeyEvent.KEYCODE_4);
                break;
            case R.id.btnNumber5:
                setKeyClick(KeyEvent.KEYCODE_5);
                break;
            case R.id.btnNumber6:
                setKeyClick(KeyEvent.KEYCODE_6);
                break;
            case R.id.btnNumber7:
                setKeyClick(KeyEvent.KEYCODE_7);
                break;
            case R.id.btnNumber8:
                setKeyClick(KeyEvent.KEYCODE_8);
                break;
            case R.id.btnNumber9:
                setKeyClick(KeyEvent.KEYCODE_9);
                break;
            case R.id.btnCong:
                if (!chuoiPhepTinh.isEmpty() & (kiTuTaiViTriChuot < 35 | kiTuTaiViTriChuot > 47))
                    setKeyClick(KeyEvent.KEYCODE_PLUS);
                break;
            case R.id.btnTru:
                if ((kiTuTaiViTriChuot < 35 | kiTuTaiViTriChuot > 47))
                    setKeyClick(KeyEvent.KEYCODE_MINUS);
                break;
            case R.id.btnNhan:
                if (!chuoiPhepTinh.isEmpty() & (kiTuTaiViTriChuot < 35 | kiTuTaiViTriChuot > 47))
                    setKeyClick(KeyEvent.KEYCODE_STAR);
                break;
            case R.id.btnChia:
                if (!chuoiPhepTinh.isEmpty() & (kiTuTaiViTriChuot < 35 | kiTuTaiViTriChuot > 47))
                    setKeyClick(KeyEvent.KEYCODE_SLASH);
                break;
            case R.id.btnDauCham:
                while (viTriChuot > 0) {
                    viTriChuot--;
                    if (mangPhepTinh[viTriChuot] == '+'|mangPhepTinh[viTriChuot] == '-'|mangPhepTinh[viTriChuot] == '*'|mangPhepTinh[viTriChuot] == '/')
                        break;
                    if (mangPhepTinh[viTriChuot] == '.')
                        return;
                }
                while (b < mangPhepTinh.length) {
                    if (mangPhepTinh[viTriChuot] == '+'|mangPhepTinh[viTriChuot] == '-'|mangPhepTinh[viTriChuot] == '*'|mangPhepTinh[viTriChuot] == '/')
                        break;
                    if (mangPhepTinh[b] == '.')
                        return;
                    b++;
                }
                setKeyClick(KeyEvent.KEYCODE_PERIOD);
                break;
            case R.id.btnXoa:
                setKeyClick(KeyEvent.KEYCODE_DEL);
                break;
            case R.id.btnDauBang:
                int j = 0;
                toanHang = new ArrayList<>();
                toanTu = new Stack<>();
                for (int i = 0; i < mangPhepTinh.length; i++) {
                    if (mangPhepTinh[i] == '+' | mangPhepTinh[i] == '*' | mangPhepTinh[i] == '/' | mangPhepTinh[i] == '-' | (i == (mangPhepTinh.length - 1))) {
                        if (i == (mangPhepTinh.length - 1))
                            toanHang.add(chuoiPhepTinh.substring(j));
                        else
                            toanHang.add(chuoiPhepTinh.substring(j, i));
                        j = i + 1;
                        switch (mangPhepTinh[i]) {
                            case '+':
                                while (true) {
                                    char ct;
                                    if (toanTu.isEmpty()) {
                                        toanTu.push('+');
                                        break;
                                    } else {
                                            toanHang.add(String.valueOf(toanTu.pop()));
                                    }
                                }
                                break;
                            case '-':
                                while (true) {
                                    char ct;
                                    if (toanTu.isEmpty()) {
                                        toanTu.push('-');
                                        break;
                                    } else {
                                        ct = toanTu.pop();
                                        if (ct == '*' | ct == '/'|ct=='-') {
                                            toanHang.add(String.valueOf(ct));
                                        } else {
                                            toanTu.push(ct);
                                            toanTu.push('-');
                                            break;
                                        }
                                    }
                                }
                                break;
                            case '*':
                                while (true) {
                                    char ct;
                                    if (toanTu.isEmpty()) {
                                        toanTu.push('*');
                                        break;
                                    } else {
                                        ct = toanTu.pop();
                                        if (ct == '/'|ct=='*') {
                                            toanHang.add(String.valueOf(ct));
                                        } else {
                                            toanTu.push(ct);
                                            toanTu.push('*');
                                            break;
                                        }
                                    }
                                }
                                break;
                            case '/':
                                toanTu.push('/');
                                break;
                        }
                    }
                }
                while (!toanTu.isEmpty()) {
                    char ct2 = toanTu.pop();
                    toanHang.add(String.valueOf(ct2));
                }
                if (!toanHang.isEmpty()) {
                    tinhToan(toanHang);
                } else
                    textView.setText("Sai cmnr ");
                break;
        }
    }

    public void setKeyClick(int key) {
        BaseInputConnection textFieldInputConnection = new BaseInputConnection(editText, true);
        textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, key));
    }

    public void tinhToan(ArrayList<String> string) {
        DecimalFormat df = new DecimalFormat("###.########");
        int i = 0;
        while (i < string.size()) {
            if (string.get(i).equals("+")|string.get(i).equals("-")|string.get(i).equals("*")|string.get(i).equals("/")) {
                double a = Double.parseDouble(string.get(i - 1));
                double b = Double.parseDouble(string.get(i - 2));
                double c =0 ;
                switch (string.get(i)){
                    case "+" : c= b+a;break;
                    case "-" : c= b-a;break;
                    case "/" :
                        if(a==0)
                            textView.setText("Loi chia cho so 0");
                        else
                            c=b/a;
                        break;
                    case "*" : c= a*b;
                }
                string.set(i - 2, String.valueOf(df.format(c)));
                string.remove(i);
                string.remove(i - 1);
                i = i - 1;
            }else{
                i++;
            }
        }
        textView.setText(string.get(0));
    }
 }