package wall.field.investigation.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import wall.field.investigation.R;
import wall.field.investigation.mvp.model.entity.Standard;
import wall.field.investigation.mvp.model.entity.TemplateDetail;

/**
 * 考核标准
 * Created by wall on 2018/6/22 14:50
 * w_ll@winning.com.cn
 */
public class StandardAdapter extends BaseQuickAdapter<Standard, BaseViewHolder> {


    public Standard getmStandard() {
        return mStandard;
    }

    public void setmStandard(Standard mStandard) {
        this.mStandard = mStandard;
    }

    private Standard mStandard;

    public StandardAdapter(@Nullable List<Standard> data) {
        super(R.layout.item_item, data);
        if (data != null) {
            int j = data.size();
            for (int i = 0; i < j; i++) {
                if (data.get(i).isSelect) {
                    mStandard = data.get(i);
                    break;
                }
            }
        }
    }

    @Override
    protected void convert(BaseViewHolder helper, Standard item) {
        helper.setText(R.id.content,item.standardName)
                .setTextColor(R.id.content, mContext.getResources().getColor(getColor(item)))
                .setVisible(R.id.img,item.isSelect);
    }

    private Integer getColor(Standard item) {
        if (item != null && !TextUtils.isEmpty(item.identification) && "1".equals(item.identification)) {
            return R.color.txt_sub;
        }
        return R.color.txt_main;
    }


}
