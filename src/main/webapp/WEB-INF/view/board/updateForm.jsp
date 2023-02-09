<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

    <div class="container my-3">
        <form>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Enter title" id="title" name="title" value="${dto.title}">
            </div>

            <div class="form-group">
                <textarea class="form-control summernote" id="content" rows="5" name="content">${dto.content}</textarea>
            </div>
        <button type="button" class="btn btn-primary" onclick="updateBoard(${dto.id})">글수정완료</button>
        </form>
    </div>
    <script>
        $('.summernote').summernote({
                tabsize: 2,
                height: 400
            });
        function updateBoard(id){
            let data = {
                title: $('#title').val(),
                content: $('#content').val()
            }
            $.ajax({
                type: "put",
                url: "/board/"+id,
                data: JSON.stringify(data),
                headers:{
                    "content-type":"application/json; charsettf-8"
                },
                dataType:"json"
            }).done((res) => {
                alert(res.msg);
                location.href="/board/detail/"+id;
                // location.href="/";
            }).fail((err) => {
                alert(err.responseJSON.msg);
                location.href="/";
            });
        }
    </script>
<%@ include file="../layout/footer.jsp" %>