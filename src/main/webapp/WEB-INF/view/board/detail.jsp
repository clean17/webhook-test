<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

    <div class="container my-3">
        <c:if test="${principal.id == dto.userId}" >
        <div class="mb-3">
            <a href="/board/${dto.id}/updateForm" class="btn btn-warning">수정</a>
            <button type="button" class="btn btn-danger" onclick="deleteBoardById(${dto.id})">삭제</button>
        </div>
        </c:if>

        <div class="mb-2 d-flex justify-content-end">
            글 번호 : &nbsp<span id="id">${dto.id}&nbsp&nbsp<i>&nbsp&nbsp&nbsp&nbsp </i></span> 작성자 : &nbsp<span class="me-3"><i>${dto.username} </i></span> 
            <i id="heart" class="fa-regular fa-heart my-xl my-cursor"></i>
        </div>
        <div>
            <h1><b>${dto.title}</b></h1>
        </div>
        <hr />
        <div>
            <div>${dto.content}</div>
        </div>
        <hr />
        <div class="card">
            <form action="/reply" method="post">
                <input type="hidden" name="boardId" value="${dto.id}">
                <div class="card-body">
                    <textarea id="reply-content" name="comment" placeholder="댓글을 입력하세요 " class="form-control" rows="1"></textarea>
                </div>
                <div class="card-footer">
                    <button type="submit" id="btn-reply-save" class="btn btn-primary">등록</button>
                </div>
            </form>
        </div>
        <br />
        <div class="card mt-3">
            <div class="card-header">댓글 리스트</div>
            <ul id="reply-box" class="list-group">
                <c:forEach items="${replyList}" var="reply">
                
                <li id="reply-1" class="list-group-item d-flex justify-content-between ">
                    <div id="reply-${reply.id}">${reply.comment}</div>
                    <!-- <input type="text" id="" value=""> -->
                    <div class="d-flex justify-content-left">
                        <div class="font-italic">작성자 : ${reply.username} &nbsp;</div>
                        <div>
                            <c:if test="${reply.userId == principal.id}">
                                <button class="badge bg-secondary" id="replyUpdate-${reply.id}" onclick="updateComment(${reply.id})">수정</button>
                                <button class="badge bg-secondary" onclick="deleteComment(${reply.id})">삭제</button>
                            </c:if>
                        </div>
                    </div>
                </li>
                </c:forEach>
            </ul>
            
        </div>
    </div>
    <script>
        let num ;

        $('.summernote').summernote({
                tabsize: 2,
                height: 400
            });
        
        function deleteBoardById(id){
            $.ajax({
                type: "delete",
                url: "/board/"+id+"/delete",
                dataType:"json"
            }).done((res) => {
                alert(res.msg);
                location.href="/";
            }).fail((err) => {
                // console.dir(err);
                alert(err.responseJSON.msg);
                location.href="/";
            });
        }

        function updateComment(id){
            let comment = $("#reply-"+id).text();
            num = id;
            console.log(num);
            $("#reply-"+id).replaceWith('<input type="text" id="dd">')
            $('#dd').val(comment);
            $('#replyUpdate-'+id).replaceWith('<button class="badge bg-secondary" id="updateComment2" onclick="updateComment()">수정완료</button>')
            $('#replyUpdate-'+id).removeClass("bg-secondary");
            $('#replyUpdate-'+id).addClass("bg-primary");
        }

        function updateComment2(id){
            let comment = $("#reply-"+id).text();
            $("#reply-"+id).replaceWith('<input type="text" id="dd">')
            $('#dd').val(comment);
            $('#updateComment').replaceWith('<button class="badge bg-secondary" id="updateComment2" onclick="updateComment(${reply.id})">수정완료</button>')
            $('#updateComment').removeClass("bg-secondary");
            $('#updateComment').addClass("bg-primary");
        }

        function deleteComment(id){
            $.ajax({
                type: "delete",
                url: "/reply/"+id,
                dataType:"json"
            }).done((res) => {
                alert(res.msg);
                history.go(0);
            }).fail((err) => {
                alert(err.responseJSON.msg);
            });
        }
    </script>
<%@ include file="../layout/footer.jsp" %>