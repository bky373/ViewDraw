package com.example.viewdraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class MyView extends View {
    Paint p1 = new Paint();
    Paint p2 = new Paint();
    Paint p3 = new Paint();

    // 매개변수가 1개인 생성자를 만듦
    // 생성자 안에서 Paint 객체들의 값 설정하기
    MyView(Context context) {
        super(context);
        p1.setTextSize(50);
        p1.setColor(Color.BLUE);

        // 0x는 16진수를 의미, 처음에 나오는 ff(10진수로 255)는 알파값(0~255)이며
        // 숫자가 작을수록 투명해진다. 즉 알파값이 0이 되면 완전투명이 되어 화면에서 안보이게 된다.
        p2.setColor(0xff990085); // 색상 16진수로 지정하기: 투명도, RED, GREEN, BLUE
        p1.setStrokeWidth(8); // 선 두께 지정
        p3.setARGB(100, 153, 0, 133); // 색상 10진수로 지정하기: 투명도, RED, GREEN, BLUE
    }

    public void onDraw(Canvas canvas) {
        canvas.drawARGB(100, 150, 50, 50); // 캔버스 바탕색 지정하기

        canvas.drawRect(0, 0, 200, 200, p1); // 사각형 그리기
        canvas.drawRect(200, 0, 400, 200, p2);
        canvas.drawRect(400, 0, 600, 200, p3);
        canvas.drawCircle(100, 300, 100, p1); // 원 그리기
        canvas.drawLine(200, 1100, 600, 1100, p1);// 라인 그리기

        //rect 사각형 안에 원을 그린다.
        RectF rectF = new RectF(200, 600, 600, 1000);
        canvas.drawArc(rectF, 0, 320, true, p1);// (false : 호, true : 부채꼴모양)

    }
}