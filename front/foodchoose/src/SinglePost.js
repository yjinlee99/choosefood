import React, { useState, useEffect } from 'react';
import Favorite from '@material-ui/icons/Favorite';
import Banner from './Banner';
import './SingleRecipe.css';
import Comment from './Comment';
import { PostAdd } from '@mui/icons-material';

function SinglePost() {
    const [posts, setPosts] = useState([[]]);
    const thumbImg = sessionStorage.getItem("thumbImg", posts.thumb);
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


  return(
    <div>
        <div className="Header"><Banner/></div>

        <div className="Single-recipe">
            <div className="Recipe-img">
                <img src={"\\img\\" + posts.thumbImg} /> 
                {console.log(thumbImg)}
            </div>

            <div className="likehit">
                <div className="hit">조회수 {posts.view}</div>
            </div>
            <div className="Recipe-info">
                <div>
                    <div className="Recipe-name"> {posts.title} </div>
                    <div className="Recipe-intro"> {posts.introduce} </div>
                    <div className="Recipe-Ingre"> {posts.ingredient} </div>
                </div>
                <div>
                    <div className="Recipe-detail"> {posts.recipe} </div>
                    <div className="Recipe-detail"> <img src={posts.stepImg} /> </div>
                </div>
            </div>
            <div className="comment-area">
               <Comment />
                </div>   
                </div>
            </div>
    );
}
export default SinglePost;