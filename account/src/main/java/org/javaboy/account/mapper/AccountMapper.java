package org.javaboy.account.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author xyma
 * @version 1.0
 * @data 2023/6/20 8:41
 */
@Mapper
public interface AccountMapper {
    @Update("update account_tbl set money = money - #{money} where userId = #{account}")
    int updateAccount(@Param("account") String account, @Param("money") Double money);

    @Select("select money from account_tbl where userId = #{account}")
    Double getMoneyByAccount(String account);
}
