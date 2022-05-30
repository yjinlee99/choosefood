import React, { useState, useEffect } from 'react';
import Favorite from '@material-ui/icons/Favorite';
import Banner from './Banner';
import './SingleRecipe.css';

function SinglePost() {
    const [posts, setPosts] = useState([[]]);
    useEffect(() => {
        var url = decodeURI(document.location.href);
        var str = url.split("?");

        fetch('/post/single?'+ new URLSearchParams({
            title: str[1],
        }))
            .then(response => {
                return response.json()
            })
            .then(posts => {
                setPosts(posts);
            });
    },[])

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

    let Comment = [
        { id: 1, profile: "프로필", username: "뽀로로", comment: "맛있겠다", time: ""},
        { id: 2, profile: "프로필", username: "크롱", comment: "별로야", time: ""},
        { id: 3, profile: "프로필", username: "에디", comment: "좋다", time: ""},
        
    ];

  return(
    <div>
        <div className="Header"><Banner/></div>

        <div className="Single-recipe">
            <div className="Recipe-img">
                <img src={posts.thumbnail} /> 
            </div>

            <div className="likehit">
                <div id="like">
                    <div className="likes"><Favorite /></div>
                    <div className="likes-text">10,000</div>
                </div>
                <div className="hit">조회수 {posts.views}</div>
            </div>
            <div className="Recipe-info">
                <div>
                    <div className="Recipe-name"> {posts.name} </div>
                    <div className="Recipe-intro"> {posts.intro} </div>
                    <div className="Recipe-Ingre"> {posts.ingredient} </div>
                </div>
                <div>
                    <div className="Recipe-detail"> {posts.recipe} </div>
                    <div className="Recipe-detail"> <img src={posts.stepImg} /> </div>
                </div>
            </div>
                    
                <div className="comment-container"> &nbsp; 댓글 
                    <div className="writing-comment">
                        <textarea className="comment-textarea" id="comment-text" onChange={onCommentHandler}/>
                        <input type="submit" value="등록" className="comment-btn" onClick={goBackend} />
                    </div>
                    { Comment.map((a) => (
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
                </div>
            </div>
    );
}
export default SinglePost;