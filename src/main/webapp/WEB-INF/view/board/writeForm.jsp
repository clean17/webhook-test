<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

    <div class="container my-3">
        <form>
            <div class="form-group">
                <input type="text" class="form-control" id="title" placeholder="Enter title" name="title" value="글 제목 위치">
            </div>
            <div class="form-group">
                <textarea class="form-control summernote" id="content" rows="5" name="content">글 내용 위치</textarea>
            </div>
            <button type="button" class="btn btn-primary">글쓰기완료</button>
        </form>
    </div>
<%@ include file="../layout/footer.jsp" %>