import React from "react";
import moment from "moment";
import { Link } from "react-router-dom";

function User({ user, onRemove }) {
    const {username, id} = user;
    const date = moment().format('MM월DD일 HH:mm:ss');
    return (
        <div id='commentContainer'>
            <div id='comment'>{username}</div>
            <div id='commentDate'>{date}</div>
            <div>
                <Link to='/SingleRecipe'>
            <button id='commentButton'>원본</button></Link>
            <button id='commentButton' onClick={() => onRemove(id)}>삭제</button>
            </div>
        </div>
    );
}


function CommentList({ users, onRemove }) {
    return (
        <div>
            {users.map((user) => (
                <User user={user} key={user.id} onRemove={onRemove} />
            ))}
        </div>
    );
}
export default CommentList;