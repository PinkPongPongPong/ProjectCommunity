package com.ohgiraffers.projectgin.model.repository;

import com.ohgiraffers.projectgin.model.entity.BoardCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardCategoryRepository extends JpaRepository<BoardCategory, Integer> {
    BoardCategory findByBoardCategory(String category);

    @Query(value="select * from tbl_board_category order by board_category_no", nativeQuery = true)
    List<BoardCategory> findBoardCategoryByNativeQuery() ;

}
