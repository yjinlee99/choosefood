import React, { useRef, useState } from 'react';
import './MyComment.css';
import Banner from "../Banner";
import CommentList from './CommentList';



function MyComment(){

    const [inputs, setInputs] = useState({ username: "" });
    const { username } = inputs;
    const onChange = (e) => {
      const { name, value } = e.target;
      setInputs({ ...inputs, [name]: value,});
    };
    const [users, setUsers] = useState([
      { id: 1, username: "맛있겠네요!"},
      { id: 2, username: "좋은 레시피입니다~"},
      { id: 3, username: "좋아요!"},
      { id: 4, username: "따라해봤는데 맛있어요"},
      { id: 5, username: "좋아요!"},
    ]);
    const nextId = useRef(4);
    const onCreate = () => {
      const user = {
        id: nextId.current, username
      };
      setUsers(users.concat(user));
      setInputs({
        username: ""
      });
      nextId.current += 1;
    };
    
    const onRemove = (id) => {
      setUsers(users.filter((user) => user.id !== id));
    };
    
    return(
        <div>
            <div className="Header"><Banner/></div>
            <h1 id='mycommentMain'>내가 쓴 댓글</h1>

            
            <div id='MyComment'>
                <div id='lineContainer'>
                    <CommentList users={users} onRemove={onRemove} />
                </div>
            </div>
                    
        </div>
    )
}

export default MyComment;