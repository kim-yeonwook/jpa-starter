package com.jpa.starter.infrastructure.persistence.repository.custom.impl;

import com.jpa.starter.infrastructure.persistence.entity.Board;
import com.jpa.starter.infrastructure.persistence.repository.custom.BoardRepositoryCustom;
import com.jpa.starter.web.dto.SearchBoardListRequest;
import com.jpa.starter.web.dto.SearchBoardTupleListResponse;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.jpa.starter.infrastructure.persistence.entity.QBoard.board;
import static com.jpa.starter.infrastructure.persistence.entity.QPost.post;

@RequiredArgsConstructor
@Repository
public class BoardRepositoryImpl implements BoardRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Board> boardList(SearchBoardListRequest request, Pageable pageable) {
        List<Board> list = this.jpaQueryFactory
                .selectFrom(board)
                .where(
                        categoryCodeEq(request.categoryCode()),
                        startDateGoe(request.startDate()),
                        endDateLoe(request.endDate())
                )
                .offset(pageable.getOffset()).limit(pageable.getPageSize())
                .orderBy(board.id.desc())
                .fetch();

        Long total = this.totalCount(request);

        return new PageImpl<>(list, pageable, total);
    }

    @Override
    public List<Board> boardList(SearchBoardListRequest request) {
        return this.jpaQueryFactory
                .selectFrom(board)
                .where(
                        categoryCodeEq(request.categoryCode()),
                        startDateGoe(request.startDate()),
                        endDateLoe(request.endDate())
                )
                .orderBy(board.id.desc())
                .fetch();
    }

    @Override
    public Page<SearchBoardTupleListResponse> boardListTuple(SearchBoardListRequest request, Pageable pageable) {
        List<Tuple> list = this.jpaQueryFactory
                .select(
                        board.code,
                        board.name,
                        board.description,
                        Expressions.stringTemplate("string_agg({0}, {1})", post.title, ",")
                )
                .from(board)
                .join(post).on(board.id.eq(post.board.id))
                .where(
                        categoryCodeEq(request.categoryCode()),
                        startDateGoe(request.startDate()),
                        endDateLoe(request.endDate())
                )
                .groupBy(board.code, board.name, board.description)
                .offset(pageable.getOffset()).limit(pageable.getPageSize())
                .fetch();
        Long total = this.totalCount(request);

        List<SearchBoardTupleListResponse> result = list.stream()
                .map(b -> new SearchBoardTupleListResponse(
                        b.get(0, String.class),
                        b.get(1, String.class),
                        b.get(2, String.class),
                        b.get(3, String.class)
                ))
                .collect(Collectors.toList());

        return new PageImpl<>(result, pageable, total);
    }

    private Long totalCount(SearchBoardListRequest request) {
        return this.jpaQueryFactory.select(board.id.count())
                .from(board)
                .where(
                        categoryCodeEq(request.categoryCode()),
                        startDateGoe(request.startDate()),
                        endDateLoe(request.endDate())
                )
                .fetchOne();
    }

    private BooleanExpression categoryCodeEq(String categoryId) {
        if (Objects.isNull(categoryId)) { return null; }

        return board.category.code.eq(categoryId);
    }

    private BooleanExpression startDateGoe(String startDate) {
        if (Objects.isNull(startDate)) { return null; }
        try {
            return board.createdAt.goe(new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
        }catch (ParseException e) {
            return null;
        }
    }

    private BooleanExpression endDateLoe(String endDate) {
        if (Objects.isNull(endDate)) { return null; }
        try {
            return board.createdAt.goe(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endDate + " 23:59:59"));
        }catch (ParseException e) {
            return null;
        }
    }
}
