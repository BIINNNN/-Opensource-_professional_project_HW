/*********************************************************************************
 * 프로그램명: MainActivity.java
 * 작성자: 2018038041 김서빈
 * 작성일: 2020.04.11
 * 프로그램 설명:
 * 1. <글자 나타내기>를 클릭하면 EditText에 입력한 글자가 잠깐 Toast 메시지로 출력
 * 2. <홈페이지 열기>를 클릭하면 EditText에 입력한 URL이 열림.
 * 3. 처음에는 기본 이미지가 나타나고, 라디오버튼을 클릭 시에 다른 이미지로 변경 (총 2개 이미지)
 **********************************************************************************/

package com.example.myfirsttask;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 변수 선언
    EditText editText; // 에디트텍스트
    String s; // 문자열
    Button button1, button2; // 버튼
    RadioGroup rGroup; // 라디오그룹
    RadioButton rButton1, rButton2; // 라디오버튼
    ImageView imageView; // 이미지뷰

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("좀 그럴듯한 앱");

        // 생성한 위젯들을 변수에 대입
        button1 = (Button) findViewById(R.id.button1); // 버튼
        button2 = (Button) findViewById(R.id.button2); // 버튼
        editText = (EditText) findViewById(R.id.editText); // 에디트텍스트
        rGroup = (RadioGroup) findViewById(R.id.rGroup); // 라디오그룹
        rButton1 = (RadioButton) findViewById(R.id.rButton1); // 라디오버튼
        rButton2 = (RadioButton) findViewById(R.id.rButton2); // 라디오버튼
        imageView = (ImageView) findViewById(R.id.imageView); // 이미지뷰

        // 글자 나타내기 버튼을 클릭할 때 동작
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = editText.getText().toString(); // 에디트테스트에 입력된 값을 s에 대입
                Toast.makeText(getApplicationContext(), s , Toast.LENGTH_SHORT).show(); // 토스트 메시지로 s 값 출력
            }
        });

        // 홈페이지 열기 버튼을 클릭할 때 동작
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(s)); // 문자열 s URL 열기
                startActivity(mIntent); // 실행
            }
        });

        // rButton1 라디오버튼을 클릭할 때
        rButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.pie); // pie.png 이미지 출력
            }
        });

        // rButton2 라디오버튼을 클릭할 때
        rButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.ohero); // ohero.png 이미지 출력
            }
        });

    }
}
