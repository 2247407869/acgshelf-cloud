package wang.acgshelf.acgshelf.common.hystrix;

import com.google.common.collect.Lists;
import wang.acgshelf.acgshelf.common.constants.HttpStatusConstants;
import wang.acgshelf.acgshelf.common.dto.BaseResult;
import wang.acgshelf.acgshelf.common.utils.MapperUtils;

/**
 * 通用的熔断方法
 */
public class Fallback {
    public static String badGateway(){
        BaseResult baseResult = BaseResult.notOk(Lists.newArrayList(
                new BaseResult.Error(
                        String.valueOf(HttpStatusConstants.BAD_GATEWAY.getStatus()),
                        HttpStatusConstants.BAD_GATEWAY.getContent()
                )
        ));
        try {
            return MapperUtils.obj2json(baseResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
