import React, { Component, useState, useEffect } from "react";
import "./Comment.css";
import uuid from "react-uuid";
import './SinglePost.js';
import { convertLength } from "@mui/material/styles/cssUtils";

class Comment extends Component {
  constructor(props) {
    super(props);
    this.state = {
      comment: "",
      id: 0,
      comments: [],
      isLength: "",
    };
  }
  handleChange = (e) => {
    this.setState({
      comment: e.target.value,
    });
    sessionStorage.setItem("content", e.target.value);
  };

  handleCommentAdd = () => {
    const { comments, comment } = this.state;
    let newcomment = {
      comment: this.state.comment,
      id: uuid(),
    };
    let addcomments = [...this.state.comments, newcomment];

    this.setState({ comments: addcomments });
    this.setState({ comment: "" });

    const Content = sessionStorage.getItem("content", Content);
    const postId = sessionStorage.getItem("postId", postId);
    const userId = sessionStorage.getItem("id", userId);
    fetch('/comment/save', {
      method: 'post',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        postId: postId,
        userId: userId,
        content: Content,
      })
    })
  };

  handleRemove = (id) => {
    const { comments } = this.state;
    const _comments = comments.filter((key) => key.id !== id);
    console.log(_comments, comments, id);
    this.setState({
      comments: _comments,
    });
  };

  handlePressEnter = (e) => {
    if (e.key === "Enter") {
      this.handleCommentAdd();
    }
  };

  render() {
    const { comment, number } = this.state;
    let isLength = comment.length > 0 ? "active" : "";
    const postId = sessionStorage.getItem("postId", postId);
    fetch('/comment/show?'+ new URLSearchParams({
        id: postId,
    }))
    .then(response => response.json())
    .then(dtos => {
      this.state.comments = dtos;
      console.log(dtos);
    });


    return (
      <div>
        <input
          type="text"
          name="comment"
          placeholder="댓글달기..."
          value={comment}
          className="comment-textarea"
          onChange={this.handleChange}
          onKeyPress={this.handlePressEnter}
        />
        <button
          type="text"
          onClick={this.handleCommentAdd}
          className={isLength}
          id="comment-btn"
          value={comment}>
              등록
        </button>
        <h1>{number}</h1>

        <ul  className="single-comment">
          {this.state.comments.map((e) => (
            <li key={e.id}> 
              <div className="comment">{e.comment}</div>
              <button
                className="comment-delbtn"
                onClick={() => this.handleRemove(e.id)}
              >
                삭제
              </button>
            </li>
          ))}
        </ul>
      </div>
    );
  }
}

/*
function Comment () {

  const [ comment, setComment ] = useState("");

  const onCommentHandler = (event) => {
      setComment(event.currentTarget.value)
  }

  const goBackend = () => {
      alert("댓글 등록 완료!")
      fetch('/join', {
        method: 'post',
        body: JSON.stringify({
          댓글: comment
        })
    })
    .then(res => res.json())
    .then(res => {
        if (res.success) {
            alert("등록 완료!");
        }
    })
    }

  return (
    <div className="comment-container"> &nbsp; 댓글 
      <div className="writing-comment">
        <textarea className="comment-textarea" id="comment-text" onChange={onCommentHandler}/>
        <input type="submit" value="등록" className="comment-btn" onClick={goBackend} />
      </div>
    
    { comment.map((a) => (
    <div className="comments"> 
        <div className="user-info">
            <div className="Profile">
                <div className="Profile-link"> { a.profile }</div>
            </div>

            <div className="username">
                <div className="username-link">{ a.username }</div>
            </div>
        </div>                        

        <div className="comment-info">
            <div className="comment"> { a.comment } </div>
            <div className="comment-time">  { a.time } </div>
        </div>

        <input type="submit" value="삭제" className="comment-delbtn"></input> 
    </div>
    ))}
    </div>
  )
}
*/

export default Comment;