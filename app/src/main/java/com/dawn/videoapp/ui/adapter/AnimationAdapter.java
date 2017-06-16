package com.dawn.videoapp.ui.adapter;

import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.dawn.videoapp.R;
import com.dawn.videoapp.adapter_util.BaseQuickAdapter;
import com.dawn.videoapp.adapter_util.BaseViewHolder;
import com.dawn.videoapp.model.AnimationModel;
import com.dawn.videoapp.togic.util.SpannableStringUtils;
import com.dawn.videoapp.togic.util.ToastUtils;
import com.dawn.videoapp.togic.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 90449 on 2017/6/7.
 */

public class AnimationAdapter extends BaseQuickAdapter<AnimationModel, BaseViewHolder> {
    public AnimationAdapter() {
        super( R.layout.layout_animation, getSampleData(100));
    }
    public static List<AnimationModel> getSampleData(int lenth) {
        List<AnimationModel> list = new ArrayList<>();
        for (int i = 0; i < lenth; i++) {
            AnimationModel status = new AnimationModel();
            status.setUserName("Chad" + i);
            status.setCreatedAt("04/05/" + i);
            status.setRetweet(i % 2 == 0);
            status.setUserAvatar("https://avatars1.githubusercontent.com/u/7698209?v=3&s=460");
            status.setText("BaseRecyclerViewAdpaterHelper https://www.recyclerview.org");
            list.add(status);
        }
        return list;
    }
    @Override
    protected void convert(BaseViewHolder helper, AnimationModel item) {
        helper.addOnClickListener(R.id.img).addOnClickListener(R.id.tweetText).addOnClickListener(R.id.tweetName);
        switch (helper.getLayoutPosition()%
                3){
            case 0:
                helper.setImageResource(R.id.img,R.mipmap.animation_img1);
                break;
            case 1:
                helper.setImageResource(R.id.img,R.mipmap.animation_img2);
                break;
            case 2:
                helper.setImageResource(R.id.img,R.mipmap.animation_img3);
                break;
        }
        helper.setText(R.id.tweetName,"Hoteis in Rio de Janeiro");
        String msg="\"He was one of Australia's most of distinguished artistes, renowned for his portraits\"";
        ( (TextView)helper.getView(R.id.tweetText)).setText(SpannableStringUtils.getBuilder(msg).append("landscapes and nedes").setClickSpan(clickableSpan).create());
        ( (TextView)helper.getView(R.id.tweetText)).setMovementMethod(LinkMovementMethod.getInstance());
    }
    ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View widget) {
            ToastUtils.showShortToast("事件触发了 landscapes and nedes");
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(Utils.getContext().getResources().getColor(R.color.clickspan_color));
            ds.setUnderlineText(true);
        }
    };
}
