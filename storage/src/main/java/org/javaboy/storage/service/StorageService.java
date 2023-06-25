package org.javaboy.storage.service;

import org.javaboy.storage.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xyma
 * @version 1.0
 * @data 2023/6/20 14:21
 */
@Service
public class StorageService {
    @Autowired
    StorageMapper storageMapper;

    public boolean deduct(String productId, Integer count) {
        int result = storageMapper.getCountByCommodityCode(productId);
        if (result < count) {
            throw new RuntimeException("库存不足，扣库存失败!");
        }
        int i = storageMapper.deductStorage(productId, count);
        return i == 1;
    }
}
