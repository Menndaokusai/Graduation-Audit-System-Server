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
    @Select("select * from vote limit #{start},#{limit}")
    List<Vote> selectAll(int start,int limit);

    //查询该学生的所有Vote
    @Select("select * from vote where studentId=#{studentId} limit #{start},#{limit}")
    List<Vote> selectBysId(String studentId,int start,int limit);

    //查询该Vote的信息
    @Select("select * from vote where voteId=#{voteId}")
    Vote selectVote(int voteId);

    //增加一个Vote
    @Insert("insert into vote values(#{voteId},#{studentId},#{agree}" +
                                ",#{disagree},#{participant},#{voting_results}" +
                                ",#{publish_time},#{deadline})")
    int insert(Vote vote);

    //修改一个Vote
    @Update("update vote set studentId=#{studentId}" +
                        ",agree=#{agree},disagree=#{disagree},participant=#{participant}" +
                        ",voting_results=#{voting_results},publish_time=#{publish_time}" +
                        ",deadline=#{deadline} where voteId=#{voteId}")
    int update(Vote vote);

    //同意
    @Update("update vote set agree=agree+1 where voteId=#{voteId}")
    int agree(int voteId);

    //不同意
    @Update("update vote set disagree=disagree+1 where voteId=#{voteId}")
    int disagree(int voteId);

}
