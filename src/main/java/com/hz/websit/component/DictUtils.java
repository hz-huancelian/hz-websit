package com.hz.websit.component;

import com.hz.websit.service.ISysDictService;
import com.hz.websit.vo.DictParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : lijinku
 * @Project : hj-platform-parent
 * @description TODO 字典工具
 * @Iteration : 1.0
 * @Date : 2021/5/8  7:28 上午
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2021/05/08    create
 */
@Slf4j
@Component
public class DictUtils {

    @Autowired
    private ISysDictService sysDictService;



    /**
     * TODO 获取所有字典包括无效效
     *
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2021/5/8 7:34 上午
     */
    public Map<Long, String> getAllDictMap() {
        Map<Long, String> dictMap = new HashMap<>();
        //平台
        Map<Long, DictParam> dictParamMap = sysDictService.findDictMap();
        if (dictParamMap != null && !dictParamMap.isEmpty()) {
            for (Map.Entry<Long, DictParam> entry : dictParamMap.entrySet()) {
                dictMap.put(entry.getKey(), entry.getValue().getDictVal());
            }
        }

        return dictMap;
    }


    /**
     * TODO 获取所有有效字典
     *
     * @Author: lijinku
     * @Iteration : 1.0
     * @Date: 2021/5/8 7:34 上午
     */
    public Map<Long, String> getValidDictMap(Long rootKey) {
        Map<Long, String> dictMap = new HashMap<>();
        Map<Long, List<Long>> relMap = sysDictService.findDictRel();
        if (relMap != null && !relMap.isEmpty()) {
            List<Long> subKeys = relMap.get(rootKey);
            //平台
            if (subKeys != null && !subKeys.isEmpty()) {
                Map<Long, DictParam> dictParamMap = sysDictService.findDictMap();
                subKeys.stream().forEach(item -> {
                    DictParam dictParam = dictParamMap.get(item);
                    if (dictParam != null && dictParam.getStatus().equals("0")) {
                        dictMap.put(item, dictParam.getDictVal());
                    }
                });
            }
        }
        return dictMap;
    }


}