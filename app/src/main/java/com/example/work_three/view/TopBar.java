package com.example.work_three.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.work_three.R;


public class TopBar extends RelativeLayout {

    private TextView toptext;
    private  Button leftbtn,rightbtn;

    public TopBar(Context context) {
        super(context);
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
       LayoutInflater.from(context).inflate( R.layout.top_layout, this);

       leftbtn = findViewById(R.id.left_btn);
       rightbtn=findViewById(R.id.right_btn);
       toptext=findViewById(R.id.toptext);

       //获得自定义属性并且传值
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        int left = typedArray.getResourceId(R.styleable.TopBar_leftBackground, 0);
        int right = typedArray.getResourceId(R.styleable.TopBar_rightBackground, 0);
        float size = typedArray.getDimension(R.styleable.TopBar_topBarTextSize, 0);
        String text = typedArray.getString(R.styleable.TopBar_topBarText);
        int color = typedArray.getColor(R.styleable.TopBar_topBarTextColor, 0x38ad5a);
        typedArray.recycle();
        leftbtn.setBackgroundResource(left);
        rightbtn.setBackgroundResource(right);
        toptext.setText(text);
        toptext.setTextColor(color);
        toptext.setTextSize(size);
    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
