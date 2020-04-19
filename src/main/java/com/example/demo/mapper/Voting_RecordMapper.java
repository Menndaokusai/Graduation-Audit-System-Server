package com.example.demo.mapper;

import com.example.demo.model.Voting_Record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface Voting_RecordMapper {

    //查询该用户是否投票
    @Select("select IFNULL(MAX(num),0) as num from voting_record where voteId=#{voteId} and username=#{username}")
    String select(int voteId,String username);

    //创建用户投票记录
    @Insert("insert into voting_record values(#{voteId},#{username},#{num})")
    int insert(Voting_Record voting_record);


}
