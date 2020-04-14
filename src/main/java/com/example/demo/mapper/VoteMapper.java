package com.example.demo.mapper;


import com.example.demo.model.Vote;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface VoteMapper {

    //查询所有Vote
    @Select("select * from vote")
    List<Vote> selectAll();

    //增加一个Vote
    @Insert("insert into vote values(#{voteId},#{studentId},#{agree}" +
                                ",#{disagree},#{voting_results},#{publish_time}" +
                                ",#{deadline})")
    int insert(Vote vote);

    //修改一个Vote
    @Update("update vote set studentId=#{studentId}" +
                        ",agree=#{agree},disagree=#{disagree}" +
                        ",voting_results=#{voting_results},publish_time=#{publish_time}" +
                        ",deadline=#{deadline} where voteId=#{voteId}")
    int update(Vote vote);

}
