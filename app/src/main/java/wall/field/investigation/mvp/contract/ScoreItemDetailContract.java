package wall.field.investigation.mvp.contract;

import android.app.Activity;

import com.jess.arms.mvp.IView;
import com.jess.arms.mvp.IModel;
import com.tbruyelle.rxpermissions2.RxPermissions;


import java.util.List;
import java.util.function.DoubleUnaryOperator;

import io.reactivex.Observable;
import wall.field.investigation.mvp.model.entity.BaseJson;
import wall.field.investigation.mvp.model.entity.Deduct;
import wall.field.investigation.mvp.model.entity.LocalImage;
import wall.field.investigation.mvp.model.entity.ScoreDetail;
import wall.field.investigation.mvp.model.entity.ScoreItem;
import wall.field.investigation.mvp.model.entity.TaskBaseInfo;
import wall.field.investigation.mvp.model.entity.TemplateDetail;


public interface ScoreItemDetailContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {

        void updateTaskBaseInfo(TaskBaseInfo data);

        void startLocation();

        //申请权限
        RxPermissions getRxPermissions();

        Activity getActivity();

        void startAddImage();

        void updateScoreDetail(ScoreDetail data);

        void onSaveStateListener();

        void showDeduct();

        void disMissRemarkCpw();
    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model extends IModel {

        Observable<BaseJson<TaskBaseInfo>> getTaskBaseInfo(String taskId);

        Observable<BaseJson<Object>> deleteScore(String taskId, String scoreId);

        Observable<BaseJson<Object>> deleteImage(String taskId, String scoreId, String url);

        Observable<BaseJson<ScoreDetail>> getScoreDetail(String taskId, String scoreId);

        Observable<BaseJson<List<TemplateDetail>>> getTemplateDetail(String templateId);

        void saveTemplate(List<TemplateDetail> data);

        Observable<BaseJson<Object>> submitScore(String taskId, String itemId, String standardId, String deductId, String deductNum, List<LocalImage> data, String address,String location);

        Observable<BaseJson<Object>> updateScoreDetail(String taskId, String scoreId, String itemId, String standardId, String deductId, String deductNum, List<LocalImage> data, String address,String location,String longitude,String latitude,String curLocation,String curLongitude,String curLatitude);

        void saveAddress(String address, String location,String longitude,String latitude);

        Observable<BaseJson<Object>> updateCheckStatus(String scoreId, String checkStatus);

        Observable<BaseJson<Object>> updateCopyTaskRemark(String taskId, String copyRemark);

        Observable<BaseJson<Object>> submitScoreByMultiple(String taskId, String itemId, String standardId, List<Deduct> deductList, String deductNum, List<LocalImage> data, String address, String location,String longitude,String latitude,String curLocation,String curLongitude,String curLatitude);

        Observable<BaseJson<Object>> updateScoreByMultiple(String taskId, String scoreId,String itemId, String standardId, List<Deduct> deductList, String deductNum, List<LocalImage> data, String address, String location);
    }
}
