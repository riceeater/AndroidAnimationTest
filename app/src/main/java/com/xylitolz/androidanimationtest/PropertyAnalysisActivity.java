package com.xylitolz.androidanimationtest;

import android.animation.FloatEvaluator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * @author 小米Xylitol
 * @email xiaomi987@hotmail.com
 * @desc 属性动画分析
 * @date 2018-04-13 12:53
 */

public class PropertyAnalysisActivity extends AppCompatActivity {

    private ImageView ivContainer;
    private RadioGroup rgInterpolatorType;
    private ValueAnimator animator;
    private StringBuilder log = new StringBuilder("");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_analysis);
        ivContainer = findViewById(R.id.iv_container);
        rgInterpolatorType = findViewById(R.id.rg_interpolator_type);


        animator = ValueAnimator.ofFloat(0,800);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ivContainer.setTranslationY((Float) animation.getAnimatedValue());
            }
        });

        rgInterpolatorType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ivContainer.setTranslationY(0);
            }
        });
    }

    public void valueAnalysis(View view) {
        log = new StringBuilder("");
        switch (rgInterpolatorType.getCheckedRadioButtonId()) {
            case R.id.rb_type_linear:
                animator.setInterpolator(new LinearInterpolator());
                break;
            case R.id.rb_type_accelerate_decelerate:
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                break;
            case R.id.rb_type_bounce:
                animator.setInterpolator(new BounceInterpolator());
                break;
        }
        animator.start();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context,PropertyAnalysisActivity.class);
        context.startActivity(intent);
    }
}
