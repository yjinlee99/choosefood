import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import StarIcon from '@material-ui/icons/StarRounded';
import Banner from './Banner';
import './SingleRecipe.css';
var datas=[];
function SingleRecipe() {

    const [dtos, setDtos] = useState([[]]);
    useEffect(() => {
        var url = decodeURI(document.location.href);
        var str = url.split("?");
        const requestOptions = {
            method: 'post',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                name: str[1],
            })
        }

        fetch('/singleRecipe', requestOptions)
            .then(response => {
                return response.json()
            })
            .then(dtos => {
                setDtos(dtos);
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
                <img src={dtos.thumbnail} />
            </div>

            <div className="Recipe-info">
                <div className="Recipe-name"> &nbsp; 요리명: {dtos.name}
                    <div className="Hit">조회수</div>
                </div>
                <div className="Recipe-intro"> &nbsp; 요리 소개: {dtos.intro}</div>
                <div className="Recipe-Ingre"> &nbsp; 재료: {dtos.ingredient}</div>
                <div className="Recipe-detail"> &nbsp; 조리 순서: {dtos.recipe}</div>
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
        </div>
    );
}
export default SingleRecipe;
