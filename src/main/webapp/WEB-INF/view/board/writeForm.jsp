<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../layout/header.jsp" %>

        <div class="container my-3">
            <form action="/board/write" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" id="title" placeholder="글 제목을 입력해주세요" name="title">
                </div>
                <div class="form-group">
                    <textarea class="form-control summernote" id="content" rows="5" name="content"
                        placeholder="글 내용을 입력해주세요"></textarea>
                </div>
                <button class="btn btn-primary">글쓰기완료</button>
            </form>
        </div>
        <script>
            $('.summernote').summernote({
                tabsize: 2,
                height: 400
            });
        </script>
        <%@ include file="../layout/footer.jsp" %>